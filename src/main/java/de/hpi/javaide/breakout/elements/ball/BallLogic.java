package de.hpi.javaide.breakout.elements.ball;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
class BallLogic {
	
	BallData data;
	
	/**
	 * the implementation of the interfaces has been moved to the class Ball.
	 * Only class Ball and BallBuilder are accessible from outside of the package.
	 * Data, Display and Logic are handling the inner workings.  
	 * @param data
	 */
	BallLogic(BallData data) {
		this.data = data;
	}
	
	/**
	 * Move the Ball around.
	 */
	void move() {
		update(new Point(data.getX() + (int) data.getDirectionX(), data.getY() + (int) data.getDirectionY()));
	}

	/**
	 * Bounce the ball in x-direction on collision
	 */
	void bounceX() {
		data.setDirectionX(-data.getDirectionX());
	}

	/**
	 * Bounce the ball in y-direction on collision
	 */
	void bounceY() {
		data.setDirectionY(-data.getDirectionY());
	}

	/**
	 * Set the speed of the ball (when it hits the paddle)
	 * @param speed
	 */
	void changeSpeed(double speed) {
		data.getDirection().normalize();
		data.getDirection().mult( (int) speed);
	}
	
	/**
	 * Determine in which direction the ball is currently moving
	 * @return boolean true if it is moving upwards
	 */
	boolean isMovingUpwards() {
		return data.getDirectionY() < 0;
	}
	
	void update(Point position, Dimension dimension) {
		data.setPosition(position);
		data.setDimension(dimension);
		((Ellipse2D) data.getGeometry()).setFrame(data.getX()-data.getWidth()/2, 
				data.getY()-data.getHeight()/2, data.getWidth(), data.getHeight());
	}
	
	
	void update() {
		Dimension dimension = new Dimension(data.getWidth(), data.getHeight());
		Point position = new Point(data.getX(), data.getY());
		update(position, dimension);
	}
	
	void update(Point position){
		Dimension dimension = new Dimension(data.getWidth(), data.getHeight());
		update(position, dimension);
	}
	
	void update(Dimension dimension){
		Point position = new Point(data.getX(), data.getY());
		update(position, dimension);
	}
	
	int getLeftBoundary() {
		return  (data.getX() - data.getWidth() / 2) ;
	}
	
	int getRightBoundary() {
		return  data.getX() + data.getWidth() / 2;
	}
	
	int getUpperBoundary() {
		return data.getY() - data.getHeight() / 2;
	}
	
	int getLowerBoundary() {
		return data.getY() + data.getHeight() / 2;
	}
	
	Shape getGeometry() {
		return data.getGeometry();
	}

	boolean intersects(Shape shape) {
		return data.getGeometry().intersects((Rectangle2D)shape);
	}
	
	/**
	 * Directly set the position of the ball. Dimension remains untouched.
	 * @param point Point where the ball should be located.
	 */
	void setPosition(Point point){
		update(point);
	}
	
	/**
	 * Directly set the dimension of the ball. Position remains untouched.
	 * @param dimension  New dimension of the ball.
	 */
	void setDimension(Dimension dimension){
		update(dimension);
	}
	
	/**
	 * Set the direction of the ball (when it hits the paddle)
	 * @param x 
	 * @param y
	 */
	void setDirection(float x, float y) {
		data.setDirectionX(x);
		data.setDirectionY(y);
	}
	
	/**
	 * Pump up the Ball to gameSize when it is moved from the depot to the game
	 */
	void addAir() {
		update(new Dimension(data.getFullSize(), data.getFullSize()));
	}
	
	/**
	 * Move the Ball from the depot to its starting position in the game
	 */
	void moveToStart() {
		addAir();
		update(Game.STARTPOSITION);
	}
	
	int getSize() {
		//As the ball is a ball, the width should equal the height
		return data.getWidth();
	}

	int getFullSize() {
		return data.getFullSize();
	}
	
	boolean isMovingLeft() {
		return data.getDirectionX() < 0;
	}
	
	boolean isMovingRight() {
		return data.getDirectionX() > 0;
	}
	
	void removeHorizontalMovement() {
		data.setDirectionX(0);
	}

	Vector getDirection() {
		return data.getDirection();
	}

	Point getCenter() {
		return new Point(data.getX(), data.getY());
	}
}
