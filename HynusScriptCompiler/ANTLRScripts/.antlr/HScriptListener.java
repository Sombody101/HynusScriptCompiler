// Generated from f:/HynusScriptCompiler/HynusScriptCompiler/ANTLRScripts/HScript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HScriptParser}.
 */
public interface HScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(HScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(HScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(HScriptParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(HScriptParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(HScriptParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(HScriptParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(HScriptParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(HScriptParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(HScriptParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(HScriptParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(HScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(HScriptParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(HScriptParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(HScriptParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(HScriptParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(HScriptParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#tryCatch}.
	 * @param ctx the parse tree
	 */
	void enterTryCatch(HScriptParser.TryCatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#tryCatch}.
	 * @param ctx the parse tree
	 */
	void exitTryCatch(HScriptParser.TryCatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#exceptionInfo}.
	 * @param ctx the parse tree
	 */
	void enterExceptionInfo(HScriptParser.ExceptionInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#exceptionInfo}.
	 * @param ctx the parse tree
	 */
	void exitExceptionInfo(HScriptParser.ExceptionInfoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parethesizedExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParethesizedExpression(HScriptParser.ParethesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parethesizedExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParethesizedExpression(HScriptParser.ParethesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code interpolatedStringExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInterpolatedStringExpression(HScriptParser.InterpolatedStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code interpolatedStringExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInterpolatedStringExpression(HScriptParser.InterpolatedStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(HScriptParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(HScriptParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(HScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(HScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(HScriptParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(HScriptParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(HScriptParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(HScriptParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(HScriptParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(HScriptParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(HScriptParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(HScriptParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(HScriptParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(HScriptParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(HScriptParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(HScriptParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(HScriptParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link HScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(HScriptParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#nestedVariable}.
	 * @param ctx the parse tree
	 */
	void enterNestedVariable(HScriptParser.NestedVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#nestedVariable}.
	 * @param ctx the parse tree
	 */
	void exitNestedVariable(HScriptParser.NestedVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#interpolatedString}.
	 * @param ctx the parse tree
	 */
	void enterInterpolatedString(HScriptParser.InterpolatedStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#interpolatedString}.
	 * @param ctx the parse tree
	 */
	void exitInterpolatedString(HScriptParser.InterpolatedStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(HScriptParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(HScriptParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#doubleStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoubleStatement(HScriptParser.DoubleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#doubleStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoubleStatement(HScriptParser.DoubleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#doubleOp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleOp(HScriptParser.DoubleOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#doubleOp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleOp(HScriptParser.DoubleOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(HScriptParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(HScriptParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(HScriptParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(HScriptParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#comareOp}.
	 * @param ctx the parse tree
	 */
	void enterComareOp(HScriptParser.ComareOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#comareOp}.
	 * @param ctx the parse tree
	 */
	void exitComareOp(HScriptParser.ComareOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(HScriptParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(HScriptParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(HScriptParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(HScriptParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#scriptVersion}.
	 * @param ctx the parse tree
	 */
	void enterScriptVersion(HScriptParser.ScriptVersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#scriptVersion}.
	 * @param ctx the parse tree
	 */
	void exitScriptVersion(HScriptParser.ScriptVersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#changeStyle}.
	 * @param ctx the parse tree
	 */
	void enterChangeStyle(HScriptParser.ChangeStyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#changeStyle}.
	 * @param ctx the parse tree
	 */
	void exitChangeStyle(HScriptParser.ChangeStyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HScriptParser.BlockContext ctx);
}