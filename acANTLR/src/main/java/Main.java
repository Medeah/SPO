import com.sun.org.apache.bcel.internal.classfile.Code;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        /*String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);*/

        String test = "fb ia a = 5 b = a + 3.2 pb";
        ANTLRInputStream input = new ANTLRInputStream(test);
        AcLexer lexer = new AcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AcParser parser = new AcParser(tokens);
        ParseTree tree = parser.prog(); // parse

        Map<String, Type> symbolTable = new HashMap<String, Type>();
        SymbolVisitor sym = new SymbolVisitor(symbolTable);
        sym.visit(tree);

        TypeVisitor typ = new TypeVisitor(symbolTable);
        typ.visit(tree);

        CodeVisitor cod = new CodeVisitor();
        cod.visit(tree);

        System.out.println("done");
    }

    public static void error(String mes) {
        System.out.println(mes);
        System.exit(-1);
    }
}