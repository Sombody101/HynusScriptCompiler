using Antlr4.Runtime;
using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using System.Reflection.Emit;

namespace HynusScriptCompiler.HynusScript;

public static class Utils
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

public static class HRuntime
{
    public static void Error(HException ex, ParserRuleContext context)
    {
        Logging.LogError($"{ex.Message} {context.Start.Line}:{context.Start.Column}");
    }
}