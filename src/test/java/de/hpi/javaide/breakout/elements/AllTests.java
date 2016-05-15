package de.hpi.javaide.breakout.elements;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.hpi.javaide.breakout.elements.ball.BallTest;
import de.hpi.javaide.breakout.elements.balldepot.BallDepotTest;
import de.hpi.javaide.breakout.elements.brick.BrickTest;
import de.hpi.javaide.breakout.elements.wall.WallTest;
import de.hpi.javaide.breakout.elements.paddle.PaddleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CollisionLogicTest.class,
	//also run the unit tests
	BallTest.class,
	BrickTest.class,
	PaddleTest.class,
	WallTest.class,
	BallDepotTest.class
})

public class AllTests {}
