using Microsoft.CodeAnalysis.CSharp.Scripting;
using Microsoft.CodeAnalysis.Scripting;
using Spectre.Console;
using System.Reflection;

namespace HynusScriptCompiler.HynusScript.Runtime;

internal static class DynamicCSharp
{
    public static object? InvokeMethodFromName(string methodName, object?[]? args)
    {
        args ??= Array.Empty<object>();
        string[] methodParts = methodName.Split(new string[] { "." }, StringSplitOptions.RemoveEmptyEntries);

        var typeName = string.Join(".", methodParts[..^1]);
        var method = methodParts[^1];

        if (!TypeLookup.TryGetValue(typeName, out var assembly))
            assembly = typeName;

        var type = Type.GetType($"{typeName}, {assembly}");

        Type[] argTypes = args?.Select(arg => arg?.GetType()).ToArray() ?? Array.Empty<Type>();

        MethodInfo? methodInfo = type?.GetMethod(method, argTypes);

        if (methodInfo != null)
            return methodInfo.Invoke(null, args);
        else
        {
            Console.WriteLine("Method not found");
            return null;
        }
    }

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

    private static Dictionary<string, string> TypeLookup = new()
    {
        { "System.Convert", "System.Runtime" },
    };

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

    private static void GetTypeName(string methodPath, out string namespaceAndClass, out string methodName)
    {
        string[] parts = methodPath.Split('.');
        if (parts.Length >= 2)
        {
            namespaceAndClass = string.Join(".", parts, 0, parts.Length - 1);
            methodName = parts[parts.Length - 1];
        }
        else
        {
            namespaceAndClass = null;
            methodName = methodPath;
        }
    }
}
