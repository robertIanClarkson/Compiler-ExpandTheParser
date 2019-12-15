package ast;

import visitor.*;

public class ForHeadTree extends AST {

    public ForHeadTree() {
    }

    public Object accept(ASTVisitor v) {
        return v.visitForHeadTree(this);
    }

}
