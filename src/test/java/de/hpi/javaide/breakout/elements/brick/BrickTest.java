/**
 * 
 */
package de.hpi.javaide.breakout.elements.brick;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import org.junit.Before;
import org.junit.Test;

import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.elements.brick.BrickLogic;
import de.hpi.javaide.breakout.elements.brick.BrickData;
import de.hpi.javaide.breakout.elements.brick.BrickDisplay;
import de.hpi.javaide.breakout.starter.Game;

public class BrickTest {

	private Brick brick;
	private Point brickPosition;


	@Before
	public void setUp() throws Exception {
		// Given:
		// 1. We start modeling our System by modeling the data structure
		// (Data)
		// 2. The data only consists of Getters and Setters to read and write
		// the data
		// (no business logic)
		// 3. Getters and Setters do not need to be tested
		// 4. the Display can easily be mocked
		BrickLogic logic;
		BrickData data;
		BrickDisplay display;

		brickPosition = new Point(10, 10);
		data = new BrickData(brickPosition, new Dimension(Brick.WIDTH, Brick.HEIGHT));
		logic = new BrickLogic(data);
		display = mock(BrickDisplay.class);

		brick = new Brick(logic, display);
	}

	@Test
	public void itInitialStatusShouldCorrespondToTheAmountOfLives() {
		assertEquals("Initial status differs from the amount of lives as set in the game.", Game.LIVES, brick.getStatus());
	}

	@Test
	public void itsNextStatusShouldBeLessThanThePreviousOne() {
		assertEquals("Initial status differs from the amount of lives as set in the game.", Game.LIVES, brick.getStatus());
		brick.nextStatus();
		assertEquals("Initial status differs from the amount of lives as set in the game.", Game.LIVES - 1, brick.getStatus());
	}


	@Test
	public void itShouldBeDeadWhenStatusIsZero() {
		assertEquals("Initial status differs from the amount of lives as set in the game.", Game.LIVES, brick.getStatus());
		for (int i = 0; i < Game.LIVES; i++) {
			brick.nextStatus();
		}
		assertTrue("Brick is dead when hit often enough.",  brick.isDead());

	}

	//This is already tested for the ball, but just to make sure.
	@Test
	public void itShapeShouldIntersectWithAnotherShapeWhenAtTheSamePosition() {
		Ball ball = mock(Ball.class);
		int ballSize = 30;
		//put the mocked ball somewhere else
		when(ball.getGeometry()).thenReturn(new Ellipse2D.Float(300, 300, ballSize, ballSize));
		assertFalse("At this position ball should not intersect with brick.", brick.intersects(ball.getGeometry()));

		//put the mocked ball on the brick
		when(ball.getGeometry()).thenReturn(new Ellipse2D.Float(-40, 5, ballSize, ballSize));
		assertTrue("At this position ball should intersect with brick.", brick.intersects(ball.getGeometry()));
	}
}
