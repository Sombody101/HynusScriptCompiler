//#define SKIP_ERROR_HANDLE // Debugging

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
    UnsupportedScriptVersion,
    LexerError,
    ParserError,
    UnidentifiedParseError,
    InvalidScriptVersion,
    UnhandledException,
    UnsupportedOperation,
    FileImportNotFound,
    FileImportAmbiguity,
}

internal class HScriptReader
{
    private readonly string script;

    public HScriptReader(string fromFile = "", string scriptData = "")
    {
        if (fromFile == "")
        {
            Logging.LogError("There is currently no support for loading a script as a string");
            Environment.Exit((int)HScriptResult.UnsupportedOperation);
        }

        if (scriptData == "")
        {
            if (fromFile == "")
                throw new InvalidScriptInfoException("Neither script data or file path were specified");

            scriptData = File.ReadAllText(fromFile);
        }

        script = scriptData;
        string fullPath = "";

        if (fromFile is not "")
            fullPath = Path.GetFullPath(fromFile);

        string entry = fromFile is "" ? "text-input" : fullPath;

        RuntimeMembers.FileStack.Push(entry);
        RuntimeMembers.ImportedFiles.Add(entry);
        RuntimeMembers.SetProjectRoot(fromFile is "" ? "text-input" : Path.GetDirectoryName(Path.GetFullPath(fullPath))! + '\\');
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


        if (Config.ShowLogs)
        {
            Logging.WriteLine($" | Took {sw.ElapsedMilliseconds}ms\r\n");
            sw.Restart();
            Logging.WriteLine("Beginning token parse");
        }

        HScriptParser parser = new(new CommonTokenStream(lexer));
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

#if SKIP_ERROR_HANDLE
        visitor.Visit(context);
#else
        try
        {
            visitor.Visit(context);
        }
        catch (HException e)
        {
            HRuntime.Error(e);
            return HScriptResult.ScriptError;
        }
        catch (Exception e)
        {
            HRuntime.Error(e);
        }
#endif

        return HScriptResult.Successful;
    }
}
