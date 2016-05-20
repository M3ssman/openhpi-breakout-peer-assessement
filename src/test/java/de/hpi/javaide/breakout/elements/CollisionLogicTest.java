package de.hpi.javaide.breakout.elements;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;
import static org.junit.Assert.*;

import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.collision.CollisionLogic;
import de.hpi.javaide.breakout.elements.ball.*;
import de.hpi.javaide.breakout.elements.balldepot.BallDepot;
import de.hpi.javaide.breakout.elements.balldepot.BallDepotBuilder;
import de.hpi.javaide.breakout.elements.brick.Brick;
import de.hpi.javaide.breakout.elements.brick.BrickBuilder;
import de.hpi.javaide.breakout.elements.paddle.Paddle;
import de.hpi.javaide.breakout.elements.paddle.PaddleBuilder;
import de.hpi.javaide.breakout.elements.wall.Wall;
import de.hpi.javaide.breakout.elements.wall.WallBuilder;
import de.hpi.javaide.breakout.screens.GameScreen;
import de.hpi.javaide.breakout.starter.Game;
import de.hpi.javaide.breakout.starter.GameConstants;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class CollisionLogicTest {

    //Da es sich hier um einen Integrationtest handelt sollen die tatsächlichen beteiligten Klassen wie Ball oder Paddle unnd eren Methoden genutzt werden.
    //Keine Mocks.
//    Ball currentBall;
    Wall wall;
    Game game;
    Paddle defaultPaddle;

    @Before
    public void setUp() throws Exception {
        game = new Game();

        wall = new WallBuilder(game).build();
        Point paddlePosition = new Point(50, 90);
        defaultPaddle = new PaddleBuilder(paddlePosition, game).build();
    }

    //Testet hier ob der Ball vom Paddle abprallt.
    @Test
    public void itShouldBounceWhenItHitsThePaddle() {
        Point initialPosition = new Point(50, 90);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(0, 10);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();

        Point paddlePosition = new Point(50, 90);
        Paddle paddle = new PaddleBuilder(paddlePosition, game).build();
        assertThat(currentBall.isMovingUpwards(), is(Boolean.FALSE));

        CollisionLogic.checkCollision(game, currentBall, paddle, wall);
        assertThat(currentBall.isMovingUpwards(), is(Boolean.TRUE));
    }

    //Testet hier ob der Ball die Geschwindigkeit des Paddles übernimmt.
    @Test
    public void itShouldAdjustItsSpeedWhenItHitsThePaddle() {
        Point initialPosition = new Point(48, 88);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(10, 10);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.isMovingRight(), is(Boolean.TRUE));
        assertEquals(14.14, currentBall.getSpeed(), 0.1);

        Point paddlePosition = new Point(45, 90);
        Paddle paddle = new PaddleBuilder(paddlePosition, game).build();
        paddle.move(55,45);

        CollisionLogic.checkCollision(game, currentBall, paddle, wall);
        assertThat(currentBall.isMovingUpwards(), is(Boolean.TRUE));
        assertEquals(10, currentBall.getSpeed(), 0.1);
    }


    //Testet hier ob der Ball vom Brick abprallt.
    @Test
    public void itShouldBounceWhenItHitsABrick() {
        Point initialPosition = new Point(390, 69);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(0, -10);
        game.width = GameConstants.SCREEN_X;
        game.height = GameConstants.SCREEN_Y;
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.isMovingUpwards(), is(Boolean.TRUE));
        Brick brick = getTheRightBrick();
        assertThat(brick, not( nullValue()));
        assertEquals(3, brick.getStatus());

        Point paddlePosition = new Point(500, 500);
        Paddle paddle = new PaddleBuilder(paddlePosition, game).build();

        CollisionLogic.checkCollision(game, currentBall, paddle, wall);

        assertThat(currentBall.isMovingUpwards(), is(Boolean.FALSE));
        assertEquals(2, brick.getStatus());
    }

    private Brick getTheRightBrick() {
        for (Brick brick: wall) {
            if(isTheBrickWeCareAbout(brick)) {
                return brick;
            }
        }
        return null;
    }

    private boolean isTheBrickWeCareAbout(Brick brick) {
        return brick.getCenter().getX() == 390 && brick.getCenter().getY() == 60;
    }

    //Testet hier ob der Ball vom rechten Spielfeldrand abprallt.
    @Test
    public void itShouldBounceWhenItHitsTheRightBoundaryOfTheGame() {
        Point initialPosition = new Point(96, 50);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(10, 0);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.isMovingRight(), is(Boolean.TRUE));
        assertThat(currentBall.isMovingLeft(), is(Boolean.FALSE));

        CollisionLogic.checkCollision(game, currentBall, defaultPaddle, wall);

        assertThat(currentBall.isMovingRight(), is(Boolean.FALSE));
        assertThat(currentBall.isMovingLeft(), is(Boolean.TRUE));
    }

    //Testet hier ob der Ball vom linken Spielfeldrand abprallt.
    @Test
    public void itShouldBounceWhenItHitsTheLeftBoundaryOfTheGame() {
        Point initialPosition = new Point(4, 50);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(-10, 0);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.isMovingLeft(), is(Boolean.TRUE));
        assertThat(currentBall.isMovingRight(), is(Boolean.FALSE));

        CollisionLogic.checkCollision(game, currentBall, defaultPaddle, wall);

        assertThat(currentBall.isMovingRight(), is(Boolean.TRUE));
        assertThat(currentBall.isMovingLeft(), is(Boolean.FALSE));
    }

    //Testet hier ob der Ball vom oberen Spielfeldrand abprallt.
    @Test
    public void itShouldBounceWhenItHitsTheUpperBoundaryOfTheGame() {
        Point initialPosition = new Point(50, 4);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(0, -10);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.isMovingUpwards(), is(Boolean.TRUE));

        CollisionLogic.checkCollision(game, currentBall, defaultPaddle, wall);

        assertThat(currentBall.isMovingUpwards(), is(Boolean.FALSE));
    }

    //Testet hier ob der Ball tatsächlich aus dem Spiel entfernt wird wenn er ins Aus geht.
    @Test
    public void itShouldBeRemovedFromTheGameWhenItPassesTheLowerBoundaryOfTheGame() {
        Point initialPosition = new Point(50, 90);
        Dimension initialSize = new Dimension(10, 10);
        Vector initialDirection = new Vector(0, 5);
        Ball currentBall = new BallBuilder(initialPosition, initialSize, initialDirection, game).build();
        assertThat(currentBall.getCenter().getY(), is(90.0));
        assertThat(currentBall.isMovingUpwards(), is(Boolean.FALSE));

        GameScreen gameScreen = (GameScreen) GameScreen.getInstance(game);
        BallDepot depot = gameScreen.getBallDepot();
        assertThat(depot.size() , is(3));

        currentBall.move();
        assertThat(currentBall.getCenter().getY(), is(95.0));

        currentBall.move();
        assertThat(currentBall.getCenter().getY(), is(100.0));

        currentBall.move();
        assertThat(currentBall.getCenter().getY(), is(105.0));

        currentBall.move();
        assertThat(currentBall.getCenter().getY(), is(110.0));

        CollisionLogic.checkBallGone(game,currentBall,depot);
        assertThat(depot.size() , is(2));
    }
}
