using HynusScriptCompiler.HynusScript;
using Spectre.Console.Cli;
using System.Data.SqlTypes;
using System.Diagnostics;

namespace HynusScriptCompiler;

/*
 *  Legit considering renaming it to "HellScript" because of the syntax
 */

public static class Program
{
    public static void Main(string[] args)
    {
        args = "run ../../../test.hscript".Split();

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

        app.Run(args); // Parse user input and apply it to Config (static)

        var scriptResult = Config.WholeScript
            ? HScriptReader.RunScriptFromString(Config.FilePath)
            : HScriptReader.RunScriptFromFile(Config.FilePath);

        HRuntime.Exit(scriptResult);
    }
}