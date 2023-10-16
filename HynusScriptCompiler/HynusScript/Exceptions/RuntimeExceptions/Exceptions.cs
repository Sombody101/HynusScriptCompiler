namespace HynusScriptCompiler.HynusScript.Exceptions.RuntimeExceptions;

public class InvalidScriptInfoException : Exception
{
    public InvalidScriptInfoException(string message)
        : base(message)
    { }
}

public class UnknownHScriptTypeException : Exception
{
    public UnknownHScriptTypeException(string type) 
        : base($"Unknown HScript type '{type}'")
    { }
}