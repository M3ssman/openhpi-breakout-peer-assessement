package de.hpi.javaide.breakout.elements.paddle;

import java.awt.*;

import de.hpi.javaide.breakout.basics.RectangleData;
import de.hpi.javaide.breakout.basics.Vector;

/**
 * this class just stores the data and provides access to it.
 */
class PaddleData extends RectangleData {

    private int speed;
    /**
     * the direction in which the Paddle is moving
     */
    private Vector direction;

    PaddleData(Point position, Dimension dimension) {
        super(position, dimension);
        direction = new Vector(0f,0f);
    }

    public Shape getGeometry() {
        return this.geometry;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector v) {
        direction = v;
    }
}
