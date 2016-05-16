package de.hpi.javaide.breakout.elements.paddle;

import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.interfaces.Collideable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Geometric;
import de.hpi.javaide.breakout.interfaces.Moveable;

public class Paddle implements Collideable, Displayable, Moveable, Geometric {

    PaddleLogic paddleLogic;
    PaddleDisplay paddleDisplay;

    public static final int WIDTH = 40;
    public static final int HEIGHT = 10;

    public Paddle(PaddleLogic paddleLogic, PaddleDisplay paddleDisplay) {
        this.paddleLogic = paddleLogic;
        this.paddleDisplay = paddleDisplay;
    }

    //collideal
    @Override
    public int getLeftBoundary() {
        return paddleLogic.getLeftBoundary();
    }

    @Override
    public int getRightBoundary() {
        return paddleLogic.getRightBoundary();
    }

    @Override
    public int getUpperBoundary() {
        return paddleLogic.getUpperBoundary();
    }

    @Override
    public int getLowerBoundary() {
        return paddleLogic.getLowerBoundary();
    }

    @Override
    public Point getCenter() {
        return paddleLogic.getCenter();
    }

    //Geometric
    @Override
    public Shape getGeometry() {
        return paddleLogic.getGeometry();
    }

    @Override
    public boolean intersects(Shape shape) {
        return paddleLogic.intersects(shape);
    }

    //Moveable
    @Override
    public double getSpeed() {
        return paddleLogic.getSpeed();
    }

    @Override
    public void move(int xNew, int xOld) {
        paddleLogic.move(xNew, xOld);
    }

    //Displayable
    @Override
    public void display() {
        paddleDisplay.display();
    }

    @Override
    public String toString() {
        return paddleLogic.toString();
    }
}
