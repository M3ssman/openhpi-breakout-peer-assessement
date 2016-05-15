package de.hpi.javaide.breakout.elements.brick;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.starter.Game;

public class BrickBuilder {
	Point position;
	Game game;
	
	public BrickBuilder(Point position, Game game) {
		this.position = position;
		this.game = game;
	}
	
	public Brick build() {
		BrickData data = new BrickData(position, new Dimension(Brick.WIDTH, Brick.HEIGHT));
		BrickLogic logic = new BrickLogic(data);
		BrickDisplay display = new BrickDisplay(game, data);
		Brick brick = new Brick(logic, display); 
		return brick;
	}
}
