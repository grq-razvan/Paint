package model.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */

public class ComplexShape extends Shape {

    private List<Shape> shapes;
    private List<Shape> undoShapes;

    public ComplexShape() {
        shapes = new ArrayList<>();
        undoShapes = new ArrayList<>();
    }


    @Override
    public void draw(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }


    @Override
    public void update(Point p) {

    }

    @Override
    public void setInitialPoint(Point point) {

    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            Shape lastElementDrawn = shapes.get(shapes.size() - 1);
            shapes.remove(lastElementDrawn);
            undoShapes.add(lastElementDrawn);
        }
    }

    public void redo() {
        if (!undoShapes.isEmpty()) {
            Shape lastElementRemoved = undoShapes.get(undoShapes.size() - 1);
            undoShapes.remove(lastElementRemoved);
            shapes.add(lastElementRemoved);
        }
    }

    public boolean containsShapes() {
        return !shapes.isEmpty();
    }

}
