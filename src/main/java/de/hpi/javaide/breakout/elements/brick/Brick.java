package de.hpi.javaide.breakout.elements.brick;

import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.interfaces.Collideable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Geometric;

public class Brick implements Collideable, Displayable, Geometric{
	
	/**
	 * Width and height of a brick
	 */
	public final static int WIDTH = 100;
	public final static int HEIGHT = 20;
	/**
	 * The distance between the bricks
	 */
	public final static int OFFSET = 5;
	
	private BrickLogic logic;
	private BrickDisplay display;
	
	public Brick(BrickLogic logic, BrickDisplay display) {
		this.logic = logic;
		this.display = display;
	}

	public int getStatus() {
		return logic.getStatus();
	}
	
	public void nextStatus() {
		logic.nextStatus();
	}

	public boolean isDead() {
		return logic.isDead();
	}
	
	//Displayable
	@Override
	public void display() {
		display.display();
	}

	//Geometric
	@Override
	public Shape getGeometry() {
		return logic.getGeometry();
	}

	@Override
	public boolean intersects(Shape shape) {
		return logic.intersects(shape);
	}

	//Collideable
	@Override
	public int getLeftBoundary() {
		return logic.getLeftBoundary();
	}

	@Override
	public int getRightBoundary() {
		return logic.getRightBoundary();
	}

	@Override
	public int getUpperBoundary() {
		return logic.getUpperBoundary();
	}

	@Override
	public int getLowerBoundary() {
		return logic.getLowerBoundary();
	}

	public Point getCenter() {
		return logic.getCenter();
	}

}
