package de.hpi.javaide.breakout.elements.paddle;

import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.interfaces.Collideable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Geometric;
import de.hpi.javaide.breakout.interfaces.Moveable;

public class Paddle implements Collideable, Displayable, Moveable, Geometric {
	
	//TODO implement the paddle's methods
	//Hint: Many of them are just delegating to the logic or the display
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 0;
	
	public Paddle(PaddleLogic paddleLogic, PaddleDisplay paddleDisplay) {
		
	}

	//collideal
	@Override
	public int getLeftBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRightBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUpperBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLowerBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	//Geometric
	@Override
	public Shape getGeometry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}

	//Moveable
	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}	
	
	//Displayable
	@Override
	public void display() {
		// TODO Auto-generated method stub
	}
}
