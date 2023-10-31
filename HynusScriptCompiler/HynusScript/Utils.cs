using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.HTypes;
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

        return name;
    }

    public static string AsMemberName(this string name)
        => $"{name}`{{{{{new Random().Next():X8}}}}}";

    public static Dictionary<string, HFunction> Merge(this IEnumerable<Dictionary<string, HFunction>> dictionaries)
    {
        return dictionaries.SelectMany(dict => dict)
                                 .ToDictionary(pair => pair.Key, pair => pair.Value);
    }
}