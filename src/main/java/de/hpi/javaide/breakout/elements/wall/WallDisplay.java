package de.hpi.javaide.breakout.elements.wall;

import de.hpi.javaide.breakout.elements.brick.Brick;

class WallDisplay {

	private WallData data;
	
	WallDisplay(WallData data) {
		this.data = data;
	}

	/**
	 * Display the wall by displaying its Bricks
	 */
	void display() {
		for (Brick b : data.getBricks()) {
			if (b != null)
				b.display();
		}
	}
}
