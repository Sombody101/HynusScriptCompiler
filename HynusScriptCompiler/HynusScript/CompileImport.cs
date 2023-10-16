namespace HynusScriptCompiler.OldHynusScript;

// Plan to use this to save time:
// https://tomassetti.me/getting-started-with-antlr-in-csharp/

public static class CompileImport
{
    //public static event EventHandler<CommandRequestEventArgs> CommandEncountered;
    //
    //internal static bool RequestCommand(CommandRequestEventArgs e)
    //{
    //    CommandEncountered?.Invoke(e);
    //}
}

public class CommandRequestEventArgs
{
    public CommandRequestEventArgs(string command, params string[] args)
    {
        RequestedCommand = command;
        RequestedCommandArgs = args;
    }

    public string RequestedCommand { get; private set; }
    public string[] RequestedCommandArgs { get; private set; }
}