using Antlr4.Runtime.Misc;
using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.Exceptions.RuntimeExceptions;
using HynusScriptCompiler.HynusScript.HTypes;
using Spectre.Console;
using System.Reflection;

namespace HynusScriptCompiler.HynusScript.Runtime;

/*
 * This is called a "Runtime", but it's really just a class that holds script instance information
 * Fun buzzwords though :P
 *
 * Copy with some modifications of: https://www.youtube.com/watch?v=bfiAvWZWnDA&t=638s&ab_channel=BenMakesGames
 */

internal enum ScopeType
{
    /// <summary>
    /// The variable doesn't exist
    /// </summary>
    NotFound = -1,

    /// <summary>
    /// Any variable defined without the 'local' keyword will be created as a global
    /// </summary>
    Global = 0,

    /// <summary>
    /// The user defined this variable inside of a scope (that being a function or a block with the 'local' or 'scoped' keywords)
    /// </summary>
    Scoped,

    /// <summary>
    /// Essensially the same as <see cref="Global"/>, but the user cannot delete it
    /// </summary>
    Preset,

}

internal static class RuntimeMembers
{
    public static string ProjectRoot { get; private set; }
    public static Stack<string> FileStack { get; private set; } = new();
    public static HashSet<string> ImportedFiles { get; private set; } = new();
    public static bool UserDebug { get; set; } = false;
    public static string AssignClassName { get; set; } = "";

    public static void SetProjectRoot(string path)
        => ProjectRoot = path;

    public static string CurrentFile { get => FileStack.Peek(); }

    public static void Initialize()
    {
        /* 
         * HScript is going in a new, real language like direction
         * All functions will be defined *in* the language itself
         * Debugging methods could go to another direction
         */

        Functions = BuiltInFunctions.GetBuiltInFunctions();
        CallStack = new();
        Variables = new();
        PresetVariables = new()
        {
            { RVar.n_IVersion, Assembly.GetExecutingAssembly().GetName().Version!.ToString() },
            { RVar.n_SVersion, null },
            { RVar.n_WinVersion, Environment.OSVersion.ToString() },
            { RVar.n_Default, "" }
        };
    }

#pragma warning disable CS8618
    /// <summary>
    /// Functions defined by the user. (Won't be as important if classes are fully supported)
    /// </summary>
    internal static Dictionary<string, HFunction> Functions { get; private set; }

    /// <summary>
    /// This is gonna make me wanna kms gl
    /// </summary>
    internal static Dictionary<string, HClass> DefinedClasses { get; private set; }

    /// <summary>
    /// Context information for every function called.
    /// </summary>
    internal static CallStack CallStack { get; private set; }

    /// <summary>
    /// Get the currently executing function
    /// </summary>
    internal static HScopeContext? CurrentScope { get => CallStack.Peek(); }

    /// <summary>
    /// Variables that can be created, modified, and deleted by the user.
    /// </summary>
    internal static Dictionary<string, object?> Variables { get; private set; }

    /// <summary>
    /// HScript variables that can be modified by the user, but cannot be deleted.
    /// </summary>
    internal static Dictionary<string, object?> PresetVariables { get; private set; }
#pragma warning restore CS8618

    public static ScopeType LocateVariable(string var, out object? variable)
    {
        variable = null;


        // Get scoped variable
        if (CallStack.TryGetScopedVariable(var, out var fVar))
        {
            variable = fVar;
            return ScopeType.Scoped;
        }

        // Get regular variable
        if (Variables.TryGetValue(var, out var v))
        {
            variable = v;
            return ScopeType.Global;
        }
        // Environment variables
        else if (PresetVariables.TryGetValue(var, out var pv))
        {
            variable = pv;
            return ScopeType.Preset;
        }

        return ScopeType.NotFound;
    }

    public static ScopeType LocateFunction(string name, out HFunction? func)
    {
        if (Functions.TryGetValue(name, out var f))
        {
            if (f is HFunction F)
            {
                func = F;
                return ScopeType.Global;
            }
        }
        else if (CallStack.TryGetScopedVariable(name, out var sf))
        {
            if (sf is HFunction sF)
            {
                func = sF;
                return ScopeType.Scoped;
            }
        }
        else if (Variables.TryGetValue(name, out var vf) && vf is HFunction vF)
        {
            func = vF;
            return ScopeType.Global;
        }

        func = null;
        return ScopeType.NotFound;
    }

    public static void OverwriteBuiltInFunctions(Dictionary<string, HFunction> funcs)
        => Functions = funcs;
}

internal class HScriptRuntime : HScriptBaseVisitor<object?>
{
    public static HScriptRuntime StaticAccess { get; private set; }

    public HScriptRuntime()
    {
        StaticAccess = this;
        RuntimeMembers.Initialize();

        // Create a new stack element that represents the script entry point (Allows for some jimmy-rigged scoping)
        RuntimeMembers.CallStack.Push(new("script-entry".AsMemberName()));
    }

    /* Script Configurations */

    public override object? VisitScriptVersionConfig([NotNull] HScriptParser.ScriptVersionConfigContext context)
    {
        var version = context.scriptVersion().VERSIONSTR().GetText();

        string[] versionComponents = version.Split('.');

        if (versionComponents.Length < 2 || versionComponents.Length > 4)
            throw new HScriptInvalidScriptVersionException("Invalid version format. It should have 2, 3, or 4 segments. (Example: '?>> [yellow]4.0.2[/]')", context);

        Version assemblyVersion = Assembly.GetExecutingAssembly().GetName().Version!;
        Version scriptVersion = new(version);
        RVar.SVersion = scriptVersion.ToString();

        int scriptToInterpreterComparison = scriptVersion.CompareTo(assemblyVersion);
        int scriptToAssemblyComparison = scriptVersion.CompareTo(assemblyVersion);

        // Ignore possible issues and return to script
        if (Config.ForceRun)
            return null;

        if (scriptToInterpreterComparison < 0)
            Logging.LogWarning($"Interpreter version ([yellow]v{assemblyVersion}[/]) is newer than HScript version ([yellow]v{scriptVersion}[/]). Some functions may be unavailable or obsolete.");
        else if (scriptToAssemblyComparison > 0)
            Logging.LogError($"HScript version is newer than the interpreter ({assemblyVersion}). Run with '-f' to run anyway. [red](May cause errors)[/]");
        // else, be in shock that its the exact version

        return null;
    }

    /// <summary>
    /// Imports a new script. Works similar to C/C++, but rather than relying on the developer to account for circular depenancies, the file name
    /// is added to a <see cref="HashSet{String}"/>. It will still work the exact same way.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptInvalidInputParameterException"></exception>
    /// <exception cref="ScriptImportException"></exception>
    public override object? VisitScriptImport([NotNull] HScriptParser.ScriptImportContext context)
    {
        string filePath = "INVALID_INPUT";

        if (context.libBuiltIn() is { } lib)
            filePath = lib.IDENTIFIER().GetText();
        else if (context.expression() is { } expr)
        {
            var ret = Visit(expr);

            if (ret is not string)
                throw new HScriptInvalidInputParameterException(typeof(string), ret);

            filePath = (string)ret;
        }

        if (filePath is string path)
        {
            string directoryPath = RuntimeMembers.ProjectRoot;
            string inputFileName = path.TrimStart('/'); // Remove leading slashes from the input.

            // Get a list of files in the directory and filter them based on user input.
            string[] matchingFiles = Directory.GetFiles(directoryPath)
                .Select(Path.GetFileName)
                .Where(fileName => fileName.StartsWith(inputFileName, StringComparison.OrdinalIgnoreCase))
                .ToArray();

            // Import the script
            if (matchingFiles.Length == 1)
            {
                string realPath = Path.Combine(directoryPath, matchingFiles[0]);

                if (!RuntimeMembers.ImportedFiles.Add(realPath))
                    return null;

                Logging.ILog("Attempting to load file from: " + realPath);

                RuntimeMembers.CallStack.Push(new("script-import".AsMemberName()));
                var ret = HScriptReader.RunScriptFromFile(realPath);
                if (ret is not HScriptResult.Successful)
                {
                    var fileName = Path.GetFileName(realPath);
                    throw new ScriptImportException($"Failed to import script [yellow]{fileName}[/]{(fileName != path ? $" [[{realPath}]]" : "")}\r\n\t└─ [lime]{ret}[/]");
                }

                RuntimeMembers.CallStack.Pop();
                Logging.ILog("Script imported");
            }

            else if (matchingFiles.Length > 1)
            {
                Logging.WriteData($"[red][[-]][/]File reference ambiguity for '{path}'\r\nPossible alternatives:", matchingFiles);
                HRuntime.Exit(HScriptResult.FileImportAmbiguity);
            }
            else
            {
                Logging.LogError($"Failed to find file to import by the name of '{Path.GetFileName(path)}'");
                HRuntime.Exit(HScriptResult.FileImportNotFound);
            }
        }

        return null;
    }

    public override object? VisitEnableDebugConfig([NotNull] HScriptParser.EnableDebugConfigContext context)
    {
        if (Operations.Evaluate(Visit(context.enableDebug().expression())))
        {
            // Provide debugging methods (i.e. Assert())
            RuntimeMembers.OverwriteBuiltInFunctions(BuiltInFunctions.GetDebuggingFunctions());
            Logging.Log("Debugging active");
        }

        return null;
    }

    public override object? VisitChangeStyle([NotNull] HScriptParser.ChangeStyleContext context)
    {
        var style = context.IDENTIFIER().GetText();

        switch (style)
        {
            case "pascal": // Doesn't really do anything, but can help with HScript readability
                break;

            case "snake":
                RuntimeMembers.OverwriteBuiltInFunctions(BuiltInFunctions.GetBuiltInFunctionsAsSnake());
                break;

            case "kebab":
                RuntimeMembers.OverwriteBuiltInFunctions(BuiltInFunctions.GetBuiltInFunctionsAsKebab());
                break;

            case "camel":
                RuntimeMembers.OverwriteBuiltInFunctions(BuiltInFunctions.GetBuiltInFunctionsAsCamel());
                break;

            case "piglatin": // More of a joke
                RuntimeMembers.OverwriteBuiltInFunctions(BuiltInFunctions.GetBuiltInFunctionsAsPigLatin());
                break;
        }

        return null;
    }

    /* Variables And Datatypes */

    /// <summary>
    /// Creates a variable by adding it to <see cref="RuntimeMembers.Variables"/>. The variable will be pushed to the most recent element 
    /// on <see cref="RuntimeMembers.CallStack"/> if the variable assignment starts with '<see langword="scoped"/>' or '<see langword="local"/>'.
    /// <para>
    /// The keyword '<see langword="temporary"/>' will remove the variable after the script file exits.
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptInvalidOperationException"></exception>
    public override object? VisitAssignment([NotNull] HScriptParser.AssignmentContext context)
    {
        string varName;
        object? value;

        // Regular variable
        if (context.IDENTIFIER() is { } iden)
            varName = iden.GetText();
        // Check if it's an array
        else if (context.arrAccess() is { } arrAcc)
            varName = arrAcc.GetText();
        // Check for 'local' or 'scoped' keywords
        else if (context.localIdentifier() is { } local)
        {
            if (RuntimeMembers.CurrentScope is null || RuntimeMembers.CallStack.Count == 1)
                throw new HScriptInvalidOperationException("The 'local' or 'scoped' keywords can only be used within blocks or a scoped area (i.e. functions)");

            varName = RuntimeMembers.AssignClassName + local.IDENTIFIER().GetText();

            // Create the variable in the scope, it will be assigned the correct value later
            RuntimeMembers.CurrentScope.ScopedVariables[varName] = "";
        }
        else if (context.tempIdentifier() is { } tmp)
        {
            if (RuntimeMembers.CurrentScope is null || RuntimeMembers.CurrentScope.ID.StartsWith("script-import"))
                throw new HScriptInvalidOperationException("The 'temporary' keyword can only be used in top-level areas of a script");

            varName = RuntimeMembers.AssignClassName + tmp.IDENTIFIER().GetText();
            RuntimeMembers.CurrentScope.ScopedVariables[varName] = "";
        }
        else
            throw new HScriptInvalidOperationException("Failed to locate the variable name for assignment");

        if (context.expression() is { } expr)
            value = Visit(expr);
        else if (context.arrBlock() is { } arrBlock) // Check if it's an array rather than a regular variable
        {
            List<object?> values = new();
            foreach (var exp in arrBlock.expression())
                values.Add(Visit(exp));
            value = values.ToArray();
        }
        else
            throw new HScriptInvalidOperationException("Failed to locate the variable value for assignment");

        switch (RuntimeMembers.LocateVariable(varName, out _))
        {
            case ScopeType.NotFound:
            case ScopeType.Global: // Normal/no var
                RuntimeMembers.Variables[varName] = value;
                break;
            case ScopeType.Preset: // Preset var
                RuntimeMembers.PresetVariables[varName] = value;
                break;
            case ScopeType.Scoped: // Scoped variables
                RuntimeMembers.CurrentScope!.ScopedVariables[varName] = value;
                break;
        }

        return value;
    }

    /// <summary>
    /// An <see langword="IDENTIFIER"/> is just a name to <see langword="HScript"/>.
    /// This will resolve them into their variable value, or return <see cref="RVar.Default"/> if it doesn't exist.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitIdentifierExpression([NotNull] HScriptParser.IdentifierExpressionContext context)
    {
        string name = context.IDENTIFIER().GetText();

        // Dispose
        if (name == "_")
            return null;

        // Regular variable access
        if (RuntimeMembers.LocateVariable(name, out var variable) is not ScopeType.NotFound)
            return variable;

        // Check if its a function
        if (RuntimeMembers.LocateFunction(name, out var func) is not ScopeType.NotFound)
            return func;

        return RVar.Default;
    }

    /// <summary>
    /// Allows you to use a variable as if it were a pointer as long as the variable reference starts with the '<see langword="@"/>' character.
    /// The variable will be searched recursively, meaning if the content of the next variable is a string and starts with '<see langword="@"/>', then the
    /// operation will search for that variable as well.
    /// <para>
    /// Note: A circular reference can be made with this method, so use carefully.
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitNestedVariableExpression([NotNull] HScriptParser.NestedVariableExpressionContext context)
    {
        return ResolveNestedVariables(context.nestedVariable().GetText());
    }

    public override object? VisitArrayAccessExpression([NotNull] HScriptParser.ArrayAccessExpressionContext context)
    {
        return null;

        // No idea why I'm trying to handle arrays like this. I'll just use the method JS uses.

        var var = Visit(context.arrAccess());

        if (var is null)
            return RVar.Default;

        if (var == RVar.Default)
            return var;

        Type varType = var.GetType();

        if (varType.GetMethod("GetEnumerator") is not null)
        {
            var elementType = varType.GetInterfaces()
                .FirstOrDefault(interfaceType => interfaceType.IsGenericType &&
                                                 interfaceType.GetGenericTypeDefinition() == typeof(IEnumerable<>));

            if (elementType is not null)
            {
                MethodInfo toArrayMethod = typeof(Enumerable).GetMethod("ToArray").MakeGenericMethod(elementType.GetGenericArguments()[0]);
                return ((Array)toArrayMethod.Invoke(null, new object[] { var })).GetValue(1);
            }
        }

        return RVar.Default;
    }

    public override object? VisitConstant([NotNull] HScriptParser.ConstantContext context)
    {
        if (context.INTEGER() is { } num)
        {
            var inum = num.GetText();
            if (int.TryParse(inum, out var Int))
                return Int;
            else if (long.TryParse(inum, out var Long))
                return Long;
            else if (Int128.TryParse(inum, out var i128))
                return i128;

            throw new HScriptInvalidOperationException($"Cannot process number '{inum}'", context);
        }

        if (context.UINTEGER() is { } unum)
        {
            var uinum = unum.GetText()[..^1];
            if (uint.TryParse(uinum, out var uInt))
                return uInt;
            else if (ulong.TryParse(uinum, out var uLong))
                return uLong;
            else if (UInt128.TryParse(uinum, out var ui128))
                return ui128;

            throw new HScriptInvalidOperationException($"Cannot process number '{uinum}'", context);
        }

        if (context.HEX() is { } hex)
        {
            var hexStr = hex.GetText();
            if (hexStr[^1] is 'u' or 'U')
                return Convert.ToUInt32(hexStr[2..^1], 2); // 0xfu => f [uint] (16)
            else
                return Convert.ToInt32(hex.GetText()[2..], 16); // 0xf => f (16)
        }

        if (context.BINARY() is { } bin)
        {
            var binStr = bin.GetText();
            if (binStr[^1] is 'u' or 'U')
                return Convert.ToUInt32(binStr[2..^1], 2); // 0b1111 => 1111 [uint] (15)
            else
                return Convert.ToInt32(binStr[2..], 2); // 0b1111 => 1111 (15)
        }

        if (context.FLOAT() is { } flt)
            return float.Parse(flt.GetText()[..^1]); // 43f => 43

        if (context.STRING() is { } str)
            return Operations.EscapeString(str.GetText()[1..^1]); // "string" => string

        if (context.ISTRING() is { } istr)
            return Operations.EscapeString(Operations.InterpolateString(istr.GetText()[2..^1]));

        if (context.ESCSTRING() is { } estr)
            return estr.GetText()[1..^1];

        if (context.CHAR() is { } chr)
            return chr.GetText()[1]; // 'A' => A

        if (context.BOOL() is { } bul)
            return bul.GetText() is "true" or ":" or "True";

        if (context.NULL() is { }) // * nothing * //
            return null;

        throw new HScriptUnknownTypeException(context.GetText(), context);
    }

    public override object? VisitParethesizedExpression([NotNull] HScriptParser.ParethesizedExpressionContext context)
    {
        return context.expression().Accept(this);
    }

    /* Function Calls And Definitions */

    /// <summary>
    /// Defines an <see cref="HFunction"/> and adds it to the <see cref="RuntimeMembers.Functions"/> dictionary
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="Exception"></exception>
    public override object? VisitFunctionDefinition([NotNull] HScriptParser.FunctionDefinitionContext context)
    {
        Dictionary<string, object?> args = new();
        if (context.functionParameter() is { } fParams)
            foreach (var param in fParams)
                if (param.IDENTIFIER() is { } iden)
                    args.Add(iden.GetText(), new HUndefined());
                else if (param.functionPresetParameter() is { } fPParam)
                    args.Add(fPParam.IDENTIFIER().GetText(), Visit(fPParam.constant()));
                else throw new Exception("IDEK what happened my guy");

        if (args.Count > 0)
        {
            HashSet<string> fIdens = new();
            foreach (var param in args.Select(arg => arg.Key))
                if (!fIdens.Add(param))
                    throw new Exception("Function definition cannot contain multiple parameters with the same identifier name");
        }

        var className = RuntimeMembers.AssignClassName is not ""
            ? RuntimeMembers.AssignClassName[0..^1]
            : "";
        
        var funIden = context.IDENTIFIER().GetText();

        // Don't append the class name to a function named after the class 
        var funcName = className == funIden
            ? className
            : RuntimeMembers.AssignClassName + context.IDENTIFIER().GetText();

        var func = new HFunction(funcName, args, context.block());
        RuntimeMembers.Functions[funcName] = func;

        return func;
    }

    /// <summary>
    /// A mimic of <see cref="VisitFunctionDefinition"/> but with a <see langword="TYPE"/> as the
    /// <see langword="IDENTIFIER"/>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="Exception"></exception>
    public override object? VisitTypeCastDefinition([NotNull] HScriptParser.TypeCastDefinitionContext context)
    {
        Dictionary<string, object?> args = new();
        if (context.functionParameter() is { } fParams)
            foreach (var param in fParams)
                if (param.IDENTIFIER() is { } iden)
                    args.Add(iden.GetText(), new HUndefined());
                else if (param.functionPresetParameter() is { } fPParam)
                    args.Add(fPParam.IDENTIFIER().GetText(), Visit(fPParam.constant()));
                else throw new Exception("IDEK what happened my guy");

        if (args.Count > 0)
        {
            HashSet<string> fIdens = new();
            foreach (var param in args.Select(arg => arg.Key))
                if (!fIdens.Add(param))
                    throw new Exception("Function definition cannot contain multiple parameters with the same identifier name");
        }

        var className = RuntimeMembers.AssignClassName is not "" 
            ? RuntimeMembers.AssignClassName[0..^1]
            : "";

        var funIden = context.TYPE().GetText();

        // Don't append the class name to a function named after the class 
        var funcName = className == funIden
            ? className
            : RuntimeMembers.AssignClassName + context.TYPE().GetText();

        var func = new HFunction(funcName, args, context.block());
        RuntimeMembers.Functions[funcName] = func;

        return func;
    }

    /// <summary>
    /// Defines an <see cref="HFunction"/> as a variable that can still be invoked (Limited to no input arguments)
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object VisitFunctionClosureExpression([NotNull] HScriptParser.FunctionClosureExpressionContext context)
    {
        return new HFunction(context.functionClosure().block());
    }

    /// <summary>
    /// Does as the name implies. It invokes an <see cref="HFunction"/> defined in <see cref="RuntimeMembers.Functions"/>
    /// <para>
    /// If no <see cref="HFunction"/> with the same name can be found in <see cref="RuntimeMembers.Functions"/>, then <see cref="RuntimeMembers.Variables"/> is
    /// checked. If no <see cref="HFunction"/> is found there either, then an <see cref="HScriptUnknownFunctionReferenceException"/> is thrown.
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptUnknownFunctionReferenceException"></exception>
    public override object? VisitFunctionCall([NotNull] HScriptParser.FunctionCallContext context)
    {
        var name = context.IDENTIFIER().GetText();

        object?[]? args;
        args = context.expression().Select(Visit).ToArray() ?? Array.Empty<object?>();

        if (RuntimeMembers.LocateFunction(name, out var func) is not ScopeType.NotFound)
            return func!.Invoke(args!);

        throw new HScriptUnknownFunctionReferenceException(name);
    }

    /// <summary>
    /// Piggybacks off of <see cref="VisitBlock"/>, but provides a specific scope.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitBlockExpression([NotNull] HScriptParser.BlockExpressionContext context)
    {
        RuntimeMembers.CallStack.Push(new("tmp-block".AsMemberName(), new()));
        // Forward to VisitBlock
        var ret = Visit(context.block());
        RuntimeMembers.CallStack.Pop();
        return ret;
    }

    /// <summary>
    /// Executes every line within a block. Breaks when '<see langword="return"/>' is encountered.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitBlock([NotNull] HScriptParser.BlockContext context)
    {
        // If function is single line (Starting with '=>'), return line result
        if (context.lineBlock() is { } lineBlock)
            return Visit(lineBlock.line());

        // Visit each line in block
        foreach (var line in context.line())
        {
            // If line has 'return expression', return result rather than default
            if (line.@return() is { } ret)
                return Visit(ret.expression());

            // Run line
            Visit(line);
        }

        // Return default if no return value
        return RVar.Default;
    }

    /// <summary>
    /// Handles every if operation (Supports else-if-else chains)
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptInvalidOperationException"></exception>
    public override object? VisitIfBlock([NotNull] HScriptParser.IfBlockContext context)
    {
        int blockIndex = 0;
        foreach (var expr in context.expression())
        {
            if (Operations.Evaluate(Visit(expr)))
                return Visit(blockIndex == 0 ? context.opBlock() : context.elseIfBlock(blockIndex - 1));
            
            blockIndex++;
        }

        if (context.elseBlock() is { } elB)
            return Visit(elB.opBlock());

        return null;
    }

    /// <summary>
    /// Enters either a while or until loop until the specified condition is met.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptInvalidOperationException"></exception>
    public override object? VisitWhileBlock([NotNull] HScriptParser.WhileBlockContext context)
    {
        Func<object?, bool> eval = context.WHILE().GetText() == "while"
            ? Operations.Evaluate
            : eval => !Operations.Evaluate(eval);

        if (eval(Visit(context.expression())))
            while (eval(Visit(context.expression())))
                Visit(context.opBlock()[0]);
        else if (context.opBlock().Length > 1 && context.opBlock()[1] is { } block)
            Visit(block);

        return null;
    }

    /// <summary>
    /// Allows for the definition of several functions of variables without having to specify the class names for every <see cref="HFunction"/>
    /// <para>
    /// PLEASE NOTE: <see langword="HScript"/> does not support instancing, meaning that the keyword <see langword="sclass"/> means <see langword="static class"/>
    /// and will not define a class.
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitStaticClass([NotNull] HScriptParser.StaticClassContext context)
    {
        RuntimeMembers.AssignClassName = 
            (context.TYPE() is { } type 
            ? type.GetText() 
            : context.IDENTIFIER().GetText()) + '.';

        Visit(context.block());
        RuntimeMembers.AssignClassName = "";

        return new HUndefined();
    }

    /// <summary>
    /// Allows you to input real C# code, compile it, then run it.
    /// <para>
    /// Note: This takes FOREVER depending on the size of the input program and may not always be beneficial.
    /// If you only need to run one or two lines, then <see langword="hscript::TYPE::CS_METHOD"/> should be used instead.
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptInvalidInputParameterException"></exception>
    public override object? VisitDynamicCSharpCallExpression([NotNull] HScriptParser.DynamicCSharpCallExpressionContext context)
    {
        var cscode = Visit(context.expression());
        string? code;

        if ((code = cscode as string) is null)
            throw new HScriptInvalidInputParameterException(typeof(string), cscode);

        return DynamicCSharp.Run(code).GetAwaiter().GetResult();
    }

    /// <summary>
    /// Uses reflection to invoke a static C# method.
    /// <para>
    /// Example: <see langword="hscript::void::System.Console.WriteLine(hello_world_string)"/>
    /// </para>
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    /// <exception cref="HScriptUnknownFunctionReferenceException"></exception>
    public override object? VisitHscriptCallExpression([NotNull] HScriptParser.HscriptCallExpressionContext context)
    {
        var special = context.specialHScript();

        string typeName = "";
        if (special.IDENTIFIER() is { } hid)
            typeName = hid.GetText();

        if (!typeName.Contains('.'))
            typeName = "System." + typeName;
        Type? type = Type.GetType(typeName);

        var func = special.specialFunctionCall();
        string funcID = "";
        if (func.IDENTIFIER() is { } fhid)
            funcID = fhid.GetText();

        object?[] args = func.expression().Select(Visit).Where(arg => arg is not HUndefined).ToArray();
        var ret = DynamicCSharp.InvokeMethodFromName(funcID.ResolveAssemblyPaths(), args);

        if (ret as Type == typeof(void))
        {
            if (args is null || args.Length == 0)
                throw new HScriptUnknownFunctionReferenceException(funcID, context);

            throw new HScriptUnknownFunctionReferenceException(funcID, args.Select(arg => arg?.GetType()).ToArray(), context);
        }

        if (type is null || ret is null)
            return null;

        return Convert.ChangeType(ret, type);
    }

    /// <summary>
    /// Uses a try/catch to handle exceptions.
    /// <see cref="HException"/> and <see cref="Exception"/> will be handled differently.
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public override object? VisitTryCatch([NotNull] HScriptParser.TryCatchContext context)
    {
        try
        {
            return Visit(context.block());
        }
        catch (HException hex)
        {
            foreach (var cBlock in context.exBlock())
            {
                foreach (var exID in cBlock.exceptionInfo())
                {
                    if (exID.IDENTIFIER(0).GetText() == hex.GetTypeName()
                        || hex.InnerException.GetTypeName() == exID.IDENTIFIER(0).GetText())
                    {
                        // Add variable to stack

                        Dictionary<string, object?> vars = new();
                        if (exID.IDENTIFIER(0) is { } fhid)
                            vars.Add(fhid.GetText(), hex);

                        RuntimeMembers.CallStack.Push(new("try-catch-handler".AsMemberName(), vars));
                        var ret = Visit(cBlock.block());
                        RuntimeMembers.CallStack.Pop();

                        return ret;
                    }
                }
            }

            Logging.WriteException("Unhandled exception", hex);
        }
        catch (Exception ex)
        {
            Logging.WriteException("Runtime error while visiting try/catch", ex);
        }

        return null;
    }

    /* Operations */

    public override object? VisitAdditiveExpression([NotNull] HScriptParser.AdditiveExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        return context.addOp().GetText() switch
        {
            "+" => Operations.Add(left, right),
            "-" => Operations.Subtract(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown additive operator '{context.addOp().GetText()}'")
        };
    }

    public override object? VisitMultiplicativeExpression([NotNull] HScriptParser.MultiplicativeExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        return context.multOp().GetText() switch
        {
            "*" => Operations.Multiply(left, right),
            "/" => Operations.Divide(left, right),
            "%" => Operations.Modulo(left, right),
            "**" => Operations.Power(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown multiplicative operator '{context.multOp().GetText()}'")
        };
    }

    public override object VisitAssignOpExpression([NotNull] HScriptParser.AssignOpExpressionContext context)
    {
        var target = Visit(context.expression(0));
        var targetName = context.expression(0).GetText();
        var value = Visit(context.expression(1));

        var ret = context.assignOp().GetText() switch
        {
            "+=" => Operations.Add(target, value),
            "-=" => Operations.Subtract(target, value),
            "*=" => Operations.Multiply(target, value),
            "/=" => Operations.Divide(target, value),
            _ => throw new HScriptUnknownOperationException($"Unknown assignment operator '{context.assignOp().GetText()}'")
        };

        switch (RuntimeMembers.LocateVariable(targetName, out _))
        {
            case ScopeType.NotFound:
                throw new HScriptUnknownOperationException($"Value required to perform assignment operator on identifier '{targetName}'");

            case ScopeType.Global:
                RuntimeMembers.Variables[targetName] = ret;
                break;

            case ScopeType.Preset:
                RuntimeMembers.PresetVariables[targetName] = ret;
                break;

            case ScopeType.Scoped:
                RuntimeMembers.CurrentScope!.ScopedVariables[targetName] = ret;
                break;
        }

        return ret;
    }

    public override object? VisitComparisonExpression([NotNull] HScriptParser.ComparisonExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        return context.comareOp().GetText() switch
        {
            ":!=" => !(bool)Operations.CompareType(left, right),
            ":==" => Operations.CompareType(left, right),
            "!=" => !(bool)Operations.Compare(left, right),
            "==" => Operations.Compare(left, right),
            ">=" => (bool)Operations.GreaterThan(left, right) || (bool)Operations.Compare(left, right),
            "<=" => !(bool)Operations.GreaterThan(left, right) || (bool)Operations.Compare(left, right),
            ">" => Operations.GreaterThan(left, right),
            "<" => !(bool)Operations.GreaterThan(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown comparison operator '{context.comareOp().GetText()}'")
        };
    }

    public override object VisitBooleanExpression([NotNull] HScriptParser.BooleanExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        return context.boolOp().GetText() switch
        {
            "&&" or "and" => Operations.BoolAnd(left, right),
            "||" or "or" => Operations.BoolOr(left, right),
            "^" or "xor" => Operations.BoolXor(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown boolean operator '{context.boolOp().GetText()}'"),
        };
    }

    public override object? VisitUnaryExpression([NotNull] HScriptParser.UnaryExpressionContext context)
    {
        var value = Visit(context.expression());

        return context.unaryOp().GetText() switch
        {
            "!" => Operations.LogicNot(value),
            "~" => Operations.BitwiseNot(value),
            "+" => Operations.BitwisePlus(value),
            "-" => Operations.BitwiseMinus(value),
            _ => throw new HScriptUnknownOperationException($"Unknown unary operator '{context.unaryOp().GetText()}'")
        };
    }

    public override object? VisitDoubleStatementExpression([NotNull] HScriptParser.DoubleStatementExpressionContext context)
    {
        var value = Visit(context.expression());

        return context.doubleOp().GetText() switch
        {
            "++" => Operations.PlusPlus(value),
            "--" => Operations.MinusMinus(value),
            _ => throw new HScriptUnknownOperationException($"Unknown unary operator '{context.doubleOp().GetText()}'")
        };
    }

    /* Method helpers */

    private object? ResolveNestedVariables(object? value)
    {
        // Recursively resolve nested variables
        if (value is string varName && varName.Length > 1)
            if (varName.StartsWith('@'))
            {
                if (RuntimeMembers.LocateVariable(varName[1..], out var variable) is not ScopeType.NotFound)
                {
                    var ret = ResolveNestedVariables(variable);

                    if (ret is HUndefined)
                        return variable;

                    return ret;
                }

                return RVar.Default;
            }
            else
            {
                if (RuntimeMembers.LocateVariable(varName, out var variable) is not ScopeType.NotFound)
                    return variable;

                return new HUndefined();
            }

        return value;
    }
}