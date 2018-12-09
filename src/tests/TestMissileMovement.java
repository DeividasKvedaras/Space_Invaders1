package tests;

import Game.GameObject;
import Game.GameObjectEnemy;
import Game.Map;
import Game.Movement;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestMissileMovement {
    ArrayList<GameObject> missiles = new ArrayList();

    @Test
    public void testMissileMovement() {
        Map map = new Map();
        Movement movement = new Movement(map);
        missiles.add(new GameObject(5, 4));
        movement.moveMissiles(missiles);
        for (GameObject missile : missiles) {
            Assert.assertEquals(missile.getObjectX(), 5);
            Assert.assertEquals(missile.getObjectY(), 3);
        }
    }
}