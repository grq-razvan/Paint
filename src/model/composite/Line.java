package model.composite;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */

public class Line extends Shape {

    private Line2D line;

    public Line(Point point) {
        line = new Line2D.Double(point, point);
    }

    public Line() {
        line = new Line2D.Double();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g2d.draw(line);
    }

    @Override
    public void update(Point p) {
        line.setLine(line.getP1(), p);
    }

    @Override
    public void setInitialPoint(Point point) {
        line.setLine(point, point);
    }

}
