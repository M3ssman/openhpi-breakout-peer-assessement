package de.hpi.javaide.breakout.elements.wall;

import de.hpi.javaide.breakout.interfaces.Builder;
import de.hpi.javaide.breakout.starter.Game;

public class WallBuilder implements Builder<Wall> {

	Game game;
	//TODO Move Game to build method
	
	public WallBuilder(Game game) {
		this.game = game;
	}
	
	@Override
	public Wall build() {

		WallData data = new WallData();		
		WallLogic logic = new WallLogic(data);
		logic.initWallData();
		
		WallDisplay display = new WallDisplay(data);
		Wall wall = new Wall(logic, display, game); 
		return wall;
	}
	
	
	
	
}
