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

using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="HScriptParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.1")]
[System.CLSCompliant(false)]
public interface IHScriptVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitProgram([NotNull] HScriptParser.ProgramContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.line"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLine([NotNull] HScriptParser.LineContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.assignment"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignment([NotNull] HScriptParser.AssignmentContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.ifBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIfBlock([NotNull] HScriptParser.IfBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.elseIfBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitElseIfBlock([NotNull] HScriptParser.ElseIfBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.elseBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitElseBlock([NotNull] HScriptParser.ElseBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.whileBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitWhileBlock([NotNull] HScriptParser.WhileBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.forBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForBlock([NotNull] HScriptParser.ForBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.foreachBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForeachBlock([NotNull] HScriptParser.ForeachBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.tryCatch"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTryCatch([NotNull] HScriptParser.TryCatchContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.exBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExBlock([NotNull] HScriptParser.ExBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.exceptionInfo"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExceptionInfo([NotNull] HScriptParser.ExceptionInfoContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.functionCall"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionCall([NotNull] HScriptParser.FunctionCallContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.functionClosure"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionClosure([NotNull] HScriptParser.FunctionClosureContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.functionDefinition"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionDefinition([NotNull] HScriptParser.FunctionDefinitionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.typeCastDefinition"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeCastDefinition([NotNull] HScriptParser.TypeCastDefinitionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.functionParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionParameter([NotNull] HScriptParser.FunctionParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.functionPresetParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionPresetParameter([NotNull] HScriptParser.FunctionPresetParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>constantExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConstantExpression([NotNull] HScriptParser.ConstantExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>additiveExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAdditiveExpression([NotNull] HScriptParser.AdditiveExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>conditionalExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConditionalExpression([NotNull] HScriptParser.ConditionalExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>identifierExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIdentifierExpression([NotNull] HScriptParser.IdentifierExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>comparisonExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitComparisonExpression([NotNull] HScriptParser.ComparisonExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>multiplicativeExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMultiplicativeExpression([NotNull] HScriptParser.MultiplicativeExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>booleanExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBooleanExpression([NotNull] HScriptParser.BooleanExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>dynamicCSharpCallExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDynamicCSharpCallExpression([NotNull] HScriptParser.DynamicCSharpCallExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>nestedVariableExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNestedVariableExpression([NotNull] HScriptParser.NestedVariableExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>hscriptCallExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitHscriptCallExpression([NotNull] HScriptParser.HscriptCallExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>arrayAccessExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArrayAccessExpression([NotNull] HScriptParser.ArrayAccessExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>parethesizedExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParethesizedExpression([NotNull] HScriptParser.ParethesizedExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>blockExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBlockExpression([NotNull] HScriptParser.BlockExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>functionCallExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionCallExpression([NotNull] HScriptParser.FunctionCallExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>assignOpExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignOpExpression([NotNull] HScriptParser.AssignOpExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>unaryExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitUnaryExpression([NotNull] HScriptParser.UnaryExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>doubleStatementExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDoubleStatementExpression([NotNull] HScriptParser.DoubleStatementExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>functionClosureExpression</c>
	/// labeled alternative in <see cref="HScriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionClosureExpression([NotNull] HScriptParser.FunctionClosureExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.addOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAddOp([NotNull] HScriptParser.AddOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.multOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMultOp([NotNull] HScriptParser.MultOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.unaryOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitUnaryOp([NotNull] HScriptParser.UnaryOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.doubleOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDoubleOp([NotNull] HScriptParser.DoubleOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.comareOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitComareOp([NotNull] HScriptParser.ComareOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.assignOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignOp([NotNull] HScriptParser.AssignOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.boolOp"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBoolOp([NotNull] HScriptParser.BoolOpContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.constant"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConstant([NotNull] HScriptParser.ConstantContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.verbatimString"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVerbatimString([NotNull] HScriptParser.VerbatimStringContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.scriptImport"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitScriptImport([NotNull] HScriptParser.ScriptImportContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.libBuiltIn"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLibBuiltIn([NotNull] HScriptParser.LibBuiltInContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>scriptVersionConfig</c>
	/// labeled alternative in <see cref="HScriptParser.scriptConfiguration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitScriptVersionConfig([NotNull] HScriptParser.ScriptVersionConfigContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>codeStyleCongfig</c>
	/// labeled alternative in <see cref="HScriptParser.scriptConfiguration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCodeStyleCongfig([NotNull] HScriptParser.CodeStyleCongfigContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>enableDebugConfig</c>
	/// labeled alternative in <see cref="HScriptParser.scriptConfiguration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEnableDebugConfig([NotNull] HScriptParser.EnableDebugConfigContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.scriptVersion"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitScriptVersion([NotNull] HScriptParser.ScriptVersionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.changeStyle"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitChangeStyle([NotNull] HScriptParser.ChangeStyleContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.enableDebug"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEnableDebug([NotNull] HScriptParser.EnableDebugContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.arrBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArrBlock([NotNull] HScriptParser.ArrBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.arrAccess"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArrAccess([NotNull] HScriptParser.ArrAccessContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBlock([NotNull] HScriptParser.BlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.lineBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLineBlock([NotNull] HScriptParser.LineBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.return"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturn([NotNull] HScriptParser.ReturnContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.opBlock"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitOpBlock([NotNull] HScriptParser.OpBlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.staticClass"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStaticClass([NotNull] HScriptParser.StaticClassContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.nestedVariable"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNestedVariable([NotNull] HScriptParser.NestedVariableContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.localIdentifier"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLocalIdentifier([NotNull] HScriptParser.LocalIdentifierContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.tempIdentifier"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTempIdentifier([NotNull] HScriptParser.TempIdentifierContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.specialHScript"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSpecialHScript([NotNull] HScriptParser.SpecialHScriptContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="HScriptParser.specialFunctionCall"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSpecialFunctionCall([NotNull] HScriptParser.SpecialFunctionCallContext context);
}
