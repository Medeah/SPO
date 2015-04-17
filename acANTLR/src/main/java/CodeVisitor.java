public class CodeVisitor extends AcBaseVisitor<Void> {
    private void emit(String code) {
        System.out.println(code);
    }

    public Void visitAssign(AcParser.AssignContext ctx) {
        ctx.expr().accept(this);
        emit("s" + ctx.Id().getText());
        emit("0 k");

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
        if (ctx.convert2float) {
            emit("5 k");
        }

        return null;
    }

    public Void visitSymref(AcParser.SymrefContext ctx) {
        emit("l" + ctx.Id().getText());
        if (ctx.convert2float) {
            emit("5 k");
        }

        return null;
    }

    public Void visitIntcon(AcParser.IntconContext ctx) {
        emit(ctx.getText());
        if (ctx.convert2float) {
            emit("5 k");
        }

        return null;
    }

    public Void visitComputing(AcParser.ComputingContext ctx) {
        ctx.expr(0).accept(this);
        ctx.expr(1).accept(this);
        emit(ctx.op.getText());
        if (ctx.convert2float) {
            emit("5 k");
        }

        return null;
    }
}