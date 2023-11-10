namespace HynusScriptCompiler.HynusScript.Exceptions.RuntimeExceptions;

public class InvalidScriptInfoException : Exception
{
    public InvalidScriptInfoException(string message)
        : base(message)
    { }
}

public class ScriptImportException : Exception
{
    public ScriptImportException(string message)
        : base(message)
    { }
}