package de.hpi.javaide.breakout.elements.paddle;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.interfaces.Builder;
import de.hpi.javaide.breakout.starter.Game;

public class PaddleBuilder implements Builder<Paddle> {
	
	Point position;
	Game game;
	
	public PaddleBuilder(Point position, Game game) {
		this.position = position;
		this.game = game;
	}
	
	public Paddle build() {
		//TODO - do the wiring. Build the paddle from a Data, a Display, and Logic.
		//In doubt, have a look at the implementation of the Ball or the Brick.  
		return null;
	}

}
