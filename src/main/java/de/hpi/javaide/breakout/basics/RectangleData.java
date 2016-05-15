package de.hpi.javaide.breakout.basics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public abstract class RectangleData extends CollisionObject {

	/**
	 * Constructor to create the basis for a rectangular object
	 * 
	 * @param game Game reference to the game that provides access to the Processing features
	 * @param position Position x,y position of the Object
	 * @param dimension
	 */
	public RectangleData(Point position, Dimension dimension) {
		super(position, dimension);
		geometry = new Rectangle2D.Float(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
	}
}
