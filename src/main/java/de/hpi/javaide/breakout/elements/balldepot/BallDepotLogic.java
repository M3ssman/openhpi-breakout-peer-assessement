package de.hpi.javaide.breakout.elements.balldepot;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

class BallDepotLogic {

	
	BallDepotData data;
	
	/**
	 * the implementation of the interfaces has been moved to the class Ball.
	 * Only class BallDepot and BallDepotBuilder are accessible from outside of the package.
	 * Data, Display, and Logic are handling the inner workings.  
	 * 
	 * @param data
	 */
	BallDepotLogic(BallDepotData data) {
		this.data = data;
	}

	void initBallDepotData() {
		int width = Game.LIVES * data.getOffset();
		int height = data.getOffset();
		data.setDimension(new Dimension(width, height));
		
		int depotX = GameConstants.SCREEN_X - data.getWidth();
		int depotY = GameConstants.SCREEN_Y - data.getHeight();
		data.setPosition(new Point(depotX, depotY));
	}
	
	Point initBallPosition(int i) {
		return new Point(data.getX() + (i * data.getOffset()), data.getY());
	}

	ArrayList<Ball> getBalls() {
		return data.getBalls();
	}

	/**
	 * Dispense a BallTest out of the Depot into the game.
	 * Remove it from the depot.
	 * Pump it up.
	 * Move it to the start position.
	 * 
	 * If the depot is empty, return null.
	 * 
	 * @return BallTest the BallTest (to become the currentBall)
	 */
	 Ball dispense() {
		if (data.getBalls().size() > 0) {
			System.out.println("go");
			Ball currentBall = data.getBalls().remove(0);
			currentBall.addAir();
			currentBall.moveToStart();
			return currentBall;
		} else {
			// todo: GAME OVER
			return null;
		}
	}
	
	/**
	 * Determine if the depot is empty by delegating to the ArrayLists isEmpty method
	 * @return
	 */
	boolean isEmpty() {
		return data.getBalls().isEmpty();
	}
	
	int getX() {
		return data.getX() ;
	}

	int getY() {
		return data.getY();
	}

	int getWidth() {
		return data.getWidth();
	}

	int getHeight() {
		return data.getHeight();
	}

	int getOffset() {
		return data.getOffset();
	}

	void setPosition(Point position) {
		data.setPosition(position); 
	}

	void setDimension(Dimension dimension) {
		data.setDimension(dimension); 
	}

	public int size() {
		return data.getBalls().size();
	}
}
