package compiler;

import ast.*;
import parser.Parser;
import constrain.Constrainer;
import codegen.*;
import visitor.*;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class Compiler {

    String sourceFile;

    public Compiler(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    void compileProgram() {
        try {
            Parser parser = new Parser(sourceFile);
            AST t = parser.execute();
            System.out.println(parser.getLex());
            System.out.println("---------------AST-------------");
            PrintVisitor pv = new PrintVisitor();
            t.accept(pv);
            OffsetVisitor ov = new OffsetVisitor();
            t.accept(ov);
            DrawOffsetVisitor dov = new DrawOffsetVisitor(ov);
            t.accept(dov);
            drawAST_ImageFile(dov);
            drawAST_Window(dov);
        } catch (Exception e) {
            System.out.println("********exception*******" + e.toString());
        }
    }

    private void drawAST_ImageFile(DrawOffsetVisitor visitor) {
        try {
            File imagefile = new File(sourceFile + ".png");
            ImageIO.write(visitor.getImage(), "png", imagefile);
        } catch (Exception e) {
            System.out.println("Error in saving image: " + e.getMessage());
        }
    }

    private void drawAST_Window(DrawOffsetVisitor visitor) {
        final JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
                System.exit(0);
            }
        });
        JLabel imagelabel = new JLabel(new ImageIcon(visitor.getImage()));
        f.add("Center", imagelabel);
        f.pack();
        f.setSize(
                new Dimension(
                        visitor.getImage().getWidth() + 30,
                        visitor.getImage().getHeight() + 40
                )
        );
        f.setVisible(true);
        f.setResizable(false);
        f.repaint();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java compiler.Compiler <file>");
            System.exit(1);
        }
        (new Compiler(args[0])).compileProgram();
    }
}
