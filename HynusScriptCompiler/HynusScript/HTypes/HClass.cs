namespace HynusScriptCompiler.HynusScript.HTypes;

internal class HClass
{
    public List<HFunction> Functions;
    public Dictionary<string, object?> Fields;

    public HClass()
    {
        Functions = new();
        Fields = new();
    }

    public HClass(List<HFunction> functions, Dictionary<string, object?> fields)
    {
        Functions = functions;
        Fields = fields;
    }
}