package de.hpi.javaide.breakout.elements.paddle;

import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

class PaddleDisplay {
	/**
	 * a reference to the game class to provide access to the processing methods
	 */
	private Game game;
	private PaddleData data;
	
	/**
	 * Create a new BrickTest at the given position.
	 * Pass a reference to access the Processing features.
	 * 
	 * @param game
	 * @param position
	 */
	PaddleDisplay(Game game, PaddleData data) {
		this.game = game;
		this.data = data;
	}
	
	void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(data.getR(), data.getG(), data.getB());
		game.rect(data.getX(), data.getY(), data.getWidth(), data.getHeight());
	}
}
