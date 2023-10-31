namespace HynusScriptCompiler.HynusScript.Runtime;

internal static class RVar
{
    public static object? IVersion
    {
        get => RuntimeMembers.PresetVariables[n_IVersion];
        set => RuntimeMembers.PresetVariables[n_IVersion] = value;
    }
    public static object? SVersion
    {
        get => RuntimeMembers.PresetVariables[n_SVersion];
        set => RuntimeMembers.PresetVariables[n_SVersion] = value;
    }
    public static object? WinVersion
    {
        get => RuntimeMembers.PresetVariables[n_WinVersion];
        set => RuntimeMembers.PresetVariables[n_WinVersion] = value;

    }
    public static object? Default
    {
        get => RuntimeMembers.PresetVariables[n_Default];
        set => RuntimeMembers.PresetVariables[n_Default] = value;
    }

    public static readonly string n_IVersion = nameof(IVersion);
    public static readonly string n_SVersion = nameof(SVersion);
    public static readonly string n_WinVersion = nameof(WinVersion);
    public static readonly string n_Default = nameof(Default);
}
