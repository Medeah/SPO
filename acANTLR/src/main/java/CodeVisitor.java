public class CodeVisitor extends AcBaseVisitor<Void> {
    private void emit(String code) {
        System.out.println(code);
    }

    public Void visitAssign(AcParser.AssignContext ctx) {
        ctx.expr().accept(this);
        emit("s" + ctx.Id().getText());

        return null;
    }

    public Void visitPrint(AcParser.PrintContext ctx) {
        emit("l" + ctx.Id().getText());
        emit("p");
        emit("si");

        return null;
    }

    public Void visitFloatcon(AcParser.FloatconContext ctx) {
        emit(ctx.Fnum().getText());

        return null;
    }

    public Void visitSymref(AcParser.SymrefContext ctx) {
        emit("l" + ctx.Id().getText());

        return null;
    }

    public Void visitIntcon(AcParser.IntconContext ctx) {
        emit(ctx.getText());

        return null;
    }

    public Void visitComputing(AcParser.ComputingContext ctx) {
        ctx.expr(0).accept(this);
        ctx.expr(1).accept(this);
        emit(ctx.getChild(1).getText());

        return null;
    }
}