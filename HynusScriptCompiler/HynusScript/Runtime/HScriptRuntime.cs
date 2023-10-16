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
    public static void Initialize()
    {
        Variables = new();
        Functions = new();
        BuiltInFunctions = HTypes.BuiltInFunctions.GetBuiltInFunctions();
        PresetVariables = new()
        {
            { "iVersion", Assembly.GetExecutingAssembly().GetName().Version!.ToString() },
            { "sVersion", null },
            { "winVersion", Environment.OSVersion.ToString() },
        };
    }

    internal static Dictionary<string, HFunction> BuiltInFunctions { get; private set; }
    internal static Dictionary<string, object?> Variables { get; private set; }
    internal static Dictionary<string, object?> PresetVariables { get; private set; }
    internal static Dictionary<string, HFunction> Functions { get; private set; }

    public static void OverwriteBuiltInFunctions(Dictionary<string, HFunction> funcs)
        => BuiltInFunctions = funcs;
}

internal class HScriptRuntime : HScriptBaseVisitor<object?>
{
    public HScriptRuntime()
    {
        RuntimeMembers.Initialize();
    }

    public override object? VisitScriptVersion([NotNull] HScriptParser.ScriptVersionContext context)
    {
        var version = context.VERSIONSTR().GetText();

        string[] versionComponents = version.Split('.');

        if (versionComponents.Length < 2 || versionComponents.Length > 4)
        {
            Console.WriteLine("Invalid version format. It should have 2, 3, or 4 segments. (Example: '?>> 4.0.2')");
            Environment.Exit((int)HScriptResult.InvalidScriptVersion);
        }

        Version assemblyVersion = Assembly.GetExecutingAssembly().GetName().Version!;
        Version scriptVersion = new(version);
        RuntimeMembers.PresetVariables["sVersion"] = scriptVersion.ToString();

        int scriptToInterpreterComparison = scriptVersion.CompareTo(assemblyVersion);
        int scriptToAssemblyComparison = scriptVersion.CompareTo(assemblyVersion);

        if (Config.ForceRun)
            return null;

        if (scriptToInterpreterComparison < 0)
            Logging.LogWarning("Interpreter version is newer than HScript version. Some functions may be unavailable or obsolete.");
        else if (scriptToAssemblyComparison > 0)
            Logging.LogError($"HScript version is newer than the interpreter ({assemblyVersion}). Run with '-f' to run anyway. [red](May cause errors)[/]");
        // else, be in shock that its the exact version

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

        foreach (var item in RuntimeMembers.BuiltInFunctions.Keys)
        {
            Console.WriteLine(item);
        }

        return null;
    }

    public override object? VisitAssignment([NotNull] HScriptParser.AssignmentContext context)
    {
        var varName = context.IDENTIFIER().GetText();
        var value = Visit(context.expression());

        RuntimeMembers.Variables[varName] = value;

        return new();
    }

    public override object? VisitIdentifierExpression([NotNull] HScriptParser.IdentifierExpressionContext context)
    {
        string name = "";

        try
        {
            name = context.nestedVariable().GetText();
        }
        catch
        {
            name = context.IDENTIFIER().GetText();
        }

        if (name.StartsWith('$'))
            return ResolveNestedVariables(name[1..]);

        if (RuntimeMembers.Variables.ContainsKey(name))
            return RuntimeMembers.Variables[name];
        else if (RuntimeMembers.PresetVariables.ContainsKey(name))
            return RuntimeMembers.PresetVariables[name];

        return "";
    }

    public override object? VisitConstant([NotNull] HScriptParser.ConstantContext context)
    {
        if (context.INTEGER() is { } num)
            return int.Parse(num.GetText());

        if (context.UINTEGER() is { } unum)
            return uint.Parse(unum.GetText()[..^1]);

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
            return float.Parse(flt.GetText()[..^1]);

        if (context.STRING() is { } str)
            return str.GetText()[1..^1]; // "string" => string

        if (context.CHAR() is { } chr)
            return chr.GetText()[1]; // 'A' => A

        if (context.BOOL() is { } bul)
            return bul.GetText() is "true" or "True";

        if (context.NULL() is { })
            return null;


        throw new UnknownHScriptTypeException(context.GetText());
    }

    public override object? VisitFunctionDefinition([NotNull] HScriptParser.FunctionDefinitionContext context)
    {
        RuntimeMembers.Functions.Add(context.IDENTIFIER().GetText(),
            new HFunction(context.block().GetText()));

        return new();
    }

    public override object? VisitFunctionCall([NotNull] HScriptParser.FunctionCallContext context)
    {
        var name = context.IDENTIFIER().GetText();
        var args = context.expression().Select(Visit).ToArray();

        HFunction func;

        if (RuntimeMembers.BuiltInFunctions.ContainsKey(name))
            func = RuntimeMembers.BuiltInFunctions[name];
        else if (RuntimeMembers.Functions.ContainsKey(name))
            func = RuntimeMembers.Functions[name];
        else
            throw new HScriptUnknownFunctionReferenceException(name);

        return func.Invoke(args!);
    }

    public override object? VisitParethesizedExpression([NotNull] HScriptParser.ParethesizedExpressionContext context)
    {
        return context.expression().Accept(this);
    }

    public override object? VisitWhileBlock([NotNull] HScriptParser.WhileBlockContext context)
    {
        bool Evaluate(object? value)
        {
            if (value is bool bul)
                return bul;

            throw new HScriptInvalidOperationException("Value is not of type bool");
        }

        bool InvEvaluate(object? value)
            => !Evaluate(value);

        Func<object?, bool> cond = context.WHILE().GetText() == "while" ? Evaluate : InvEvaluate;

        if (cond(Visit(context.expression())))
        {
            do
            {
                Visit(context.block());
            } while (cond(Visit(context.expression())));
        }
        else if (context.elseIfBlock() is { } block)
            Visit(block);

        return null;
    }

    /* Operations */

    public override object? VisitAdditiveExpression([NotNull] HScriptParser.AdditiveExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.addOp().GetText();

        return op switch
        {
            "+" => Operations.Add(left, right),
            "-" => Operations.Subtract(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown additive operator '{op}'")
        };
    }

    public override object? VisitMultiplicativeExpression([NotNull] HScriptParser.MultiplicativeExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.multOp().GetText();

        return op switch
        {
            "*" => Operations.Multiply(left, right),
            "/" => Operations.Divide(left, right),
            "%" => Operations.Modulo(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown multiplicative operator '{op}'")
        };
    }

    public override object? VisitComparisonExpression([NotNull] HScriptParser.ComparisonExpressionContext context)
    {
        var left = Visit(context.expression(0));
        var right = Visit(context.expression(1));

        var op = context.comareOp().GetText();

        return op switch
        {
            ":!=" => !(bool)Operations.CompareType(left, right),
            ":==" => Operations.CompareType(left, right),
            "!=" => !(bool)Operations.Compare(left, right),
            "==" => Operations.Compare(left, right),
            ">=" => (bool)Operations.GreaterThan(left, right) || (bool)Operations.Compare(left, right),
            "<=" => !(bool)Operations.GreaterThan(left, right) || (bool)Operations.Compare(left, right),
            ">" => Operations.GreaterThan(left, right),
            "<" => !(bool)Operations.GreaterThan(left, right),
            _ => throw new HScriptUnknownOperationException($"Unknown comparison operator '{op}'")
        };
    }

    public override object? VisitUnaryExpression([NotNull] HScriptParser.UnaryExpressionContext context)
    {
        var value = Visit(context.expression());
        var op = context.unaryOp().GetText();

        return op switch
        {
            "!" => Operations.LogicNot(value),
            "~" => Operations.BitwiseNot(value),
            "+" => Operations.BitwisePlus(value),
            "-" => Operations.BitwiseMinus(value),
            _ => throw new HScriptUnknownOperationException($"Unknown unary operator '{op}'")
        };
    }

    /* Failed to get double ops working */
    //public override object VisitDoubleExpression([NotNull] HScriptParser.DoubleExpressionContext context)
    //{
    //    var value = Visit(context.expression());
    //    var op = context.doubleOp().GetText();
    //
    //    return op switch
    //    {
    //        "++" => Operations.PlusPlus(value),
    //        "--" => Operations.MinusMinus(value),
    //        _ => throw new HScriptUnknownOperationException($"Unknown double operator '{op}'")
    //    };
    //}

    /* Method helpers */

    private object? ResolveNestedVariables(object? value)
    {
        // Recursively resolve nested variables
        if (value is string variableName && variableName.Length > 1)
            if (variableName.StartsWith('$'))
                return ResolveNestedVariables(RuntimeMembers.Variables[variableName[1..]]);
            else
                return ResolveNestedVariables(RuntimeMembers.Variables[variableName]);

        return value;
    }
}