using HynusScriptCompiler.HynusScript.Runtime;
using Spectre.Console;

namespace HynusScriptCompiler.HynusScript.HTypes;

/// <summary>
/// A struct that is intended to be a null type, and is used when a variable is uninitialized (Because 'null' is already used as it's own type)
/// </summary>
internal struct HUndefined { }

internal class HFunction
{
    private readonly object Function;


    public string Name { get; set; }
    public Dictionary<string, object?> Parameters { get; set; }

    public HFunction(Func<object[], object?> func)
    {
        Name = $"built-in".AsMemberName();
        Function = func;
        Parameters = new(0);
    }

    public HFunction(string name, Dictionary<string, object?> param, HScriptParser.BlockContext hscript)
    {
        Name = name;
        Function = hscript;
        Parameters = param;
    }

    public HFunction(HScriptParser.BlockContext hscript)
    {
        Name = $"user-defined-closure".AsMemberName();
        Function = hscript;
        Parameters = new(0);
    }

    public object? Invoke(object[]? obs)
    {
        obs ??= Array.Empty<object>();

        if (Function is Func<object[], object?> func)
            return func(obs);

        else if (Function is HScriptParser.BlockContext context)
        {
            //Dictionary<string, object?> vars = new()
            //{
            //    { "$@", obs.Select(ob => ob.ToString() ?? RVar.Default) },
            //    { "$#", obs.Length }
            //};
            //
            //for (int i = 0; i < obs.Length; i++)
            //    vars.Add($"${i + 1}", obs[i]);

            Dictionary<string, object?> vars = MapParameters(Parameters, obs);

            RuntimeMembers.CallStack.Push(new HFunctionCallContext(Name, vars));
            var ret = HScriptRuntime.StaticAccess.Visit(context);
            RuntimeMembers.CallStack.Pop();

            return ret;
        }

        return null;
    }

    private static Dictionary<string, object?> MapParameters(Dictionary<string, object?> fromDef, object[] fromCall)
    {
        Dictionary<string, object?> ctx = new();

        for (int i = 0; i < fromDef.Count; i++)
        {
            var parameter = fromDef.ElementAt(i);
            object? value = i < fromCall.Length ? fromCall[i] : new HUndefined();

            if (value is not HUndefined)
                ctx.Add(parameter.Key, value);
            else
            {
                if (parameter.Value is not HUndefined)
                    ctx.Add(parameter.Key, parameter.Value);
                else
                    ctx.Add(parameter.Key, new HUndefined());
            }
        }

        return ctx;
    }

}

internal class HFunctionCallContext
{
    public string ID { get; }
    public Dictionary<string, object?> ScopedVariables { get; private set; }

    public HFunctionCallContext(string id, Dictionary<string, object?> scopedVariables)
    {
        ID = id;
        ScopedVariables = scopedVariables;
    }
}

internal static class BuiltInFunctions
{
    /// <summary>
    /// Gets all built in functions in PascalCase
    /// </summary>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctions()
    {
        return new()
        {
            { "Input", new(Input) },
            { "Markup", new(Markup) },
            { "MarkupLine", new(MarkupLine) },
            { "Write", new(Write) },
            { "WriteLine", new(WriteLine) },

            // Logging
            { "Log", new(Log) },
            { "LogWarning", new(LogWarning) },
            { "LogError", new(LogError) },
            { "WriteTitle", new(WriteTitle) },
            { "WriteData", new(WriteData) },

            // Environment
            { "ListVariables", new(ListVariables) },
            { "ListFunctions", new(List) },
            { "GcClean", new(ExitScript) },

            // Keyword methods
            { "typeof", new(TypeOf) },
            { "sizeof", new(SizeOf) },
            { "delete", new(DeleteMember) },
            { "exit", new(ExitScript) },
        };
    }

    public static object? List(object[] obs)
    {
        foreach (var f in RuntimeMembers.Functions)
            Console.WriteLine($"{f.Key} : {f.Value.Name}");
        return null;
    }

    #region DebuggingFunctions

    private static Dictionary<string, HFunction> DebuggingFunctions()
    {
        return new()
        {
            { "CallStack", new(GetCallStack) },
        };
    }

    public static object? GetCallStack(object[] obs)
    {
        foreach (var call in RuntimeMembers.CallStack.Stack)
            Console.WriteLine("+ " + call.ID);

        return RVar.Default;
    }

    #endregion

    #region MethodNameManipulation

    /// <summary>
    /// Gets all built in functions in camelCase
    /// </summary>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctionsAsCamel()
    {
        return GetBuiltInFunctions().ToDictionary(
            kvp => char.ToLower(kvp.Key[0]) + kvp.Key[1..],
            kvp => kvp.Value
        );
    }

    /// <summary>
    /// Gets all built in functions in snake_case
    /// </summary>
    /// <param name="inputDictionary"></param>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctionsAsSnake()
    {
        var methods = GetBuiltInFunctions();
        var convertedDictionary = new Dictionary<string, HFunction>();

        foreach (var kvp in methods)
            convertedDictionary[ConvertToSnakeCase(kvp.Key)] = kvp.Value;

        return convertedDictionary;
    }

    /// <summary>
    /// Gets all built in functions in kebab-case
    /// </summary>
    /// <param name="inputDictionary"></param>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctionsAsKebab()
    {
        var methods = GetBuiltInFunctions();
        var convertedDictionary = new Dictionary<string, HFunction>();

        foreach (var kvp in methods)
            convertedDictionary[ConvertToKebabCase(kvp.Key)] = kvp.Value;

        return convertedDictionary;
    }

    /// <summary>
    /// Get all built in functions in pig-latin
    /// </summary>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctionsAsPigLatin()
    {
        var methods = GetBuiltInFunctions();
        var pigLatin = new Dictionary<string, HFunction>();

        foreach (var kvp in methods)
            pigLatin[ToPigLatin(kvp.Key)] = kvp.Value;

        return pigLatin;
    }

    public static Dictionary<string, HFunction> GetDebuggingFunctions()
    {
        return HRuntime.Merge(new List<Dictionary<string, HFunction>>()
        {
            RuntimeMembers.Functions,
            DebuggingFunctions()
        });
    }

    #endregion

    #region UserIO

    public static object? Input(object[] strs)
    {
        Write(strs);
        return Console.ReadLine();
    }

    public static object? Markup(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            AnsiConsole.Markup(str, data);
        else
            AnsiConsole.Markup(str);

        return RVar.Default;
    }

    public static object? MarkupLine(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            AnsiConsole.MarkupLine(str, data);
        else
            AnsiConsole.MarkupLine(str);

        return RVar.Default;
    }

    public static object? Write(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            Console.Write(str, data);
        else
            Console.Write(str);

        return RVar.Default;
    }

    public static object? WriteLine(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            Console.WriteLine(str, data);
        else
            Console.WriteLine(str);

        return RVar.Default;
    }

    /* Logging */

    public static object? Log(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.Log(str);
        return RVar.Default;
    }

    public static object? LogWarning(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.LogWarning(str);
        return RVar.Default;
    }

    public static object? LogError(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.LogError(str);
        return RVar.Default;
    }

    public static object? WriteTitle(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.WriteTitle(str);
        return RVar.Default;
    }

    public static object? WriteData(object[] strs)
    {
        (var str, var data) = ResolveStrings(strs);

        Logging.WriteData(str, data);
        return RVar.Default;
    }

    /* HScript environment functions */

    public static object? ExitScript(object[] strs)
    {
        (var code, _) = ResolveStrings(strs);

        if (int.TryParse(code, out var exitCode))
            Environment.Exit(exitCode);

        Environment.Exit(0); // Exits even if the user typed a string

        return RVar.Default;
    }

    public static object? GetType(object[] strs)
    {
        if (strs is null || strs.Length == 0)
            return RVar.Default;

        var obj = strs[0];
        if (obj is null)
            return RVar.Default;

        return obj.GetType().Name;
    }

    public static object? DeleteMember(object[] strs)
    {
        var allGood = true;

        foreach (string member in GetStrings(strs))
            if (!RuntimeMembers.Variables.Remove(member))
                allGood = false;

        return allGood;
    }

    public static object? ListVariables(object[] _)
    {
        foreach (var variable in RuntimeMembers.Variables)
            Console.WriteLine(variable.Key);

        return RVar.Default;
    }

    public static object? CollectGarbage()
    {
        GC.Collect();
        return RVar.Default;
    }

    public static object? SizeOf(object[] obs)
    {
        var str = obs[0] is null ? "null" : Operations.EscapeString(obs[0].ToString() ?? "null");
        return Utils.SizeOf(str);
    }

    public static object? TypeOf(object[] obs)
    {
        if (obs is null || obs.Length is 0)
            return RVar.Default;

        return obs[0].GetTypeName();
    }

    #endregion

    #region MethodHelpers

    private static string ConvertToSnakeCase(string input)
    {
        return string.Join("_", input.Split(' ').Select(word => word.ToLower()));
    }

    private static string ConvertToKebabCase(string input)
    {
        return string.Join("-", input.Split(' ').Select(word => word.ToLower()));
    }

    private static (string, string[]) ResolveStrings(object[] obs)
    {
        if (obs is null || obs.Length == 0 || obs[0] is null)
            return ("null", Array.Empty<string>());

        return (
            Operations.EscapeString(obs[0].ToString() ?? "null"),
            obs[1..].Select(st => st is null ? "null" : Operations.EscapeString(st.ToString() ?? "null")).ToArray()
        );
    }

    public static string[] ResolveObjects(object[] obs)
        => obs.Select(st => st is null ? "null" : Operations.EscapeString(st.ToString() ?? "null")).ToArray();

    private static (string, object[]) ResolveStringObjects(object[] obs)
    {
        if (obs is null || obs.Length == 0 || obs[0] is null)
            return ("null", Array.Empty<string>());

        return (Operations.EscapeString(obs[0].ToString() ?? "null"), obs[1..]);
    }

    private static string[] GetStrings(object[] obs)
    {
        if (obs is null || obs.Length == 0 || obs[0] is null)
            return Array.Empty<string>();

        return obs.Select(st => Operations.EscapeString(st.ToString() ?? "null")).ToArray();
    }

    private static string ToPigLatin(string input)
    {
        if (string.IsNullOrEmpty(input))
            return input;

        input = input.ToLower();
        string vowels = "aeiou";

        if (vowels.Contains(input[0]))
            return input + "way";
        else
        {
            int firstVowelIndex = input.IndexOfAny(vowels.ToCharArray());
            return string.Concat(input.AsSpan(firstVowelIndex), input.AsSpan(0, firstVowelIndex), "ay");
        }
    }

    #endregion
}
