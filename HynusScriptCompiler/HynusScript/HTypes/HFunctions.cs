using HynusScriptCompiler.HynusScript.Runtime;
using Spectre.Console;
using System.Drawing;
using System;

namespace HynusScriptCompiler.HynusScript.HTypes;

internal class HFunction
{
    private readonly object Function;

    public HFunction(Func<object[], object?> func)
    {
        Function = func;
    }

    public HFunction(string hscript)
    {
        Function = hscript;
    }

    public object? Invoke(object[] obs)
    {
        if (Function is Func<object[], object?> func)
            return func(obs);

        return null;
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
            { "GetType", new(GetType) },
            { "SizeOf", new(SizeOf) },
            { "ListVariables", new(ListVariables) },

            // Keyword methods
            { "delete", new(DeleteMember) },
            { "exit", new(ExitScript) },
        };
    }

    /* Method Name Manupulation */

    /// <summary>
    /// Gets all built in functions in camelCase
    /// </summary>
    /// <returns></returns>
    public static Dictionary<string, HFunction> GetBuiltInFunctionsAsCamel()
    {
        var methods = GetBuiltInFunctions();

        var toLower = methods.ToDictionary(
            kvp => char.ToLower(kvp.Key[0]) + kvp.Key[1..],
            kvp => kvp.Value
        );

        return toLower;
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
        {
            var convertedKey = ConvertToSnakeCase(kvp.Key);
            convertedDictionary[convertedKey] = kvp.Value;
        }

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
        {
            var convertedKey = ConvertToKebabCase(kvp.Key);
            convertedDictionary[convertedKey] = kvp.Value;
        }

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
        {
            var pigLatinName = ToPigLatin(kvp.Key);
            pigLatin[pigLatinName] = kvp.Value;
        }

        return pigLatin;
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

    /* User I/O */

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
        return null;
    }

    public static object? MarkupLine(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            AnsiConsole.MarkupLine(str, data);
        else
            AnsiConsole.MarkupLine(str);
        return null;
    }

    public static object? Write(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            Console.Write(str, data);
        else
            Console.Write(str);
        return null;
    }

    public static object? WriteLine(object[] strs)
    {
        (var str, var data) = ResolveStringObjects(strs);

        if (data.Length != 0)
            Console.WriteLine(str, data);
        else
            Console.WriteLine(str);

        return null;
    }

    /* Logging */

    public static object? Log(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.Log(str);
        return null;
    }

    public static object? LogWarning(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.LogWarning(str);
        return null;
    }

    public static object? LogError(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.LogError(str);
        return null;
    }

    public static object? WriteTitle(object[] strs)
    {
        (var str, _) = ResolveStrings(strs);

        Logging.WriteTitle(str);
        return null;
    }

    public static object? WriteData(object[] strs)
    {
        (var str, var data) = ResolveStrings(strs);

        Logging.WriteData(str, data);
        return null;
    }

    /* HScript environment functions */

    public static object? ExitScript(object[] strs)
    {
        (var code, _) = ResolveStrings(strs);

        if (int.TryParse(code, out var exitCode))
            Environment.Exit(exitCode);

        Environment.Exit(0); // Exits even if the user typed a string

        return null; // Useless
    }

    public static object? GetType(object[] strs)
    {
        if (strs is null || strs.Length == 0)
            return "null";

        var obj = strs[0];
        if (obj is null)
            return "null";

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

        return null;
    }

    public static object? SizeOf(object[] obs)
    {
        var str = obs[0] is null ? "null" : Operations.EscapeString(obs[0].ToString() ?? "null");
        return Utils.SizeOf(str);
    }

    /* Method helpers */

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

        var str = Operations.EscapeString(obs[0].ToString() ?? "null");
        var data = obs[1..].Select(st => st is null ? "null" : Operations.EscapeString(st.ToString() ?? "null")).ToArray();

        return (str, data);
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
}
