package model.command;

import model.composite.ComplexShape;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class UndoCommand extends Command {
    private ComplexShape currentShapes;

    public UndoCommand(ComplexShape currentShapes) {
        this.currentShapes = currentShapes;
    }

    public void execute() {
        if (currentShapes.containsShapes())
            currentShapes.undo();
    }
}
