package view;

import model.composite.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Razvan-Stefan on 18.05.2015.
 */
public class Frame extends JFrame {
    private JPanel panel;
    private DrawingSurface paintPanel;
    private JButton rectangleButton;
    private JButton lineButton;
    private JButton circleButton;
    private JPanel surfaceWrapper;
    private JButton redoButton;
    private JButton undoButton;
    private JButton newButton;
    private JButton addButton;

    private boolean isChild;
    private Frame parent;

    public Frame(boolean child, Frame parent) {
        this.parent = parent;
        this.isChild = child;
        add(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUIComponents() {
        surfaceWrapper = new JPanel();
        paintPanel = new DrawingSurface();
        surfaceWrapper.add(paintPanel);
        rectangleButton = new JButton();
        rectangleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setCurrentShape(new Rectangle());
            }
        });

        lineButton = new JButton();
        lineButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setCurrentShape(new Line());
            }
        });

        circleButton = new JButton();
        circleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.setCurrentShape(new Circle());
            }
        });

        undoButton = new JButton();
        undoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.undo();
            }
        });

        redoButton = new JButton();
        redoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.redo();
            }
        });

        newButton = new JButton();
        newButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame(true, Frame.this);
            }
        });
        addButton = new JButton();
        addButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.add(getContent());
                dispose();
            }
        });

        if (isChild) {
            newButton.setVisible(false);
            addButton.setVisible(true);
        } else {
            newButton.setVisible(true);
            addButton.setVisible(false);
        }
    }

    public ComplexShape getContent() {
        return paintPanel.getComplexShape();
    }

    public void add(Shape shape) {
        paintPanel.add(shape);
    }
}
