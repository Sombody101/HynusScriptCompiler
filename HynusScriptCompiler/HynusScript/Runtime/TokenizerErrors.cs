using Antlr4.Runtime;
using Spectre.Console;

namespace HynusScriptCompiler.HynusScript.Runtime;

public class HScriptLexerErrorListener : IAntlrErrorListener<int>
{
    public bool ErrorOccured = false;

    public void SyntaxError(TextWriter output, IRecognizer recognizer,
        int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        string sourceName = recognizer.InputStream.SourceName;

        AnsiConsole.MarkupLineInterpolated($"[white]line:{line} [cyan]col[/]:{charPositionInLine} [red]src[/]:{sourceName} [yellow]msg[/]:{msg}[/]");
        AnsiConsole.MarkupLine("[white]--------------------[/]");

#if DEBUG
        if (e is null)
            Console.WriteLine("Failed to load lexer exception data");
        else
            AnsiConsole.WriteException(e); 
        AnsiConsole.MarkupLine("[white]--------------------[/]");
#endif
        ErrorOccured = true;
    }
}
public class HScriptParserErrorListener : BaseErrorListener
{
    public bool ErrorOccured = false;

    public override void SyntaxError(TextWriter output, IRecognizer recognizer,
        IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        string sourceName = recognizer.InputStream.SourceName;

        AnsiConsole.MarkupLineInterpolated($"[white]line:{line} [cyan]col[/]:{charPositionInLine} [red]src[/]:{sourceName} [yellow]msg[/]:{msg}[/]");
        AnsiConsole.MarkupLine("[white]--------------------[/]");

#if DEBUG
        if (e is null)
            Console.WriteLine("Failed to load parser exception data");
        else
            AnsiConsole.WriteException(e);
        AnsiConsole.MarkupLine("[white]--------------------[/]");
#endif

        ErrorOccured = true;
    }
}