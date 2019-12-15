package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class IntTree extends AST {
    private Symbol symbol;

    public IntTree(Token tok) {
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v) {
        return v.visitIntTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

}

