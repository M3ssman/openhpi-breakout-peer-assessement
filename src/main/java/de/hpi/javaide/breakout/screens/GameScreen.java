package de.hpi.javaide.breakout.screens;

import java.awt.Point;

import de.hpi.javaide.breakout.collision.CollisionLogic;
import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.elements.balldepot.BallDepot;
import de.hpi.javaide.breakout.elements.balldepot.BallDepotBuilder;
import de.hpi.javaide.breakout.elements.paddle.Paddle;
import de.hpi.javaide.breakout.elements.paddle.PaddleBuilder;
import de.hpi.javaide.breakout.elements.wall.Wall;
import de.hpi.javaide.breakout.elements.wall.WallBuilder;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;

/**
 * The Screen can be in three states, either the StartScreen, the GameScreen, or the EndScreen.
 * The game logic takes care, which of those is the currently active screen.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class GameScreen implements Screen  {

	/**
	 * This variable is needed for the Singleton pattern
	 */
	private static Screen instance;

	/**
	 * As we are in the actual game now, we need all the elements that are part of the game.
	 * Such as the BallDepotTest (containing the Balls), the currentBall (the BallDepotTest dispenses the one BallTest after the other to this variable),
	 * the PaddleTest, and the WallTest (containing all the Bricks) 
	 */
	private BallDepot ballDepot;
	
	private Ball currentBall;

	private Paddle paddle;
	
	private Wall wall;

	/** 
	 * Plus some UIObjects to display the score and the timer
	 */
//	private UIObject score;
//	private UIObject timer;
	
	/** 
	 * And of course a reference to access the Processing features
	 */
	private Game game;

	private GameScreen(Game game) {
		this.game = game;
		init();
	}

	/**
	 * GameScreen folgt dem Ansatz der "Lazy Instantiation" des Singleton Design
	 * Patterns (Gang of Four) Dieser Ansatz ist nicht "Thread safe", genügt
	 * hier aber unseren Ansprüchen.
	 * 
	 * @return the EndScreen
	 */
	public static Screen getInstance(Game game) {
		if (instance == null) {
			instance = new GameScreen(game);
		} else {
			instance.init();
		}
		return instance;
	}

	/**
	 * Initialize the GameScreen whenever the game is started again.
	 */
	@Override
	public void init() {
		ballDepot = new BallDepotBuilder(game).build();
		paddle = new PaddleBuilder(new Point(GameConstants.SCREEN_X / 2, GameConstants.SCREEN_Y - 200), game).build();
		wall = new WallBuilder(game).build();
//		score = new Score(game);
//		timer = new Timer(game);
		game.loop();
	}

	/**
	 * Update the GameScreen x times per second
	 */
	public void update() {
		if (currentBall != null) {
			currentBall.move();
			CollisionLogic.checkCollision(game, currentBall, paddle, wall);
		}
//		timer.update(null);
	}

	/**
	 * Display the updated state of the Game Screen x times per second
	 * Just delegate to the display Methods of the Objects to be displayed.
	 */
	@Override
	public void display() {
		ballDepot.display();
		if (currentBall != null) {
			currentBall.display();
		} else {
			// there is no more BallTest in the game and the depot is empty.
			if (ballDepot.isEmpty()) {
				ScreenManager.setScreen(game, Screen.END);
			}
		}
		paddle.display();
		wall.display();
//		score.display();
//		timer.display();
	}

	/**
	 * Take care of keyboard input
	 */
	@Override
	public void handleKeyPressed(String key) {
		switch (key) {
		case Screen.KEY_ENTER:
			currentBall = ballDepot.dispense();
			break;
		case Screen.KEY_SPACE:
		default:
			break;
		}
	}

	/**
	 * Take care of Mouse input
	 */
	@Override
	public void handleMouseDragged() {
		paddle.move(game.mouseX, game.pmouseX);
	}

	@Override
	public void increaseScore(int amount) {
		// cheap trick to convert an int to a String
		// (Hint: the update() Method expects an input argument of type String)
//		score.update(amount + "");
	}
}
