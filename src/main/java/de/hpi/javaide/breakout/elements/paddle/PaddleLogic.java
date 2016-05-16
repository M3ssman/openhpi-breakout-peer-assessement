package de.hpi.javaide.breakout.elements.paddle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

class PaddleLogic {

    private PaddleData data;

    PaddleLogic(PaddleData data) {
        this.data = data;
    }

    int getLeftBoundary() {
        return (data.getX() - data.getWidth() / 2);
    }

    int getRightBoundary() {
        return data.getX() + data.getWidth() / 2;
    }

    int getUpperBoundary() {
        return data.getY() - data.getHeight() / 2;
    }

    int getLowerBoundary() {
        return data.getY() + data.getHeight() / 2;
    }

    public Point getCenter() {
        return new Point(data.getX(), data.getY());
    }

    public Shape getGeometry() {
        return data.getGeometry();
    }

    public boolean intersects(Shape shape) {
        return data.getGeometry().intersects(shape.getBounds2D());
    }

    public double getSpeed() {
        double dirLen = data.getDirection().getLength();
        if( dirLen < Game.INITIAL_SPEED) {
            return Game.INITIAL_SPEED;
        } else {
            return dirLen;
        }
    }

    public void move(int xNew, int xOld) {
        Vector vOld = data.getDirection();
//        float nx = Math.abs(xNew - vOld.getX());
        float nx = Math.abs(xNew - xOld);
//        Vector vNew = new Vector(nx, vOld.getY());
        Vector vNew = new Vector(nx, vOld.getY());

        data.setDirection(vNew);
        update(new Point(xNew, data.getY()));
    }

    void update(Point position) {
        Dimension dimension = new Dimension(data.getWidth(), data.getHeight());
        update(position, dimension);
    }

    void update(Point position, Dimension dimension) {
        data.setPosition(position);
        data.setDimension(dimension);
    }
}
