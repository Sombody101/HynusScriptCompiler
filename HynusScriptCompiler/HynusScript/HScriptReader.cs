using Antlr4.Runtime;
using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.Exceptions.RuntimeExceptions;
using HynusScriptCompiler.HynusScript.Runtime;
using System.Diagnostics;

namespace HynusScriptCompiler.HynusScript;

public enum HScriptResult
{
    DeveloperErrorLol = -1,
    Successful,
    ScriptError,
    ScriptNotFound,
    UnsuportedScriptVersion,
    LexerError,
    ParserError,
    UnidentifiedParseError,
    InvalidScriptVersion,
}

internal class HScriptReader : HScriptBaseVisitor<int>
{
    private readonly string script;

    public HScriptReader(string fromFile = "", string scriptData = "")
    {
        if (scriptData == "")
        {
            if (fromFile == "")
                throw new InvalidScriptInfoException("Neither script data or file path were specified");

            scriptData = File.ReadAllText(fromFile);
        }

        script = scriptData;
    }

    public static HScriptResult RunScriptFromFile(string scriptPath)
    {
        if (!File.Exists(scriptPath))
            return HScriptResult.ScriptNotFound;

        var reader = new HScriptReader(scriptPath);
        return reader.scriptRunner();
    }

    public static HScriptResult RunScriptFromString(string scriptStr)
    {
        var reader = new HScriptReader("", scriptStr);
        return reader.scriptRunner();
    }

    private HScriptResult scriptRunner()
    {
        Stopwatch sw = null!; // Being able to add '!' to a literal null is the dumbest thing ever

        if (Config.ShowLogs)
        {
            Logging.WriteLine("Beginning tokenization");
            sw = Stopwatch.StartNew();
        }

        HScriptLexer? lexer = new(new AntlrInputStream(script));

        lexer.RemoveErrorListeners();
        var lexerListener = new HScriptLexerErrorListener();
        lexer.AddErrorListener(lexerListener);

        if (lexerListener.ErrorOccured)
            return HScriptResult.LexerError;

        CommonTokenStream? tokens = new(lexer);

        if (Config.ShowLogs)
        {
            Logging.WriteLine($" | Took {sw.ElapsedMilliseconds}ms\r\n");
            sw.Restart();
            Logging.WriteLine("Beginning token parse");
        }

        HScriptParser parser = new(tokens);
        parser.RemoveErrorListeners();
        var parserListener = new HScriptParserErrorListener();
        parser.AddErrorListener(parserListener);
        var context = parser.program();

        if (parserListener.ErrorOccured)
            return HScriptResult.ParserError;

        var visitor = new HScriptRuntime();

        if (Config.ShowLogs)
        {
            sw.Stop();
            Logging.WriteLine($" | Took {sw.ElapsedMilliseconds}ms\r\n");
            Logging.Log("Running script");
        }

        try
        {
            visitor.Visit(context);
        }
        catch (HException e)
        {
            HRuntime.Error(e);
            return HScriptResult.ScriptError;
        }

        return HScriptResult.Successful;
    }
}
