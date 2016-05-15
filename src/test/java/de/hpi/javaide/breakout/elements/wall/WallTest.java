package de.hpi.javaide.breakout.elements.wall;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.starter.Game;

public class WallTest {

	private Wall wall;
	
	@Before
	public void setUp() throws Exception {
		WallData data = new WallData();		
		
		WallLogic logic = new WallLogic(data);
		logic.initWallData();
		
		WallDisplay display = mock(WallDisplay.class);
		Game game = mock(Game.class);
		wall = new Wall(logic, display, game); 
	}

	@Test
	public void itShouldContainTheSpecifiedAmountOfBricks() {
		int numberOfBricks = Game.WALL_WIDTH * Game.WALL_HEIGHT;
		assertEquals("Wrong amount of bricks in wall.", numberOfBricks, wall.size());
	}
	
	@Test
	public void itShouldContainTheSpecifiedArrangementOfBricks() {
		assertEquals("X of first Brick should be at offset.", wall.getOffsetX(), wall.getPositionFirst().x);
		assertEquals("Y of first Brick should be at offset.", wall.getOffsetY(), wall.getPositionFirst().y);
		
		int expectedXLast = (Game.WALL_WIDTH - 1) * (Brick.WIDTH + Brick.OFFSET) + wall.getOffsetX();
		int expectedYLast = (Game.WALL_HEIGHT - 1) * (Brick.HEIGHT + Brick.OFFSET) + wall.getOffsetY();
		assertEquals("X of last Brick should be at offset.", expectedXLast, wall.getPositionLast().x);
		assertEquals("Y of last Brick should be at offset.", expectedYLast, wall.getPositionLast().y);
	}

}
