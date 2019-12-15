package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class MultOpTree extends AST {
    private Symbol symbol;

    public MultOpTree(Token tok) {
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v) {
        return v.visitMultOpTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
