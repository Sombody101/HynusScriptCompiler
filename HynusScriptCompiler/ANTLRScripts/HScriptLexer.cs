//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.1
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from f:/HynusScriptCompiler/HynusScriptCompiler/ANTLRScripts/HScript.g4 by ANTLR 4.13.1

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.1")]
[System.CLSCompliant(false)]
public partial class HScriptLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		WHILE=39, BOOL_OPERATOR=40, BINARY=41, HEX=42, UINTEGER=43, FLOAT=44, 
		INTEGER=45, STRING=46, CHAR=47, BYTE=48, BOOL=49, NULL=50, AND=51, OR=52, 
		XOR=53, FUNCTIONDEC=54, SCRIPTATTR=55, VERSIONSTR=56, COMMENT=57, MLCOMMENT=58, 
		WHITESPACE=59, IDENTIFIER=60;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "WHILE", "BOOL_OPERATOR", 
		"BINARY", "HEX", "UINTEGER", "FLOAT", "INTEGER", "STRING", "CHAR", "BYTE", 
		"ESC_SEQ", "UNICODE", "U_HEX", "BOOL", "NULL", "AND", "OR", "XOR", "FUNCTIONDEC", 
		"SCRIPTATTR", "VERSIONSTR", "COMMENT", "MLCOMMENT", "WHITESPACE", "IDENTIFIER"
	};


	public HScriptLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public HScriptLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, "';'", "'if'", "'('", "')'", "'else'", "'or'", "'='", "','", "'try'", 
		"'catch'", "'?'", "':'", "'$'", "'-'", "'+'", "'~'", "'!'", "'--'", "'++'", 
		"'*'", "'/'", "'%'", "'**'", "':!='", "':=='", "'=='", "'!='", "'>'", 
		"'<'", "'>='", "'<='", "'U'", "'u'", "'F'", "'f'", "'style'", "'{'", "'}'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'?>>'"
	};
	private static readonly string[] _SymbolicNames = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "WHILE", "BOOL_OPERATOR", "BINARY", "HEX", "UINTEGER", 
		"FLOAT", "INTEGER", "STRING", "CHAR", "BYTE", "BOOL", "NULL", "AND", "OR", 
		"XOR", "FUNCTIONDEC", "SCRIPTATTR", "VERSIONSTR", "COMMENT", "MLCOMMENT", 
		"WHITESPACE", "IDENTIFIER"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "HScript.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override int[] SerializedAtn { get { return _serializedATN; } }

	static HScriptLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static int[] _serializedATN = {
		4,0,60,463,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,
		6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,
		7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,
		7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,2,27,7,27,2,28,
		7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,33,7,33,2,34,7,34,2,35,
		7,35,2,36,7,36,2,37,7,37,2,38,7,38,2,39,7,39,2,40,7,40,2,41,7,41,2,42,
		7,42,2,43,7,43,2,44,7,44,2,45,7,45,2,46,7,46,2,47,7,47,2,48,7,48,2,49,
		7,49,2,50,7,50,2,51,7,51,2,52,7,52,2,53,7,53,2,54,7,54,2,55,7,55,2,56,
		7,56,2,57,7,57,2,58,7,58,2,59,7,59,2,60,7,60,2,61,7,61,2,62,7,62,1,0,1,
		0,1,1,1,1,1,1,1,2,1,2,1,3,1,3,1,4,1,4,1,4,1,4,1,4,1,5,1,5,1,5,1,6,1,6,
		1,7,1,7,1,8,1,8,1,8,1,8,1,9,1,9,1,9,1,9,1,9,1,9,1,10,1,10,1,11,1,11,1,
		12,1,12,1,13,1,13,1,14,1,14,1,15,1,15,1,16,1,16,1,17,1,17,1,17,1,18,1,
		18,1,18,1,19,1,19,1,20,1,20,1,21,1,21,1,22,1,22,1,22,1,23,1,23,1,23,1,
		23,1,24,1,24,1,24,1,24,1,25,1,25,1,25,1,26,1,26,1,26,1,27,1,27,1,28,1,
		28,1,29,1,29,1,29,1,30,1,30,1,30,1,31,1,31,1,32,1,32,1,33,1,33,1,34,1,
		34,1,35,1,35,1,35,1,35,1,35,1,35,1,36,1,36,1,37,1,37,1,38,1,38,1,38,1,
		38,1,38,1,38,1,38,1,38,1,38,1,38,3,38,240,8,38,1,39,1,39,1,39,3,39,245,
		8,39,1,40,1,40,1,40,1,40,3,40,251,8,40,1,40,4,40,254,8,40,11,40,12,40,
		255,1,41,1,41,1,41,1,41,3,41,262,8,41,1,41,4,41,265,8,41,11,41,12,41,266,
		1,42,1,42,1,42,1,43,1,43,1,43,1,43,1,44,4,44,277,8,44,11,44,12,44,278,
		1,45,1,45,1,45,5,45,284,8,45,10,45,12,45,287,9,45,1,45,1,45,1,46,1,46,
		1,46,1,46,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,
		3,47,307,8,47,1,48,1,48,1,48,3,48,312,8,48,1,49,1,49,1,49,1,49,1,49,1,
		49,1,50,1,50,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,
		51,1,51,1,51,1,51,1,51,1,51,1,51,3,51,340,8,51,1,52,1,52,1,52,1,52,1,52,
		1,52,1,52,1,52,1,52,1,52,1,52,3,52,353,8,52,1,53,1,53,1,53,1,53,1,53,3,
		53,360,8,53,1,54,1,54,1,54,1,54,3,54,366,8,54,1,55,1,55,1,55,1,55,3,55,
		372,8,55,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,
		56,1,56,1,56,3,56,389,8,56,1,57,1,57,1,57,1,57,1,58,1,58,1,58,1,58,1,58,
		1,58,1,58,3,58,402,8,58,3,58,404,8,58,1,59,1,59,1,59,3,59,409,8,59,1,59,
		5,59,412,8,59,10,59,12,59,415,9,59,1,59,1,59,1,60,1,60,1,60,1,60,1,60,
		5,60,424,8,60,10,60,12,60,427,9,60,1,60,1,60,1,60,1,60,1,60,1,60,1,60,
		5,60,436,8,60,10,60,12,60,439,9,60,1,60,1,60,3,60,443,8,60,1,60,1,60,1,
		61,4,61,448,8,61,11,61,12,61,449,1,61,1,61,1,62,3,62,455,8,62,1,62,1,62,
		5,62,459,8,62,10,62,12,62,462,9,62,2,425,437,0,63,1,1,3,2,5,3,7,4,9,5,
		11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,13,27,14,29,15,31,16,33,17,35,
		18,37,19,39,20,41,21,43,22,45,23,47,24,49,25,51,26,53,27,55,28,57,29,59,
		30,61,31,63,32,65,33,67,34,69,35,71,36,73,37,75,38,77,39,79,40,81,41,83,
		42,85,43,87,44,89,45,91,46,93,47,95,48,97,0,99,0,101,0,103,49,105,50,107,
		51,109,52,111,53,113,54,115,55,117,56,119,57,121,58,123,59,125,60,1,0,
		11,2,0,48,49,95,95,4,0,48,57,65,70,95,95,97,102,2,0,85,85,117,117,2,0,
		48,57,95,95,2,0,34,34,92,92,8,0,34,34,47,47,92,92,98,98,102,102,110,110,
		114,114,116,116,3,0,48,57,65,70,97,102,2,0,10,10,13,13,3,0,9,13,32,32,
		65279,65279,3,0,65,90,95,95,97,122,4,0,48,57,65,90,95,95,97,122,493,0,
		1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,
		0,13,1,0,0,0,0,15,1,0,0,0,0,17,1,0,0,0,0,19,1,0,0,0,0,21,1,0,0,0,0,23,
		1,0,0,0,0,25,1,0,0,0,0,27,1,0,0,0,0,29,1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,
		0,0,35,1,0,0,0,0,37,1,0,0,0,0,39,1,0,0,0,0,41,1,0,0,0,0,43,1,0,0,0,0,45,
		1,0,0,0,0,47,1,0,0,0,0,49,1,0,0,0,0,51,1,0,0,0,0,53,1,0,0,0,0,55,1,0,0,
		0,0,57,1,0,0,0,0,59,1,0,0,0,0,61,1,0,0,0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,
		1,0,0,0,0,69,1,0,0,0,0,71,1,0,0,0,0,73,1,0,0,0,0,75,1,0,0,0,0,77,1,0,0,
		0,0,79,1,0,0,0,0,81,1,0,0,0,0,83,1,0,0,0,0,85,1,0,0,0,0,87,1,0,0,0,0,89,
		1,0,0,0,0,91,1,0,0,0,0,93,1,0,0,0,0,95,1,0,0,0,0,103,1,0,0,0,0,105,1,0,
		0,0,0,107,1,0,0,0,0,109,1,0,0,0,0,111,1,0,0,0,0,113,1,0,0,0,0,115,1,0,
		0,0,0,117,1,0,0,0,0,119,1,0,0,0,0,121,1,0,0,0,0,123,1,0,0,0,0,125,1,0,
		0,0,1,127,1,0,0,0,3,129,1,0,0,0,5,132,1,0,0,0,7,134,1,0,0,0,9,136,1,0,
		0,0,11,141,1,0,0,0,13,144,1,0,0,0,15,146,1,0,0,0,17,148,1,0,0,0,19,152,
		1,0,0,0,21,158,1,0,0,0,23,160,1,0,0,0,25,162,1,0,0,0,27,164,1,0,0,0,29,
		166,1,0,0,0,31,168,1,0,0,0,33,170,1,0,0,0,35,172,1,0,0,0,37,175,1,0,0,
		0,39,178,1,0,0,0,41,180,1,0,0,0,43,182,1,0,0,0,45,184,1,0,0,0,47,187,1,
		0,0,0,49,191,1,0,0,0,51,195,1,0,0,0,53,198,1,0,0,0,55,201,1,0,0,0,57,203,
		1,0,0,0,59,205,1,0,0,0,61,208,1,0,0,0,63,211,1,0,0,0,65,213,1,0,0,0,67,
		215,1,0,0,0,69,217,1,0,0,0,71,219,1,0,0,0,73,225,1,0,0,0,75,227,1,0,0,
		0,77,239,1,0,0,0,79,244,1,0,0,0,81,250,1,0,0,0,83,261,1,0,0,0,85,268,1,
		0,0,0,87,271,1,0,0,0,89,276,1,0,0,0,91,280,1,0,0,0,93,290,1,0,0,0,95,306,
		1,0,0,0,97,308,1,0,0,0,99,313,1,0,0,0,101,319,1,0,0,0,103,339,1,0,0,0,
		105,352,1,0,0,0,107,359,1,0,0,0,109,365,1,0,0,0,111,371,1,0,0,0,113,388,
		1,0,0,0,115,390,1,0,0,0,117,394,1,0,0,0,119,408,1,0,0,0,121,442,1,0,0,
		0,123,447,1,0,0,0,125,454,1,0,0,0,127,128,5,59,0,0,128,2,1,0,0,0,129,130,
		5,105,0,0,130,131,5,102,0,0,131,4,1,0,0,0,132,133,5,40,0,0,133,6,1,0,0,
		0,134,135,5,41,0,0,135,8,1,0,0,0,136,137,5,101,0,0,137,138,5,108,0,0,138,
		139,5,115,0,0,139,140,5,101,0,0,140,10,1,0,0,0,141,142,5,111,0,0,142,143,
		5,114,0,0,143,12,1,0,0,0,144,145,5,61,0,0,145,14,1,0,0,0,146,147,5,44,
		0,0,147,16,1,0,0,0,148,149,5,116,0,0,149,150,5,114,0,0,150,151,5,121,0,
		0,151,18,1,0,0,0,152,153,5,99,0,0,153,154,5,97,0,0,154,155,5,116,0,0,155,
		156,5,99,0,0,156,157,5,104,0,0,157,20,1,0,0,0,158,159,5,63,0,0,159,22,
		1,0,0,0,160,161,5,58,0,0,161,24,1,0,0,0,162,163,5,36,0,0,163,26,1,0,0,
		0,164,165,5,45,0,0,165,28,1,0,0,0,166,167,5,43,0,0,167,30,1,0,0,0,168,
		169,5,126,0,0,169,32,1,0,0,0,170,171,5,33,0,0,171,34,1,0,0,0,172,173,5,
		45,0,0,173,174,5,45,0,0,174,36,1,0,0,0,175,176,5,43,0,0,176,177,5,43,0,
		0,177,38,1,0,0,0,178,179,5,42,0,0,179,40,1,0,0,0,180,181,5,47,0,0,181,
		42,1,0,0,0,182,183,5,37,0,0,183,44,1,0,0,0,184,185,5,42,0,0,185,186,5,
		42,0,0,186,46,1,0,0,0,187,188,5,58,0,0,188,189,5,33,0,0,189,190,5,61,0,
		0,190,48,1,0,0,0,191,192,5,58,0,0,192,193,5,61,0,0,193,194,5,61,0,0,194,
		50,1,0,0,0,195,196,5,61,0,0,196,197,5,61,0,0,197,52,1,0,0,0,198,199,5,
		33,0,0,199,200,5,61,0,0,200,54,1,0,0,0,201,202,5,62,0,0,202,56,1,0,0,0,
		203,204,5,60,0,0,204,58,1,0,0,0,205,206,5,62,0,0,206,207,5,61,0,0,207,
		60,1,0,0,0,208,209,5,60,0,0,209,210,5,61,0,0,210,62,1,0,0,0,211,212,5,
		85,0,0,212,64,1,0,0,0,213,214,5,117,0,0,214,66,1,0,0,0,215,216,5,70,0,
		0,216,68,1,0,0,0,217,218,5,102,0,0,218,70,1,0,0,0,219,220,5,115,0,0,220,
		221,5,116,0,0,221,222,5,121,0,0,222,223,5,108,0,0,223,224,5,101,0,0,224,
		72,1,0,0,0,225,226,5,123,0,0,226,74,1,0,0,0,227,228,5,125,0,0,228,76,1,
		0,0,0,229,230,5,119,0,0,230,231,5,104,0,0,231,232,5,105,0,0,232,233,5,
		108,0,0,233,240,5,101,0,0,234,235,5,117,0,0,235,236,5,110,0,0,236,237,
		5,116,0,0,237,238,5,105,0,0,238,240,5,108,0,0,239,229,1,0,0,0,239,234,
		1,0,0,0,240,78,1,0,0,0,241,245,3,107,53,0,242,245,3,109,54,0,243,245,3,
		111,55,0,244,241,1,0,0,0,244,242,1,0,0,0,244,243,1,0,0,0,245,80,1,0,0,
		0,246,247,5,48,0,0,247,251,5,98,0,0,248,249,5,48,0,0,249,251,5,66,0,0,
		250,246,1,0,0,0,250,248,1,0,0,0,251,253,1,0,0,0,252,254,7,0,0,0,253,252,
		1,0,0,0,254,255,1,0,0,0,255,253,1,0,0,0,255,256,1,0,0,0,256,82,1,0,0,0,
		257,258,5,48,0,0,258,262,5,120,0,0,259,260,5,48,0,0,260,262,5,88,0,0,261,
		257,1,0,0,0,261,259,1,0,0,0,262,264,1,0,0,0,263,265,7,1,0,0,264,263,1,
		0,0,0,265,266,1,0,0,0,266,264,1,0,0,0,266,267,1,0,0,0,267,84,1,0,0,0,268,
		269,3,89,44,0,269,270,7,2,0,0,270,86,1,0,0,0,271,272,3,89,44,0,272,273,
		5,46,0,0,273,274,3,89,44,0,274,88,1,0,0,0,275,277,7,3,0,0,276,275,1,0,
		0,0,277,278,1,0,0,0,278,276,1,0,0,0,278,279,1,0,0,0,279,90,1,0,0,0,280,
		285,5,34,0,0,281,284,3,97,48,0,282,284,8,4,0,0,283,281,1,0,0,0,283,282,
		1,0,0,0,284,287,1,0,0,0,285,283,1,0,0,0,285,286,1,0,0,0,286,288,1,0,0,
		0,287,285,1,0,0,0,288,289,5,34,0,0,289,92,1,0,0,0,290,291,5,39,0,0,291,
		292,9,0,0,0,292,293,5,39,0,0,293,94,1,0,0,0,294,295,2,49,57,0,295,307,
		2,48,57,0,296,297,5,49,0,0,297,298,5,48,0,0,298,307,2,48,57,0,299,300,
		5,50,0,0,300,301,5,48,0,0,301,302,2,48,52,0,302,307,2,48,57,0,303,304,
		5,50,0,0,304,305,5,53,0,0,305,307,2,48,53,0,306,294,1,0,0,0,306,296,1,
		0,0,0,306,299,1,0,0,0,306,303,1,0,0,0,307,96,1,0,0,0,308,311,5,92,0,0,
		309,312,7,5,0,0,310,312,3,99,49,0,311,309,1,0,0,0,311,310,1,0,0,0,312,
		98,1,0,0,0,313,314,5,117,0,0,314,315,3,101,50,0,315,316,3,101,50,0,316,
		317,3,101,50,0,317,318,3,101,50,0,318,100,1,0,0,0,319,320,7,6,0,0,320,
		102,1,0,0,0,321,322,5,116,0,0,322,323,5,114,0,0,323,324,5,117,0,0,324,
		340,5,101,0,0,325,326,5,102,0,0,326,327,5,97,0,0,327,328,5,108,0,0,328,
		329,5,115,0,0,329,340,5,101,0,0,330,331,5,84,0,0,331,332,5,114,0,0,332,
		333,5,117,0,0,333,340,5,101,0,0,334,335,5,70,0,0,335,336,5,97,0,0,336,
		337,5,108,0,0,337,338,5,115,0,0,338,340,5,101,0,0,339,321,1,0,0,0,339,
		325,1,0,0,0,339,330,1,0,0,0,339,334,1,0,0,0,340,104,1,0,0,0,341,342,5,
		110,0,0,342,343,5,117,0,0,343,344,5,108,0,0,344,353,5,108,0,0,345,346,
		5,110,0,0,346,347,5,105,0,0,347,353,5,108,0,0,348,349,5,78,0,0,349,350,
		5,111,0,0,350,351,5,110,0,0,351,353,5,101,0,0,352,341,1,0,0,0,352,345,
		1,0,0,0,352,348,1,0,0,0,353,106,1,0,0,0,354,355,5,38,0,0,355,360,5,38,
		0,0,356,357,5,97,0,0,357,358,5,110,0,0,358,360,5,100,0,0,359,354,1,0,0,
		0,359,356,1,0,0,0,360,108,1,0,0,0,361,362,5,124,0,0,362,366,5,124,0,0,
		363,364,5,111,0,0,364,366,5,114,0,0,365,361,1,0,0,0,365,363,1,0,0,0,366,
		110,1,0,0,0,367,372,5,94,0,0,368,369,5,120,0,0,369,370,5,111,0,0,370,372,
		5,114,0,0,371,367,1,0,0,0,371,368,1,0,0,0,372,112,1,0,0,0,373,374,5,102,
		0,0,374,375,5,117,0,0,375,389,5,110,0,0,376,377,5,102,0,0,377,378,5,117,
		0,0,378,379,5,110,0,0,379,389,5,99,0,0,380,381,5,102,0,0,381,382,5,117,
		0,0,382,383,5,110,0,0,383,384,5,99,0,0,384,385,5,116,0,0,385,386,5,105,
		0,0,386,387,5,111,0,0,387,389,5,110,0,0,388,373,1,0,0,0,388,376,1,0,0,
		0,388,380,1,0,0,0,389,114,1,0,0,0,390,391,5,63,0,0,391,392,5,62,0,0,392,
		393,5,62,0,0,393,116,1,0,0,0,394,395,3,89,44,0,395,396,5,46,0,0,396,403,
		3,89,44,0,397,398,5,46,0,0,398,401,3,89,44,0,399,400,5,46,0,0,400,402,
		3,89,44,0,401,399,1,0,0,0,401,402,1,0,0,0,402,404,1,0,0,0,403,397,1,0,
		0,0,403,404,1,0,0,0,404,118,1,0,0,0,405,406,5,47,0,0,406,409,5,47,0,0,
		407,409,5,35,0,0,408,405,1,0,0,0,408,407,1,0,0,0,409,413,1,0,0,0,410,412,
		8,7,0,0,411,410,1,0,0,0,412,415,1,0,0,0,413,411,1,0,0,0,413,414,1,0,0,
		0,414,416,1,0,0,0,415,413,1,0,0,0,416,417,6,59,0,0,417,120,1,0,0,0,418,
		419,5,35,0,0,419,420,5,35,0,0,420,421,5,35,0,0,421,425,1,0,0,0,422,424,
		9,0,0,0,423,422,1,0,0,0,424,427,1,0,0,0,425,426,1,0,0,0,425,423,1,0,0,
		0,426,428,1,0,0,0,427,425,1,0,0,0,428,429,5,35,0,0,429,430,5,35,0,0,430,
		443,5,35,0,0,431,432,5,47,0,0,432,433,5,42,0,0,433,437,1,0,0,0,434,436,
		9,0,0,0,435,434,1,0,0,0,436,439,1,0,0,0,437,438,1,0,0,0,437,435,1,0,0,
		0,438,440,1,0,0,0,439,437,1,0,0,0,440,441,5,42,0,0,441,443,5,47,0,0,442,
		418,1,0,0,0,442,431,1,0,0,0,443,444,1,0,0,0,444,445,6,60,0,0,445,122,1,
		0,0,0,446,448,7,8,0,0,447,446,1,0,0,0,448,449,1,0,0,0,449,447,1,0,0,0,
		449,450,1,0,0,0,450,451,1,0,0,0,451,452,6,61,0,0,452,124,1,0,0,0,453,455,
		5,64,0,0,454,453,1,0,0,0,454,455,1,0,0,0,455,456,1,0,0,0,456,460,7,9,0,
		0,457,459,7,10,0,0,458,457,1,0,0,0,459,462,1,0,0,0,460,458,1,0,0,0,460,
		461,1,0,0,0,461,126,1,0,0,0,462,460,1,0,0,0,28,0,239,244,250,255,261,266,
		278,283,285,306,311,339,352,359,365,371,388,401,403,408,413,425,437,442,
		449,454,460,1,6,0,0
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}