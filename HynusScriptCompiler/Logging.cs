using HynusScriptCompiler.HynusScript.Runtime;
using Spectre.Console;
using System.Text;

namespace HynusScriptCompiler;

internal static class Logging
{
    public static void ILog(string log)
    {
        if (Config.ShowLogs)
            AnsiConsole.MarkupLine("[magenta1]HScript[/]: " + log);
    }

    public static void WriteLine(string line = "")
        => AnsiConsole.MarkupLine(line);

    public static void Write(string text = "")
        => AnsiConsole.Markup(text);

    public static void Log(string log)
        => WriteLine("[blue][[!]][/]\t" + log);

    public static void LogWarning(string log)
        => WriteLine("[yellow][[!]][/]\t" + log);

    public static void LogError(string log)
        => WriteLine("[red][[!]][/]\t" + log);

    public static void WriteTitle(string title)
        => WriteTitle(new Rule(title).LeftJustified());

    public static void WriteTitle(Rule rule)
    {
        AnsiConsole.Write(rule);
        Console.Write("\r\n");
    }

    public static void WriteData(string header, params string[] data)
    {
        StringBuilder text = new($"{header}:\r\n");

        foreach (string d in data)
            text.Append("\t" + d + "\r\n");

        WriteLine(text.ToString());
    }

    public static void WriteException(string message, Exception e)
    {
        LogError(message);
        AnsiConsole.WriteException(e);
    }
}
