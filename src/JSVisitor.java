import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by ali on 12/3/15.
 */
public class JSVisitor implements ECMAScriptVisitor<Object> {

    TreeMap<String, Object> ValueLookupTable = new TreeMap<String, Object>() ;
    /* Handle variable initialisation and adding it to lookup table */
    public void addVariableToLookupTable(TerminalNode varKeyword, TerminalNode identifier, ECMAScriptParser.InitialiserContext initialiser) {
        Object initialisedVal = initialiser.accept(this);
        ValueLookupTable.put(identifier.getText(), initialisedVal);
    }

    /* program : sourceElements? EOF */
    @Override
    public Object visitProgram(ECMAScriptParser.ProgramContext programContext) {
        int len = programContext.sourceElements().getChildCount();
        System.out.printf("Program has %d children.\r\n", len);
        for (int i = 0; i < len; i++) {
            ParseTree child = programContext.sourceElements().getChild(i);
            System.out.printf(" Visiting: %s...\r\n", child.getClass().toString());
            child.accept(this);
        }
        return null;
    }

    /* sourceElements : sourceElement+ -> Handled in visitProgram */
    @Override
    public Object visitSourceElements(ECMAScriptParser.SourceElementsContext sourceElementsContext) {
        return null;
    }

    /* sourceElement : statement | functionDeclaration */
    @Override
    public Object visitSourceElement(ECMAScriptParser.SourceElementContext sourceElementContext) {
        if (sourceElementContext.functionDeclaration() != null)
            sourceElementContext.functionDeclaration().accept(this);
        else
            sourceElementContext.statement().accept(this);

        return null;
    }

    /*
     statement :
       block
     | variableStatement
     | emptyStatement
     | expressionStatement
     | ifStatement
     | iterationStatement
     | continueStatement
     | breakStatement
     | returnStatement
     | withStatement
     | labelledStatement
     | switchStatement
     | throwStatement
     | tryStatement
     | debuggerStatement
    * */
    @Override
    public Object visitStatement(ECMAScriptParser.StatementContext statementContext) {
        ParseTree child = statementContext.getChild(0);
        System.out.printf("  Visiting: %s...\r\n", child.getClass().toString());
        child.accept(this);
        return null;
    }

    /* block : '{' statementList? '}' */
    @Override
    public Object visitBlock(ECMAScriptParser.BlockContext blockContext) {
        blockContext.statementList().accept(this);
        return null;
    }

    @Override
    public Object visitStatementList(ECMAScriptParser.StatementListContext statementListContext) {
        int len = statementListContext.getChildCount();
        for (int i = 0; i < len; i++)
            statementListContext.getChild(i).accept(this);
        return null;
    }

    /* variableStatement : Var variableDeclarationList eos */
    @Override
    public Object visitVariableStatement(ECMAScriptParser.VariableStatementContext variableStatementContext) {
        variableStatementContext.getChild(1).accept(this);
        return null;
    }

    /* variableDeclarationList : variableDeclaration ( ',' variableDeclaration )* */
    @Override
    public Object visitVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext variableDeclarationListContext) {
        for (int i = 0; i< variableDeclarationListContext.getChildCount(); i++)
            variableDeclarationListContext.getChild(i).accept(this);
        return null;
    }

    /* variableDeclaration : Identifier initialiser? */
    @Override
    public Object visitVariableDeclaration(ECMAScriptParser.VariableDeclarationContext variableDeclarationContext) {
        /* We might later need some information about 'var' (Maybe be want to use 'int' or 'byte' instead of var later
           on) so we need this content */
        ECMAScriptParser.VariableStatementContext variableStatementContext =
                (ECMAScriptParser.VariableStatementContext)variableDeclarationContext.getParent().getParent();


        addVariableToLookupTable(variableStatementContext.Var(),
                                 variableDeclarationContext.Identifier(),
                                 variableDeclarationContext.initialiser());
        return null;
    }

    /* initialiser : '=' singleExpression */
    @Override
    public Object visitInitialiser(ECMAScriptParser.InitialiserContext initialiserContext) {
        initialiserContext.singleExpression().accept(this);
        return null;
    }

    /*  emptyStatement : SemiColon */
    @Override
    public Object visitEmptyStatement(ECMAScriptParser.EmptyStatementContext emptyStatementContext) {
        return null;
    }


    /* expressionStatement : {(_input.LA(1) != OpenBrace) && (_input.LA(1) != Function)}? expressionSequence eos */
    @Override
    public Object visitExpressionStatement(ECMAScriptParser.ExpressionStatementContext expressionStatementContext) {
        expressionStatementContext.expressionSequence().accept(this);
        return null;
    }

    /* IfStatement :   if ( Expression ) Statement else Statement
                       if ( Expression ) Statement */
    @Override
    public Object visitIfStatement(ECMAScriptParser.IfStatementContext ifStatementContext) {
        int i = ifStatementContext.getChildCount();
        if ((boolean)(ifStatementContext.expressionSequence().accept(this)) == true)
            ifStatementContext.statement(0).accept(this);
        else
            if (ifStatementContext.Else() != null)
                ifStatementContext.statement(1).accept(this);
        return null;
    }

    /* Do statement While '(' expressionSequence ')' eos */
    @Override
    public Object visitDoStatement(ECMAScriptParser.DoStatementContext doStatementContext) {
        do
        {
            doStatementContext.statement().accept(this);
        } while ((boolean)doStatementContext.expressionSequence().accept(this));

        return null;
    }

    /* While '(' expressionSequence ')' statement */
    @Override
    public Object visitWhileStatement(ECMAScriptParser.WhileStatementContext whileStatementContext) {
        while ((boolean)whileStatementContext.expressionSequence().accept(this))
            whileStatementContext.statement();
        return null;
    }

    /* For '(' expressionSequence? ';' expressionSequence? ';' expressionSequence? ')' statement */
    @Override
    public Object visitForStatement(ECMAScriptParser.ForStatementContext forStatementContext) {

        if (forStatementContext.expressionSequence(0) != null)
            forStatementContext.expressionSequence(0).accept(this);

        while (forStatementContext.expressionSequence(1) == null
                || (boolean)forStatementContext.expressionSequence(1).accept(this)) {

            forStatementContext.statement().accept(this);
            forStatementContext.expressionSequence(2).accept(this); //For update statement
        }
        return null;
    }

    /* For '(' Var variableDeclarationList ';' expressionSequence? ';' expressionSequence? ')' statement */
    @Override
    public Object visitForVarStatement(ECMAScriptParser.ForVarStatementContext forVarStatementContext) {

        forVarStatementContext.variableDeclarationList().accept(this);

        if (forVarStatementContext.expressionSequence(0) != null)
            forVarStatementContext.expressionSequence(0).accept(this);

        while (forVarStatementContext.expressionSequence(0) == null
                || (boolean)forVarStatementContext.expressionSequence(0).accept(this)) {

            forVarStatementContext.statement().accept(this);
            forVarStatementContext.expressionSequence(1).accept(this); //For update statement
        }

        return null;
    }

    // TODO: Check forInStatementContext.singleExpression() is leftHandSide expression
    private void assign(Object lval, Object e) {
    }

    /* For '(' singleExpression In expressionSequence ')' statement */
    @Override
    public Object visitForInStatement(ECMAScriptParser.ForInStatementContext forInStatementContext) {
        for (Object e : (Collection) forInStatementContext.expressionSequence().accept(this)) {
            assign (forInStatementContext.singleExpression().accept(this), e);
            forInStatementContext.statement();
        }
        return null;
    }

    /* For '(' Var variableDeclaration In expressionSequence ')' statement */
    @Override
    public Object visitForVarInStatement(ECMAScriptParser.ForVarInStatementContext forVarInStatementContext) {
        for (Object e : (Collection) forVarInStatementContext.expressionSequence().accept(this)) {
            assign (forVarInStatementContext.variableDeclaration().accept(this), e);
            forVarInStatementContext.statement();
        }
        return null;
    }
//TODO: Implement here
    @Override
    public Object visitContinueStatement(ECMAScriptParser.ContinueStatementContext continueStatementContext) {

        return null;
    }

    @Override
    public Object visitBreakStatement(ECMAScriptParser.BreakStatementContext breakStatementContext) {
        return null;
    }

    @Override
    public Object visitReturnStatement(ECMAScriptParser.ReturnStatementContext returnStatementContext) {
        return null;
    }

    @Override
    public Object visitWithStatement(ECMAScriptParser.WithStatementContext withStatementContext) {
        return null;
    }

    @Override
    public Object visitSwitchStatement(ECMAScriptParser.SwitchStatementContext switchStatementContext) {
        return null;
    }

    @Override
    public Object visitCaseBlock(ECMAScriptParser.CaseBlockContext caseBlockContext) {
        return null;
    }

    @Override
    public Object visitCaseClauses(ECMAScriptParser.CaseClausesContext caseClausesContext) {
        return null;
    }

    @Override
    public Object visitCaseClause(ECMAScriptParser.CaseClauseContext caseClauseContext) {
        return null;
    }

    @Override
    public Object visitDefaultClause(ECMAScriptParser.DefaultClauseContext defaultClauseContext) {
        return null;
    }

    @Override
    public Object visitLabelledStatement(ECMAScriptParser.LabelledStatementContext labelledStatementContext) {
        return null;
    }

    @Override
    public Object visitThrowStatement(ECMAScriptParser.ThrowStatementContext throwStatementContext) {
        return null;
    }

    @Override
    public Object visitTryStatement(ECMAScriptParser.TryStatementContext tryStatementContext) {
        return null;
    }

    @Override
    public Object visitCatchProduction(ECMAScriptParser.CatchProductionContext catchProductionContext) {
        return null;
    }

    @Override
    public Object visitFinallyProduction(ECMAScriptParser.FinallyProductionContext finallyProductionContext) {
        return null;
    }

    @Override
    public Object visitDebuggerStatement(ECMAScriptParser.DebuggerStatementContext debuggerStatementContext) {
        return null;
    }

    @Override
    public Object visitFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext functionDeclarationContext) {
        System.out.printf("  Function visited! %s\r\n", functionDeclarationContext.toString());
        return null;
    }

    @Override
    public Object visitFormalParameterList(ECMAScriptParser.FormalParameterListContext formalParameterListContext) {
        return null;
    }

    @Override
    public Object visitFunctionBody(ECMAScriptParser.FunctionBodyContext functionBodyContext) {
        return null;
    }

    @Override
    public Object visitArrayLiteral(ECMAScriptParser.ArrayLiteralContext arrayLiteralContext) {
        return null;
    }

    @Override
    public Object visitElementList(ECMAScriptParser.ElementListContext elementListContext) {
        return null;
    }

    @Override
    public Object visitElision(ECMAScriptParser.ElisionContext elisionContext) {
        return null;
    }

    @Override
    public Object visitObjectLiteral(ECMAScriptParser.ObjectLiteralContext objectLiteralContext) {
        return null;
    }

    @Override
    public Object visitPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext propertyNameAndValueListContext) {
        return null;
    }

    @Override
    public Object visitPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext propertyExpressionAssignmentContext) {
        return null;
    }

    @Override
    public Object visitPropertyGetter(ECMAScriptParser.PropertyGetterContext propertyGetterContext) {
        return null;
    }

    @Override
    public Object visitPropertySetter(ECMAScriptParser.PropertySetterContext propertySetterContext) {
        return null;
    }

    @Override
    public Object visitPropertyName(ECMAScriptParser.PropertyNameContext propertyNameContext) {
        return null;
    }

    @Override
    public Object visitPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext propertySetParameterListContext) {
        return null;
    }

    @Override
    public Object visitArguments(ECMAScriptParser.ArgumentsContext argumentsContext) {
        return null;
    }

    @Override
    public Object visitArgumentList(ECMAScriptParser.ArgumentListContext argumentListContext) {
        return null;
    }

    @Override
    public Object visitExpressionSequence(ECMAScriptParser.ExpressionSequenceContext expressionSequenceContext) {
        return null;
    }

    @Override
    public Object visitTernaryExpression(ECMAScriptParser.TernaryExpressionContext ternaryExpressionContext) {
        return null;
    }

    @Override
    public Object visitBitOrExpression(ECMAScriptParser.BitOrExpressionContext bitOrExpressionContext) {
        return null;
    }

    @Override
    public Object visitAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext assignmentExpressionContext) {
        return null;
    }

    @Override
    public Object visitLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext logicalAndExpressionContext) {
        return null;
    }

    @Override
    public Object visitInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext instanceofExpressionContext) {
        return null;
    }

    @Override
    public Object visitObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext objectLiteralExpressionContext) {
        return null;
    }

    @Override
    public Object visitPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext preDecreaseExpressionContext) {
        return null;
    }

    @Override
    public Object visitArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext arrayLiteralExpressionContext) {
        return null;
    }

    @Override
    public Object visitInExpression(ECMAScriptParser.InExpressionContext inExpressionContext) {
        return null;
    }

    @Override
    public Object visitArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext argumentsExpressionContext) {
        return null;
    }

    @Override
    public Object visitMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext memberDotExpressionContext) {
        return null;
    }

    @Override
    public Object visitNotExpression(ECMAScriptParser.NotExpressionContext notExpressionContext) {
        return null;
    }

    @Override
    public Object visitDeleteExpression(ECMAScriptParser.DeleteExpressionContext deleteExpressionContext) {
        return null;
    }

    @Override
    public Object visitIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext identifierExpressionContext) {
        return null;
    }

    @Override
    public Object visitBitAndExpression(ECMAScriptParser.BitAndExpressionContext bitAndExpressionContext) {
        return null;
    }

    @Override
    public Object visitUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext unaryMinusExpressionContext) {
        return null;
    }

    @Override
    public Object visitPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext preIncrementExpressionContext) {
        return null;
    }

    @Override
    public Object visitFunctionExpression(ECMAScriptParser.FunctionExpressionContext functionExpressionContext) {
        return null;
    }

    @Override
    public Object visitBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext bitShiftExpressionContext) {
        return null;
    }

    @Override
    public Object visitLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext logicalOrExpressionContext) {
        return null;
    }

    @Override
    public Object visitVoidExpression(ECMAScriptParser.VoidExpressionContext voidExpressionContext) {
        return null;
    }

    @Override
    public Object visitParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext parenthesizedExpressionContext) {
        return null;
    }

    @Override
    public Object visitUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext unaryPlusExpressionContext) {
        return null;
    }

    @Override
    public Object visitLiteralExpression(ECMAScriptParser.LiteralExpressionContext literalExpressionContext) {
        return null;
    }

    @Override
    public Object visitBitNotExpression(ECMAScriptParser.BitNotExpressionContext bitNotExpressionContext) {
        return null;
    }

    @Override
    public Object visitPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext postIncrementExpressionContext) {
        return null;
    }

    @Override
    public Object visitTypeofExpression(ECMAScriptParser.TypeofExpressionContext typeofExpressionContext) {
        return null;
    }

    @Override
    public Object visitAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext assignmentOperatorExpressionContext) {
        return null;
    }

    @Override
    public Object visitNewExpression(ECMAScriptParser.NewExpressionContext newExpressionContext) {
        return null;
    }

    @Override
    public Object visitPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext postDecreaseExpressionContext) {
        return null;
    }

    @Override
    public Object visitRelationalExpression(ECMAScriptParser.RelationalExpressionContext relationalExpressionContext) {
        return null;
    }

    @Override
    public Object visitEqualityExpression(ECMAScriptParser.EqualityExpressionContext equalityExpressionContext) {
        return null;
    }

    @Override
    public Object visitBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext bitXOrExpressionContext) {
        return null;
    }

    @Override
    public Object visitAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext additiveExpressionContext) {
        return null;
    }

    @Override
    public Object visitMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext memberIndexExpressionContext) {
        return null;
    }

    @Override
    public Object visitThisExpression(ECMAScriptParser.ThisExpressionContext thisExpressionContext) {
        return null;
    }

    @Override
    public Object visitMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext multiplicativeExpressionContext) {
        return null;
    }

    @Override
    public Object visitAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext assignmentOperatorContext) {
        return null;
    }

    @Override
    public Object visitLiteral(ECMAScriptParser.LiteralContext literalContext) {
        return null;
    }

    @Override
    public Object visitNumericLiteral(ECMAScriptParser.NumericLiteralContext numericLiteralContext) {
        return null;
    }

    @Override
    public Object visitIdentifierName(ECMAScriptParser.IdentifierNameContext identifierNameContext) {
        return null;
    }

    @Override
    public Object visitReservedWord(ECMAScriptParser.ReservedWordContext reservedWordContext) {
        return null;
    }

    @Override
    public Object visitKeyword(ECMAScriptParser.KeywordContext keywordContext) {
        return null;
    }

    @Override
    public Object visitFutureReservedWord(ECMAScriptParser.FutureReservedWordContext futureReservedWordContext) {
        return null;
    }

    @Override
    public Object visitGetter(ECMAScriptParser.GetterContext getterContext) {
        return null;
    }

    @Override
    public Object visitSetter(ECMAScriptParser.SetterContext setterContext) {
        return null;
    }

    @Override
    public Object visitEos(ECMAScriptParser.EosContext eosContext) {
        return null;
    }

    @Override
    public Object visitEof(ECMAScriptParser.EofContext eofContext) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
