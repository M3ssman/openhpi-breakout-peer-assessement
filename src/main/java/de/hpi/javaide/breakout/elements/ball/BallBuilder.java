package de.hpi.javaide.breakout.elements.ball;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.interfaces.Builder;
import de.hpi.javaide.breakout.starter.Game;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class BallBuilder implements Builder<Ball> {
	
	Point initialPosition;
	Dimension initialSize;
	Vector initialDirection;
	Game game;
	
	public BallBuilder(Point initialPosition, Dimension initialSize, Vector initialDirection, Game game) {
		this.initialPosition = initialPosition;
		this.initialSize = initialSize;
		this.initialDirection = initialDirection;
		this.game = game;
	}
	
	public Ball build() {
		//Wire the components of the ball
		BallData data = new BallData(
				initialPosition,
				initialSize,
				initialDirection);
		BallLogic logic = new BallLogic(data);
		BallDisplay display = new BallDisplay(game, data);
		Ball ball = new Ball(logic, display); 
		return ball;
	}

}
