package model.command;

import model.composite.ComplexShape;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class RedoCommand extends Command {

    private ComplexShape currentShapes;

    public RedoCommand(ComplexShape currentShapes) {
        this.currentShapes = currentShapes;
    }

    public void execute() {
        if (currentShapes.containsShapes())
            currentShapes.redo();
    }

}
