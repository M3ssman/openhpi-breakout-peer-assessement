package de.hpi.javaide.breakout.elements.balldepot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

public class BallDepotTest {

	private BallDepot ballDepot;
	private int leftBoundaryAtSP; // start position
	private int upperBoundaryAtSP;
	
	@Before
	public void setUp() throws Exception {
		BallDepotData data = new BallDepotData();		
		BallDepotLogic logic = new BallDepotLogic(data);
		logic.initBallDepotData();
		
		BallDepotDisplay display = mock(BallDepotDisplay.class);
		Game game = mock(Game.class);
		ballDepot = new BallDepot(logic, display, game); 
	}

	@Test
	public void itShouldContainTheSpecifiedAmountOfBalls() {
		assertEquals("BallDepot not correctly filled up", Game.LIVES, ballDepot.size());
	}
	
	@Test
	public void itShouldContainOneBallLessWhenABallIsStarted() {
		assertEquals("BallDepot not correctly filled up at start", Game.LIVES, ballDepot.size());
		ballDepot.dispense();
		assertEquals("Ball not dispensed", Game.LIVES - 1, ballDepot.size());
	}
	
	@Test
	public void itShouldBeEmptyWhenAllBallsHaveBeenUsed() {
		assertEquals("BallDepot not correctly filled up at start", Game.LIVES, ballDepot.size());
		for (int i = 0; i < Game.LIVES; i++) {
			ballDepot.dispense();
		}
		assertTrue("BallDepot should be empty",  ballDepot.isEmpty());
	}
	
	@Test
	public void itShouldInflateTheBallWhenItIsStarted() {
		Ball currentBall = ballDepot.dispense();
		assertEquals("Ball should be inflated when moved to start.", currentBall.getFullSize(), currentBall.getSize());
	}

	@Test
	public void itShouldMoveTheBallToTheStartPositionWhenItIsStarted() {
		Ball currentBall = ballDepot.dispense();

		leftBoundaryAtSP = (int) (GameConstants.STARTPOSITION.getX() - currentBall.getSize() / 2);
		upperBoundaryAtSP = (int) (GameConstants.STARTPOSITION.getY() - currentBall.getSize() / 2);
		
		assertEquals("Ball should be moved to start.", leftBoundaryAtSP, currentBall.getLeftBoundary());
		assertEquals("Ball should be moved to start.", upperBoundaryAtSP, currentBall.getUpperBoundary());
	}
}
