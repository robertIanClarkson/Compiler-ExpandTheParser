package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class NumberTree extends AST {
    private Symbol symbol;

    public NumberTree(Token tok) {
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v) {
        return v.visitNumberTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
