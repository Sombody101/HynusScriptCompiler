// Generated from d:/HynusScriptCompiler/HynusScriptCompiler/ANTLRScripts/HScript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class HScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, WHILE=51, BOOL_OPERATOR=52, 
		AND=53, OR=54, XOR=55, BINARY=56, HEX=57, UINTEGER=58, FLOAT=59, INTEGER=60, 
		STRING=61, ISTRING=62, ESCSTRING=63, CHAR=64, BYTE=65, BOOL=66, SHORTHANDTRUE=67, 
		NULL=68, FUNCTIONDEC=69, SCRIPTATTR=70, VERSIONSTR=71, COMMENT=72, MLCOMMENT=73, 
		WHITESPACE=74, IDENTIFIER=75;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_assignment = 2, RULE_ifBlock = 3, 
		RULE_elseIfBlock = 4, RULE_whileBlock = 5, RULE_forBlock = 6, RULE_foreachBlock = 7, 
		RULE_tryCatch = 8, RULE_exceptionInfo = 9, RULE_functionCall = 10, RULE_functionClosure = 11, 
		RULE_functionDefinition = 12, RULE_functionParameter = 13, RULE_functionPresetParameter = 14, 
		RULE_expression = 15, RULE_doubleStatement = 16, RULE_addOp = 17, RULE_multOp = 18, 
		RULE_unaryOp = 19, RULE_doubleOp = 20, RULE_comareOp = 21, RULE_boolOp = 22, 
		RULE_constant = 23, RULE_verbatimString = 24, RULE_scriptConfiguration = 25, 
		RULE_scriptVersion = 26, RULE_changeStyle = 27, RULE_enableDebug = 28, 
		RULE_importScript = 29, RULE_arrBlock = 30, RULE_arrAccess = 31, RULE_block = 32, 
		RULE_lineBlock = 33, RULE_return = 34, RULE_opBlock = 35, RULE_nestedVariable = 36, 
		RULE_localIdentifier = 37, RULE_specialHScript = 38, RULE_specialFunctionCall = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "assignment", "ifBlock", "elseIfBlock", "whileBlock", 
			"forBlock", "foreachBlock", "tryCatch", "exceptionInfo", "functionCall", 
			"functionClosure", "functionDefinition", "functionParameter", "functionPresetParameter", 
			"expression", "doubleStatement", "addOp", "multOp", "unaryOp", "doubleOp", 
			"comareOp", "boolOp", "constant", "verbatimString", "scriptConfiguration", 
			"scriptVersion", "changeStyle", "enableDebug", "importScript", "arrBlock", 
			"arrAccess", "block", "lineBlock", "return", "opBlock", "nestedVariable", 
			"localIdentifier", "specialHScript", "specialFunctionCall"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'if'", "'('", "')'", "'else if'", "'else'", "'or'", 
			"'for'", "'foreach'", "'in'", "'try'", "'catch'", "','", "'?'", "'-'", 
			"'>'", "'hscript::'", "'cscall::'", "'+'", "'*'", "'/'", "'%'", "'**'", 
			"'~'", "'!'", "'--'", "'++'", "':!='", "':=='", "'=='", "'!='", "'<'", 
			"'>='", "'<='", "'U'", "'u'", "'```'", "'style'", "'debug'", "'import'", 
			"'['", "']'", "'{'", "'}'", "'return'", "'@'", "'scoped'", "'local'", 
			"'::'", null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "':'", null, null, "'?>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WHILE", "BOOL_OPERATOR", "AND", "OR", "XOR", "BINARY", 
			"HEX", "UINTEGER", "FLOAT", "INTEGER", "STRING", "ISTRING", "ESCSTRING", 
			"CHAR", "BYTE", "BOOL", "SHORTHANDTRUE", "NULL", "FUNCTIONDEC", "SCRIPTATTR", 
			"VERSIONSTR", "COMMENT", "MLCOMMENT", "WHITESPACE", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HScriptParser.EOF, 0); }
		public List<ScriptConfigurationContext> scriptConfiguration() {
			return getRuleContexts(ScriptConfigurationContext.class);
		}
		public ScriptConfigurationContext scriptConfiguration(int i) {
			return getRuleContext(ScriptConfigurationContext.class,i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(80);
					scriptConfiguration();
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -68750262959013860L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2103L) != 0)) {
				{
				{
				setState(86);
				line();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public WhileBlockContext whileBlock() {
			return getRuleContext(WhileBlockContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(94);
				functionDefinition();
				}
				break;
			case 2:
				{
				setState(95);
				functionCall();
				}
				break;
			case 3:
				{
				setState(96);
				assignment();
				}
				break;
			case 4:
				{
				setState(97);
				ifBlock();
				}
				break;
			case 5:
				{
				setState(98);
				whileBlock();
				}
				break;
			case 6:
				{
				setState(99);
				return_();
				}
				break;
			case 7:
				{
				setState(100);
				expression(0);
				}
				break;
			}
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(103);
				match(T__0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public ArrAccessContext arrAccess() {
			return getRuleContext(ArrAccessContext.class,0);
		}
		public LocalIdentifierContext localIdentifier() {
			return getRuleContext(LocalIdentifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrBlockContext arrBlock() {
			return getRuleContext(ArrBlockContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(106);
				arrAccess();
				}
				break;
			case 2:
				{
				setState(107);
				localIdentifier();
				}
				break;
			case 3:
				{
				setState(108);
				match(IDENTIFIER);
				}
				break;
			}
			setState(111);
			match(T__1);
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__3:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__24:
			case T__25:
			case T__46:
			case BINARY:
			case HEX:
			case UINTEGER:
			case FLOAT:
			case INTEGER:
			case STRING:
			case ISTRING:
			case ESCSTRING:
			case CHAR:
			case BYTE:
			case BOOL:
			case NULL:
			case FUNCTIONDEC:
			case IDENTIFIER:
				{
				setState(112);
				expression(0);
				}
				break;
			case T__41:
				{
				setState(113);
				arrBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OpBlockContext opBlock() {
			return getRuleContext(OpBlockContext.class,0);
		}
		public List<ElseIfBlockContext> elseIfBlock() {
			return getRuleContexts(ElseIfBlockContext.class);
		}
		public ElseIfBlockContext elseIfBlock(int i) {
			return getRuleContext(ElseIfBlockContext.class,i);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitIfBlock(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__2);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(117);
				match(T__3);
				}
				break;
			}
			setState(120);
			expression(0);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(121);
				match(T__4);
				}
			}

			setState(124);
			opBlock();
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(125);
				match(T__5);
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(126);
					match(T__3);
					}
					break;
				}
				setState(129);
				expression(0);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(130);
					match(T__4);
					}
				}

				setState(133);
				elseIfBlock();
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(134);
						match(T__5);
						setState(136);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
						case 1:
							{
							setState(135);
							match(T__3);
							}
							break;
						}
						setState(138);
						expression(0);
						setState(140);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__4) {
							{
							setState(139);
							match(T__4);
							}
						}

						setState(142);
						elseIfBlock();
						}
						} 
					}
					setState(148);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				}
				break;
			}
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(151);
				match(T__6);
				setState(152);
				elseIfBlock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfBlockContext extends ParserRuleContext {
		public OpBlockContext opBlock() {
			return getRuleContext(OpBlockContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public ElseIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterElseIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitElseIfBlock(this);
		}
	}

	public final ElseIfBlockContext elseIfBlock() throws RecognitionException {
		ElseIfBlockContext _localctx = new ElseIfBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseIfBlock);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				opBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				ifBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileBlockContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(HScriptParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<OpBlockContext> opBlock() {
			return getRuleContexts(OpBlockContext.class);
		}
		public OpBlockContext opBlock(int i) {
			return getRuleContext(OpBlockContext.class,i);
		}
		public WhileBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterWhileBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitWhileBlock(this);
		}
	}

	public final WhileBlockContext whileBlock() throws RecognitionException {
		WhileBlockContext _localctx = new WhileBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whileBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(WHILE);
			setState(160);
			expression(0);
			setState(161);
			opBlock();
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(162);
				match(T__7);
				setState(163);
				opBlock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBlockContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OpBlockContext opBlock() {
			return getRuleContext(OpBlockContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitForBlock(this);
		}
	}

	public final ForBlockContext forBlock() throws RecognitionException {
		ForBlockContext _localctx = new ForBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__8);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(167);
				match(T__3);
				}
			}

			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & 134217731L) != 0)) {
				{
				setState(170);
				assignment();
				}
			}

			setState(173);
			match(T__0);
			setState(174);
			expression(0);
			setState(175);
			match(T__0);
			setState(176);
			expression(0);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(177);
				match(T__4);
				}
			}

			setState(180);
			opBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForeachBlockContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OpBlockContext opBlock() {
			return getRuleContext(OpBlockContext.class,0);
		}
		public TerminalNode SHORTHANDTRUE() { return getToken(HScriptParser.SHORTHANDTRUE, 0); }
		public ForeachBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterForeachBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitForeachBlock(this);
		}
	}

	public final ForeachBlockContext foreachBlock() throws RecognitionException {
		ForeachBlockContext _localctx = new ForeachBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_foreachBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__9);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(183);
				match(T__3);
				}
			}

			setState(186);
			assignment();
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==SHORTHANDTRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(188);
			expression(0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(189);
				match(T__4);
				}
			}

			setState(192);
			opBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExceptionInfoContext exceptionInfo() {
			return getRuleContext(ExceptionInfoContext.class,0);
		}
		public TryCatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterTryCatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitTryCatch(this);
		}
	}

	public final TryCatchContext tryCatch() throws RecognitionException {
		TryCatchContext _localctx = new TryCatchContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tryCatch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__11);
			setState(195);
			block();
			setState(196);
			match(T__12);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(197);
				match(T__3);
				setState(198);
				exceptionInfo();
				setState(199);
				match(T__4);
				}
			}

			setState(203);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExceptionInfoContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(HScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HScriptParser.IDENTIFIER, i);
		}
		public ExceptionInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterExceptionInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitExceptionInfo(this);
		}
	}

	public final ExceptionInfoContext exceptionInfo() throws RecognitionException {
		ExceptionInfoContext _localctx = new ExceptionInfoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exceptionInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(IDENTIFIER);
			setState(206);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(IDENTIFIER);
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(210);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(209);
					match(T__3);
					}
					break;
				}
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(212);
					expression(0);
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1+1 ) {
							{
							{
							setState(213);
							match(T__13);
							setState(214);
							expression(0);
							}
							} 
						}
						setState(219);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					}
					}
					break;
				}
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(222);
					match(T__4);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(225);
				match(T__3);
				setState(226);
				match(T__4);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionClosureContext extends ParserRuleContext {
		public TerminalNode FUNCTIONDEC() { return getToken(HScriptParser.FUNCTIONDEC, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionClosureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionClosure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionClosure(this);
		}
	}

	public final FunctionClosureContext functionClosure() throws RecognitionException {
		FunctionClosureContext _localctx = new FunctionClosureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionClosure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(FUNCTIONDEC);
			setState(230);
			match(T__3);
			setState(231);
			match(T__4);
			setState(232);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode FUNCTIONDEC() { return getToken(HScriptParser.FUNCTIONDEC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FunctionParameterContext> functionParameter() {
			return getRuleContexts(FunctionParameterContext.class);
		}
		public FunctionParameterContext functionParameter(int i) {
			return getRuleContext(FunctionParameterContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(FUNCTIONDEC);
			setState(235);
			match(IDENTIFIER);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(236);
				match(T__3);
				}
			}

			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				{
				setState(239);
				functionParameter();
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(240);
						match(T__13);
						setState(241);
						functionParameter();
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				}
			}

			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(249);
				match(T__4);
				}
			}

			setState(252);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParameterContext extends ParserRuleContext {
		public FunctionPresetParameterContext functionPresetParameter() {
			return getRuleContext(FunctionPresetParameterContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public FunctionParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionParameter(this);
		}
	}

	public final FunctionParameterContext functionParameter() throws RecognitionException {
		FunctionParameterContext _localctx = new FunctionParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionParameter);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				functionPresetParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionPresetParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FunctionPresetParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPresetParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionPresetParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionPresetParameter(this);
		}
	}

	public final FunctionPresetParameterContext functionPresetParameter() throws RecognitionException {
		FunctionPresetParameterContext _localctx = new FunctionPresetParameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionPresetParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(IDENTIFIER);
			setState(259);
			match(T__1);
			setState(260);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitConstantExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitAdditiveExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SHORTHANDTRUE() { return getToken(HScriptParser.SHORTHANDTRUE, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitConditionalExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitIdentifierExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComareOpContext comareOp() {
			return getRuleContext(ComareOpContext.class,0);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitComparisonExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitMultiplicativeExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BooleanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitBooleanExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DynamicCSharpCallExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DynamicCSharpCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterDynamicCSharpCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitDynamicCSharpCallExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedVariableExpressionContext extends ExpressionContext {
		public NestedVariableContext nestedVariable() {
			return getRuleContext(NestedVariableContext.class,0);
		}
		public NestedVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterNestedVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitNestedVariableExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HscriptCallExpressionContext extends ExpressionContext {
		public SpecialHScriptContext specialHScript() {
			return getRuleContext(SpecialHScriptContext.class,0);
		}
		public HscriptCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterHscriptCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitHscriptCallExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessExpressionContext extends ExpressionContext {
		public ArrAccessContext arrAccess() {
			return getRuleContext(ArrAccessContext.class,0);
		}
		public ArrayAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitArrayAccessExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParethesizedExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParethesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterParethesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitParethesizedExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockExpressionContext extends ExpressionContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitBlockExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionCallExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ExpressionContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitUnaryExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionClosureExpressionContext extends ExpressionContext {
		public FunctionClosureContext functionClosure() {
			return getRuleContext(FunctionClosureContext.class,0);
		}
		public FunctionClosureExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterFunctionClosureExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitFunctionClosureExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(263);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new NestedVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				nestedVariable();
				}
				break;
			case 3:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(IDENTIFIER);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				arrAccess();
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				functionCall();
				}
				break;
			case 6:
				{
				_localctx = new FunctionClosureExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				functionClosure();
				}
				break;
			case 7:
				{
				_localctx = new ParethesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(T__3);
				setState(270);
				expression(0);
				setState(271);
				match(T__4);
				}
				break;
			case 8:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				unaryOp();
				setState(274);
				expression(4);
				}
				break;
			case 9:
				{
				_localctx = new BlockExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(277);
				match(T__16);
				setState(278);
				block();
				}
				break;
			case 10:
				{
				_localctx = new HscriptCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(T__17);
				setState(280);
				specialHScript();
				}
				break;
			case 11:
				{
				_localctx = new DynamicCSharpCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(T__18);
				setState(282);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(307);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(286);
						match(T__14);
						setState(287);
						expression(0);
						setState(288);
						match(SHORTHANDTRUE);
						setState(289);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(292);
						multOp();
						setState(293);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(296);
						addOp();
						setState(297);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(299);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(300);
						comareOp();
						setState(301);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new BooleanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(304);
						boolOp();
						setState(305);
						expression(6);
						}
						break;
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleStatementContext extends ParserRuleContext {
		public DoubleOpContext doubleOp() {
			return getRuleContext(DoubleOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoubleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterDoubleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitDoubleStatement(this);
		}
	}

	public final DoubleStatementContext doubleStatement() throws RecognitionException {
		DoubleStatementContext _localctx = new DoubleStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_doubleStatement);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				doubleOp();
				setState(313);
				expression(0);
				}
				break;
			case T__1:
			case T__3:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__24:
			case T__25:
			case T__46:
			case BINARY:
			case HEX:
			case UINTEGER:
			case FLOAT:
			case INTEGER:
			case STRING:
			case ISTRING:
			case ESCSTRING:
			case CHAR:
			case BYTE:
			case BOOL:
			case NULL:
			case FUNCTIONDEC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				expression(0);
				setState(316);
				doubleOp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitAddOp(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultOpContext extends ParserRuleContext {
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitMultOp(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitUnaryOp(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 101777408L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleOpContext extends ParserRuleContext {
		public DoubleOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterDoubleOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitDoubleOp(this);
		}
	}

	public final DoubleOpContext doubleOp() throws RecognitionException {
		DoubleOpContext _localctx = new DoubleOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_doubleOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComareOpContext extends ParserRuleContext {
		public ComareOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comareOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterComareOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitComareOp(this);
		}
	}

	public final ComareOpContext comareOp() throws RecognitionException {
		ComareOpContext _localctx = new ComareOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comareOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68182736896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode BOOL_OPERATOR() { return getToken(HScriptParser.BOOL_OPERATOR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitBoolOp(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_boolOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(BOOL_OPERATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(HScriptParser.BOOL, 0); }
		public TerminalNode UINTEGER() { return getToken(HScriptParser.UINTEGER, 0); }
		public TerminalNode INTEGER() { return getToken(HScriptParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(HScriptParser.FLOAT, 0); }
		public TerminalNode HEX() { return getToken(HScriptParser.HEX, 0); }
		public TerminalNode BINARY() { return getToken(HScriptParser.BINARY, 0); }
		public TerminalNode BYTE() { return getToken(HScriptParser.BYTE, 0); }
		public TerminalNode ISTRING() { return getToken(HScriptParser.ISTRING, 0); }
		public TerminalNode STRING() { return getToken(HScriptParser.STRING, 0); }
		public TerminalNode ESCSTRING() { return getToken(HScriptParser.ESCSTRING, 0); }
		public TerminalNode CHAR() { return getToken(HScriptParser.CHAR, 0); }
		public TerminalNode NULL() { return getToken(HScriptParser.NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constant);
		int _la;
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(BOOL);
				}
				break;
			case UINTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(UINTEGER);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				match(FLOAT);
				}
				break;
			case HEX:
				enterOuterAlt(_localctx, 5);
				{
				setState(336);
				match(HEX);
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(337);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case BINARY:
				enterOuterAlt(_localctx, 6);
				{
				setState(340);
				match(BINARY);
				setState(342);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(341);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case BYTE:
				enterOuterAlt(_localctx, 7);
				{
				setState(344);
				match(BYTE);
				}
				break;
			case ISTRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(345);
				match(ISTRING);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 9);
				{
				setState(346);
				match(STRING);
				}
				break;
			case ESCSTRING:
				enterOuterAlt(_localctx, 10);
				{
				setState(347);
				match(ESCSTRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 11);
				{
				setState(348);
				match(CHAR);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 12);
				{
				setState(349);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VerbatimStringContext extends ParserRuleContext {
		public VerbatimStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbatimString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterVerbatimString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitVerbatimString(this);
		}
	}

	public final VerbatimStringContext verbatimString() throws RecognitionException {
		VerbatimStringContext _localctx = new VerbatimStringContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_verbatimString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__37);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -274877906946L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4095L) != 0)) {
				{
				{
				setState(353);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__37) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(359);
			match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptConfigurationContext extends ParserRuleContext {
		public ScriptConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptConfiguration; }
	 
		public ScriptConfigurationContext() { }
		public void copyFrom(ScriptConfigurationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeStyleCongfigContext extends ScriptConfigurationContext {
		public ChangeStyleContext changeStyle() {
			return getRuleContext(ChangeStyleContext.class,0);
		}
		public CodeStyleCongfigContext(ScriptConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterCodeStyleCongfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitCodeStyleCongfig(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnableDebugConfigContext extends ScriptConfigurationContext {
		public EnableDebugContext enableDebug() {
			return getRuleContext(EnableDebugContext.class,0);
		}
		public EnableDebugConfigContext(ScriptConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterEnableDebugConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitEnableDebugConfig(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportScriptConfigContext extends ScriptConfigurationContext {
		public ImportScriptContext importScript() {
			return getRuleContext(ImportScriptContext.class,0);
		}
		public ImportScriptConfigContext(ScriptConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterImportScriptConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitImportScriptConfig(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScriptVersionConfigContext extends ScriptConfigurationContext {
		public ScriptVersionContext scriptVersion() {
			return getRuleContext(ScriptVersionContext.class,0);
		}
		public ScriptVersionConfigContext(ScriptConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterScriptVersionConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitScriptVersionConfig(this);
		}
	}

	public final ScriptConfigurationContext scriptConfiguration() throws RecognitionException {
		ScriptConfigurationContext _localctx = new ScriptConfigurationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_scriptConfiguration);
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new ScriptVersionConfigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				scriptVersion();
				}
				break;
			case 2:
				_localctx = new CodeStyleCongfigContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				changeStyle();
				}
				break;
			case 3:
				_localctx = new EnableDebugConfigContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				enableDebug();
				}
				break;
			case 4:
				_localctx = new ImportScriptConfigContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				importScript();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptVersionContext extends ParserRuleContext {
		public TerminalNode SCRIPTATTR() { return getToken(HScriptParser.SCRIPTATTR, 0); }
		public TerminalNode VERSIONSTR() { return getToken(HScriptParser.VERSIONSTR, 0); }
		public ScriptVersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptVersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterScriptVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitScriptVersion(this);
		}
	}

	public final ScriptVersionContext scriptVersion() throws RecognitionException {
		ScriptVersionContext _localctx = new ScriptVersionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_scriptVersion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(SCRIPTATTR);
			setState(368);
			match(VERSIONSTR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChangeStyleContext extends ParserRuleContext {
		public TerminalNode SCRIPTATTR() { return getToken(HScriptParser.SCRIPTATTR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ChangeStyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeStyle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterChangeStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitChangeStyle(this);
		}
	}

	public final ChangeStyleContext changeStyle() throws RecognitionException {
		ChangeStyleContext _localctx = new ChangeStyleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_changeStyle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(SCRIPTATTR);
			setState(371);
			match(T__38);
			setState(372);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnableDebugContext extends ParserRuleContext {
		public TerminalNode SCRIPTATTR() { return getToken(HScriptParser.SCRIPTATTR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnableDebugContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enableDebug; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterEnableDebug(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitEnableDebug(this);
		}
	}

	public final EnableDebugContext enableDebug() throws RecognitionException {
		EnableDebugContext _localctx = new EnableDebugContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_enableDebug);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(SCRIPTATTR);
			setState(375);
			match(T__39);
			setState(376);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportScriptContext extends ParserRuleContext {
		public TerminalNode SCRIPTATTR() { return getToken(HScriptParser.SCRIPTATTR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ImportScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterImportScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitImportScript(this);
		}
	}

	public final ImportScriptContext importScript() throws RecognitionException {
		ImportScriptContext _localctx = new ImportScriptContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_importScript);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(SCRIPTATTR);
			setState(379);
			match(T__40);
			setState(380);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrBlockContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterArrBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitArrBlock(this);
		}
	}

	public final ArrBlockContext arrBlock() throws RecognitionException {
		ArrBlockContext _localctx = new ArrBlockContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__41);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -71916856447008748L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2103L) != 0)) {
				{
				setState(383);
				expression(0);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(384);
					match(T__13);
					setState(385);
					expression(0);
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(393);
			match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrAccessContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterArrAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitArrAccess(this);
		}
	}

	public final ArrAccessContext arrAccess() throws RecognitionException {
		ArrAccessContext _localctx = new ArrAccessContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arrAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(IDENTIFIER);
			setState(396);
			match(T__41);
			setState(397);
			expression(0);
			setState(398);
			match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public LineBlockContext lineBlock() {
			return getRuleContext(LineBlockContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_block);
		int _la;
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(T__43);
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -68750262959013860L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2103L) != 0)) {
					{
					{
					setState(401);
					line();
					}
					}
					setState(406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(407);
				match(T__44);
				}
				break;
			case T__1:
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				lineBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineBlockContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public LineBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterLineBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitLineBlock(this);
		}
	}

	public final LineBlockContext lineBlock() throws RecognitionException {
		LineBlockContext _localctx = new LineBlockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lineBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(412);
			match(T__16);
			setState(413);
			line();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitReturn(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__45);
			setState(416);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpBlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public OpBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterOpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitOpBlock(this);
		}
	}

	public final OpBlockContext opBlock() throws RecognitionException {
		OpBlockContext _localctx = new OpBlockContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_opBlock);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				match(T__43);
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -68750262959013860L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2103L) != 0)) {
					{
					{
					setState(419);
					line();
					}
					}
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(425);
				match(T__44);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__24:
			case T__25:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case WHILE:
			case BINARY:
			case HEX:
			case UINTEGER:
			case FLOAT:
			case INTEGER:
			case STRING:
			case ISTRING:
			case ESCSTRING:
			case CHAR:
			case BYTE:
			case BOOL:
			case NULL:
			case FUNCTIONDEC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				line();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NestedVariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public NestedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterNestedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitNestedVariable(this);
		}
	}

	public final NestedVariableContext nestedVariable() throws RecognitionException {
		NestedVariableContext _localctx = new NestedVariableContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_nestedVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(T__46);
			setState(430);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public LocalIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterLocalIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitLocalIdentifier(this);
		}
	}

	public final LocalIdentifierContext localIdentifier() throws RecognitionException {
		LocalIdentifierContext _localctx = new LocalIdentifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_localIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_la = _input.LA(1);
			if ( !(_la==T__47 || _la==T__48) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(433);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialHScriptContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public SpecialFunctionCallContext specialFunctionCall() {
			return getRuleContext(SpecialFunctionCallContext.class,0);
		}
		public SpecialHScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialHScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterSpecialHScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitSpecialHScript(this);
		}
	}

	public final SpecialHScriptContext specialHScript() throws RecognitionException {
		SpecialHScriptContext _localctx = new SpecialHScriptContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_specialHScript);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(IDENTIFIER);
			setState(436);
			match(T__49);
			setState(437);
			specialFunctionCall();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialFunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SpecialFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterSpecialFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitSpecialFunctionCall(this);
		}
	}

	public final SpecialFunctionCallContext specialFunctionCall() throws RecognitionException {
		SpecialFunctionCallContext _localctx = new SpecialFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_specialFunctionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(IDENTIFIER);
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(441);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(440);
					match(T__3);
					}
					break;
				}
				{
				setState(443);
				expression(0);
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(444);
						match(T__13);
						setState(445);
						expression(0);
						}
						} 
					}
					setState(450);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				}
				setState(452);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(451);
					match(T__4);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(454);
				match(T__3);
				setState(455);
				match(T__4);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001K\u01cb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0005\u0000R\b\u0000\n\u0000\f\u0000U\t\u0000\u0001\u0000\u0005"+
		"\u0000X\b\u0000\n\u0000\f\u0000[\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001f\b\u0001\u0001\u0001\u0003\u0001i\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002n\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002s\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"w\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003{\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u0080\b\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u0084\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0089"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u008d\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003\u0091\b\u0003\n\u0003\f\u0003\u0094\t\u0003\u0003"+
		"\u0003\u0096\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009a\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u009e\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00a5\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00a9\b\u0006\u0001\u0006\u0003\u0006\u00ac\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00b3\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00b9\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00bf\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ca\b\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0003\n\u00d3\b\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00d8\b\n\n\n\f\n\u00db\t\n\u0003\n\u00dd\b\n\u0001\n\u0003\n\u00e0"+
		"\b\n\u0001\n\u0001\n\u0003\n\u00e4\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u00ee\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00f3\b\f\n\f\f\f\u00f6\t\f\u0003\f\u00f8\b"+
		"\f\u0001\f\u0003\f\u00fb\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0101"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u011c\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u0134\b\u000f\n\u000f\f\u000f\u0137\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u013f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u0153\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0157\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u015f\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0163\b\u0018\n\u0018\f\u0018\u0166\t\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u016e"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0005\u001e\u0183\b\u001e\n\u001e\f\u001e\u0186\t\u001e"+
		"\u0003\u001e\u0188\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0005 \u0193\b \n "+
		"\f \u0196\t \u0001 \u0001 \u0003 \u019a\b \u0001!\u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0005#\u01a5\b#\n#\f#\u01a8\t"+
		"#\u0001#\u0001#\u0003#\u01ac\b#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0003\'\u01ba\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0005\'\u01bf\b\'\n\'\f\'\u01c2\t\'\u0001\'\u0003\'"+
		"\u01c5\b\'\u0001\'\u0001\'\u0003\'\u01c9\b\'\u0001\'\u0005S\u0092\u00d9"+
		"\u00f4\u01c0\u0001\u001e(\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLN\u0000\n"+
		"\u0002\u0000\u000b\u000bCC\u0002\u0000\u0002\u0002\u0010\u0010\u0002\u0000"+
		"\u0010\u0010\u0014\u0014\u0001\u0000\u0015\u0018\u0003\u0000\u0010\u0010"+
		"\u0014\u0014\u0019\u001a\u0001\u0000\u001b\u001c\u0002\u0000\u0011\u0011"+
		"\u001d#\u0001\u0000$%\u0001\u0000&&\u0001\u000001\u01f4\u0000S\u0001\u0000"+
		"\u0000\u0000\u0002e\u0001\u0000\u0000\u0000\u0004m\u0001\u0000\u0000\u0000"+
		"\u0006t\u0001\u0000\u0000\u0000\b\u009d\u0001\u0000\u0000\u0000\n\u009f"+
		"\u0001\u0000\u0000\u0000\f\u00a6\u0001\u0000\u0000\u0000\u000e\u00b6\u0001"+
		"\u0000\u0000\u0000\u0010\u00c2\u0001\u0000\u0000\u0000\u0012\u00cd\u0001"+
		"\u0000\u0000\u0000\u0014\u00d0\u0001\u0000\u0000\u0000\u0016\u00e5\u0001"+
		"\u0000\u0000\u0000\u0018\u00ea\u0001\u0000\u0000\u0000\u001a\u0100\u0001"+
		"\u0000\u0000\u0000\u001c\u0102\u0001\u0000\u0000\u0000\u001e\u011b\u0001"+
		"\u0000\u0000\u0000 \u013e\u0001\u0000\u0000\u0000\"\u0140\u0001\u0000"+
		"\u0000\u0000$\u0142\u0001\u0000\u0000\u0000&\u0144\u0001\u0000\u0000\u0000"+
		"(\u0146\u0001\u0000\u0000\u0000*\u0148\u0001\u0000\u0000\u0000,\u014a"+
		"\u0001\u0000\u0000\u0000.\u015e\u0001\u0000\u0000\u00000\u0160\u0001\u0000"+
		"\u0000\u00002\u016d\u0001\u0000\u0000\u00004\u016f\u0001\u0000\u0000\u0000"+
		"6\u0172\u0001\u0000\u0000\u00008\u0176\u0001\u0000\u0000\u0000:\u017a"+
		"\u0001\u0000\u0000\u0000<\u017e\u0001\u0000\u0000\u0000>\u018b\u0001\u0000"+
		"\u0000\u0000@\u0199\u0001\u0000\u0000\u0000B\u019b\u0001\u0000\u0000\u0000"+
		"D\u019f\u0001\u0000\u0000\u0000F\u01ab\u0001\u0000\u0000\u0000H\u01ad"+
		"\u0001\u0000\u0000\u0000J\u01b0\u0001\u0000\u0000\u0000L\u01b3\u0001\u0000"+
		"\u0000\u0000N\u01b7\u0001\u0000\u0000\u0000PR\u00032\u0019\u0000QP\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000TY\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000VX\u0003\u0002\u0001\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0000\u0000\u0001"+
		"]\u0001\u0001\u0000\u0000\u0000^f\u0003\u0018\f\u0000_f\u0003\u0014\n"+
		"\u0000`f\u0003\u0004\u0002\u0000af\u0003\u0006\u0003\u0000bf\u0003\n\u0005"+
		"\u0000cf\u0003D\"\u0000df\u0003\u001e\u000f\u0000e^\u0001\u0000\u0000"+
		"\u0000e_\u0001\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000ea\u0001\u0000"+
		"\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000gi\u0005\u0001\u0000\u0000"+
		"hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0003\u0001\u0000"+
		"\u0000\u0000jn\u0003>\u001f\u0000kn\u0003J%\u0000ln\u0005K\u0000\u0000"+
		"mj\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000or\u0005\u0002\u0000\u0000ps\u0003\u001e"+
		"\u000f\u0000qs\u0003<\u001e\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000"+
		"\u0000\u0000s\u0005\u0001\u0000\u0000\u0000tv\u0005\u0003\u0000\u0000"+
		"uw\u0005\u0004\u0000\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xz\u0003\u001e\u000f\u0000y{\u0005\u0005"+
		"\u0000\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|\u0095\u0003F#\u0000}\u007f\u0005\u0006\u0000\u0000"+
		"~\u0080\u0005\u0004\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0003\u001e\u000f\u0000\u0082\u0084\u0005\u0005\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0092\u0003\b\u0004\u0000\u0086\u0088\u0005"+
		"\u0006\u0000\u0000\u0087\u0089\u0005\u0004\u0000\u0000\u0088\u0087\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008c\u0003\u001e\u000f\u0000\u008b\u008d\u0005"+
		"\u0005\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0003"+
		"\b\u0004\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u0086\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095}\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\u0007\u0000\u0000\u0098\u009a\u0003\b\u0004\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u0007\u0001\u0000\u0000\u0000\u009b\u009e\u0003F#\u0000\u009c\u009e"+
		"\u0003\u0006\u0003\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\t\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"3\u0000\u0000\u00a0\u00a1\u0003\u001e\u000f\u0000\u00a1\u00a4\u0003F#"+
		"\u0000\u00a2\u00a3\u0005\b\u0000\u0000\u00a3\u00a5\u0003F#\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u000b\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005\t\u0000\u0000\u00a7\u00a9"+
		"\u0005\u0004\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00ac"+
		"\u0003\u0004\u0002\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0001\u0000\u0000\u00ae\u00af\u0003\u001e\u000f\u0000\u00af\u00b0"+
		"\u0005\u0001\u0000\u0000\u00b0\u00b2\u0003\u001e\u000f\u0000\u00b1\u00b3"+
		"\u0005\u0005\u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0003F#\u0000\u00b5\r\u0001\u0000\u0000\u0000\u00b6\u00b8\u0005\n\u0000"+
		"\u0000\u00b7\u00b9\u0005\u0004\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0003\u0004\u0002\u0000\u00bb\u00bc\u0007\u0000\u0000"+
		"\u0000\u00bc\u00be\u0003\u001e\u000f\u0000\u00bd\u00bf\u0005\u0005\u0000"+
		"\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0003F#\u0000\u00c1"+
		"\u000f\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\f\u0000\u0000\u00c3\u00c4"+
		"\u0003@ \u0000\u00c4\u00c9\u0005\r\u0000\u0000\u00c5\u00c6\u0005\u0004"+
		"\u0000\u0000\u00c6\u00c7\u0003\u0012\t\u0000\u00c7\u00c8\u0005\u0005\u0000"+
		"\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0003@ \u0000\u00cc\u0011\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0005K\u0000\u0000\u00ce\u00cf\u0005K\u0000\u0000\u00cf\u0013\u0001"+
		"\u0000\u0000\u0000\u00d0\u00e3\u0005K\u0000\u0000\u00d1\u00d3\u0005\u0004"+
		"\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00dc\u0001\u0000\u0000\u0000\u00d4\u00d9\u0003\u001e"+
		"\u000f\u0000\u00d5\u00d6\u0005\u000e\u0000\u0000\u00d6\u00d8\u0003\u001e"+
		"\u000f\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00dc\u00d4\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000"+
		"\u0000\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de\u00e0\u0005\u0005"+
		"\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e4\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u0004"+
		"\u0000\u0000\u00e2\u00e4\u0005\u0005\u0000\u0000\u00e3\u00d2\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u0015\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0005E\u0000\u0000\u00e6\u00e7\u0005\u0004\u0000"+
		"\u0000\u00e7\u00e8\u0005\u0005\u0000\u0000\u00e8\u00e9\u0003@ \u0000\u00e9"+
		"\u0017\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005E\u0000\u0000\u00eb\u00ed"+
		"\u0005K\u0000\u0000\u00ec\u00ee\u0005\u0004\u0000\u0000\u00ed\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f7\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f4\u0003\u001a\r\u0000\u00f0\u00f1\u0005\u000e"+
		"\u0000\u0000\u00f1\u00f3\u0003\u001a\r\u0000\u00f2\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fb\u0005\u0005\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0003@ \u0000\u00fd\u0019\u0001\u0000\u0000\u0000\u00fe"+
		"\u0101\u0003\u001c\u000e\u0000\u00ff\u0101\u0005K\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0101\u001b"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0005K\u0000\u0000\u0103\u0104\u0005"+
		"\u0002\u0000\u0000\u0104\u0105\u0003.\u0017\u0000\u0105\u001d\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0006\u000f\uffff\uffff\u0000\u0107\u011c\u0003"+
		".\u0017\u0000\u0108\u011c\u0003H$\u0000\u0109\u011c\u0005K\u0000\u0000"+
		"\u010a\u011c\u0003>\u001f\u0000\u010b\u011c\u0003\u0014\n\u0000\u010c"+
		"\u011c\u0003\u0016\u000b\u0000\u010d\u010e\u0005\u0004\u0000\u0000\u010e"+
		"\u010f\u0003\u001e\u000f\u0000\u010f\u0110\u0005\u0005\u0000\u0000\u0110"+
		"\u011c\u0001\u0000\u0000\u0000\u0111\u0112\u0003&\u0013\u0000\u0112\u0113"+
		"\u0003\u001e\u000f\u0004\u0113\u011c\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0007\u0001\u0000\u0000\u0115\u0116\u0005\u0011\u0000\u0000\u0116\u011c"+
		"\u0003@ \u0000\u0117\u0118\u0005\u0012\u0000\u0000\u0118\u011c\u0003L"+
		"&\u0000\u0119\u011a\u0005\u0013\u0000\u0000\u011a\u011c\u0003\u001e\u000f"+
		"\u0001\u011b\u0106\u0001\u0000\u0000\u0000\u011b\u0108\u0001\u0000\u0000"+
		"\u0000\u011b\u0109\u0001\u0000\u0000\u0000\u011b\u010a\u0001\u0000\u0000"+
		"\u0000\u011b\u010b\u0001\u0000\u0000\u0000\u011b\u010c\u0001\u0000\u0000"+
		"\u0000\u011b\u010d\u0001\u0000\u0000\u0000\u011b\u0111\u0001\u0000\u0000"+
		"\u0000\u011b\u0114\u0001\u0000\u0000\u0000\u011b\u0117\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u0135\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\n\t\u0000\u0000\u011e\u011f\u0005\u000f\u0000\u0000"+
		"\u011f\u0120\u0003\u001e\u000f\u0000\u0120\u0121\u0005C\u0000\u0000\u0121"+
		"\u0122\u0003\u001e\u000f\n\u0122\u0134\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\n\b\u0000\u0000\u0124\u0125\u0003$\u0012\u0000\u0125\u0126\u0003\u001e"+
		"\u000f\t\u0126\u0134\u0001\u0000\u0000\u0000\u0127\u0128\n\u0007\u0000"+
		"\u0000\u0128\u0129\u0003\"\u0011\u0000\u0129\u012a\u0003\u001e\u000f\b"+
		"\u012a\u0134\u0001\u0000\u0000\u0000\u012b\u012c\n\u0006\u0000\u0000\u012c"+
		"\u012d\u0003*\u0015\u0000\u012d\u012e\u0003\u001e\u000f\u0007\u012e\u0134"+
		"\u0001\u0000\u0000\u0000\u012f\u0130\n\u0005\u0000\u0000\u0130\u0131\u0003"+
		",\u0016\u0000\u0131\u0132\u0003\u001e\u000f\u0006\u0132\u0134\u0001\u0000"+
		"\u0000\u0000\u0133\u011d\u0001\u0000\u0000\u0000\u0133\u0123\u0001\u0000"+
		"\u0000\u0000\u0133\u0127\u0001\u0000\u0000\u0000\u0133\u012b\u0001\u0000"+
		"\u0000\u0000\u0133\u012f\u0001\u0000\u0000\u0000\u0134\u0137\u0001\u0000"+
		"\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000"+
		"\u0000\u0000\u0136\u001f\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0003(\u0014\u0000\u0139\u013a\u0003\u001e\u000f"+
		"\u0000\u013a\u013f\u0001\u0000\u0000\u0000\u013b\u013c\u0003\u001e\u000f"+
		"\u0000\u013c\u013d\u0003(\u0014\u0000\u013d\u013f\u0001\u0000\u0000\u0000"+
		"\u013e\u0138\u0001\u0000\u0000\u0000\u013e\u013b\u0001\u0000\u0000\u0000"+
		"\u013f!\u0001\u0000\u0000\u0000\u0140\u0141\u0007\u0002\u0000\u0000\u0141"+
		"#\u0001\u0000\u0000\u0000\u0142\u0143\u0007\u0003\u0000\u0000\u0143%\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0007\u0004\u0000\u0000\u0145\'\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0007\u0005\u0000\u0000\u0147)\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0007\u0006\u0000\u0000\u0149+\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u00054\u0000\u0000\u014b-\u0001\u0000\u0000\u0000\u014c\u015f"+
		"\u0005B\u0000\u0000\u014d\u015f\u0005:\u0000\u0000\u014e\u015f\u0005<"+
		"\u0000\u0000\u014f\u015f\u0005;\u0000\u0000\u0150\u0152\u00059\u0000\u0000"+
		"\u0151\u0153\u0007\u0007\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u015f\u0001\u0000\u0000\u0000"+
		"\u0154\u0156\u00058\u0000\u0000\u0155\u0157\u0007\u0007\u0000\u0000\u0156"+
		"\u0155\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157"+
		"\u015f\u0001\u0000\u0000\u0000\u0158\u015f\u0005A\u0000\u0000\u0159\u015f"+
		"\u0005>\u0000\u0000\u015a\u015f\u0005=\u0000\u0000\u015b\u015f\u0005?"+
		"\u0000\u0000\u015c\u015f\u0005@\u0000\u0000\u015d\u015f\u0005D\u0000\u0000"+
		"\u015e\u014c\u0001\u0000\u0000\u0000\u015e\u014d\u0001\u0000\u0000\u0000"+
		"\u015e\u014e\u0001\u0000\u0000\u0000\u015e\u014f\u0001\u0000\u0000\u0000"+
		"\u015e\u0150\u0001\u0000\u0000\u0000\u015e\u0154\u0001\u0000\u0000\u0000"+
		"\u015e\u0158\u0001\u0000\u0000\u0000\u015e\u0159\u0001\u0000\u0000\u0000"+
		"\u015e\u015a\u0001\u0000\u0000\u0000\u015e\u015b\u0001\u0000\u0000\u0000"+
		"\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000"+
		"\u015f/\u0001\u0000\u0000\u0000\u0160\u0164\u0005&\u0000\u0000\u0161\u0163"+
		"\b\b\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0163\u0166\u0001"+
		"\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001"+
		"\u0000\u0000\u0000\u0165\u0167\u0001\u0000\u0000\u0000\u0166\u0164\u0001"+
		"\u0000\u0000\u0000\u0167\u0168\u0005&\u0000\u0000\u01681\u0001\u0000\u0000"+
		"\u0000\u0169\u016e\u00034\u001a\u0000\u016a\u016e\u00036\u001b\u0000\u016b"+
		"\u016e\u00038\u001c\u0000\u016c\u016e\u0003:\u001d\u0000\u016d\u0169\u0001"+
		"\u0000\u0000\u0000\u016d\u016a\u0001\u0000\u0000\u0000\u016d\u016b\u0001"+
		"\u0000\u0000\u0000\u016d\u016c\u0001\u0000\u0000\u0000\u016e3\u0001\u0000"+
		"\u0000\u0000\u016f\u0170\u0005F\u0000\u0000\u0170\u0171\u0005G\u0000\u0000"+
		"\u01715\u0001\u0000\u0000\u0000\u0172\u0173\u0005F\u0000\u0000\u0173\u0174"+
		"\u0005\'\u0000\u0000\u0174\u0175\u0005K\u0000\u0000\u01757\u0001\u0000"+
		"\u0000\u0000\u0176\u0177\u0005F\u0000\u0000\u0177\u0178\u0005(\u0000\u0000"+
		"\u0178\u0179\u0003\u001e\u000f\u0000\u01799\u0001\u0000\u0000\u0000\u017a"+
		"\u017b\u0005F\u0000\u0000\u017b\u017c\u0005)\u0000\u0000\u017c\u017d\u0005"+
		"K\u0000\u0000\u017d;\u0001\u0000\u0000\u0000\u017e\u0187\u0005*\u0000"+
		"\u0000\u017f\u0184\u0003\u001e\u000f\u0000\u0180\u0181\u0005\u000e\u0000"+
		"\u0000\u0181\u0183\u0003\u001e\u000f\u0000\u0182\u0180\u0001\u0000\u0000"+
		"\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000"+
		"\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0188\u0001\u0000\u0000"+
		"\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u017f\u0001\u0000\u0000"+
		"\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000"+
		"\u0000\u0189\u018a\u0005+\u0000\u0000\u018a=\u0001\u0000\u0000\u0000\u018b"+
		"\u018c\u0005K\u0000\u0000\u018c\u018d\u0005*\u0000\u0000\u018d\u018e\u0003"+
		"\u001e\u000f\u0000\u018e\u018f\u0005+\u0000\u0000\u018f?\u0001\u0000\u0000"+
		"\u0000\u0190\u0194\u0005,\u0000\u0000\u0191\u0193\u0003\u0002\u0001\u0000"+
		"\u0192\u0191\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000\u0000"+
		"\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000"+
		"\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000"+
		"\u0197\u019a\u0005-\u0000\u0000\u0198\u019a\u0003B!\u0000\u0199\u0190"+
		"\u0001\u0000\u0000\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019aA\u0001"+
		"\u0000\u0000\u0000\u019b\u019c\u0007\u0001\u0000\u0000\u019c\u019d\u0005"+
		"\u0011\u0000\u0000\u019d\u019e\u0003\u0002\u0001\u0000\u019eC\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0005.\u0000\u0000\u01a0\u01a1\u0003\u001e\u000f"+
		"\u0000\u01a1E\u0001\u0000\u0000\u0000\u01a2\u01a6\u0005,\u0000\u0000\u01a3"+
		"\u01a5\u0003\u0002\u0001\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a9\u01ac\u0005-\u0000\u0000\u01aa\u01ac"+
		"\u0003\u0002\u0001\u0000\u01ab\u01a2\u0001\u0000\u0000\u0000\u01ab\u01aa"+
		"\u0001\u0000\u0000\u0000\u01acG\u0001\u0000\u0000\u0000\u01ad\u01ae\u0005"+
		"/\u0000\u0000\u01ae\u01af\u0005K\u0000\u0000\u01afI\u0001\u0000\u0000"+
		"\u0000\u01b0\u01b1\u0007\t\u0000\u0000\u01b1\u01b2\u0005K\u0000\u0000"+
		"\u01b2K\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005K\u0000\u0000\u01b4\u01b5"+
		"\u00052\u0000\u0000\u01b5\u01b6\u0003N\'\u0000\u01b6M\u0001\u0000\u0000"+
		"\u0000\u01b7\u01c8\u0005K\u0000\u0000\u01b8\u01ba\u0005\u0004\u0000\u0000"+
		"\u01b9\u01b8\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01c0\u0003\u001e\u000f\u0000"+
		"\u01bc\u01bd\u0005\u000e\u0000\u0000\u01bd\u01bf\u0003\u001e\u000f\u0000"+
		"\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000"+
		"\u01c1\u01c4\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000"+
		"\u01c3\u01c5\u0005\u0005\u0000\u0000\u01c4\u01c3\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c6\u01c7\u0005\u0004\u0000\u0000\u01c7\u01c9\u0005\u0005\u0000\u0000"+
		"\u01c8\u01b9\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000"+
		"\u01c9O\u0001\u0000\u0000\u00004SYehmrvz\u007f\u0083\u0088\u008c\u0092"+
		"\u0095\u0099\u009d\u00a4\u00a8\u00ab\u00b2\u00b8\u00be\u00c9\u00d2\u00d9"+
		"\u00dc\u00df\u00e3\u00ed\u00f4\u00f7\u00fa\u0100\u011b\u0133\u0135\u013e"+
		"\u0152\u0156\u015e\u0164\u016d\u0184\u0187\u0194\u0199\u01a6\u01ab\u01b9"+
		"\u01c0\u01c4\u01c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}