using HynusScriptCompiler.HynusScript.HTypes;

namespace HynusScriptCompiler.HynusScript.Runtime;

internal class CallStack
{
    public Stack<HFunctionCallContext> Stack { get; }

    public int Count { get => Stack.Count; }

    public CallStack()
    {
        Stack = new();
    }

    public void Push(HFunctionCallContext funcContext)
    {
        Stack.Push(funcContext);
    }

    public HFunctionCallContext Pop()
    {
        return Stack.Pop();
    }

    public HFunctionCallContext Peek()
    {
        return Stack.Peek();
    }
}
