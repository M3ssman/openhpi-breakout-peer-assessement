package de.hpi.javaide.breakout.elements.ball;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.basics.EllipseData;
import de.hpi.javaide.breakout.basics.Vector;

/**
 * The Data class only holds the data and provides access to it.
 * In another context, this e.g. could serve as a fake for a database connection.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
class BallData extends EllipseData {
	/**
	 * the size of the Ball when its in the game
	 */
	private int fullSize;
	/**
	 * the direction in which the Ball is moving
	 */
	private Vector direction;
	
	
	/**
	 * Create a Ball at the given position with size 10,10 (depotSize).
	 * The fullSize of the Ball will be 30, 30 (gameSize).
	 * The color of the Ball is somewhat reddish
	 * 
	 * @param game Game reference to the Game that provides access to the Processing features 
	 * @param position Position x,y 
	 */
	BallData(Point position, Dimension dimension, Vector direction) {
		super(position, dimension);
		this.direction = direction;
		fullSize = 30;
		setColor(150, 0, 77);
	}
	
	//Methods are package private so they can be easily accessed 
	//by the other components of the Ball but by no one else
	int getFullSize() {
		return fullSize;
	}

	float getDirectionX() {
		return direction.getX();
	}
	
	float getDirectionY() {
		return direction.getY();
	}

	void setDirectionX(float dX) {
		direction.setX(dX);
	}

	void setDirectionY(float dY) {
		direction.setY(dY);
	}
	
	Vector getDirection() {
		return this.direction;
	}
	
	Shape getGeometry() {
		return this.geometry;
	}
}
