using HynusScriptCompiler.HynusScript;
using Spectre.Console.Cli;
using System.Diagnostics.CodeAnalysis;

namespace HynusScriptCompiler;

public class ScriptFileSettingsCommand : Command<ScriptFileSettingsCommand.ScriptFileSettings>
{
    public class ScriptFileSettings : CommandSettings
    {
        [CommandArgument(0, "[RUN]")]
        public string File { get; set; }

        [CommandOption("-s|--whole-script")]
        public bool WholeScript { get; set; } = false;

        [CommandOption("-l|--logs")]
        public bool ShowLogs { get; set; } = false;

        [CommandOption("-f|--force")]
        public bool ForceRun { get; set; } = false;
    }

    public override int Execute([NotNull] CommandContext context, [NotNull] ScriptFileSettings settings)
    {
        Config.FilePath = settings.File;
        Config.WholeScript = settings.WholeScript;
        Config.ForceRun = settings.ForceRun;
        Config.ShowLogs = settings.ShowLogs;

        return Config.WholeScript 
            ? (int)HScriptReader.RunScriptFromString(Config.FilePath) 
            : (int)HScriptReader.RunScriptFromFile(Config.FilePath);
    }
}

public class AppExitCodeResolverCommand : Command<AppExitCodeResolverCommand.AppExitCodeResolver>
{
    public class AppExitCodeResolver : CommandSettings
    {
        [CommandArgument(0, "[CODE]")]
        public string ExitCode { get; set; }
    }

    public override int Execute([NotNull] CommandContext context, [NotNull] AppExitCodeResolver settings)
    {
        if (settings.ExitCode == "-a")
            foreach (var result in Enum.GetNames(typeof(HScriptResult)))
                Console.WriteLine(result);

        if (int.TryParse(settings.ExitCode, out var enumCode))
        {
            Console.WriteLine((HScriptResult)enumCode);
            return 0;
        }
        else if (Enum.TryParse(settings.ExitCode, out HScriptResult intCode))
        {
            Console.WriteLine((int)intCode);
            return 0;
        }

        Console.WriteLine($"Failed to interpret '{settings.ExitCode}'");
        return -1;
    }
}

public static class Config
{
    public static string FilePath { get; set; } = "";
    public static bool WholeScript { get; set; } = false;
    public static bool ForceRun { get; set; } = false;

    public static bool ShowLogs { get; set; } = false;
}