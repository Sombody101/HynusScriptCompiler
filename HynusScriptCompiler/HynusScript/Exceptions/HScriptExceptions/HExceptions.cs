namespace HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;

public class HException : Exception
{
    public HException(string message)
    {

    }
}

public class HScriptInvalidOperationException : HException
{
    public HScriptInvalidOperationException(string message)
        : base(message)
    { }
}

public class HScriptUnknownOperationException : HException
{
    public HScriptUnknownOperationException(string message)
        : base(message)
    { }
}

public class HScriptInvalidInputParameterCountException : HException
{
    public HScriptInvalidInputParameterCountException(string properCount)
        : base($"Input parameter count is {properCount}")
    { }

    public HScriptInvalidInputParameterCountException(int properCount)
    : base($"Input parameter count is {properCount}")
    { }
}

public class HScriptUnknownFunctionReferenceException : HException
{
    public HScriptUnknownFunctionReferenceException(string functionName)
        : base($"Failed to find a function by the name of '{functionName}'")
    { }
}

public class HScriptUnknownVariableReferenceException : HException
{
    public HScriptUnknownVariableReferenceException(string varName)
        : base($"The variable by the name '{varName}' does not exist")
    { }
}

public class HScriptUnknownScriptCaseStyleException : HException
{
    public HScriptUnknownScriptCaseStyleException(string receivedStyle)
        : base($"Unknown case style '{receivedStyle}'")
    { }
}