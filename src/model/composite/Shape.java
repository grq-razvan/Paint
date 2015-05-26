package model.composite;

import java.awt.*;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public abstract class Shape {

    public abstract void draw(Graphics g);

    public abstract void update(Point p);

    public abstract void setInitialPoint(Point point);

}
