package view;

import model.command.DrawCommand;
import model.command.RedoCommand;
import model.command.UndoCommand;
import model.composite.ComplexShape;
import model.composite.Rectangle;
import model.composite.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class DrawingSurface extends JComponent {
    private ComplexShape complexShape;
    private Shape currentShape;


    public DrawingSurface() {
        super();
        currentShape = new Rectangle();
        complexShape = new ComplexShape();
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                DrawCommand command = new DrawCommand(complexShape);
                currentShape.setInitialPoint(e.getPoint());
                command.execute(currentShape);
            }

            public void mouseDragged(MouseEvent e) {
                currentShape.update(e.getPoint());
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                currentShape.update(e.getPoint());
                repaint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                DrawCommand command = new DrawCommand(complexShape);
                currentShape.setInitialPoint(e.getPoint());
                command.execute(currentShape);
            }

            public void mouseDragged(MouseEvent e) {
                currentShape.update(e.getPoint());
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                currentShape.update(e.getPoint());
                repaint();
            }
        });

    }

    protected void paintComponent(Graphics g) {
        complexShape.draw(g);
    }

    public void setCurrentShape(Shape shape) {
        currentShape = shape;
    }

    public ComplexShape getComplexShape(){
        return complexShape;
    }

    public void undo() {
       new UndoCommand(complexShape).execute();
        repaint();
    }

    public void redo() {
        new RedoCommand(complexShape).execute();
        repaint();
    }

    public void add(Shape shape){
        complexShape.add(shape);
        repaint();
    }



}
