import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

/**
 * Created by ali on 12/3/15.
 */
public class JSCompiler {
    private class Avt extends AbstractParseTreeVisitor {

    }
    public static void main(String[] args) throws IOException {


        ANTLRInputStream inputStream = new ANTLRFileStream(args[0]);
        ECMAScriptLexer lexer = new ECMAScriptLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ECMAScriptParser parser = new ECMAScriptParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();

        ECMAScriptParser.ProgramContext programContext = parser.program();
        JSVisitor visitor = new JSVisitor();

        tree.accept(visitor);

    }
}
