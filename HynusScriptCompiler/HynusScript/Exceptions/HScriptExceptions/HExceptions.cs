namespace HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;

public class HScriptInvalidOperationException : Exception
{
    public HScriptInvalidOperationException(string message)
        : base(message)
    { }
}

public class HScriptUnknownOperationException : Exception
{
    public HScriptUnknownOperationException(string message)
        : base(message) 
    { }
}

public class HScriptInvalidInputParameterCountException : Exception
{
    public HScriptInvalidInputParameterCountException(string properCount)
        : base($"Input parameter count is {properCount}")
    { }

    public HScriptInvalidInputParameterCountException(int properCount)
    : base($"Input parameter count is {properCount}")
    { }
}

public class HScriptUnknownFunctionReferenceException : Exception
{
    public HScriptUnknownFunctionReferenceException(string functionName)
        : base($"Failed to find a function by the name of '{functionName}'") 
    { }
}

public class HScriptUnknownVariableReferenceException : Exception
{
    public HScriptUnknownVariableReferenceException(string varName)
        : base($"The variable by the name '{varName}' does not exist")
    { }
}

public class HScriptUnknownScriptCaseStyleException : Exception
{
    public HScriptUnknownScriptCaseStyleException(string receivedStyle)
        : base($"Unknown case style '{receivedStyle}'")
    { }
}