using Microsoft.CodeAnalysis.CSharp.Scripting;
using Microsoft.CodeAnalysis.Scripting;
using Spectre.Console;
using System.Security.AccessControl;

namespace HynusScriptCompiler.HynusScript.Runtime;

internal static class DynamicCSharp
{
    public static async Task<object?> Run(string code)
    {
        try
        {
            return await CSharpScript.EvaluateAsync(code, ScriptOptions.Default);
        }
        catch (CompilationErrorException e)
        {
            Logging.LogError("Failed to compile dynamic C# code");
            foreach (var diagnostic in e.Diagnostics)
                AnsiConsole.MarkupLine(FormatAndDisplayDiagnostic(diagnostic.GetMessage()));

        }
        catch (Exception ex)
        {
            Logging.WriteException("Encountered an unexpected exception while running C#", ex);
        }

        return null;
    }

    private static string FormatAndDisplayDiagnostic(string message)
    {
        var segments = message.Split(':');

        if (segments.Length > 1)
        {
            var errorText = segments[0].Trim();
            var rest = string.Join(":", segments[1..].Select(str => $"[yellow]{str}[/]")).Trim();

            return $"[red]{errorText}[/] {rest}";
        }
        else
            return message;
    }
}
