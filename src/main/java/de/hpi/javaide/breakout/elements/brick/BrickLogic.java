package de.hpi.javaide.breakout.elements.brick;

import java.awt.Point;
import java.awt.Shape;

class BrickLogic {

	BrickData data;
	
    BrickLogic(BrickData data) {
		this.data = data;
	}
		
	/**
	 * If the BrickTest is hit (and not already dead), set the next status.
	 * Calculate the color of the brick depending on the status.
	 */
	void nextStatus() {
		if (!data.isDead()) {
			data.setStatus(data.getStatus()-1);
		}
		data.setColor(calcColorComponent(85), calcColorComponent(60), calcColorComponent(20));
	}
	
	int getStatus() {
		return data.getStatus();
	}
	
	boolean isDead() {
		return data.isDead();
	}

	/**
	 * Helper to calculate the BrickTest's color components depending on the status.
	 * @param factor int basic value for the color component (0-255)
	 * @return int the new color value (0-255)
	 */
	int calcColorComponent(int factor) {
		return data.getStatus() * factor;
	}

	public int getLeftBoundary() {
		return  (data.getX() - data.getWidth() / 2) ;
	}
	
	public int getRightBoundary() {
		return  data.getX() + data.getWidth() / 2;
	}
	
	public int getUpperBoundary() {
		return data.getY() - data.getHeight() / 2;
	}
	
	public int getLowerBoundary() {
		return data.getY() + data.getHeight() / 2;
	}
	public Shape getGeometry() {
		return data.getGeometry();
	}
	public boolean intersects(Shape shape) {
		return data.getGeometry().intersects(shape.getBounds2D());
	}
	
	public Point getCenter() {
		return new Point(data.getX(), data.getY());
	}
}
