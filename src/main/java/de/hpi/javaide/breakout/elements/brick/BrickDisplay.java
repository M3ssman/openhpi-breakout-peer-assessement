package de.hpi.javaide.breakout.elements.brick;

import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

class BrickDisplay {

	/**
	 * a reference to the game class to provide access to the processing methods
	 */
	protected Game game;
	private BrickData data; 
	
	/**
	 * Create a new BrickTest at the given position.
	 * Pass a reference to access the Processing features.
	 * 
	 * @param game
	 * @param position
	 */
	BrickDisplay(Game game, BrickData data) {
		this.game = game;
		this.data = data;
	}

	/**
	 * Display the BrickTest. 
	 * Make it invisible if it's dead.
	 */
	void display() {
		game.rectMode(PApplet.CENTER);
		game.strokeWeight(4);
		game.noStroke();
		if (data.isDead()) {
			game.noFill();
		} else {
			game.fill(data.getR(), data.getG(), data.getB());
		}
		game.rect(data.getX(), data.getY(), data.getWidth(), data.getHeight());
	}
}
