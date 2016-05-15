package de.hpi.javaide.breakout.interfaces;

import java.awt.Shape;

public interface Geometric {
	Shape getGeometry();
	boolean intersects(Shape shape);
}
