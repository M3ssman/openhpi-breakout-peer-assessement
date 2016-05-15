package de.hpi.javaide.breakout.screens;

import de.hpi.javaide.breakout.interfaces.Displayable;
import de.hpi.javaide.breakout.interfaces.Initializable;

/**
 * Provides a common interface for all Screen classes, so that we can easily switch between the states of the Screen.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public interface Screen extends Initializable, Displayable {
	String START = "start";
	String GAME = "game";
	String END = "end";

	String KEY_ENTER = "Enter key pressed";
	String KEY_SPACE = "Space key pressed";

	void handleKeyPressed(String key);

	void handleMouseDragged();

	void increaseScore(int amount);

	void update();
}
