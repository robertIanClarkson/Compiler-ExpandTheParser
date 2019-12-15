package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class IdTree extends AST {
    private Symbol symbol;
    private int frameOffset = -1;

    public IdTree(Token tok) {
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v) {
        return v.visitIdTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setFrameOffset(int i) {
        frameOffset = i;
    }

    public int getFrameOffset() {
        return frameOffset;
    }

}

