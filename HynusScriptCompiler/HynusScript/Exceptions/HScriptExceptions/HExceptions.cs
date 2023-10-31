using Antlr4.Runtime;

namespace HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;

public class HException : Exception
{
    public ParserRuleContext? Context { get; private set; }

    public HException(string message, ParserRuleContext? context)
        : base(message) => Context = context;
}

public class HScriptInvalidOperationException : HException
{
    public HScriptInvalidOperationException(string message, ParserRuleContext? context = null)
        : base(message, context)
    { }
}

public class HScriptUnknownOperationException : HException
{
    public HScriptUnknownOperationException(string message, ParserRuleContext? context = null)
        : base(message, context)
    { }
}

public class HScriptInvalidInputParameterCountException : HException
{
    public HScriptInvalidInputParameterCountException(string properCount, ParserRuleContext? context = null)
        : base($"Input parameter count is {properCount}", context)
    { }

    public HScriptInvalidInputParameterCountException(int properCount, ParserRuleContext? context = null)
    : base($"Input parameter count is {properCount}", context)
    { }
}

public class HScriptInvalidInputParameterException : HException
{
    public HScriptInvalidInputParameterException(object? wantedType, object? errorType, ParserRuleContext? context = null)
        : base($"Encountered input parameter type '{errorType.GetTypeName()}' when '{wantedType.GetTypeName()}' was expected", context)
    { }
}

public class HScriptUnknownFunctionReferenceException : HException
{
    public HScriptUnknownFunctionReferenceException(string functionName, ParserRuleContext? context = null)
        : base($"Failed to find a function by the name of '{functionName}'", context)
    { }
}

public class HScriptUnknownVariableReferenceException : HException
{
    public HScriptUnknownVariableReferenceException(string varName, ParserRuleContext? context = null)
        : base($"The variable by the name '{varName}' does not exist", context)
    { }
}

public class HScriptUnknownScriptCaseStyleException : HException
{
    public HScriptUnknownScriptCaseStyleException(string receivedStyle, ParserRuleContext? context = null)
        : base($"Unknown case style '{receivedStyle}'", context)
    { }
}