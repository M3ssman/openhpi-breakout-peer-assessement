package de.hpi.javaide.breakout.interfaces;

public interface AutoMoveable {
	void changeSpeed(double speed);
	void move();
	double getSpeed();
	void moveToStart();
}
