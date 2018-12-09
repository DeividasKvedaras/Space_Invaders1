package tests;

import Game.Score;
import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {
    private int expected_value_test_one = 1;
    private int expected_value_test_two = 2;
    private int expected_value_test_three = 4;

    static Score score = new Score();

    @Test
    public void scoreTest(){
        score.addScore();
        Assert.assertEquals(score.getScore(), expected_value_test_one);
        score.addScore();
        Assert.assertEquals(score.getScore(), expected_value_test_two);
        score.addScore();
        score.addScore();
        Assert.assertEquals(score.getScore(), expected_value_test_three);
    }


}