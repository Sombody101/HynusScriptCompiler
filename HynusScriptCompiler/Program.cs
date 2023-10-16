using HynusScriptCompiler.HynusScript;
using Spectre.Console;
using Spectre.Console.Cli;

namespace HynusScriptCompiler;

public static class Program
{
    public static int Main(string[] args)
    {
        args = "run ../../../test.hscript -l".Split();

        var app = new CommandApp();

        app.Configure(config =>
        {
            config.SetApplicationName("HScriptCompiler");

            config.AddCommand<AppExitCodeResolverCommand>("ec")
                .WithAlias("exitcode")
                .WithDescription("Retrieves a parsed version of the HScript exit code, or the input value if it cannot be found");

            config.AddCommand<ScriptFileSettingsCommand>("run")
                .WithDescription("Runs the selected file path, or the input script string when used with -s|--whole-script");
        });

        var commandResult = app.Run(args);

        if (Config.ShowLogs)
            AnsiConsole.MarkupLine($"Script exit result: [lime]{(HScriptResult)commandResult}[/]");

        return commandResult;
    }
}