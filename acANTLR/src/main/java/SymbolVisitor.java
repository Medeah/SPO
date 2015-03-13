import java.util.HashMap;
import java.util.Map;

public class SymbolVisitor extends AcBaseVisitor<Void> {

    public SymbolVisitor(Map<String, Type> symbolTable) {
        this.symbolTable = symbolTable;
    }

    private Map<String, Type> symbolTable;

    public Void visitDcl(AcParser.DclContext ctx) {
        Type t = Type.INT;
        String type = ctx.children.get(0).toString();
        if (type.compareTo("f") == 0) {
            t = Type.FLOAT;
        } else if (type.compareTo("i") == 0) {
            t = Type.INT;
        } else {
            Main.error("hmm");
        }
        String sym = ctx.Id().getSymbol().getText();
        if (symbolTable.containsKey(sym)) {
            Main.error("duplicate declaration");
        }
        symbolTable.put(sym, t);
        return null;
    }

    public Void visitSymref(AcParser.SymrefContext ctx) {
        if (!symbolTable.containsKey(ctx.Id().getSymbol().getText())) {
            Main.error("not defined: " + ctx.Id().getSymbol().getText());
        }

        return null;
    }

    public Void visitAssign(AcParser.AssignContext ctx) {
        if (!symbolTable.containsKey(ctx.Id().getSymbol().getText())) {
            Main.error("not defined: " + ctx.Id().getSymbol().getText());
        }

        ctx.expr().accept(this);

        return null;
    }
}