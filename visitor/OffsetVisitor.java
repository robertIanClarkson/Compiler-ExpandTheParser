package visitor;

import ast.*;

import java.util.HashMap;

public class OffsetVisitor extends ASTVisitor {
    private int[] offset = new int[100];
    private int depth = 0;
    private int maxDepth = 0;
    private int leftKidOffset;
    private int rightKidOffset;
    private int parentOffset;
    private int checkOffset;
    private int nextAvailableOffset;
    private int updateAddition;
    private int leafOffset;
    private AST leftKid;
    private AST rightKid;
    private HashMap<AST, Offset> location = new HashMap<>();

    public int getTreeDepth(AST t) {
        return location.get(t).getDepth();
    }

    public int getTreeOffset(AST t) {
        return location.get(t).getOffset();
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public int getMaxOffset() {
        int max = 0;
        for (AST t : location.keySet()) {
            if (location.get(t).getOffset() > max) {
                max = location.get(t).getOffset();
            }
        }
        return max;
    }

    private void offset(String s, AST t) {
        if (t.kidCount() != 0) {
            depth++;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            visitKids(t);
            depth--;
            leftKid = t.getKid(1);
            rightKid = t.getKid(t.kidCount());
            leftKidOffset = location.get(leftKid).getOffset();
            rightKidOffset = location.get(rightKid).getOffset();
            parentOffset = (leftKidOffset + rightKidOffset) / 2;
            checkOffset = offset[depth];
            if (parentOffset >= checkOffset) {
                location.put(t, new Offset(depth, parentOffset));
                offset[depth] = parentOffset;
                offset[depth] += 2;
            } else {
                nextAvailableOffset = offset[depth];
                location.put(t, new Offset(depth, nextAvailableOffset));
                updateAddition = nextAvailableOffset - parentOffset;
                updateKids(updateAddition, t);
                offset[depth] += 2;
            }

        } else {
            leafOffset = offset[depth];
            location.put(t, new Offset(depth, leafOffset));
            offset[depth] += 2;
        }
    }

    private void updateKids(int addition, AST t) {
        int newOffset;
        depth++;
        for (AST kid : t.getKids()) {
            if (kid.kidCount() != 0) {
                updateKids(addition, kid);
                newOffset = addition + location.get(kid).getOffset();
                location.replace(kid, new Offset(depth, newOffset));
                offset[depth] = newOffset + 2;
            } else {
                newOffset = addition + location.get(kid).getOffset();
                location.replace(kid, new Offset(depth, newOffset));
                offset[depth] = newOffset + 2;
            }
        }
        depth--;
    }

    public Object visitProgramTree(AST t) {
        offset("Program", t);
        return null;
    }

    public Object visitBlockTree(AST t) {
        offset("Block", t);
        return null;
    }

    public Object visitForHeadTree(AST t) {
        offset("ForHead", t);
        return null;
    }

    public Object visitFunctionDeclTree(AST t) {
        offset("FunctionDecl", t);
        return null;
    }

    public Object visitCallTree(AST t) {
        offset("Call", t);
        return null;
    }

    public Object visitDeclTree(AST t) {
        offset("Decl", t);
        return null;
    }

    public Object visitIntTypeTree(AST t) {
        offset("IntType", t);
        return null;
    }

    public Object visitBoolTypeTree(AST t) {
        offset("BoolType", t);
        return null;
    }

    public Object visitVoidTypeTree(AST t) {
        offset("VoidType", t);
        return null;
    }

    public Object visitStringTypeTree(AST t) {
        offset("StringType", t);
        return null;
    }

    public Object visitNumberTypeTree(AST t) {
        offset("NumberType", t);
        return null;
    }

    public Object visitFormalsTree(AST t) {
        offset("Formals", t);
        return null;
    }

    public Object visitActualArgsTree(AST t) {
        offset("ActualArgs", t);
        return null;
    }

    public Object visitIfTree(AST t) {
        offset("If", t);
        return null;
    }

    public Object visitDoTree(AST t) {
        offset("Do", t);
        return null;
    }

    public Object visitWhileTree(AST t) {
        offset("While", t);
        return null;
    }

    public Object visitForTree(AST t) {
        offset("For", t);
        return null;
    }

    public Object visitReturnTree(AST t) {
        offset("Return", t);
        return null;
    }

    public Object visitAssignTree(AST t) {
        offset("Assign", t);
        return null;
    }

    public Object visitIntTree(AST t) {
        offset("Int: " + ((IntTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitStringTree(AST t) {
        offset("String: " + ((StringTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitNumberTree(AST t) {
        offset("Number: " + ((NumberTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitIdTree(AST t) {
        offset("Id: " + ((IdTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitRelOpTree(AST t) {
        offset("RelOp: " + ((RelOpTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitAddOpTree(AST t) {
        offset("AddOp: " + ((AddOpTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitMultOpTree(AST t) {
        offset("MultOp: " + ((MultOpTree) t).getSymbol().toString(), t);
        return null;
    }
}
