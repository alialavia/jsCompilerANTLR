import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by ali on 12/3/15.
 */
public class JSListener implements ECMAScriptListener {
    @Override
    public void enterProgram(ECMAScriptParser.ProgramContext programContext) {
        System.out.printf("Entered program");
    }

    @Override
    public void exitProgram(ECMAScriptParser.ProgramContext programContext) {

    }

    @Override
    public void enterSourceElements(ECMAScriptParser.SourceElementsContext sourceElementsContext) {

    }

    @Override
    public void exitSourceElements(ECMAScriptParser.SourceElementsContext sourceElementsContext) {

    }

    @Override
    public void enterSourceElement(ECMAScriptParser.SourceElementContext sourceElementContext) {

    }

    @Override
    public void exitSourceElement(ECMAScriptParser.SourceElementContext sourceElementContext) {

    }

    @Override
    public void enterStatement(ECMAScriptParser.StatementContext statementContext) {

    }

    @Override
    public void exitStatement(ECMAScriptParser.StatementContext statementContext) {

    }

    @Override
    public void enterBlock(ECMAScriptParser.BlockContext blockContext) {

    }

    @Override
    public void exitBlock(ECMAScriptParser.BlockContext blockContext) {

    }

    @Override
    public void enterStatementList(ECMAScriptParser.StatementListContext statementListContext) {

    }

    @Override
    public void exitStatementList(ECMAScriptParser.StatementListContext statementListContext) {

    }

    @Override
    public void enterVariableStatement(ECMAScriptParser.VariableStatementContext variableStatementContext) {

    }

    @Override
    public void exitVariableStatement(ECMAScriptParser.VariableStatementContext variableStatementContext) {

    }

    @Override
    public void enterVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext variableDeclarationListContext) {

    }

    @Override
    public void exitVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext variableDeclarationListContext) {

    }

    @Override
    public void enterVariableDeclaration(ECMAScriptParser.VariableDeclarationContext variableDeclarationContext) {

    }

    @Override
    public void exitVariableDeclaration(ECMAScriptParser.VariableDeclarationContext variableDeclarationContext) {

    }

    @Override
    public void enterInitialiser(ECMAScriptParser.InitialiserContext initialiserContext) {

    }

    @Override
    public void exitInitialiser(ECMAScriptParser.InitialiserContext initialiserContext) {

    }

    @Override
    public void enterEmptyStatement(ECMAScriptParser.EmptyStatementContext emptyStatementContext) {

    }

    @Override
    public void exitEmptyStatement(ECMAScriptParser.EmptyStatementContext emptyStatementContext) {

    }

    @Override
    public void enterExpressionStatement(ECMAScriptParser.ExpressionStatementContext expressionStatementContext) {

    }

    @Override
    public void exitExpressionStatement(ECMAScriptParser.ExpressionStatementContext expressionStatementContext) {

    }

    @Override
    public void enterIfStatement(ECMAScriptParser.IfStatementContext ifStatementContext) {

    }

    @Override
    public void exitIfStatement(ECMAScriptParser.IfStatementContext ifStatementContext) {

    }

    @Override
    public void enterDoStatement(ECMAScriptParser.DoStatementContext doStatementContext) {

    }

    @Override
    public void exitDoStatement(ECMAScriptParser.DoStatementContext doStatementContext) {

    }

    @Override
    public void enterWhileStatement(ECMAScriptParser.WhileStatementContext whileStatementContext) {

    }

    @Override
    public void exitWhileStatement(ECMAScriptParser.WhileStatementContext whileStatementContext) {

    }

    @Override
    public void enterForStatement(ECMAScriptParser.ForStatementContext forStatementContext) {

    }

    @Override
    public void exitForStatement(ECMAScriptParser.ForStatementContext forStatementContext) {

    }

    @Override
    public void enterForVarStatement(ECMAScriptParser.ForVarStatementContext forVarStatementContext) {

    }

    @Override
    public void exitForVarStatement(ECMAScriptParser.ForVarStatementContext forVarStatementContext) {

    }

    @Override
    public void enterForInStatement(ECMAScriptParser.ForInStatementContext forInStatementContext) {

    }

    @Override
    public void exitForInStatement(ECMAScriptParser.ForInStatementContext forInStatementContext) {

    }

    @Override
    public void enterForVarInStatement(ECMAScriptParser.ForVarInStatementContext forVarInStatementContext) {

    }

    @Override
    public void exitForVarInStatement(ECMAScriptParser.ForVarInStatementContext forVarInStatementContext) {

    }

    @Override
    public void enterContinueStatement(ECMAScriptParser.ContinueStatementContext continueStatementContext) {

    }

    @Override
    public void exitContinueStatement(ECMAScriptParser.ContinueStatementContext continueStatementContext) {

    }

    @Override
    public void enterBreakStatement(ECMAScriptParser.BreakStatementContext breakStatementContext) {

    }

    @Override
    public void exitBreakStatement(ECMAScriptParser.BreakStatementContext breakStatementContext) {

    }

    @Override
    public void enterReturnStatement(ECMAScriptParser.ReturnStatementContext returnStatementContext) {

    }

    @Override
    public void exitReturnStatement(ECMAScriptParser.ReturnStatementContext returnStatementContext) {

    }

    @Override
    public void enterWithStatement(ECMAScriptParser.WithStatementContext withStatementContext) {

    }

    @Override
    public void exitWithStatement(ECMAScriptParser.WithStatementContext withStatementContext) {

    }

    @Override
    public void enterSwitchStatement(ECMAScriptParser.SwitchStatementContext switchStatementContext) {

    }

    @Override
    public void exitSwitchStatement(ECMAScriptParser.SwitchStatementContext switchStatementContext) {

    }

    @Override
    public void enterCaseBlock(ECMAScriptParser.CaseBlockContext caseBlockContext) {

    }

    @Override
    public void exitCaseBlock(ECMAScriptParser.CaseBlockContext caseBlockContext) {

    }

    @Override
    public void enterCaseClauses(ECMAScriptParser.CaseClausesContext caseClausesContext) {

    }

    @Override
    public void exitCaseClauses(ECMAScriptParser.CaseClausesContext caseClausesContext) {

    }

    @Override
    public void enterCaseClause(ECMAScriptParser.CaseClauseContext caseClauseContext) {

    }

    @Override
    public void exitCaseClause(ECMAScriptParser.CaseClauseContext caseClauseContext) {

    }

    @Override
    public void enterDefaultClause(ECMAScriptParser.DefaultClauseContext defaultClauseContext) {

    }

    @Override
    public void exitDefaultClause(ECMAScriptParser.DefaultClauseContext defaultClauseContext) {

    }

    @Override
    public void enterLabelledStatement(ECMAScriptParser.LabelledStatementContext labelledStatementContext) {

    }

    @Override
    public void exitLabelledStatement(ECMAScriptParser.LabelledStatementContext labelledStatementContext) {

    }

    @Override
    public void enterThrowStatement(ECMAScriptParser.ThrowStatementContext throwStatementContext) {

    }

    @Override
    public void exitThrowStatement(ECMAScriptParser.ThrowStatementContext throwStatementContext) {

    }

    @Override
    public void enterTryStatement(ECMAScriptParser.TryStatementContext tryStatementContext) {

    }

    @Override
    public void exitTryStatement(ECMAScriptParser.TryStatementContext tryStatementContext) {

    }

    @Override
    public void enterCatchProduction(ECMAScriptParser.CatchProductionContext catchProductionContext) {

    }

    @Override
    public void exitCatchProduction(ECMAScriptParser.CatchProductionContext catchProductionContext) {

    }

    @Override
    public void enterFinallyProduction(ECMAScriptParser.FinallyProductionContext finallyProductionContext) {

    }

    @Override
    public void exitFinallyProduction(ECMAScriptParser.FinallyProductionContext finallyProductionContext) {

    }

    @Override
    public void enterDebuggerStatement(ECMAScriptParser.DebuggerStatementContext debuggerStatementContext) {

    }

    @Override
    public void exitDebuggerStatement(ECMAScriptParser.DebuggerStatementContext debuggerStatementContext) {

    }

    @Override
    public void enterFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext functionDeclarationContext) {

    }

    @Override
    public void exitFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext functionDeclarationContext) {

    }

    @Override
    public void enterFormalParameterList(ECMAScriptParser.FormalParameterListContext formalParameterListContext) {

    }

    @Override
    public void exitFormalParameterList(ECMAScriptParser.FormalParameterListContext formalParameterListContext) {

    }

    @Override
    public void enterFunctionBody(ECMAScriptParser.FunctionBodyContext functionBodyContext) {

    }

    @Override
    public void exitFunctionBody(ECMAScriptParser.FunctionBodyContext functionBodyContext) {

    }

    @Override
    public void enterArrayLiteral(ECMAScriptParser.ArrayLiteralContext arrayLiteralContext) {

    }

    @Override
    public void exitArrayLiteral(ECMAScriptParser.ArrayLiteralContext arrayLiteralContext) {

    }

    @Override
    public void enterElementList(ECMAScriptParser.ElementListContext elementListContext) {

    }

    @Override
    public void exitElementList(ECMAScriptParser.ElementListContext elementListContext) {

    }

    @Override
    public void enterElision(ECMAScriptParser.ElisionContext elisionContext) {

    }

    @Override
    public void exitElision(ECMAScriptParser.ElisionContext elisionContext) {

    }

    @Override
    public void enterObjectLiteral(ECMAScriptParser.ObjectLiteralContext objectLiteralContext) {

    }

    @Override
    public void exitObjectLiteral(ECMAScriptParser.ObjectLiteralContext objectLiteralContext) {

    }

    @Override
    public void enterPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext propertyNameAndValueListContext) {

    }

    @Override
    public void exitPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext propertyNameAndValueListContext) {

    }

    @Override
    public void enterPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext propertyExpressionAssignmentContext) {

    }

    @Override
    public void exitPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext propertyExpressionAssignmentContext) {

    }

    @Override
    public void enterPropertyGetter(ECMAScriptParser.PropertyGetterContext propertyGetterContext) {

    }

    @Override
    public void exitPropertyGetter(ECMAScriptParser.PropertyGetterContext propertyGetterContext) {

    }

    @Override
    public void enterPropertySetter(ECMAScriptParser.PropertySetterContext propertySetterContext) {

    }

    @Override
    public void exitPropertySetter(ECMAScriptParser.PropertySetterContext propertySetterContext) {

    }

    @Override
    public void enterPropertyName(ECMAScriptParser.PropertyNameContext propertyNameContext) {

    }

    @Override
    public void exitPropertyName(ECMAScriptParser.PropertyNameContext propertyNameContext) {

    }

    @Override
    public void enterPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext propertySetParameterListContext) {

    }

    @Override
    public void exitPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext propertySetParameterListContext) {

    }

    @Override
    public void enterArguments(ECMAScriptParser.ArgumentsContext argumentsContext) {

    }

    @Override
    public void exitArguments(ECMAScriptParser.ArgumentsContext argumentsContext) {

    }

    @Override
    public void enterArgumentList(ECMAScriptParser.ArgumentListContext argumentListContext) {

    }

    @Override
    public void exitArgumentList(ECMAScriptParser.ArgumentListContext argumentListContext) {

    }

    @Override
    public void enterExpressionSequence(ECMAScriptParser.ExpressionSequenceContext expressionSequenceContext) {

    }

    @Override
    public void exitExpressionSequence(ECMAScriptParser.ExpressionSequenceContext expressionSequenceContext) {

    }

    @Override
    public void enterTernaryExpression(ECMAScriptParser.TernaryExpressionContext ternaryExpressionContext) {

    }

    @Override
    public void exitTernaryExpression(ECMAScriptParser.TernaryExpressionContext ternaryExpressionContext) {

    }

    @Override
    public void enterBitOrExpression(ECMAScriptParser.BitOrExpressionContext bitOrExpressionContext) {

    }

    @Override
    public void exitBitOrExpression(ECMAScriptParser.BitOrExpressionContext bitOrExpressionContext) {

    }

    @Override
    public void enterAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext assignmentExpressionContext) {

    }

    @Override
    public void exitAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext assignmentExpressionContext) {

    }

    @Override
    public void enterLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext logicalAndExpressionContext) {

    }

    @Override
    public void exitLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext logicalAndExpressionContext) {

    }

    @Override
    public void enterInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext instanceofExpressionContext) {

    }

    @Override
    public void exitInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext instanceofExpressionContext) {

    }

    @Override
    public void enterObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext objectLiteralExpressionContext) {

    }

    @Override
    public void exitObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext objectLiteralExpressionContext) {

    }

    @Override
    public void enterPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext preDecreaseExpressionContext) {

    }

    @Override
    public void exitPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext preDecreaseExpressionContext) {

    }

    @Override
    public void enterArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext arrayLiteralExpressionContext) {

    }

    @Override
    public void exitArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext arrayLiteralExpressionContext) {

    }

    @Override
    public void enterInExpression(ECMAScriptParser.InExpressionContext inExpressionContext) {

    }

    @Override
    public void exitInExpression(ECMAScriptParser.InExpressionContext inExpressionContext) {

    }

    @Override
    public void enterArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext argumentsExpressionContext) {

    }

    @Override
    public void exitArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext argumentsExpressionContext) {

    }

    @Override
    public void enterMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext memberDotExpressionContext) {

    }

    @Override
    public void exitMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext memberDotExpressionContext) {

    }

    @Override
    public void enterNotExpression(ECMAScriptParser.NotExpressionContext notExpressionContext) {

    }

    @Override
    public void exitNotExpression(ECMAScriptParser.NotExpressionContext notExpressionContext) {

    }

    @Override
    public void enterDeleteExpression(ECMAScriptParser.DeleteExpressionContext deleteExpressionContext) {

    }

    @Override
    public void exitDeleteExpression(ECMAScriptParser.DeleteExpressionContext deleteExpressionContext) {

    }

    @Override
    public void enterIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext identifierExpressionContext) {

    }

    @Override
    public void exitIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext identifierExpressionContext) {

    }

    @Override
    public void enterBitAndExpression(ECMAScriptParser.BitAndExpressionContext bitAndExpressionContext) {

    }

    @Override
    public void exitBitAndExpression(ECMAScriptParser.BitAndExpressionContext bitAndExpressionContext) {

    }

    @Override
    public void enterUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext unaryMinusExpressionContext) {

    }

    @Override
    public void exitUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext unaryMinusExpressionContext) {

    }

    @Override
    public void enterPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext preIncrementExpressionContext) {

    }

    @Override
    public void exitPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext preIncrementExpressionContext) {

    }

    @Override
    public void enterFunctionExpression(ECMAScriptParser.FunctionExpressionContext functionExpressionContext) {

    }

    @Override
    public void exitFunctionExpression(ECMAScriptParser.FunctionExpressionContext functionExpressionContext) {

    }

    @Override
    public void enterBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext bitShiftExpressionContext) {

    }

    @Override
    public void exitBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext bitShiftExpressionContext) {

    }

    @Override
    public void enterLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext logicalOrExpressionContext) {

    }

    @Override
    public void exitLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext logicalOrExpressionContext) {

    }

    @Override
    public void enterVoidExpression(ECMAScriptParser.VoidExpressionContext voidExpressionContext) {

    }

    @Override
    public void exitVoidExpression(ECMAScriptParser.VoidExpressionContext voidExpressionContext) {

    }

    @Override
    public void enterParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext parenthesizedExpressionContext) {

    }

    @Override
    public void exitParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext parenthesizedExpressionContext) {

    }

    @Override
    public void enterUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext unaryPlusExpressionContext) {

    }

    @Override
    public void exitUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext unaryPlusExpressionContext) {

    }

    @Override
    public void enterLiteralExpression(ECMAScriptParser.LiteralExpressionContext literalExpressionContext) {

    }

    @Override
    public void exitLiteralExpression(ECMAScriptParser.LiteralExpressionContext literalExpressionContext) {

    }

    @Override
    public void enterBitNotExpression(ECMAScriptParser.BitNotExpressionContext bitNotExpressionContext) {

    }

    @Override
    public void exitBitNotExpression(ECMAScriptParser.BitNotExpressionContext bitNotExpressionContext) {

    }

    @Override
    public void enterPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext postIncrementExpressionContext) {

    }

    @Override
    public void exitPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext postIncrementExpressionContext) {

    }

    @Override
    public void enterTypeofExpression(ECMAScriptParser.TypeofExpressionContext typeofExpressionContext) {

    }

    @Override
    public void exitTypeofExpression(ECMAScriptParser.TypeofExpressionContext typeofExpressionContext) {

    }

    @Override
    public void enterAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext assignmentOperatorExpressionContext) {

    }

    @Override
    public void exitAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext assignmentOperatorExpressionContext) {

    }

    @Override
    public void enterNewExpression(ECMAScriptParser.NewExpressionContext newExpressionContext) {

    }

    @Override
    public void exitNewExpression(ECMAScriptParser.NewExpressionContext newExpressionContext) {

    }

    @Override
    public void enterPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext postDecreaseExpressionContext) {

    }

    @Override
    public void exitPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext postDecreaseExpressionContext) {

    }

    @Override
    public void enterRelationalExpression(ECMAScriptParser.RelationalExpressionContext relationalExpressionContext) {

    }

    @Override
    public void exitRelationalExpression(ECMAScriptParser.RelationalExpressionContext relationalExpressionContext) {

    }

    @Override
    public void enterEqualityExpression(ECMAScriptParser.EqualityExpressionContext equalityExpressionContext) {

    }

    @Override
    public void exitEqualityExpression(ECMAScriptParser.EqualityExpressionContext equalityExpressionContext) {

    }

    @Override
    public void enterBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext bitXOrExpressionContext) {

    }

    @Override
    public void exitBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext bitXOrExpressionContext) {

    }

    @Override
    public void enterAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext additiveExpressionContext) {

    }

    @Override
    public void exitAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext additiveExpressionContext) {

    }

    @Override
    public void enterMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext memberIndexExpressionContext) {

    }

    @Override
    public void exitMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext memberIndexExpressionContext) {

    }

    @Override
    public void enterThisExpression(ECMAScriptParser.ThisExpressionContext thisExpressionContext) {

    }

    @Override
    public void exitThisExpression(ECMAScriptParser.ThisExpressionContext thisExpressionContext) {

    }

    @Override
    public void enterMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext multiplicativeExpressionContext) {

    }

    @Override
    public void exitMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext multiplicativeExpressionContext) {

    }

    @Override
    public void enterAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext assignmentOperatorContext) {

    }

    @Override
    public void exitAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext assignmentOperatorContext) {

    }

    @Override
    public void enterLiteral(ECMAScriptParser.LiteralContext literalContext) {

    }

    @Override
    public void exitLiteral(ECMAScriptParser.LiteralContext literalContext) {

    }

    @Override
    public void enterNumericLiteral(ECMAScriptParser.NumericLiteralContext numericLiteralContext) {

    }

    @Override
    public void exitNumericLiteral(ECMAScriptParser.NumericLiteralContext numericLiteralContext) {

    }

    @Override
    public void enterIdentifierName(ECMAScriptParser.IdentifierNameContext identifierNameContext) {

    }

    @Override
    public void exitIdentifierName(ECMAScriptParser.IdentifierNameContext identifierNameContext) {

    }

    @Override
    public void enterReservedWord(ECMAScriptParser.ReservedWordContext reservedWordContext) {

    }

    @Override
    public void exitReservedWord(ECMAScriptParser.ReservedWordContext reservedWordContext) {

    }

    @Override
    public void enterKeyword(ECMAScriptParser.KeywordContext keywordContext) {

    }

    @Override
    public void exitKeyword(ECMAScriptParser.KeywordContext keywordContext) {

    }

    @Override
    public void enterFutureReservedWord(ECMAScriptParser.FutureReservedWordContext futureReservedWordContext) {

    }

    @Override
    public void exitFutureReservedWord(ECMAScriptParser.FutureReservedWordContext futureReservedWordContext) {

    }

    @Override
    public void enterGetter(ECMAScriptParser.GetterContext getterContext) {

    }

    @Override
    public void exitGetter(ECMAScriptParser.GetterContext getterContext) {

    }

    @Override
    public void enterSetter(ECMAScriptParser.SetterContext setterContext) {

    }

    @Override
    public void exitSetter(ECMAScriptParser.SetterContext setterContext) {

    }

    @Override
    public void enterEos(ECMAScriptParser.EosContext eosContext) {

    }

    @Override
    public void exitEos(ECMAScriptParser.EosContext eosContext) {

    }

    @Override
    public void enterEof(ECMAScriptParser.EofContext eofContext) {

    }

    @Override
    public void exitEof(ECMAScriptParser.EofContext eofContext) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
