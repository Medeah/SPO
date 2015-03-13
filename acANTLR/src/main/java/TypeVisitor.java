import java.util.Map;

public class TypeVisitor extends AcBaseVisitor<Type> {

    public TypeVisitor(Map<String, Type> symbolTable) {
        this.symbolTable = symbolTable;
    }

    private Map<String, Type> symbolTable;

    private Type convert(Type t1, Type t2) {
        if (t1 == Type.FLOAT && t2 == Type.INT) {
            Main.error("cannot convert float to int");
        }
        return t2;
    }

    private Type generalize(Type t1, Type t2) {
        if (t1 == Type.FLOAT || t2 == Type.FLOAT) {
            return Type.FLOAT;
        } else {
            return Type.INT;
        }
    }

    /**
     * Visit a parse tree produced by the {@code assign}
     * labeled alternative in {@link AcParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    public Type visitAssign(AcParser.AssignContext ctx) {
        Type id = symbolTable.get(ctx.Id().getText());
        Type ex = ctx.expr().accept(this);

        return convert(ex, id);
    }

    /**
     * Visit a parse tree produced by the {@code floatcon}
     * labeled alternative in {@link AcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    public Type visitFloatcon(AcParser.FloatconContext ctx) {
        return Type.FLOAT;
    }

    /**
     * Visit a parse tree produced by the {@code intcon}
     * labeled alternative in {@link AcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    public Type visitIntcon(AcParser.IntconContext ctx) {
        return Type.INT;
    }

    /**
     * Visit a parse tree produced by the {@code symref}
     * labeled alternative in {@link AcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    public Type visitSymref(AcParser.SymrefContext ctx) {
        return symbolTable.get(ctx.Id().getSymbol().getText());
    }

    /**
     * Visit a parse tree produced by the {@code computing}
     * labeled alternative in {@link AcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    public Type visitComputing(AcParser.ComputingContext ctx) {
        return generalize(ctx.expr(0).accept(this), ctx.expr(1).accept(this));
    }
}