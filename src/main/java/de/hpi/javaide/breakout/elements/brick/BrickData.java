package de.hpi.javaide.breakout.elements.brick;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.basics.RectangleData;
import de.hpi.javaide.breakout.starter.Game;

class BrickData extends RectangleData {
	
	/**
	 * The BrickTest's status. Is reduced by 1 each time it is hit by a BallTest.
	 */
	private int status = Game.LIVES;
	
	BrickData(Point position, Dimension dimension) {
		super(position, dimension);
	}
	
	int getStatus() {
		return status;
	}

	void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * Determine if the BrickTest is already dead.
	 * @return true if the status is 0 or less
	 */
	boolean isDead() {
		return this.status <= 0;
	}
	
	Shape getGeometry() {
		return this.geometry;
	}
}
