package de.hpi.javaide.breakout.interfaces;

import java.awt.Point;

/**
 * Interface for objects that might collide. 
 * @author Ralf Teusner and Tom Staubitz
 */
public interface Collideable {
	
	int getLeftBoundary();
	
	int getRightBoundary();
	
	int getUpperBoundary();
	
	int getLowerBoundary();
	
	Point getCenter();
}