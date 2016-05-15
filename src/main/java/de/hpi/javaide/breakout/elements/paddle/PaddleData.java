package de.hpi.javaide.breakout.elements.paddle;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.RectangleData;

class PaddleData extends RectangleData {
	
	private int speed;
	
	PaddleData(Point position, Dimension dimension) {
		super(position, dimension);
	}
	
	//TODO this class just stores the data and provides access to it.
	
}
