import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static AcParser parser;

    public static void main(String[] args) throws Exception {
        /*String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);*/

        String test = "fb ia a = 5 \nb = a + 3.2 \npb";
        ANTLRInputStream input = new ANTLRInputStream(test);
        AcLexer lexer = new AcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new AcParser(tokens);
        ParseTree tree = parser.prog();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(1);
        }

        Map<String, Type> symbolTable = new HashMap<String, Type>();
        SymbolVisitor sym = new SymbolVisitor(symbolTable);
        sym.visit(tree);

        TypeVisitor typ = new TypeVisitor(symbolTable);
        typ.visit(tree);

        CodeVisitor cod = new CodeVisitor();
        cod.visit(tree);
    }

    public static void error(String mes, ParserRuleContext ctx) {
        int line = ctx.getStart().getLine();
        int schar = ctx.getStart().getCharPositionInLine();
        System.err.println("error line " + line + ":" + schar + " " + mes);
        if (line == ctx.getStop().getLine()) {
            underlineError(ctx.getStart(), ctx.getStop(), line, schar);
        }

        System.exit(1);
    }

    public static void error(String mes, Token token) {
        int line = token.getLine();
        int schar = token.getCharPositionInLine();
        System.err.println(line + ":" + schar + ": error: " + mes);
        underlineError(token, token, line, schar);

        System.exit(1);
    }

    public static void error(String mes) {
        System.err.println(mes);

        System.exit(1);
    }

    private static void underlineError(Token startToken, Token endToken, int line, int charPositionInLine) {
        CommonTokenStream tokens = (CommonTokenStream) parser.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        System.err.println(errorLine);
        for (int i = 0; i < charPositionInLine; i++) System.err.print(" ");
        int start = startToken.getStartIndex();
        int stop = endToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i++) System.err.print("^");
        }
        System.err.println();
    }
}