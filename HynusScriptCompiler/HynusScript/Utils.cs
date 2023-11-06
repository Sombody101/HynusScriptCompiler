using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.HTypes;
using System.Reflection;
using System.Reflection.Emit;

namespace HynusScriptCompiler.HynusScript;

internal static class Utils
{
    public static int SizeOf<T>(T _)
        => SizeOfCache<T>.SizeOf;

    private static class SizeOfCache<T>
    {
        public static readonly int SizeOf;

        static SizeOfCache()
        {
            var dm = new DynamicMethod("func", typeof(int), Type.EmptyTypes, typeof(Utils));

            ILGenerator il = dm.GetILGenerator();
            il.Emit(OpCodes.Sizeof, typeof(T));
            il.Emit(OpCodes.Ret);

            var func = (Func<int>)dm.CreateDelegate(typeof(Func<int>));
            SizeOf = func();
        }
    }
}

internal static class HRuntime
{
    public static void Error(this HException ex)
    {
        Logging.LogError($"[red]{ex.GetType().Name}[/]: {ex.Message} " +
            $"{(ex.Context is not null ? ($"{ex.Context.Start.Line}:{ex.Context.Start.Column}") : "")}");
    }

    public static string GetTypeName(this object? obj)
    {
        if (obj is null)
            return "null";

        var name = obj.GetType().Name;

        if (!name.StartsWith('H'))
            name = 'H' + name;

        foreach (var pair in TypeNameLookup)
            if (pair.Key == name)
            {
                name = pair.Value;
                break;
            }

        return name;
    }

    public static string AsMemberName(this string name)
        => $"{name}`{{{{{new Random().Next():X8}}}}}";

    public static void Delay(int ms)
    {
        Task.Delay(ms).GetAwaiter().GetResult();
    }

    public static object? ExecuteCSharp(string code)
    {
        try
        {
            string[] parts = code.Split(new[] { "::" }, StringSplitOptions.None);

            if (parts.Length == 2)
            {
                string typeName = parts[0];
                string methodCode = parts[1];

                // Use reflection to dynamically load and invoke the method
                Type type = Type.GetType(typeName);
                MethodInfo method = type.GetMethod("Invoke", new Type[] { typeof(string) });
                if (method != null)
                {
                    object instance = Activator.CreateInstance(type);
                    object result = method.Invoke(instance, new object[] { methodCode });

                    return result;
                }
            }

            return null;
        }
        catch (Exception ex)
        {
            Logging.WriteException("An error occurred while executing dynamic C#", ex);
            return null;
        }
    }

    public static string ResolveAssemblyPaths(this string assemblyPath)
    {
        if (string.IsNullOrEmpty(assemblyPath) || !assemblyPath.Contains('['))
            return assemblyPath;

        foreach (var pathVar in AssemblyVariables)
            assemblyPath = assemblyPath.Replace(pathVar.Key, pathVar.Value);

        return assemblyPath;
    }

    public static Dictionary<string, HFunction> Merge(this IEnumerable<Dictionary<string, HFunction>> dictionaries)
    {
        return dictionaries.SelectMany(dict => dict)
                                 .ToDictionary(pair => pair.Key, pair => pair.Value);
    }

    private static readonly Dictionary<string, string> AssemblyVariables = new()
    {
        { "[HUtils]", "HynusScriptCompiler.HynusScript.Utils" },
        { "[HRuntime]", "HynusScriptCompiler.HynusScript.HRuntime" },
        { "[HTypes]", "HynusScriptCompiler.HynusScript.HTypes" },
    };

    private static readonly Dictionary<string, string> TypeNameLookup = new()
    {
        { "HUndefined", "undefined" },
    };
}