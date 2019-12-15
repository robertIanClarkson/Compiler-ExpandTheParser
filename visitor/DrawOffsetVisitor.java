package visitor;

import ast.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class DrawOffsetVisitor extends ASTVisitor {
    private final int nodeX = 100;
    private final int nodeY = 30;
    private final int padding = 20;
    private OffsetVisitor ov;
    private BufferedImage bimg;
    private Graphics2D g2;

    public DrawOffsetVisitor(OffsetVisitor ov) {
        this.ov = ov;
        int maxOffset = ov.getMaxOffset();
        int maxDepth = ov.getMaxDepth();
        int xWindow = (padding) + ((maxOffset + 1) * nodeX) + (padding);
        int yWindow = ((maxDepth + 1) * nodeY) + (3 * padding * (maxDepth + 1)) - padding;
        g2 = initializeWindow(xWindow, yWindow);
    }

    private Graphics2D initializeWindow(int x, int y) {
        Graphics2D g2;
        bimg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        g2 = bimg.createGraphics();
        g2.setBackground(Color.WHITE);
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2.setRenderingHints(rh);
        g2.clearRect(0, 0, x, y);
        return g2;
    }

    private void draw(String s, AST t) {
        int x = ov.getTreeOffset(t);
        int y = ov.getTreeDepth(t);
        if (t.kidCount() != 0) {
            visitKids(t);
            drawLines(s, t);
        }
        drawOval(s, x, y);
    }

    private void drawOval(String s, int x, int y) {
        int xPix = (padding) + (x * (nodeX));
        int yPix = (padding) + (y * (nodeY + 3 * padding));

        g2.setColor(new Color(135, 206, 250));
        g2.fillOval(xPix, yPix, nodeX, nodeY);
        g2.setColor(Color.BLACK);
        g2.drawOval(xPix, yPix, nodeX, nodeY);
        g2.drawString(s, xPix + 10, yPix + (nodeY / 2 + 5));
    }

    private void drawLines(String s, AST t) {
        int endX, endY;
        int startX = ((padding) + (ov.getTreeOffset(t) * (nodeX))) + (nodeX / 2);
        int startY = ((padding) + (ov.getTreeDepth(t) * (nodeY + 3 * padding))) + (nodeY);
        for (AST kid : t.getKids()) {
            endX = ((padding) + (ov.getTreeOffset(kid) * (nodeX))) + (nodeX / 2);
            endY = (padding) + (ov.getTreeDepth(kid) * (nodeY + 3 * padding));
            g2.drawLine(startX, startY, endX, endY);
        }
    }

    public BufferedImage getImage() {
        return bimg;
    }

    public Object visitProgramTree(AST t) {
        draw("Program", t);
        return null;
    }

    public Object visitBlockTree(AST t) {
        draw("Block", t);
        return null;
    }

    public Object visitForHeadTree(AST t) {
        draw("ForHead", t);
        return null;
    }

    public Object visitFunctionDeclTree(AST t) {
        draw("FunctionDecl", t);
        return null;
    }

    public Object visitCallTree(AST t) {
        draw("Call", t);
        return null;
    }

    public Object visitDeclTree(AST t) {
        draw("Decl", t);
        return null;
    }

    public Object visitIntTypeTree(AST t) {
        draw("IntType", t);
        return null;
    }

    public Object visitBoolTypeTree(AST t) {
        draw("BoolType", t);
        return null;
    }

    public Object visitVoidTypeTree(AST t) {
        draw("VoidType", t);
        return null;
    }

    public Object visitStringTypeTree(AST t) {
        draw("StringType", t);
        return null;
    }

    public Object visitNumberTypeTree(AST t) {
        draw("NumberType", t);
        return null;
    }

    public Object visitFormalsTree(AST t) {
        draw("Formals", t);
        return null;
    }

    public Object visitActualArgsTree(AST t) {
        draw("ActualArgs", t);
        return null;
    }

    public Object visitIfTree(AST t) {
        draw("If", t);
        return null;
    }

    public Object visitDoTree(AST t) {
        draw("Do", t);
        return null;
    }

    public Object visitWhileTree(AST t) {
        draw("While", t);
        return null;
    }

    public Object visitForTree(AST t) {
        draw("For", t);
        return null;
    }

    public Object visitReturnTree(AST t) {
        draw("Return", t);
        return null;
    }

    public Object visitAssignTree(AST t) {
        draw("Assign", t);
        return null;
    }

    public Object visitIntTree(AST t) {
        draw("Int: " + ((IntTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitStringTree(AST t) {
        draw("String: " + ((StringTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitNumberTree(AST t) {
        draw("Number: " + ((NumberTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitIdTree(AST t) {
        draw("Id: " + ((IdTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitRelOpTree(AST t) {
        draw("RelOp: " + ((RelOpTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitAddOpTree(AST t) {
        draw("AddOp: " + ((AddOpTree) t).getSymbol().toString(), t);
        return null;
    }

    public Object visitMultOpTree(AST t) {
        draw("MultOp: " + ((MultOpTree) t).getSymbol().toString(), t);
        return null;
    }
}
