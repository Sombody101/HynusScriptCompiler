// Generated from f:/HynusScriptCompiler/HynusScriptCompiler/ANTLRScripts/HScript.g4 by ANTLR 4.13.1
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
		WHILE=39, BOOL_OPERATOR=40, BINARY=41, HEX=42, UINTEGER=43, FLOAT=44, 
		INTEGER=45, STRING=46, CHAR=47, BYTE=48, BOOL=49, NULL=50, AND=51, OR=52, 
		XOR=53, FUNCTIONDEC=54, SCRIPTATTR=55, VERSIONSTR=56, COMMENT=57, MLCOMMENT=58, 
		WHITESPACE=59, IDENTIFIER=60;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_statement = 2, RULE_ifBlock = 3, 
		RULE_elseIfBlock = 4, RULE_whileBlock = 5, RULE_assignment = 6, RULE_functionDefinition = 7, 
		RULE_functionCall = 8, RULE_tryCatch = 9, RULE_exceptionInfo = 10, RULE_expression = 11, 
		RULE_nestedVariable = 12, RULE_interpolatedString = 13, RULE_unaryOp = 14, 
		RULE_doubleStatement = 15, RULE_doubleOp = 16, RULE_multOp = 17, RULE_addOp = 18, 
		RULE_comareOp = 19, RULE_boolOp = 20, RULE_constant = 21, RULE_scriptVersion = 22, 
		RULE_changeStyle = 23, RULE_block = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "statement", "ifBlock", "elseIfBlock", "whileBlock", 
			"assignment", "functionDefinition", "functionCall", "tryCatch", "exceptionInfo", 
			"expression", "nestedVariable", "interpolatedString", "unaryOp", "doubleStatement", 
			"doubleOp", "multOp", "addOp", "comareOp", "boolOp", "constant", "scriptVersion", 
			"changeStyle", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'if'", "'('", "')'", "'else'", "'or'", "'='", "','", "'try'", 
			"'catch'", "'?'", "':'", "'$'", "'-'", "'+'", "'~'", "'!'", "'--'", "'++'", 
			"'*'", "'/'", "'%'", "'**'", "':!='", "':=='", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'U'", "'u'", "'F'", "'f'", "'style'", "'{'", 
			"'}'", null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'?>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WHILE", "BOOL_OPERATOR", "BINARY", "HEX", "UINTEGER", 
			"FLOAT", "INTEGER", "STRING", "CHAR", "BYTE", "BOOL", "NULL", "AND", 
			"OR", "XOR", "FUNCTIONDEC", "SCRIPTATTR", "VERSIONSTR", "COMMENT", "MLCOMMENT", 
			"WHITESPACE", "IDENTIFIER"
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
		public ScriptVersionContext scriptVersion() {
			return getRuleContext(ScriptVersionContext.class,0);
		}
		public ChangeStyleContext changeStyle() {
			return getRuleContext(ChangeStyleContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(50);
				scriptVersion();
				}
				break;
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPTATTR) {
				{
				setState(53);
				changeStyle();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152922054362660868L) != 0)) {
				{
				{
				setState(56);
				line();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public WhileBlockContext whileBlock() {
			return getRuleContext(WhileBlockContext.class,0);
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				statement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				ifBlock();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				whileBlock();
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
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(69);
				assignment();
				}
				break;
			case 2:
				{
				setState(70);
				functionCall();
				}
				break;
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(73);
				match(T__0);
				}
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfBlockContext elseIfBlock() {
			return getRuleContext(ElseIfBlockContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__1);
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(77);
				match(T__2);
				}
				break;
			}
			setState(80);
			expression(0);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(81);
				match(T__3);
				}
			}

			setState(84);
			block();
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(85);
				match(T__4);
				setState(86);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfBlockContext elseIfBlock() {
			return getRuleContext(ElseIfBlockContext.class,0);
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
			setState(93);
			match(WHILE);
			setState(94);
			expression(0);
			setState(95);
			block();
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(96);
				match(T__5);
				setState(97);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IDENTIFIER);
			setState(101);
			match(T__6);
			setState(102);
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode FUNCTIONDEC() { return getToken(HScriptParser.FUNCTIONDEC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(HScriptParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 14, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(FUNCTIONDEC);
			setState(105);
			match(IDENTIFIER);
			setState(106);
			match(T__2);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1155171105397530632L) != 0)) {
				{
				setState(107);
				expression(0);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(108);
					match(T__7);
					setState(109);
					expression(0);
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(117);
			match(T__3);
			setState(118);
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
		enterRule(_localctx, 16, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(IDENTIFIER);
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(121);
				match(T__2);
				}
				break;
			}
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(124);
				expression(0);
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(125);
						match(T__7);
						setState(126);
						expression(0);
						}
						} 
					}
					setState(131);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			}
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(134);
				match(T__3);
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
		enterRule(_localctx, 18, RULE_tryCatch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__8);
			setState(138);
			block();
			setState(139);
			match(T__9);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(140);
				match(T__2);
				setState(141);
				exceptionInfo();
				setState(142);
				match(T__3);
				}
			}

			setState(146);
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
		enterRule(_localctx, 20, RULE_exceptionInfo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(IDENTIFIER);
			setState(149);
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
	public static class InterpolatedStringExpressionContext extends ExpressionContext {
		public NestedVariableContext nestedVariable() {
			return getRuleContext(NestedVariableContext.class,0);
		}
		public InterpolatedStringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterInterpolatedStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitInterpolatedStringExpression(this);
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
		public NestedVariableContext nestedVariable() {
			return getRuleContext(NestedVariableContext.class,0);
		}
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(152);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				nestedVariable();
				}
				break;
			case 3:
				{
				_localctx = new InterpolatedStringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				nestedVariable();
				}
				break;
			case 4:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(IDENTIFIER);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				functionCall();
				}
				break;
			case 6:
				{
				_localctx = new ParethesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(T__2);
				setState(158);
				expression(0);
				setState(159);
				match(T__3);
				}
				break;
			case 7:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				unaryOp();
				setState(162);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(167);
						match(T__10);
						setState(168);
						expression(0);
						setState(169);
						match(T__11);
						setState(170);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(173);
						multOp();
						setState(174);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(177);
						addOp();
						setState(178);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181);
						comareOp();
						setState(182);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new BooleanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(185);
						boolOp();
						setState(186);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 24, RULE_nestedVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__12);
			setState(194);
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
	public static class InterpolatedStringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HScriptParser.STRING, 0); }
		public InterpolatedStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolatedString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).enterInterpolatedString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HScriptListener ) ((HScriptListener)listener).exitInterpolatedString(this);
		}
	}

	public final InterpolatedStringContext interpolatedString() throws RecognitionException {
		InterpolatedStringContext _localctx = new InterpolatedStringContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_interpolatedString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__12);
			setState(197);
			match(STRING);
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
		enterRule(_localctx, 28, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_doubleStatement);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				doubleOp();
				setState(202);
				expression(0);
				}
				break;
			case T__2:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case BINARY:
			case HEX:
			case UINTEGER:
			case FLOAT:
			case INTEGER:
			case STRING:
			case CHAR:
			case BYTE:
			case BOOL:
			case NULL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				expression(0);
				setState(205);
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
		enterRule(_localctx, 32, RULE_doubleOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
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
		enterRule(_localctx, 34, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) ) {
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
		enterRule(_localctx, 36, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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
		enterRule(_localctx, 38, RULE_comareOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4278190080L) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_boolOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		public TerminalNode UINTEGER() { return getToken(HScriptParser.UINTEGER, 0); }
		public TerminalNode INTEGER() { return getToken(HScriptParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(HScriptParser.FLOAT, 0); }
		public TerminalNode HEX() { return getToken(HScriptParser.HEX, 0); }
		public TerminalNode BINARY() { return getToken(HScriptParser.BINARY, 0); }
		public TerminalNode BYTE() { return getToken(HScriptParser.BYTE, 0); }
		public TerminalNode STRING() { return getToken(HScriptParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(HScriptParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(HScriptParser.BOOL, 0); }
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
		enterRule(_localctx, 42, RULE_constant);
		int _la;
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UINTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(UINTEGER);
				setState(220);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(FLOAT);
				setState(223);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case HEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(HEX);
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(225);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
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
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(BINARY);
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(229);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
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
				enterOuterAlt(_localctx, 6);
				{
				setState(232);
				match(BYTE);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 7);
				{
				setState(233);
				match(STRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(234);
				match(CHAR);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 9);
				{
				setState(235);
				match(BOOL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 10);
				{
				setState(236);
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
		enterRule(_localctx, 44, RULE_scriptVersion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(SCRIPTATTR);
			setState(240);
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
		enterRule(_localctx, 46, RULE_changeStyle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(SCRIPTATTR);
			setState(243);
			match(T__35);
			setState(244);
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
	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(T__36);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152922054362660868L) != 0)) {
					{
					{
					setState(247);
					line();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(253);
				match(T__37);
				}
				break;
			case T__1:
			case WHILE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001<\u0102\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0003\u00004\b\u0000\u0001\u0000\u0003\u00007\b\u0000\u0001"+
		"\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0002\u0003\u0002K\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003S\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"X\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007o\b\u0007\n\u0007"+
		"\f\u0007r\t\u0007\u0003\u0007t\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0003\b{\b\b\u0001\b\u0001\b\u0001\b\u0005\b\u0080\b"+
		"\b\n\b\f\b\u0083\t\b\u0003\b\u0085\b\b\u0001\b\u0003\b\u0088\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0091\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a5\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00bd\b\u000b"+
		"\n\u000b\f\u000b\u00c0\t\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d0\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00e3\b\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00e7\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00ee\b\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u00f9\b\u0018\n\u0018\f\u0018\u00fc\t\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0100\b\u0018\u0001\u0018\u0000\u0001"+
		"\u0016\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\u0007\u0001\u0000\u000e\u0011"+
		"\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0017\u0001\u0000\u000e\u000f"+
		"\u0001\u0000\u0018\u001f\u0001\u0000 !\u0001\u0000\"#\u0114\u00003\u0001"+
		"\u0000\u0000\u0000\u0002C\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000"+
		"\u0000\u0006L\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\n]\u0001"+
		"\u0000\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000eh\u0001\u0000\u0000"+
		"\u0000\u0010x\u0001\u0000\u0000\u0000\u0012\u0089\u0001\u0000\u0000\u0000"+
		"\u0014\u0094\u0001\u0000\u0000\u0000\u0016\u00a4\u0001\u0000\u0000\u0000"+
		"\u0018\u00c1\u0001\u0000\u0000\u0000\u001a\u00c4\u0001\u0000\u0000\u0000"+
		"\u001c\u00c7\u0001\u0000\u0000\u0000\u001e\u00cf\u0001\u0000\u0000\u0000"+
		" \u00d1\u0001\u0000\u0000\u0000\"\u00d3\u0001\u0000\u0000\u0000$\u00d5"+
		"\u0001\u0000\u0000\u0000&\u00d7\u0001\u0000\u0000\u0000(\u00d9\u0001\u0000"+
		"\u0000\u0000*\u00ed\u0001\u0000\u0000\u0000,\u00ef\u0001\u0000\u0000\u0000"+
		".\u00f2\u0001\u0000\u0000\u00000\u00ff\u0001\u0000\u0000\u000024\u0003"+
		",\u0016\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001"+
		"\u0000\u0000\u000057\u0003.\u0017\u000065\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007;\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u0000"+
		"98\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000>?\u0005\u0000\u0000\u0001?\u0001\u0001\u0000\u0000\u0000"+
		"@D\u0003\u0004\u0002\u0000AD\u0003\u0006\u0003\u0000BD\u0003\n\u0005\u0000"+
		"C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000\u0000"+
		"\u0000D\u0003\u0001\u0000\u0000\u0000EH\u0003\f\u0006\u0000FH\u0003\u0010"+
		"\b\u0000GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000HJ\u0001\u0000"+
		"\u0000\u0000IK\u0005\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LN\u0005\u0002\u0000"+
		"\u0000MO\u0005\u0003\u0000\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0003\u0016\u000b\u0000QS\u0005"+
		"\u0004\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TW\u00030\u0018\u0000UV\u0005\u0005\u0000\u0000"+
		"VX\u0003\b\u0004\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"X\u0007\u0001\u0000\u0000\u0000Y\\\u00030\u0018\u0000Z\\\u0003\u0006\u0003"+
		"\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\t\u0001\u0000"+
		"\u0000\u0000]^\u0005\'\u0000\u0000^_\u0003\u0016\u000b\u0000_b\u00030"+
		"\u0018\u0000`a\u0005\u0006\u0000\u0000ac\u0003\b\u0004\u0000b`\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000b\u0001\u0000\u0000\u0000"+
		"de\u0005<\u0000\u0000ef\u0005\u0007\u0000\u0000fg\u0003\u0016\u000b\u0000"+
		"g\r\u0001\u0000\u0000\u0000hi\u00056\u0000\u0000ij\u0005<\u0000\u0000"+
		"js\u0005\u0003\u0000\u0000kp\u0003\u0016\u000b\u0000lm\u0005\b\u0000\u0000"+
		"mo\u0003\u0016\u000b\u0000nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qt\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005\u0004\u0000\u0000"+
		"vw\u00030\u0018\u0000w\u000f\u0001\u0000\u0000\u0000xz\u0005<\u0000\u0000"+
		"y{\u0005\u0003\u0000\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\u0084\u0001\u0000\u0000\u0000|\u0081\u0003\u0016\u000b\u0000}"+
		"~\u0005\b\u0000\u0000~\u0080\u0003\u0016\u000b\u0000\u007f}\u0001\u0000"+
		"\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084|\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000"+
		"\u0000\u0086\u0088\u0005\u0004\u0000\u0000\u0087\u0086\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0011\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005\t\u0000\u0000\u008a\u008b\u00030\u0018\u0000"+
		"\u008b\u0090\u0005\n\u0000\u0000\u008c\u008d\u0005\u0003\u0000\u0000\u008d"+
		"\u008e\u0003\u0014\n\u0000\u008e\u008f\u0005\u0004\u0000\u0000\u008f\u0091"+
		"\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u00030\u0018\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"<\u0000\u0000\u0095\u0096\u0005<\u0000\u0000\u0096\u0015\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0006\u000b\uffff\uffff\u0000\u0098\u00a5\u0003*\u0015"+
		"\u0000\u0099\u00a5\u0003\u0018\f\u0000\u009a\u00a5\u0003\u0018\f\u0000"+
		"\u009b\u00a5\u0005<\u0000\u0000\u009c\u00a5\u0003\u0010\b\u0000\u009d"+
		"\u009e\u0005\u0003\u0000\u0000\u009e\u009f\u0003\u0016\u000b\u0000\u009f"+
		"\u00a0\u0005\u0004\u0000\u0000\u00a0\u00a5\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0003\u001c\u000e\u0000\u00a2\u00a3\u0003\u0016\u000b\u0001\u00a3"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a4\u0097\u0001\u0000\u0000\u0000\u00a4"+
		"\u0099\u0001\u0000\u0000\u0000\u00a4\u009a\u0001\u0000\u0000\u0000\u00a4"+
		"\u009b\u0001\u0000\u0000\u0000\u00a4\u009c\u0001\u0000\u0000\u0000\u00a4"+
		"\u009d\u0001\u0000\u0000\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a5"+
		"\u00be\u0001\u0000\u0000\u0000\u00a6\u00a7\n\u0006\u0000\u0000\u00a7\u00a8"+
		"\u0005\u000b\u0000\u0000\u00a8\u00a9\u0003\u0016\u000b\u0000\u00a9\u00aa"+
		"\u0005\f\u0000\u0000\u00aa\u00ab\u0003\u0016\u000b\u0007\u00ab\u00bd\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\n\u0005\u0000\u0000\u00ad\u00ae\u0003\""+
		"\u0011\u0000\u00ae\u00af\u0003\u0016\u000b\u0006\u00af\u00bd\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\n\u0004\u0000\u0000\u00b1\u00b2\u0003$\u0012"+
		"\u0000\u00b2\u00b3\u0003\u0016\u000b\u0005\u00b3\u00bd\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\n\u0003\u0000\u0000\u00b5\u00b6\u0003&\u0013\u0000"+
		"\u00b6\u00b7\u0003\u0016\u000b\u0004\u00b7\u00bd\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\n\u0002\u0000\u0000\u00b9\u00ba\u0003(\u0014\u0000\u00ba"+
		"\u00bb\u0003\u0016\u000b\u0003\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc"+
		"\u00a6\u0001\u0000\u0000\u0000\u00bc\u00ac\u0001\u0000\u0000\u0000\u00bc"+
		"\u00b0\u0001\u0000\u0000\u0000\u00bc\u00b4\u0001\u0000\u0000\u0000\u00bc"+
		"\u00b8\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf"+
		"\u0017\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0005\r\u0000\u0000\u00c2\u00c3\u0005<\u0000\u0000\u00c3\u0019"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\r\u0000\u0000\u00c5\u00c6\u0005"+
		".\u0000\u0000\u00c6\u001b\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0000"+
		"\u0000\u0000\u00c8\u001d\u0001\u0000\u0000\u0000\u00c9\u00ca\u0003 \u0010"+
		"\u0000\u00ca\u00cb\u0003\u0016\u000b\u0000\u00cb\u00d0\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0003\u0016\u000b\u0000\u00cd\u00ce\u0003 \u0010\u0000"+
		"\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cc\u0001\u0000\u0000\u0000\u00d0\u001f\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0007\u0001\u0000\u0000\u00d2!\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0007\u0002\u0000\u0000\u00d4#\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0007\u0003\u0000\u0000\u00d6%\u0001\u0000\u0000\u0000\u00d7\u00d8\u0007"+
		"\u0004\u0000\u0000\u00d8\'\u0001\u0000\u0000\u0000\u00d9\u00da\u0005("+
		"\u0000\u0000\u00da)\u0001\u0000\u0000\u0000\u00db\u00dc\u0005+\u0000\u0000"+
		"\u00dc\u00ee\u0007\u0005\u0000\u0000\u00dd\u00ee\u0005-\u0000\u0000\u00de"+
		"\u00df\u0005,\u0000\u0000\u00df\u00ee\u0007\u0006\u0000\u0000\u00e0\u00e2"+
		"\u0005*\u0000\u0000\u00e1\u00e3\u0007\u0005\u0000\u0000\u00e2\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00ee\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e6\u0005)\u0000\u0000\u00e5\u00e7\u0007\u0005"+
		"\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u00ee\u0001\u0000\u0000\u0000\u00e8\u00ee\u00050\u0000"+
		"\u0000\u00e9\u00ee\u0005.\u0000\u0000\u00ea\u00ee\u0005/\u0000\u0000\u00eb"+
		"\u00ee\u00051\u0000\u0000\u00ec\u00ee\u00052\u0000\u0000\u00ed\u00db\u0001"+
		"\u0000\u0000\u0000\u00ed\u00dd\u0001\u0000\u0000\u0000\u00ed\u00de\u0001"+
		"\u0000\u0000\u0000\u00ed\u00e0\u0001\u0000\u0000\u0000\u00ed\u00e4\u0001"+
		"\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000\u0000\u00ed\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee+\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u00057\u0000\u0000\u00f0\u00f1\u00058\u0000\u0000"+
		"\u00f1-\u0001\u0000\u0000\u0000\u00f2\u00f3\u00057\u0000\u0000\u00f3\u00f4"+
		"\u0005$\u0000\u0000\u00f4\u00f5\u0005<\u0000\u0000\u00f5/\u0001\u0000"+
		"\u0000\u0000\u00f6\u00fa\u0005%\u0000\u0000\u00f7\u00f9\u0003\u0002\u0001"+
		"\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fd\u0100\u0005&\u0000\u0000\u00fe\u0100\u0003\u0002\u0001\u0000"+
		"\u00ff\u00f6\u0001\u0000\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000"+
		"\u01001\u0001\u0000\u0000\u0000\u001b36;CGJNRW[bpsz\u0081\u0084\u0087"+
		"\u0090\u00a4\u00bc\u00be\u00cf\u00e2\u00e6\u00ed\u00fa\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}