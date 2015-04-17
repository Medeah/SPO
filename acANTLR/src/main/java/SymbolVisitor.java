import java.util.HashMap;
import java.util.Map;

public class SymbolVisitor extends AcBaseVisitor<Void> {

    public SymbolVisitor(Map<String, Type> symbolTable) {
        this.symbolTable = symbolTable;
    }

    private Map<String, Type> symbolTable;

    public Void visitDcl(AcParser.DclContext ctx) {
        Type t = Type.INT;
        if (ctx.getChild(0).getText().equals("f")) {
            t = Type.FLOAT;
        }
        String sym = ctx.Id().getSymbol().getText();
        if (symbolTable.containsKey(sym)) {
            Main.error("redeclaration of '" + sym + "'", ctx.Id().getSymbol());
        }
        symbolTable.put(sym, t);
        return null;
    }

    public Void visitSymref(AcParser.SymrefContext ctx) {
        if (!symbolTable.containsKey(ctx.Id().getSymbol().getText())) {
            Main.error("symbol not defined: " + ctx.Id().getSymbol().getText(), ctx.Id().getSymbol());
        }

        return null;
    }

    public Void visitAssign(AcParser.AssignContext ctx) {
        if (!symbolTable.containsKey(ctx.Id().getSymbol().getText())) {
            Main.error("symbol not defined: " + ctx.Id().getSymbol().getText(), ctx.Id().getSymbol());
        }

        ctx.expr().accept(this);

        return null;
    }
}