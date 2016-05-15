package de.hpi.javaide.breakout.elements.wall;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

class WallLogic {

	WallData data;
	
	/**
	 * the implementation of the interfaces has been moved to the class Wall.
	 * Only class Wall and WallBuilder are accessible from outside of the package.
	 * Data, Display, Logic, etc. are handling the inner workings.  
	 * @param data
	 */
	WallLogic(WallData data) {
		this.data = data;
	}
	
	void update(Point position, Dimension dimension) {}

	void update() {}

	Iterator<Brick> iterator() {
		return getBricks().iterator();
	}

	ArrayList<Brick> getBricks() {
		return data.getBricks();
	}
	
	Point initBrickPosition(int column, int row) {
		return new Point(calcXPos(column), calcYPos(row));
	}
	
	/**
	 * Helper to calculate a Bricks x-pos (within the WallTest) depending on the current column
	 * @param column
	 * @return
	 */
	private int calcXPos(int column) {
//		System.out.println("w: " + BrickTest.WIDTH + "  -  o: " + BrickTest.OFFSET);
		return column * (Brick.WIDTH + Brick.OFFSET) + getOffsetX();
	}

	/**
	 * Helper to calculate a Bricks x-pos (within the WallTest) depending on the current row
	 * @param row
	 * @return
	 */
	private int calcYPos(int row) {
		return row * (Brick.HEIGHT + Brick.OFFSET) + getOffsetY();
	}

	public void initWallData() {
		int offsetX = (GameConstants.SCREEN_X / 2) - (Game.WALL_WIDTH * Brick.WIDTH / 2);
		int offsetY = Brick.HEIGHT / 2;
		data.setPosition(new Point(offsetX, offsetY));
		data.setDimension(new Dimension(Game.WALL_WIDTH, Game.WALL_HEIGHT));
	}

	public int getOffsetX() {
		return data.getOffsetX();
	}

	public int getOffsetY() {
		return data.getOffsetY();
	}
}
