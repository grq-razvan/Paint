package model.composite;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */

public class Circle extends Shape {

    private Ellipse2D circle;
    private double startX;
    private double startY;

    public Circle(Point point) {
        startX = point.getX();
        startY = point.getY();
        circle = new Ellipse2D.Double(startX, startY, 0, 0);
    }

    public Circle() {
        circle = new Ellipse2D.Double(startX, startY, 0, 0);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g2d.draw(circle);
    }

    @Override
    public void update(Point p) {
        double newX = p.getX();
        double newY = p.getY();
        double w = Math.abs(newX - startX);
        double h = Math.abs(newY - startY);
        if (newX < startX) {
            if (newY > startY) {
                circle.setFrame(newX, startY, w, h);
            } else {
                circle.setFrame(newX, newY, w, h);
            }
        } else {
            if (newY > startY) {
                circle.setFrame(startX, startY, w, h);
            } else {
                circle.setFrame(startX, newY, w, h);
            }
        }
    }

    @Override
    public void setInitialPoint(Point point) {
        startX = point.getX();
        startY = point.getY();
    }
}
