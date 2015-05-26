package model.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class Rectangle extends Shape {

    private double startX;
    private double startY;
    private Rectangle2D rectangle;

    public Rectangle(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;
        rectangle = new Rectangle2D.Double(startX, startY, 0, 0);
    }

    public Rectangle() {
        rectangle = new Rectangle2D.Double();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g2d.draw(rectangle);
    }

    @Override
    public void update(Point p) {
        double newX = p.getX();
        double newY = p.getY();
        double w = Math.abs(newX - startX);
        double h = Math.abs(newY - startY);
        if (newX < startX) {
            if (newY > startY) {
                rectangle.setRect(newX, startY, w, h);
            } else {
                rectangle.setRect(newX, newY, w, h);
            }
        } else {
            if (newY > startY) {
                rectangle.setRect(startX, startY, w, h);
            } else {
                rectangle.setRect(startX, newY, w, h);
            }
        }
    }

    @Override
    public void setInitialPoint(Point point) {
        startX = point.getX();
        startY = point.getY();
        rectangle.setRect(startX, startY, 0, 0);
    }
}
