package de.hpi.javaide.breakout.interfaces;

public interface Bounceable {
	void bounceY();
	void bounceX();

	boolean isMovingUpwards();
	boolean isMovingRight();
	boolean isMovingLeft();
}
