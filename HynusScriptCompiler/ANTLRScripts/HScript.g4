grammar HScript;

program: scriptConfiguration*? line* EOF;

line: (functionDefinition | functionCall | assignment | ifBlock | whileBlock | return | expression) ';'?;

ifBlock: 'if' '('? expression ')'? opBlock 
    ('else if' '('? expression ')'? elseIfBlock 
    ('else if' '('? expression ')'? elseIfBlock)*?)? 
    ('else' elseIfBlock)?;

elseIfBlock: opBlock | ifBlock;

whileBlock: WHILE expression opBlock ('or' elseIfBlock)?;

WHILE: 'while' | 'until';

assignment: (arrAccess | localIdentifier | IDENTIFIER) '=' (expression | arrBlock);

functionDefinition: FUNCTIONDEC IDENTIFIER '()' block;

functionClosure: FUNCTIONDEC '()' block;

functionCall: IDENTIFIER ('('? (expression (',' expression)*?)? ')'? | '()');

tryCatch: 'try' block 'catch' ('(' exceptionInfo ')')? block;

exceptionInfo: IDENTIFIER IDENTIFIER; 

expression
    :   constant                                    #constantExpression
    |   nestedVariable                              #nestedVariableExpression
    |   IDENTIFIER                                  #identifierExpression
    |   arrAccess                                   #arrayAccessExpression
    |   functionCall                                #functionCallExpression
    |   functionClosure                             #functionClosureExpression
    |   '(' expression ')'                          #parethesizedExpression
    |   expression '?' expression ':' expression    #conditionalExpression
    |   expression multOp expression                #multiplicativeExpression
    |   expression addOp expression                 #additiveExpression
    |   expression comareOp expression              #comparisonExpression
    |   expression boolOp expression                #booleanExpression
    |   unaryOp expression                          #unaryExpression
    |   block                                       #blockExpression
    |   'hscript::' expression                      #hscriptCallExpression
    |   'cscall::' expression                       #dynamicCSharpCallExpression
    ;

nestedVariable: '@'IDENTIFIER;

unaryOp
    : '-'
    | '+'
    | '~'
    | '!'
    ;

// Both '++number' and 'number++' will be seen as the exact same (If I can get it to work)
doubleStatement
    :   doubleOp expression
    |   expression doubleOp
    ;

doubleOp
    : '--'
    | '++'
    ;

multOp
    : '*' 
    | '/' 
    | '%'
    | '**'
    ;

addOp
    : '+' 
    | '-'
    ;

comareOp
    : ':!=' 
    | ':=='
    | '==' 
    | '!=' 
    | '>' 
    | '<' 
    | '>=' 
    | '<='
    ;

boolOp: BOOL_OPERATOR;

constant
    : BOOL
    | UINTEGER
    | INTEGER 
    | FLOAT
    | HEX ('U' | 'u')?
    | BINARY ('U' | 'u')?
    | BYTE
    | ISTRING
    | STRING
    | ESCSTRING
    | CHAR 
    | NULL
    ;


BINARY: ('0b' | '0B') [0-1_]+;
HEX: ('0x' | '0X') [a-fA-F0-9_]+;
UINTEGER: INTEGER ('U' | 'u');
FLOAT: INTEGER '.' INTEGER ('F' | 'f');
INTEGER: [0-9_]+;

STRING: '"' ( ESC_SEQ | ~('\\'|'"') )* '"';
ISTRING: '$"' ( ESC_SEQ | ~('\\'|'"') )* '"';
verbatimString: '```' ( ~'```' )* '```';
ESCSTRING: '`' ( ESC_SEQ | ~('\\'|'`') )* '`';

CHAR: '\'' . '\'';
BYTE
    : '1'..'9' '0'..'9'
    | '1' '0' '0'..'9'
    | '2' '0' '0'..'4' '0'..'9'
    | '2' '5' '0'..'5'
    ;

fragment ESC_SEQ: '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE: 'u' U_HEX U_HEX U_HEX U_HEX;
fragment U_HEX: [0-9a-fA-F];

BOOL
    : 'true' 
    | 'false'
    | ':'       // Shorthand 'true' 
    | 'True'    // Compliant for Python users 
    | 'False'
    ;

BOOL_OPERATOR
    : AND 
    | OR 
    | XOR
    ;

NULL
    : 'null'    // Compliant with normal people
    | 'nil'     // Compliant with Lua users
    | 'None'    // Compliant for Python users 
    ;

AND: '&&' | 'and';
OR: '||' | 'or';
XOR: '^' | 'xor';

FUNCTIONDEC: 'fun' | 'func' | 'function';

SCRIPTATTR: '?>>';
VERSIONSTR: INTEGER '.' INTEGER ('.' INTEGER ('.' INTEGER)?)?;
scriptVersion: SCRIPTATTR VERSIONSTR;
changeStyle: SCRIPTATTR 'style' IDENTIFIER;
enableDebug: SCRIPTATTR 'debug' expression;
importScript: SCRIPTATTR 'import' IDENTIFIER;

scriptConfiguration
    : scriptVersion     #scriptVersionConfig
    | changeStyle       #codeStyleCongfig
    | enableDebug       #enableDebugConfig
    | importScript      #importScriptConfig
    ;

arrBlock: '[' (expression (',' expression)*)? ']';
arrAccess: IDENTIFIER '[' expression ']';
block: '{' line* '}' | lineBlock;
lineBlock: ('-' | '=')'>' line;
opBlock: '{' line* '}' | line;
return: 'return' expression;

COMMENT: /*('//' | '#')*/ '#' ~[\r\n]* -> skip;
MLCOMMENT: ('###' .*? '###') /*('/*' .*? '* /')*/ -> skip;
WHITESPACE: [ \t\r\n\u000B\f\uFEFF]+ -> skip;

IDENTIFIER: ('_' | ':') | SCOPEIDENTIFIER | ([a-zA-Z_][a-zA-Z0-9_]* | [a-zA-Z]);

SCOPEIDENTIFIER: '$'('#' | '@' | [0-9]+);
localIdentifier: 'local' IDENTIFIER;