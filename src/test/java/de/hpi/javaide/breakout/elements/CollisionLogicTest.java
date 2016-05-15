package de.hpi.javaide.breakout.elements;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollisionLogicTest {
	
	//Da es sich hier um einen Integrationtest handelt sollen die tatsächlichen beteiligten Klassen wie Ball oder Paddle unnd eren Methoden genutzt werden. 
	//Keine Mocks.
	
	@Before
	public void setUp() throws Exception { 
		//Hier könnt ihr euch alles beschaffen, was ihr in den kommenden Tests immer wieder braucht.
	}
	@Test
	public void itShouldBounceWhenItHitsThePaddle() {
		//Testet hier ob der Ball vom Paddle abprallt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldAdjustItsSpeedWhenItHitsThePaddle() {
		//Testet hier ob der Ball die Geschwindigkeit des Paddles übernimmt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldBounceWhenItHitsABrick() {
		//Testet hier ob der Ball vom Brick abprallt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldBounceWhenItHitsTheRightBoundaryOfTheGame() {
		//Testet hier ob der Ball vom rechten Spielfeldrand abprallt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldBounceWhenItHitsTheLeftBoundaryOfTheGame() {
		//Testet hier ob der Ball vom linken Spielfeldrand abprallt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldBounceWhenItHitsTheUpperBoundaryOfTheGame() {
		//Testet hier ob der Ball vom oberen Spielfeldrand abprallt.
		fail("Not yet implemented");
	}
	
	@Test
	public void itShouldBeRemovedFromTheGameWhenItPassesTheLowerBoundaryOfTheGame() {
		//Testet hier ob der Ball tatsächlich aus dem Spiel entfernt wird wenn er ins Aus geht.
		fail("Not yet implemented");
	}
}
