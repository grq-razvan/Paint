package model.command;

import model.composite.ComplexShape;
import model.composite.Shape;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class DrawCommand extends Command {
    private ComplexShape currentShapes;

    public DrawCommand(ComplexShape currentShapes) {
        this.currentShapes = currentShapes;
    }

    public void execute(Shape shape) {
        currentShapes.add(shape);
    }
}
