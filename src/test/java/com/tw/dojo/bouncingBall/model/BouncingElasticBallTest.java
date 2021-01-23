package com.tw.dojo.bouncingBall.model;

import org.junit.jupiter.api.Test;

import static com.tw.dojo.bouncingBall.BallTestHarness.*;

public class BouncingElasticBallTest {
    @Test
    public void shouldGoDown() {
        Ball bouncingElasticBall = BallFactory.bouncingElasticBall(0, 0, Bounce.DOWN, Elastic.SHRINK);

        bouncingElasticBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(0), bouncingElasticBall);
    }

    @Test
    public void shouldDecreaseRadius() {
        Ball bouncingElasticBall = BallFactory.bouncingElasticBall(0, 0, Bounce.DOWN, Elastic.SHRINK);

        bouncingElasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(Ball.DEFAULT_RADIUS), bouncingElasticBall);
    }

    @Test
    public void shouldGoDownAndDecreaseRadius() {
        Ball bouncingElasticBall = BallFactory.bouncingElasticBall(0, 0, Bounce.DOWN, Elastic.SHRINK);

        bouncingElasticBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(0), bouncingElasticBall);
        assertRadiusIs(oneStepInwardsFrom(Ball.DEFAULT_RADIUS), bouncingElasticBall);
    }

}
