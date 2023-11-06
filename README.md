![](./GitAssets/HynusScript.png)

# HynusScript (HScript) - HynusWynus Automation
HScript was created to act the same way as a shell script or batch file. 
My biggest goal while making this language was for ease of use among all program users. I want this language to be easier to pickup and learn
regardless of if you started with C, or Python.

Comments are started with either 

```py
# comment
```

Multiline comments can also be made with three '#' as both the opening and closing tags:
```py
###
Comment
###
```

The syntax of this language is JavaScript based, with a small blend of Python and BashScript.

The boolean keywords are traditional 'true' and 'false', but HScript also supports Pythons weird capitalized keywords 'True' and 'False'.
There is a shorthand true which is the ':' character. To make false, you would just use "!:".

HScript also supports all common C-Family operators. Such as '==', '!=', '>', '<', '<=', '>=', etc. You can also use special operators.
Such as unary operators ('~', '-', '+', '!'), and double operators ('++', '--'). Although, double operators will not function the same in a normal language where the placement of the operator determines how it is used. They will all react as if it's use is "variable++", even if it's written out as
"++variable"

There are also some other operators custom to HScript.
The ":==" and ":!=" operators will check if the input value types match.

Example:
```js
WriteLine("Types match: {0}", true :== false); // Output: "Types match: True"
```

Even if "true" and "false" do not equal each other, their types do. They're both boolean values, so the ":==" operator will return true. This is especially useful in a
dynamic language, where the type of the variable cannot always be determined.

The equivalent of this in JavaScript would be:
```js
typeof(myBool) == "bool"
```
And in Python:
```py
isinstance(myBool, bool)
```

But here, it has been simplified to:
```bash
myBool :== true # "false" would work as well, you just need an instance of the type
```

HScript still has a "typeof" function. So you can also use:
```c
typeof(myBool) == typeof(true)
```

HScript files have some optional lines used for interpreter configuration. These lines will start with "?>>".
An example would be the interpreter version:
```bash
?>> 1.3.55.2
```

This line tells the interpreter that the version the script was designed for was v1.3.55.2. The interpreter will throw an error if the script version is newer than
it, and will only throw a warning if the interpreter version is newer than the script.

Another option to be used is "enableLowerStyle". This will change the built in function names from PascalCase to camelCase.


# Custom Features
HScript provides a few features that other languages don't. One of these features that isn't exactly "genius", but is my overall favorite is the ability to change the format of all built in functions.

Take this code block for example:

```bash
?>>style pascal # This line doesn't do anything, but will not throw an error
# According to default syntax (PascalCase)
WriteLine "This is the script version: {0}", sVersions
```

This code block looks pretty normal. Pretty boring.
Well, let's spice it up with a new style case!

```bash
?>> style camel # Changes format to camelCase
writeLine "This is the script version: {0}", sVersions
```

And this code will *still work*.

In total, there are 5 different code styles built into HScript. PascalCase (by default), snake_case, kebab-case, camelCase, and for gits-n-shiggles, piglatin case. Yes. You can change all built in methods to be piglatin. This is what the same codeblock will look like with the piglatin style:

```bash
?>> style piglatin # Changes format to piglatin
itelinewray "This is the script version: {0}", sVersions
```

Sadly, this will only convert the built in function names. The environment variables wont be changed, nor will the way data is interpreted. That would have been a great way to obfuscate the script, and might be a feature I add at some point.

# Functions

The datatype seen by the HScript interpreter when dealing with a function is called a **HFunction** (HynusFunction).

Functions work the same way variables do, except you can invoke them with parenthesis. (Or no parenthesis as long as there is a parameter supplies)

## Function Definitions 

To define a function, you must use the **function** keyword, a function name, parenthesis, then a block or arrow for a line.

```js
function myFunction() {
    WriteLine("Some value");
}

# You can use either "->" or "=>" as the arrow for single line functions
function myOtherFunction
    -> WriteLine("Some other value");

myFunction();
```

The **function** keyword also has some shorthand versions. Those are **func**, and **fun**.

```kt
fun myFunction()
    => WriteLine("My shorthand function");
```

## Passing Parameters

Because the backend of this language is based on BashScript, but with types, passing parameters will be just like it.

Passed parameters will be referenced as a dollar-sign ('$') and then a number indicating the parameter you would like to reference.

```js
function myFunction() {
    WriteLine($1);
}

myFunction "This is the value I'd like printed!"

```

And in bash style, if the parameter passed just doesn't exist, HScript will default to a value set via the **default** variable.

```js
default = "default value" # This can be any type, it will be converted to a string if needed

function myFunction() {
    WriteLine($1);
}

myFunction() # Output would be "default value" since a value for $1 was never passed.
```

### Creating Scoped Variables

To create a scoped variable, you must use the **local** keyword. It's use is similar to Lua or BashScript.

```lua
function myFunction() {
    local r = "this is my local variable"

    return r
}

WriteLine(r); # This will output default rather than the value defined in the function
```

The **local** keyword can only be used inside of a block. That assigns the variable to the scope of the block.

