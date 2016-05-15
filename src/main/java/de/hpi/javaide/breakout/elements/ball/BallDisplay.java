package de.hpi.javaide.breakout.elements.ball;

import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
class BallDisplay {
	//The display just takes care of the display. Nothing else.
	/**
	 * a reference to the game class to provide access to the processing methods
	 */
	private Game game;
	private BallData data; 
	
	/**
	 * Create a Ball 
	 * 
	 * @param game Game reference to the Game that provides access to the Processing features 
	 * @param BallData data
	 */
	BallDisplay(Game game, BallData data) {
		this.game = game;
		this.data = data;
	}

	/**
	 * Define the method to draw the Ball. 
	 * Use the Processing features as provided from the game to do so.
	 * Uses the methods that are provided by the CollisionObject to access the 
	 */
	void display() {
		game.ellipseMode(PApplet.CENTER);
		game.strokeWeight(4);
		game.fill(data.getR(), data.getG(), data.getB());
		game.noStroke();
		game.ellipse(data.getX(), data.getY(), data.getWidth(), data.getHeight());
	}
}
