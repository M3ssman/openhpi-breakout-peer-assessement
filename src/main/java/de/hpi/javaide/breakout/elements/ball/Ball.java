package de.hpi.javaide.breakout.elements.ball;

import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.interfaces.AutoMoveable;
import de.hpi.javaide.breakout.interfaces.Bounceable;
import de.hpi.javaide.breakout.interfaces.Collideable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Geometric;
import de.hpi.javaide.breakout.interfaces.Inflateable;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class Ball implements Collideable, Displayable, AutoMoveable, Inflateable, Bounceable, Geometric {
	
	private BallLogic logic;
	private BallDisplay display;
	
	public Ball(BallLogic logic, BallDisplay display) {
		this.logic = logic;
		this.display = display;
	}
	
	//Inflateable
	@Override
	public void addAir() {
		logic.addAir();
	}
	//AutoMoveable
	@Override
	public void moveToStart() {
		logic.moveToStart();
	}
		
	@Override
	public void move() {
		logic.move();
	}
	
	@Override
	public void changeSpeed(double speed) {
		logic.changeSpeed(speed);
	}
	
	@Override
	public double getSpeed() {
		return logic.getDirection().getLength(); //This is a candidate for a law of demeter violation
	}
	//Bounceable
	@Override
	public void bounceY() {
		logic.bounceY();
	}
	
	@Override
	public void bounceX() {
		logic.bounceX();
	}

	@Override
	public boolean isMovingUpwards() {
		return logic.isMovingUpwards();
	}
	
	@Override
	public boolean isMovingRight() {
		return logic.isMovingRight();
	}
	
	@Override
	public boolean isMovingLeft() {
		return logic.isMovingLeft();
	}
	//Collideable
	@Override
	public int getLeftBoundary() {
		return logic.getLeftBoundary();
	}
	
	@Override
	public int getUpperBoundary() {
		return logic.getUpperBoundary();
	}
	
	@Override
	public int getRightBoundary() {
		return logic.getRightBoundary();
	}
	
	@Override
	public int getLowerBoundary() {
		return logic.getLowerBoundary();
	}
		
	@Override
	public boolean intersects(Shape geometry) {
		return logic.intersects(geometry);
	}
	
	@Override
	public Shape getGeometry() {
		return logic.getGeometry();
	}
	
	@Override
	public Point getCenter() {
		return logic.getCenter();
	}
	
	//Displayable
	@Override
	public void display() {
		display.display();
	}
	
	//Object
	@Override
	public String toString() {
		return logic.toString();
	}

	public void noHorizontal() {
		logic.removeHorizontalMovement();
	}

	public int getSize() {
		return logic.getSize();
	}
	
	public int getFullSize() {
		return logic.getFullSize();
	}
}
