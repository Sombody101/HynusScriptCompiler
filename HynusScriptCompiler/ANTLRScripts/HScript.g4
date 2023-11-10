grammar HScript;

// Represents the entire script file
program: 
	scriptConfiguration*?  	// Attributes that are to be applied to a script
	scriptImport*?			// Other scripts the user want's to import
	line* 					// Each line of the file (Not seperated by "(\r)?\n", but by segments (ex: a class would be considered a single line))
	EOF 					// EndOfFile (Lets the interpreter know that the file has ended)
	;

line:
	(
		functionDefinition
		| staticClass
		| functionCall
		| typeCastDefinition
		| tryCatch
		| assignment
		| ifBlock
		| whileBlock
		| return
		| expression
	) ';'?;

assignment: (arrAccess | localIdentifier | tempIdentifier | IDENTIFIER) '=' (expression | arrBlock);

ifBlock: 'if' '('? expression ')'? opBlock 
  ('else''if' '('? expression ')'? elseIfBlock 
  ('else''if' '('? expression ')'? elseIfBlock)*?)? 
  ('else' elseBlock)? // Helps with identifying
  ;
	
elseIfBlock: opBlock | ifBlock;
elseBlock: opBlock;

WHILE: 'while' | 'until';
whileBlock: WHILE expression opBlock ('or' opBlock)?;

forBlock: 'for' '('? assignment? ';' expression ';' expression ')'? opBlock;
foreachBlock: 'foreach' '('? assignment (':' | 'in') expression ')'? opBlock;

tryCatch: 'try' block (exBlock (',' exBlock)*?);
exBlock: ('catch' '('? exceptionInfo ')'? ('catch' '('? exceptionInfo)*? ')'?) block;
exceptionInfo: IDENTIFIER IDENTIFIER;

functionCall: IDENTIFIER ('('? (expression (',' expression)*?)? ')'? | '('')');

functionClosure: FUNCTIONDEC '('')' block;
functionDefinition: FUNCTIONDEC IDENTIFIER '('? ((functionParameter (',' functionParameter)*?))? ')'? block;
//SYSFUNC: 'sys'; // Aligns arguments differently to account for C# methods
typeCastDefinition: 'typecast' TYPE '('? ((functionParameter (',' functionParameter)*?))? ')'? block;
functionParameter: functionPresetParameter | IDENTIFIER;
functionPresetParameter: IDENTIFIER '=' constant;

// The backbone of any statement
expression:
	constant									# constantExpression
	| nestedVariable							# nestedVariableExpression
	| IDENTIFIER								# identifierExpression
	| arrAccess									# arrayAccessExpression
	| functionCall								# functionCallExpression
	| functionClosure							# functionClosureExpression
	| '(' expression ')'						# parethesizedExpression
	| expression '?' expression ':' expression	# conditionalExpression
	| expression multOp expression				# multiplicativeExpression
	| expression addOp expression				# additiveExpression
	| expression comareOp expression			# comparisonExpression
	| expression boolOp expression				# booleanExpression
	| unaryOp expression						# unaryExpression
	| expression assignOp expression			# assignOpExpression
	| doubleOp expression						# doubleStatementExpression
	| expression doubleOp						# doubleStatementExpression
	| (('-' | '=') '>')? block					# blockExpression
	| 'hscript::' specialHScript				# hscriptCallExpression
	| 'cscall::' expression						# dynamicCSharpCallExpression
	;

// Operators

// Both '++number' and 'number++' will be seen as the exact same (If I can't get it to work)

addOp: '+' | '-';
multOp: '*' | '/' | '%' | '**';
unaryOp: '-' | '+' | '~' | '!';
doubleOp: '--' | '++';
comareOp: ':!=' | ':==' | '==' | '!=' | '>' | '<' | '>=' | '<=';
assignOp: '+=' | '-=' | '*=' | '/=';
boolOp: BOOL_OPERATOR;

BOOL_OPERATOR: AND | OR | XOR;

AND: '&&' | 'and';
OR: '||' | 'or';
XOR: '^' | 'xor';
//

// Datatypes
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

STRING: '"' ( ESC_SEQ | ~('\\' | '"'))* '"';
ISTRING: '$"' (ESC_SEQ | ~('\\' | '"'))* '"' | '$`' ( ESC_SEQ | ~('\\'))* '`';
verbatimString: '```' ( ~'```')* '```';
ESCSTRING: '`' ( ESC_SEQ | ~('\\' | '`'))* '`';

CHAR: '\'' . '\'';
BYTE: [0-9]+;

fragment ESC_SEQ: '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE: 'u' U_HEX U_HEX U_HEX U_HEX;
fragment U_HEX: [0-9a-fA-F];

BOOL:
	SHORTHANDTRUE 	// I have no idea why, but placing ':' breaks it. This is like the coconut image for TF2.
	| 'true'
	| 'false'
	| 'True' 		// Compliant for Python users 
	| 'False'
	;

SHORTHANDTRUE: ':'; // Shorthand 'true' ('!:' for false)

NULL:
	'null' 		// Compliant with normal people
	| 'nil'  	// Compliant with Lua users
	| 'None' 	// Compliant for Python users 
	;

TYPE
	: 'string'
	| 'char'
	| 'sbyte'
	| 'short'
	| 'int'
	| 'long'
	| 'byte'
	| 'ushort'
	| 'uint'
	| 'ulong'
	| NULL
	;
//

FUNCTIONDEC: 'fun' | 'func' | 'function';

// Script configurations
scriptImport: ('import' | 'using') ( libBuiltIn | expression);
libBuiltIn: '<'? IDENTIFIER '>'?;

scriptConfiguration:
	scriptVersion	# scriptVersionConfig
	| changeStyle	# codeStyleCongfig
	| enableDebug	# enableDebugConfig
	;

SCRIPTATTR: '?>>';
VERSIONSTR: INTEGER '.' INTEGER ('.' INTEGER ('.' INTEGER)?)?;
scriptVersion: SCRIPTATTR VERSIONSTR;
changeStyle: SCRIPTATTR 'style' IDENTIFIER;
enableDebug: SCRIPTATTR 'debug' expression;
//importScript: SCRIPTATTR 'import' (IDENTIFIER | expression);
//

// Blocks
arrBlock: '[' (expression (',' expression)*)? ']';
arrAccess: IDENTIFIER '[' expression ']';
block: '{' line* '}' | lineBlock;
lineBlock: ('-' | '=')'>' line; // Specifically for function type blocks
return: 'return' expression;
opBlock: '{' line* '}' | line; 	// Used for operations (like if, for, while, etc)
staticClass: 'sclass' (IDENTIFIER | TYPE) block;
//

// Whitespaces
COMMENT: /*('//' | '#')*/ '#' ~[\r\n]* -> skip;
MLCOMMENT: ('###' .*? '###') /*('/*' .*? '* /')*/ -> skip;
WHITESPACE: [ \t\r\n\u000B\f\uFEFF]+ -> skip;
//

// Idenifiers
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_.-]* | [a-zA-Z];
//SCOPEIDENTIFIER: '$' ('#' | '@' | [0-9]+);
nestedVariable: '@' IDENTIFIER;
localIdentifier: ('scoped' | 'local') IDENTIFIER;
tempIdentifier: ('tmp' | 'temp' | 'temporary') IDENTIFIER;
//

// SpecialHScript
specialHScript: IDENTIFIER '::' specialFunctionCall;
specialFunctionCall: IDENTIFIER ( '('? (expression (',' expression)*?) ')'? | '('')' );
//