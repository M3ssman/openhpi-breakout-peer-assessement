package de.hpi.javaide.breakout.collision;

import de.hpi.javaide.breakout.elements.ball.Ball;
import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.elements.paddle.Paddle;
import de.hpi.javaide.breakout.elements.wall.Wall;
import de.hpi.javaide.breakout.interfaces.Geometric;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Static Class. Provides a method that handles collisions by calling the "hooks" that are provided by the CollisionObjects.
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class CollisionLogic {
	/**
	 * Make sure the Class is not instantiated
	 */
	private CollisionLogic() {
	}

	/**
	 * Check if any of the CollisionObjects collides with another one. 
	 * Hand the action back to the CollisionObject.
	 * 
	 * @param game Game provides access to the Processing methods
	 * @param currentBall Ball the current ball
	 * @param paddle Paddle the paddle
	 * @param wall Wall the wall
	 */
	public static void checkCollision(Game game, Ball currentBall, Paddle paddle, Wall wall) {
		if (collidesWithSideBoundary(game, currentBall)) {
			currentBall.bounceX();
//			System.out.println("ball bounced x");
		} else if (collidesWithTopBoundary(game, currentBall)) {
			currentBall.bounceY();
//			System.out.println("ball bounced y");
		} else if (collidesWithPaddle(currentBall, paddle)) {
			// System.out.println("GS.update - PaddleCollision detected");
			currentBall.bounceY();
			currentBall.changeSpeed(paddle.getSpeed());
		} else {
			for (Brick brick : wall) {
				if (collidesWithBrick(currentBall, brick)) {
					if (!brick.isDead()) {
						if (currentBall.isMovingUpwards()) {
							brick.nextStatus();
							game.increaseScore(1);
						}
						currentBall.bounceY();
					}
				}
			}
		}
	}

	/**
	 * Internal helper methods to provide speaking names for the actual decision making.
	 */
	protected static boolean collidesWithSideBoundary(Game game, Ball currentBall) {
        return 0 > currentBall.getLeftBoundary() || game.width < currentBall.getLeftBoundary();
	}

	protected static boolean collidesWithTopBoundary(Game game, Ball ball) {
		return 0 > ball.getUpperBoundary();
	}

	protected static boolean collidesWithPaddle(Ball ball, Geometric paddle) {
		return ball.intersects(paddle.getGeometry());
	}

	protected static boolean collidesWithBrick(Ball ball, Geometric brick) {
		return ball.intersects(brick.getGeometry());
	}
}
