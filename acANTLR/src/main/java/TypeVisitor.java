import java.util.Map;

public class TypeVisitor extends AcBaseVisitor<Void> {

    public TypeVisitor(Map<String, Type> symbolTable) {
        this.symbolTable = symbolTable;
    }

    private Map<String, Type> symbolTable;

    private void convert(AcParser.ExprContext c, Type t) {
        if (c.type == Type.FLOAT && t == Type.INT) {
            Main.error("Cannot convert float to int");
        } else if (c.type == Type.INT && t == Type.FLOAT) {
            c.convert2float = true;
        }
    }

    private Type generalize(Type t1, Type t2) {
        if (t1 == Type.FLOAT || t2 == Type.FLOAT) {
            return Type.FLOAT;
        } else {
            return Type.INT;
        }
    }

    private Type consistent(AcParser.ExprContext c1, AcParser.ExprContext c2) {
        Type m = generalize(c1.type, c2.type);
        convert(c1, m);
        convert(c2, m);
        return m;
    }

    public Void visitAssign(AcParser.AssignContext ctx) {
        Type id = symbolTable.get(ctx.Id().getText());
        ctx.expr().accept(this);
        convert(ctx.expr(), id);

        //ctx.type = assign node properly does not need type
        return null;
    }

    public Void visitFloatcon(AcParser.FloatconContext ctx) {
        ctx.type = Type.FLOAT;
        return null;
    }

    public Void visitIntcon(AcParser.IntconContext ctx) {
        ctx.type = Type.INT;
        return null;
    }

    public Void visitSymref(AcParser.SymrefContext ctx) {
        ctx.type = symbolTable.get(ctx.Id().getSymbol().getText());
        return null;
    }

    public Void visitComputing(AcParser.ComputingContext ctx) {
        ctx.expr(0).accept(this);
        ctx.expr(1).accept(this);
        ctx.type = consistent(ctx.expr(0), ctx.expr(1));
        return null;
    }
}