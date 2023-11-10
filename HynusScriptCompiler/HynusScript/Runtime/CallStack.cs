using Microsoft.CodeAnalysis;

namespace HynusScriptCompiler.HynusScript.Runtime;

internal class CallStack
{
    public Stack<HScopeContext> Stack { get; init; }

    public int Count { get => Stack.Count; }

    public CallStack()
    {
        Stack = new();
    }

    public void Push(HScopeContext funcContext)
    {
        Stack.Push(funcContext);
    }

    public HScopeContext Pop()
    {
        return Stack.Pop();
    }

    public HScopeContext? Peek()
    {
        if (Stack.Count == 0) 
            return null;

        return Stack.Peek();
    }

    public static bool TryGetScopedVariable(string varName, out object? value)
    {
        value = null;

        // Lock the call stack (in case async is added in the future)
        lock (RuntimeMembers.CallStack.Stack)
        {
            // Copy stack
            //var vStack = RuntimeMembers.CallStack.Stack.ToArray();

            // Loop through in reverse
            foreach (var sElm in RuntimeMembers.CallStack.Stack)
            {
                if (sElm.ID.StartsWith("function") || sElm.ID.StartsWith("script-import"))
                    return sElm.ScopedVariables.TryGetValue(varName, out value);
                
                if (sElm.ScopedVariables.TryGetValue(varName, out value))
                    return true; // Return true if the value is found
            }
        }

        return false;
    }
}

internal class HScopeContext
{
    public string ID { get; }
    public Dictionary<string, object?> ScopedVariables { get; private set; }

    public HScopeContext(string id, Dictionary<string, object?> scopedVariables)
    {
        ID = id;
        ScopedVariables = scopedVariables;
    }

    public HScopeContext(string id)
    {
        ID = id;
        ScopedVariables = new();
    }
}