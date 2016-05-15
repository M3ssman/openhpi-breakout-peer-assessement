package de.hpi.javaide.breakout.elements.ball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import org.junit.Before;
import org.junit.Test;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

public class BallTest {

	private Ball ball;
	// some convenience values
	private int originalPosition = 0;
	private int leftBoundaryAtOP; // original position
	private int upperBoundaryAtOP;
	private int leftBoundaryAtSP; // start position
	private int upperBoundaryAtSP;

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
		
		BallLogic logic;
		BallData data;
		BallDisplay display;

		data = new BallData(new Point(originalPosition, originalPosition), new Dimension(10, 10), new Vector(2, 2));
		logic = new BallLogic(data);
		display = mock(BallDisplay.class);

		ball = new Ball(logic, display);
		
		leftBoundaryAtOP = originalPosition - logic.getSize() / 2;
		upperBoundaryAtOP = originalPosition - logic.getSize() / 2;
	}

	@Test
	public void itShouldInflate() {
		assertEquals("The ball should be deflated.", 10, ball.getSize());
		ball.addAir();
		assertEquals("The ball should be inflated.", ball.getFullSize(), ball.getSize());
	}

	@Test
	public void itShouldMoveToTheStartPosition() {
		assertEquals("The ball should be at it's original position (x).", leftBoundaryAtOP, ball.getLeftBoundary());
		assertEquals("The ball should be at it's original position (y).", upperBoundaryAtOP, ball.getUpperBoundary());
		ball.moveToStart();
		leftBoundaryAtSP = (int) (GameConstants.STARTPOSITION.getX() - ball.getSize() / 2);
		upperBoundaryAtSP = (int) (GameConstants.STARTPOSITION.getY() - ball.getSize() / 2);
		assertEquals("The ball should be at the start position (x).", leftBoundaryAtSP, ball.getLeftBoundary());
		assertEquals("The ball should be at the start position (y).", upperBoundaryAtSP, ball.getUpperBoundary());
	}

	@Test
	public void itShouldMoveDownwardsAtStart() {
		assertFalse("The ball should be moving downwards.", ball.isMovingUpwards());
	}

	@Test
	public void itShouldBounceUp() {
		assertFalse("The ball should be moving downwards.", ball.isMovingUpwards());
		ball.bounceY();
		assertTrue("The ball should be moving upwards after bouncing.", ball.isMovingUpwards());
	}

	@Test
	public void itShouldBounceDown() {
		ball.bounceY();
		assertTrue("The ball should be moving upwards.", ball.isMovingUpwards());
		ball.bounceY();
		assertFalse("The ball should be moving downwards after bouncing again.", ball.isMovingUpwards());
	}

	@Test
	public void itShouldBounceLeft() {
		assertTrue("The ball should be moving to the right.", ball.isMovingRight());
		ball.bounceX();
		assertTrue("The ball should be moving the left after bouncing.", ball.isMovingLeft());
	}

	@Test
	public void itShouldBounceRight() {
		ball.bounceX();
		assertTrue("The ball should be moving to the left.", ball.isMovingLeft());
		ball.bounceX();
		assertTrue("The ball should be moving the right after bouncing again.", ball.isMovingRight());
	}
	
	@Test
	public void itShouldChangeItsSpeed() {
		double expectedSpeed = 3.0;
		assertEquals("Initial speed should be " + expectedSpeed, expectedSpeed, ball.getSpeed(), 2);
		ball.changeSpeed(10);
		//TODO comment on the formula used or even better: use it
		expectedSpeed = 10.60;
		assertEquals("Initial speed should be " + expectedSpeed, expectedSpeed, ball.getSpeed(), 2);
	}
	
	@Test
	public void itShapeShouldIntersectWithAnotherShapeWhenAtTheSamePosition() {
		Brick brick = mock(Brick.class);
		//Create a brick as wide as the playground to make sure the ball does not fly by
		when(brick.getGeometry()).thenReturn(new Rectangle2D.Float(leftBoundaryAtSP, 0, Game.SCREEN_X, 20));
		when(brick.getCenter()).thenReturn(new Point(leftBoundaryAtSP, 10));
		ball.moveToStart();
		ball.bounceY();
		ball.noHorizontal();
		
		assertFalse(ball.intersects(brick.getGeometry()));
		while (ball.getUpperBoundary() >= brick.getCenter().getY()) {
			ball.move();
		}
		assertTrue(ball.intersects(brick.getGeometry()));
	}
}
