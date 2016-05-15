package de.hpi.javaide.breakout.elements.wall;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.elements.brick.Brick;

class WallData {
	/**
	 * Set the position of the WallTest depending on window size and number of columns
	 */
	private Point position;
	private Dimension dimension;
	
	/**
	 * Datastructure to keep the Bricks
	 */
	private ArrayList<Brick> bricks;

	WallData() {
		bricks = new ArrayList<>();
	}

	int getRows() {
		return dimension.height;
	}

	int getColumns() {
		return dimension.width;
	}

	int getOffsetX() {
		return position.x;
	}

	int getOffsetY() {
		return position.y;
	}
	
	ArrayList<Brick> getBricks() {
		return bricks;
	}
	/**
	 * Remove a brick from the wall
	 * @param index
	 */
	void removeBrick(int index) {
		bricks.set(index, null);
	}

	void setPosition(Point position) {
		this.position = position;
	}
	
	void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

}
