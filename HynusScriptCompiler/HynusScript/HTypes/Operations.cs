using HynusScriptCompiler.HynusScript.Exceptions.HScriptExceptions;
using HynusScriptCompiler.HynusScript.Runtime;
using System.Text.RegularExpressions;

namespace HynusScriptCompiler.HynusScript.HTypes;

public static partial class Operations
{
    private static readonly Dictionary<char, char> EscapeMappings = new()
    {
        { '0', '\0' },  // Null
        { 'a', '\a' },  // Alert (bell)
        { 'b', '\b' },  // Backspace
        { 'f', '\f' },  // Form feed
        { 'n', '\n' },  // New line
        { 'r', '\r' },  // Carriage return
        { 't', '\t' },  // Horizontal tab
        { 'v', '\v' },  // Vertical tab
        { '\\', '\\' }, // Backslash
        { '\'', '\'' }, // Single quote
        { '\"', '\"' }  // Double quote
    };

    public static string EscapeString(string input)
    {
        char[] result = new char[input.Length];
        int resultIndex = 0;

        for (int i = 0; i < input.Length; i++)
            if (input[i] == '\\' && i + 1 < input.Length)
            {
                char nextChar = input[i + 1];
                if (EscapeMappings.TryGetValue(nextChar, out char mappedChar))
                {
                    result[resultIndex++] = mappedChar;
                    i++;
                }
                else if (nextChar == 'x' && i + 3 < input.Length &&
                         byte.TryParse(input.AsSpan(i + 2, 2), System.Globalization.NumberStyles.HexNumber, null, out byte hexValue))
                {
                    result[resultIndex++] = (char)hexValue;
                    i += 3;
                }
                else
                    result[resultIndex++] = input[i];
            }
            else
                result[resultIndex++] = input[i];

        return new string(result, 0, resultIndex);
    }

    public static string GetTypeName(object? obj)
        => obj is null ? "null" : obj.GetType().Name;

    public static string InterpolateString(string str)
    {
        return InterpolatedStringRegex().Replace(str,
            match => RuntimeMembers.LocateVariable(match.Groups[1].Value, out var variable) != -1
                ? $"{variable}"
                : $"{RVar.Default}"
        );
    }

    #region AdditiveOperations

    public static object Add(object? left, object? right)
    {
        if (left is string || right is string)
            return $"{left}{right}";

        if (left is int lInt)
        {
            if (right is int rInt)
                return lInt + rInt;
            if (right is float rFloat)
                return lInt + rFloat;
            if (right is uint rUint)
                return lInt + rUint;
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return lFloat + rInt;
            if (right is float rFloat)
                return lFloat + rFloat;
            if (right is uint rUint)
                return lFloat + rUint;
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return lUint + rInt;
            if (right is float rFloat)
                return lUint + rFloat;
            if (right is uint rUint)
                return lUint + rUint;
        }

        throw new HScriptInvalidOperationException($"Cannot add values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object Subtract(object? left, object? right)
    {
        if (left is int lInt)
        {
            if (right is int rInt)
                return lInt - rInt;
            if (right is float rFloat)
                return lInt - rFloat;
            if (right is uint rUint)
                return lInt - rUint;
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return lFloat - rInt;
            if (right is float rFloat)
                return lFloat - rFloat;
            if (right is uint rUint)
                return lFloat - rUint;
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return lUint - rInt;
            if (right is float rFloat)
                return lUint - rFloat;
            if (right is uint rUint)
                return lUint - rUint;
        }

        throw new HScriptInvalidOperationException($"Cannot subtract values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    #endregion

    #region MultiplicativeOperations

    public static object Multiply(object? left, object? right)
    {
        if (left is int lInt && right is int rInt)
            return lInt * rInt;

        if (left is float lFloat && right is float rFloat)
            return lFloat * rFloat;

        if (left is int lIntFloat && right is float rFloatInt)
            return lIntFloat * rFloatInt;

        if (left is float lFloatInt && right is int rIntFloat)
            return lFloatInt * rIntFloat;

        if (left is uint lUint && right is uint rUint)
            return lUint * rUint;

        if (left is int lIntUint && right is uint rUintInt)
            return lIntUint * rUintInt;

        if (left is uint lUintInt && right is int rIntUint)
            return lUintInt * rIntUint;

        throw new HScriptInvalidOperationException($"Cannot multiply values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object Divide(object? left, object? right)
    {
        if (left is int lInt && right is int rInt)
            return lInt / rInt;

        if (left is float lFloat && right is float rFloat)
            return lFloat / rFloat;

        if (left is int lIntFloat && right is float rFloatInt)
            return lIntFloat / rFloatInt;

        if (left is float lFloatInt && right is int rIntFloat)
            return lFloatInt / rIntFloat;

        if (left is uint lUint && right is uint rUint)
            return lUint / rUint;

        if (left is int lIntUint && right is uint rUintInt)
            return lIntUint / rUintInt;

        if (left is uint lUintInt && right is int rIntUint)
            return lUintInt / rIntUint;

        throw new HScriptInvalidOperationException($"Cannot divide values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object Modulo(object? left, object? right)
    {
        if (left is int lInt && right is int rInt)
            return lInt % rInt;

        if (left is float lFloat && right is float rFloat)
            return lFloat % rFloat;

        if (left is int lIntFloat && right is float rFloatInt)
            return lIntFloat % rFloatInt;

        if (left is float lFloatInt && right is int rIntFloat)
            return lFloatInt % rIntFloat;

        if (left is uint lUint && right is uint rUint)
            return lUint % rUint;

        if (left is int lIntUint && right is uint rUintInt)
            return lIntUint % rUintInt;

        if (left is uint lUintInt && right is int rIntUint)
            return lUintInt % rIntUint;

        throw new HScriptInvalidOperationException($"Cannot modulus values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object Power(object? left, object? right)
    {
        if (left is int lInt)
        {
            if (right is int rInt)
                return Math.Pow(lInt, rInt);
            if (right is float rFloat)
                return Math.Pow(lInt, rFloat);
            if (right is uint rUint)
                return Math.Pow(lInt, rUint);
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return Math.Pow(lFloat, rInt);
            if (right is float rFloat)
                return Math.Pow(lFloat, rFloat);
            if (right is uint rUint)
                return Math.Pow(lFloat, rUint);
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return Math.Pow(lUint, rInt);
            if (right is float rFloat)
                return Math.Pow(lUint, rFloat);
            if (right is uint rUint)
                return Math.Pow(lUint, rUint);
        }

        throw new HScriptInvalidOperationException($"Cannot power values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    #endregion

    #region ComparisonOperators

    public static object CompareType(object? left, object? right)
    {
        // Null checks
        if (left is null && right is null)
            return true;
        if (left is null || right is null)
            return false;

        try
        {
            return left.GetType() == right.GetType();
        }
        catch
        {
            throw new HScriptInvalidOperationException($"Cannot compare types of '{GetTypeName(left)}' and '{GetTypeName(right)}'");
        }
    }

    public static object Compare(object? left, object? right)
    {
        if (left is int lInt && right is int rInt)
            return lInt == rInt;

        if (left is float lFloat && right is float rFloat)
            return lFloat == rFloat;

        if (left is int lIntFloat && right is float rFloatInt)
            return lIntFloat == rFloatInt;

        if (left is float lFloatInt && right is int rIntFloat)
            return lFloatInt == rIntFloat;

        if (left is string lStr && right is string rStr)
            return lStr == rStr;

        if (left is uint lUint && right is uint rUint)
            return lUint == rUint;

        if (left is int lIntUint && right is uint rUintInt)
            return lIntUint == rUintInt;

        if (left is uint lUintInt && right is int rIntUint)
            return lUintInt == rIntUint;

        if (left is bool lBool && right is bool rBool)
            return lBool == rBool;

        throw new HScriptInvalidOperationException($"Cannot compare values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object GreaterThan(object? left, object? right)
    {
        if (left is int lInt && right is int rInt)
            return lInt > rInt;

        if (left is float lFloat && right is float rFloat)
            return lFloat > rFloat;

        if (left is int lIntFloat && right is float rFloatInt)
            return lIntFloat > rFloatInt;

        if (left is float lFloatInt && right is int rIntFloat)
            return lFloatInt > rIntFloat;

        if (left is uint lUint && right is uint rUint)
            return lUint > rUint;

        if (left is int lIntUint && right is uint rUintInt)
            return lIntUint > rUintInt;

        if (left is uint lUintInt && right is int rIntUint)
            return lUintInt > rIntUint;

        if (left is bool lBool && right is bool rBool)
            return lBool == rBool;

        throw new HScriptInvalidOperationException($"Cannot compare values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    #endregion

    #region BooleanOperators

    public static bool Evaluate(object? obj)
    {
        if (obj is bool b)
            return b;
        else if (obj is int i)
            return i == 1;
        else if (obj is uint ui)
            return ui == 1;
        else
            throw new HScriptInvalidOperationException("Cannot evaluate non-boolean value '" + GetTypeName(obj) + '\'');
    }

    public static bool BoolAnd(object? left, object? right)
    {
        if (left is bool lb && right is bool rb)
            return lb && rb;

        if (left is int lInt)
        {
            if (right is int rInt)
                return (lInt == 1) && (rInt == 1);
            if (right is float rFloat)
                return (lInt == 1) && (rFloat == 1);
            if (right is uint rUint)
                return (lInt == 1) && (rUint == 1);
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return (lFloat == 1) && (rInt == 1);
            if (right is float rFloat)
                return (lFloat == 1) && (rFloat == 1);
            if (right is uint rUint)
                return (lFloat == 1) && (rUint == 1);
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return (lUint == 1) && (rInt == 1);
            if (right is float rFloat)
                return (lUint == 1) && (rFloat == 1);
            if (right is uint rUint)
                return (lUint == 1) && (rUint == 1);
        }

        throw new HScriptInvalidOperationException($"Cannot perform an and operation on values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static bool BoolOr(object? left, object? right)
    {
        if (left is bool lb && right is bool rb)
            return lb || rb;

        if (left is int lInt)
        {
            if (right is int rInt)
                return (lInt == 1) || (rInt == 1);
            if (right is float rFloat)
                return (lInt == 1) || (rFloat == 1);
            if (right is uint rUint)
                return (lInt == 1) || (rUint == 1);
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return (lFloat == 1) || (rInt == 1);
            if (right is float rFloat)
                return (lFloat == 1) || (rFloat == 1);
            if (right is uint rUint)
                return (lFloat == 1) || (rUint == 1);
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return (lUint == 1) || (rInt == 1);
            if (right is float rFloat)
                return (lUint == 1) || (rFloat == 1);
            if (right is uint rUint)
                return (lUint == 1) || (rUint == 1);
        }

        throw new HScriptInvalidOperationException($"Cannot perform an or operation on values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    public static object BoolXor(object? left, object? right)
    {
        if (left is bool lb && right is bool rb)
            return lb ^ rb;

        if (left is int lInt)
        {
            if (right is int rInt)
                return lInt ^ rInt;
            if (right is float rFloat)
                return lInt ^ (long)rFloat;
            if (right is uint rUint)
                return lInt ^ rUint;
        }
        else if (left is float lFloat)
        {
            if (right is int rInt)
                return (long)lFloat ^ rInt;
            if (right is float rFloat)
                return (long)lFloat ^ (long)rFloat;
            if (right is uint rUint)
                return (long)lFloat ^ rUint;
        }
        else if (left is uint lUint)
        {
            if (right is int rInt)
                return lUint ^ rInt;
            if (right is float rFloat)
                return lUint ^ (long)rFloat;
            if (right is uint rUint)
                return lUint ^ rUint;
        }

        throw new HScriptInvalidOperationException($"Cannot perform an xor operation on values of type '{GetTypeName(left)}' and '{GetTypeName(right)}'");
    }

    #endregion

    #region UnaryOperators

    public static object LogicNot(object? value)
    {
        if (value is bool bl)
            return !bl;

        throw new HScriptInvalidOperationException($"Cannot perform a not operation on an object with the type '{GetTypeName(value)}'");
    }

    public static object BitwiseNot(object? value)
    {
        if (value is int r)
            return ~r;

        if (value is uint u)
            return ~u;

        if (value is byte b)
            return ~b;

        throw new HScriptInvalidOperationException($"Cannot perform a bitwise not operation on an object with the type '{GetTypeName(value)}'");
    }

    public static object BitwisePlus(object? value)
    {
        if (value is int i)
            return +i;

        if (value is float f)
            return +f;

        throw new HScriptInvalidOperationException($"Cannot perform a bitwise plus operation on an object with the type '{GetTypeName(value)}'");
    }

    public static object BitwiseMinus(object? value)
    {
        if (value is int i)
            return -i;

        if (value is float f)
            return -f;

        throw new HScriptInvalidOperationException($"Cannot perform a bitwise minus operation on an object with the type '{GetTypeName(value)}'");
    }

    #endregion

    #region DoubleOperation

    public static object PlusPlus(object? value)
    {
        if (value is int r)
            return r + 1;

        if (value is uint u)
            return u + 1;

        if (value is byte b)
            return b + 1;

        if (value is float f)
            return f + 1;

        throw new HScriptInvalidOperationException($"Cannot perform a plus plus operation on an object with the type '{GetTypeName(value)}'");
    }

    public static object MinusMinus(object? value)
    {
        if (value is int r)
            return r - 1;

        if (value is uint u)
            return u - 1;

        if (value is byte b)
            return b - 1;

        if (value is float f)
            return f - 1;

        throw new HScriptInvalidOperationException($"Cannot perform a minus minus operation on an object with the type '{GetTypeName(value)}'");
    }

    #endregion

    [GeneratedRegex("\\{([^{}]+)\\}")]
    private static partial Regex InterpolatedStringRegex();
}