package de.hpi.javaide.breakout.elements.paddle;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import org.junit.Before;
import org.junit.Test;

import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.starter.Game;

public class PaddleTest {

	private Paddle paddle;
	
	@Before
	public void setUp() throws Exception {
		PaddleData data = new PaddleData(new Point(Game.SCREEN_X / 2, Game.SCREEN_Y - 200), new Dimension(Paddle.WIDTH, Paddle.HEIGHT));
		PaddleLogic logic = new PaddleLogic(data);
		PaddleDisplay display = mock(PaddleDisplay.class);
		paddle = new Paddle(logic, display); 
	}
	
	@Test
	public void itShouldHaveAnInitialSpeedOfZero() {
		assertEquals("Initial Speed not set where it should have been set.", Game.INITIAL_SPEED, paddle.getSpeed(), 2);
	}
	
	@Test
	public void itShouldChangeSpeed() {
		int mouseX = 100;
		int pmouseX = 80;
		paddle.move(mouseX, pmouseX);
		assertEquals("Speed has not changed when it should have.", 20, paddle.getSpeed(), 2);
	}

	@Test
	public void itShouldMoveTotheGivenPosition() {
		int mouseX = 100;
		int pmouseX = 80;
		paddle.move(mouseX, pmouseX);
		assertEquals("Paddle has not been moved where it should have.", 100, paddle.getCenter().x);
	}
	
	//This is already tested for the ball, but just to make sure.
	@Test
	public void itShapeShouldIntersectWithAnotherShapeWhenAtTheSamePosition() {
		Ball ball = mock(Ball.class);
		int ballSize = 30;
		//put the mocked ball somewhere else
		when(ball.getGeometry()).thenReturn(new Ellipse2D.Float(0, 0, ballSize, ballSize));
		assertFalse("At this position ball should not intersect with brick.", paddle.intersects(ball.getGeometry()));

		//put the mocked ball on the brick
		when(ball.getGeometry()).thenReturn(new Ellipse2D.Float(Game.SCREEN_X / 2, Game.SCREEN_Y - 200, ballSize, ballSize));
		assertTrue("At this position ball should intersect with brick.", paddle.intersects(ball.getGeometry()));
	}
}
