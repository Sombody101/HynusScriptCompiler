grammar HScript;

program: scriptVersion? changeStyle? line* EOF;

line: statement | ifBlock | whileBlock;

statement: (assignment | functionCall) ';'?;

ifBlock: 'if' '('? expression ')'? block ('else' elseIfBlock)?;

elseIfBlock: block | ifBlock;

whileBlock: WHILE expression block ('or' elseIfBlock)?;

WHILE: 'while' | 'until';

assignment: IDENTIFIER '=' expression;

functionDefinition: FUNCTIONDEC IDENTIFIER '(' (expression (',' expression)*)? ')' block;

functionCall: IDENTIFIER '('? (expression (',' expression)*)? ')'?;

tryCatch: 'try' block 'catch' ('(' exceptionInfo ')')? block;

exceptionInfo: IDENTIFIER IDENTIFIER; 

expression
    :   constant                                    #constantExpression
    |   nestedVariable                              #identifierExpression
    |   interpolatedString                          #interpolatedStringExpression
    |   IDENTIFIER                                  #identifierExpression
    |   functionCall                                #functionCallExpression
    |   '(' expression ')'                          #parethesizedExpression
    |   expression '?' expression ':' expression    #conditionalExpression
    |   expression multOp expression                #multiplicativeExpression
    |   expression addOp expression                 #additiveExpression
    |   expression comareOp expression              #comparisonExpression
    |   expression boolOp expression                #booleanExpression
    |   unaryOp expression                          #unaryExpression
    ;

nestedVariable: '$'IDENTIFIER;
interpolatedString: '$'STRING;

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

BOOL_OPERATOR
    : AND 
    | OR 
    | XOR
    ;

constant
    : UINTEGER ('U' | 'u')
    | INTEGER 
    | FLOAT ('F' | 'f')
    | HEX ('U' | 'u')?
    | BINARY ('U' | 'u')?
    | BYTE
    | STRING
    | CHAR 
    | BOOL 
    | NULL // Will be interperited the same as void in c#
    ;

BINARY: ('0b' | '0B') [0-1_]+;
HEX: ('0x' | '0X') [a-fA-F0-9_]+;
UINTEGER: INTEGER ('U' | 'u');
FLOAT: INTEGER '.' INTEGER;
INTEGER: [0-9_]+;
STRING: '"' ( ESC_SEQ | ~('\\'|'"') )* '"';
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
    | 'True' // Compliant for Python users 
    | 'False'
    ;

NULL
    : 'null' 
    | 'nil' 
    | 'None' // Compliant for Python users 
    ;

AND: '&&' | 'and';
OR: '||' | 'or';
XOR: '^' | 'xor';

FUNCTIONDEC: 'fun' | 'func' | 'function';

SCRIPTATTR: '?>>';
scriptVersion: SCRIPTATTR VERSIONSTR;
changeStyle: SCRIPTATTR 'style' IDENTIFIER;

VERSIONSTR: INTEGER '.' INTEGER ('.' INTEGER ('.' INTEGER)?)?;

block: '{' line* '}' | line;

COMMENT: ('//' | '#') ~[\r\n]* -> skip;
MLCOMMENT: (('###' .*? '###') | ('/*' .*? '*/')) -> skip;
WHITESPACE: [ \t\r\n\u000B\f\uFEFF]+ -> skip;
IDENTIFIER: '@'?[a-zA-Z_][a-zA-Z0-9_]*;