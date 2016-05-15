package de.hpi.javaide.breakout.basics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Extends the CollisionObject to provide the basis for the round collidable Elements, such as the BallTest
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public abstract class EllipseData extends CollisionObject {

	/**
	 * Constructor to create the basis for a round object
	 * 
	 * @param game Game reference to the game that provides access to the Processing features
	 * @param position Position x,y position of the Object
	 * @param dimension
	 */
	public EllipseData(Point position, Dimension dimension) {
		super(position, dimension);
		geometry = new Ellipse2D.Float(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
	}

	/**
	 * Default constructor to create a round object with a size 10,10 at the top left corner of the screen.
	 * @param game Game
	 */
	public EllipseData() {
		this(new Point(0, 0), new Dimension(10, 10));
	}
}
