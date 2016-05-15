package de.hpi.javaide.breakout.elements.balldepot;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;

import de.hpi.javaide.breakout.elements.ball.Ball;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
class BallDepotData {
	
	/**
	 * x and y position of the depot
	 */
	private Dimension dimension;
	private Point position;
	/**
	 * Datastructure to store the Balls
	 */
	private ArrayList<Ball> balls;
	
	/**
	 * distance between the balls in the depot
	 */
	private int offset = 50;

	/**
	 * Create the Depot at bottom right of the screen
	 * and add the amount of Balls that has been set in the game settings.
	 * @param game Game reference to access the Processing features
	 */
	BallDepotData() {
		balls = new ArrayList<>();
	}

	int getX() {
		return position.x;
	}

	int getY() {
		return position.y;
	}

	int getWidth() {
		return dimension.width;
	}

	int getHeight() {
		return dimension.height;
	}

	int getOffset() {
		return offset;
	}
	
	Shape getGeometry() {
		return null;
	}

	void setPosition(Point position) {
		this.position = position;
	}

	void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	ArrayList<Ball> getBalls() {
		return balls;
	}
}
