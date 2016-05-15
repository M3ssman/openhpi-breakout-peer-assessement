package de.hpi.javaide.breakout.elements.wall;



import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.elements.brick.BrickBuilder;
import de.hpi.javaide.breakout.interfaces.Countable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.starter.Game;

public class Wall implements Displayable, Iterable<Brick>, Countable {
	
	private WallLogic logic;
	private WallDisplay display;
	
	
	public  Wall(WallLogic logic, WallDisplay display, Game game) {
		this.logic =  logic;
		this.display = display;
		
		buildWall(game, Game.WALL_WIDTH, Game.WALL_HEIGHT);
	}

	/**
	 * Make the WallTest iterable by delegating to the ArrayList iterator 
	 */
	@Override
	public Iterator<Brick> iterator() {
		return logic.iterator();
	}

	@Override
	public void display() {
		display.display();
	}
	
	/**
	 * Helper to build the WallTest
	 * 
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows) {
		int bricksCount = columns * rows;

		for (int index = 0; index < bricksCount; index++) {
			int column = index % columns;
			int row = (index - column) / columns;
			addBrick(game, index, column, row);
		}
	}
	
	/**
	 * Add a new Brick to the Wall.
	 * Calculate its position depending on column and row.
	 * 
	 * @param game
	 * @param index
	 * @param column
	 * @param row
	 */
	private void addBrick(Game game, int index, int column, int row) {	
		Brick brick = new BrickBuilder(
				logic.initBrickPosition(column, row),
				game
				).build();
		logic.getBricks().add(brick);
	}

	public Point getPositionFirst() {
		ArrayList<Brick> bricks = logic.getBricks();
		Brick first = bricks.get(0);
		return first.getCenter();
	}

	public Point getPositionLast() {
		ArrayList<Brick> bricks = logic.getBricks();
		int size = bricks.size();
		Brick last = bricks.get(size-1);
		return last.getCenter();
	}

	public int getOffsetX() {
		return logic.getOffsetX();
	}

	public int getOffsetY() {
		return logic.getOffsetY();
	}
	
	//Countable
	@Override	
	public int size() {
		return logic.getBricks().size();
	}

	@Override
	public boolean isEmpty() {
		// Currently not in use
		return false;
	}
}
