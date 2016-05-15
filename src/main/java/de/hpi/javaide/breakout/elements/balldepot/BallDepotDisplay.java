package de.hpi.javaide.breakout.elements.balldepot;

import de.hpi.javaide.breakout.elements.ball.Ball;

class BallDepotDisplay {
	
	private BallDepotData data; 
	
	/**
	 * Create a BallTest at the given position with size 10,10 (depotSize).
	 * The fullSize of the BallTest will be 30, 30 (gameSize).
	 * The color of the BallTest is somewhat reddish
	 * 
	 * @param game Game reference to the Game that provides access to the Processing features 
	 * @param position Position x,y 
	 */
	BallDepotDisplay(BallDepotData data) {
		this.data = data;
	}

	/**
	 * Display the depot by displaying the Balls
	 */
	void display() {
		for (Ball ball : data.getBalls()) {
			ball.display();
		}
	}
}
