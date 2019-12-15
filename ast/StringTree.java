package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class StringTree extends AST {
    private Symbol symbol;

    public StringTree(Token tok) {
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v) {
        return v.visitStringTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
