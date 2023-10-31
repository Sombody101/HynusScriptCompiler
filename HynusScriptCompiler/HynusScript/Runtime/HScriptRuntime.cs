using Antlr4.Runtime.Misc;
using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.Exceptions.RuntimeExceptions;
using HynusScriptCompiler.HynusScript.HTypes;
using System.Reflection;

namespace HynusScriptCompiler.HynusScript.Runtime;

/*
 * This is called a "Runtime", but it's really just a class that holds script instance information
 * Fun buzzwords though :P
 *
 * Copy with some modifications of: https://www.youtube.com/watch?v=bfiAvWZWnDA&t=638s&ab_channel=BenMakesGames
 */

internal static class RuntimeMembers
{
    public static bool UserDebug { get; set; } = false;

    public static void Initialize()
    {
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
    /// Functions defined by the user.
    /// </summary>
    internal static Dictionary<string, HFunction> Functions { get; private set; }

    /// <summary>
    /// Context information for every function called.
    /// </summary>
    internal static CallStack CallStack { get; private set; }

    /// <summary>
    /// Get the currently executing function
    /// </summary>
    internal static HFunctionCallContext CurrentFunc { get => CallStack.Peek(); }

    /// <summary>
    /// Variables that can be created, modified, and deleted by the user.
    /// </summary>
    internal static Dictionary<string, object?> Variables { get; private set; }

    /// <summary>
    /// HScript variables that can be modified by the user, but cannot be deleted.
    /// </summary>
    internal static Dictionary<string, object?> PresetVariables { get; private set; }
#pragma warning restore CS8618

    public static int LocateVariable(string var, out object? variable)
    {
        // Get scoped variable
        if (var.StartsWith('$'))
        {
            if (CurrentFunc.ScopedVariables.TryGetValue(var, out var fVar))
            {
                variable = fVar;
                return 3;
            }
        }
        // Get regular variable
        else if (Variables.TryGetValue(var, out var v))
        {
            variable = v;
            return 1;
        }
        // Environment variables
        else if (PresetVariables.TryGetValue(var, out var pv))
        {
            variable = pv;
            return 2;
        }

        variable = null;
        return -1;
    }

    public static int LocateFunction(string name, out HFunction? func)
    {
        if (Functions.TryGetValue(name, out var f))
        {
            if (f is HFunction F)
            {
                func = F;
                return 1;
            }
        }
        else if (Variables.TryGetValue(name, out var vf))
        {
            if (vf is HFunction vF)
            {
                func = vF;
                return 2;
            }
        }

        func = null;
        return -1;
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
    }

    /* Script Configurations */

    public override object? VisitScriptVersionConfig([NotNull] HScriptParser.ScriptVersionConfigContext context)
    {
        var version = context.scriptVersion().VERSIONSTR().GetText();

        string[] versionComponents = version.Split('.');

        if (versionComponents.Length < 2 || versionComponents.Length > 4)
        {
            Logging.LogError("Invalid version format. It should have 2, 3, or 4 segments. (Example: '?>> 4.0.2')");
            Environment.Exit((int)HScriptResult.InvalidScriptVersion);
        }

        Version assemblyVersion = Assembly.GetExecutingAssembly().GetName().Version!;
        Version scriptVersion = new(version);
        RVar.SVersion = scriptVersion.ToString();

        int scriptToInterpreterComparison = scriptVersion.CompareTo(assemblyVersion);
        int scriptToAssemblyComparison = scriptVersion.CompareTo(assemblyVersion);

        if (Config.ForceRun)
            return null;

        if (scriptToInterpreterComparison < 0)
            Logging.LogWarning($"Interpreter version ([yellow]v{assemblyVersion}[/]) is newer than HScript version ([yellow]v{scriptVersion}[/]). Some functions may be unavailable or obsolete.");
        else if (scriptToAssemblyComparison > 0)
            Logging.LogError($"HScript version is newer than the interpreter ({assemblyVersion}). Run with '-f' to run anyway. [red](May cause errors)[/]");
        // else, be in shock that its the exact version

        return null;
    }

    public override object? VisitImportScriptConfig([NotNull] HScriptParser.ImportScriptConfigContext context)
    {
        //var filePath = Visit(context.importScript().IDENTIFIER());
        //
        //if (filePath is string path)
        //{
        //    Path.Combine(AppDomain.CurrentDomain.BaseDirectory, path);
        //
        //    HScriptReader.RunScriptFromFile();
        //}

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

    public override object? VisitAssignment([NotNull] HScriptParser.AssignmentContext context)
    {
        string varName;
        object? value;

        if (context.IDENTIFIER() is { } iden)
            varName = iden.GetText();
        else if (context.arrAccess() is { } arrAcc)
            varName = arrAcc.GetText();
        else if (context.localIdentifier() is { } local)
        {
            varName = local.IDENTIFIER().GetText();
            RuntimeMembers.CurrentFunc.ScopedVariables[varName] = "";
        }

        else
            throw new HScriptInvalidOperationException("Failed to locate the variable name for assignment");

        if (context.expression() is { } expr)
            value = Visit(expr);
        else if (context.arrBlock() is { } arrBlock)
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
            case -1:
            case 1: // Normal/no var
                RuntimeMembers.Variables[varName] = value;
                break;
            case 2: // Preset var
                RuntimeMembers.PresetVariables[varName] = value;
                break;
            case 3: // Scoped variables
                RuntimeMembers.CurrentFunc.ScopedVariables[varName] = value;
                break;
        }

        return value;
    }

    public override object? VisitIdentifierExpression([NotNull] HScriptParser.IdentifierExpressionContext context)
    {
        string name = context.IDENTIFIER().GetText();

        // Dispose
        if (name == "_")
            return null;

        // Regular variable access
        if (RuntimeMembers.LocateVariable(name, out var variable) != -1)
            return variable;

        // Check if its a function
        if (RuntimeMembers.LocateFunction(name, out var func) != -1)
            return func;

        return RVar.Default;
    }

    public override object? VisitNestedVariableExpression([NotNull] HScriptParser.NestedVariableExpressionContext context)
    {
        return ResolveNestedVariables(context.nestedVariable().GetText());
    }

    public override object? VisitArrayAccessExpression([NotNull] HScriptParser.ArrayAccessExpressionContext context)
    {
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

            throw new HScriptInvalidOperationException($"Cannot process number '{inum}'");
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

            throw new HScriptInvalidOperationException($"Cannot process number '{uinum}'");
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

        if (context.NULL() is { })
            return null;

        throw new UnknownHScriptTypeException(context.GetText());
    }

    public override object? VisitParethesizedExpression([NotNull] HScriptParser.ParethesizedExpressionContext context)
    {
        return context.expression().Accept(this);
    }

    /* Function Calls And Definitions */

    public override object? VisitFunctionDefinition([NotNull] HScriptParser.FunctionDefinitionContext context)
    {
        var funcName = context.IDENTIFIER().GetText();
        var func = new HFunction(funcName, context.block());
        RuntimeMembers.Functions[funcName] = func;

        return func;
    }

    public override object VisitFunctionClosureExpression([NotNull] HScriptParser.FunctionClosureExpressionContext context)
    {
        return new HFunction(context.functionClosure().block());
    }

    public override object? VisitFunctionCall([NotNull] HScriptParser.FunctionCallContext context)
    {
        var name = context.IDENTIFIER().GetText();
        var args = context.expression().Select(Visit).ToArray() ?? Array.Empty<object?>();

        if (RuntimeMembers.LocateFunction(name, out var func) != -1)
            return func!.Invoke(args!);

        throw new HScriptUnknownFunctionReferenceException(name);
    }

    public override object? VisitBlockExpression([NotNull] HScriptParser.BlockExpressionContext context)
    {
        RuntimeMembers.CallStack.Push(new("temp-block".AsMemberName(), new()));
        // Forward to VisitBlock
        var ret = Visit(context.block());
        RuntimeMembers.CallStack.Pop();
        return ret;
    }

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

    public override object? VisitIfBlock([NotNull] HScriptParser.IfBlockContext context)
    {
        int blockIndex = 0;
        foreach (var expr in context.expression())
        {
            var ret = Visit(expr);
            bool eval;

            if (ret is bool b)
                eval = b;
            else if (ret is int i)
                eval = i == 0;
            else if (ret is uint ui)
                eval = ui == 0;
            else
                throw new HScriptInvalidOperationException("Cannot evaluate non-boolean value");

            if (eval)
                if (blockIndex == 0)
                    return Visit(context.opBlock());
                else
                    return Visit(context.elseIfBlock(blockIndex - 1));

            blockIndex++;
        }

        return null;
    }

    public override object? VisitWhileBlock([NotNull] HScriptParser.WhileBlockContext context)
    {
        bool Evaluate(object? ret)
        {
            bool eval;

            if (ret is bool b)
                eval = b;
            else if (ret is int i)
                eval = i == 0;
            else if (ret is uint ui)
                eval = ui == 0;
            else
                throw new HScriptInvalidOperationException("Cannot evaluate non-boolean value");

            return eval;
        }

        bool InvEvaluate(object? value)
            => !Evaluate(value);

        Func<object?, bool> cond = context.WHILE().GetText() == "while" ? Evaluate : InvEvaluate;

        if (cond(Visit(context.expression())))
            while (cond(Visit(context.expression())))
                Visit(context.opBlock());
        else if (context.elseIfBlock() is { } block)
            Visit(block);

        return null;
    }

    public override object? VisitDynamicCSharpCallExpression([NotNull] HScriptParser.DynamicCSharpCallExpressionContext context)
    {
        var cscode = Visit(context.expression());
        string? code;

        if ((code = cscode as string) is null)
            throw new HScriptInvalidInputParameterException(typeof(string), cscode);

        return DynamicCSharp.Run(code).GetAwaiter().GetResult();
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

    /* Method helpers */

    private object? ResolveNestedVariables(object? value)
    {
        // Recursively resolve nested variables
        if (value is string varName && varName.Length > 1)
            if (varName.StartsWith('@'))
            {
                if (RuntimeMembers.LocateVariable(varName[1..], out var variable) != -1)
                    return ResolveNestedVariables(variable);

                return RVar.Default;
            }
            else
            {
                if (RuntimeMembers.LocateVariable(varName, out var variable) != -1)
                    return variable;

                return RVar.Default;
            }

        return value;
    }
}