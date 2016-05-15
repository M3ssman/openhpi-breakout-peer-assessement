package de.hpi.javaide.breakout.elements.balldepot;

import de.hpi.javaide.breakout.interfaces.Builder;
import de.hpi.javaide.breakout.starter.Game;

public class BallDepotBuilder implements Builder<BallDepot> {

	Game game;
	
	public BallDepotBuilder(Game game) {
		this.game = game;
	}
	
	@Override
	public BallDepot build() {

		BallDepotData data = new BallDepotData();		
		BallDepotLogic logic = new BallDepotLogic(data);
		logic.initBallDepotData();
		
		BallDepotDisplay display = new BallDepotDisplay(data);
		BallDepot ballDepot = new BallDepot(logic, display, game); 
		return ballDepot;
	}

}
