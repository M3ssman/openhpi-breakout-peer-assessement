package de.hpi.javaide.breakout.elements.balldepot;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.elements.ball.BallBuilder;
import de.hpi.javaide.breakout.interfaces.Countable;
import de.hpi.javaide.breakout.interfaces.Dimensionable;
import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Measureable;
import de.hpi.javaide.breakout.interfaces.Positionable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class BallDepot implements Displayable, Measureable, Positionable, Dimensionable, Countable  {

	private BallDepotLogic logic;
	private BallDepotDisplay display;
	
	public  BallDepot(BallDepotLogic logic, BallDepotDisplay display, Game game) {

		this.logic = logic;
		this.display = display;
		
		for (int i = 0; i < Game.LIVES; i++) {
			Ball ball = new BallBuilder(
					logic.initBallPosition(i),
					new Dimension(10, 10),
					new Vector(2, 2),
					game
					).build();
			logic.getBalls().add(ball);
		}
	}
		
	public Ball dispense() {
		return logic.dispense();
	}
	
	//Measurable
	@Override
	public int getX() {
		return logic.getX();
	}
	@Override
	public int getY() {
		return logic.getY();
	}
	@Override
	public int getWidth() {
		return logic.getWidth();
	}
	@Override
	public int getHeight() {
		return logic.getHeight();
	}
	
	//Positionable
	@Override
	public void setPosition(Point position) {
		logic.setPosition(position);
	}
	
	//Dimensionable
	@Override
	public void setDimension(Dimension dimension) {
		logic.setDimension(dimension);
	}
	
	//Displayable
	/**
	 * Display the depot by displaying the Balls
	 */
	@Override
	public void display() {
		display.display();
	}
	
	//Countable
	@Override
	public int size() {
		return logic.size();
	}
	@Override
	public boolean isEmpty() {
		return logic.isEmpty();
	}
	
}
