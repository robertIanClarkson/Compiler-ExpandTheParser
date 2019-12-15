package visitor;

import ast.*;

public abstract class ASTVisitor {
    public void visitKids(AST t) {
        for (AST kid : t.getKids()) {
            kid.accept(this);
        }
        return;
    }

    public abstract Object visitProgramTree(AST t);

    public abstract Object visitBlockTree(AST t);

    public abstract Object visitForHeadTree(AST t);

    public abstract Object visitFunctionDeclTree(AST t);

    public abstract Object visitCallTree(AST t);

    public abstract Object visitDeclTree(AST t);

    public abstract Object visitIntTypeTree(AST t);

    public abstract Object visitBoolTypeTree(AST t);

    public abstract Object visitVoidTypeTree(AST t);

    public abstract Object visitStringTypeTree(AST t);

    public abstract Object visitNumberTypeTree(AST t);

    public abstract Object visitFormalsTree(AST t);

    public abstract Object visitActualArgsTree(AST t);

    public abstract Object visitIfTree(AST t);

    public abstract Object visitDoTree(AST t);

    public abstract Object visitWhileTree(AST t);

    public abstract Object visitForTree(AST t);

    public abstract Object visitReturnTree(AST t);

    public abstract Object visitAssignTree(AST t);

    public abstract Object visitIntTree(AST t);

    public abstract Object visitStringTree(AST t);

    public abstract Object visitNumberTree(AST t);

    public abstract Object visitIdTree(AST t);

    public abstract Object visitRelOpTree(AST t);

    public abstract Object visitAddOpTree(AST t);

    public abstract Object visitMultOpTree(AST t);
}
