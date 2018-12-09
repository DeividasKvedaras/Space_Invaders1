package Game;

import java.util.ArrayList;
import java.util.Iterator;

public class Rules extends AbstractRules {

    public void isEnemyShotDown(ArrayList<GameObjectEnemy> enemies, ArrayList<GameObject> missiles, Score score) {
        for (GameObjectEnemy enemy : enemies) {
            if (missiles != null) {
                for (Iterator<GameObject> iterator = missiles.iterator(); iterator.hasNext(); ) {
                    GameObject missile = iterator.next();
                    if (enemy.getObjectX() == missile.getObjectX() && enemy.getObjectY() == missile.getObjectY() && enemy.getHealth()) {
                        enemy.setAlive(false);
                        iterator.remove();
                        score.addScore();
                    }
                }
            }
        }
    }

    public Boolean hasEnemiesArrived(GameObject shooter, ArrayList<GameObjectEnemy> enemies) {
        for (GameObjectEnemy enemy : enemies) {
            if (enemy.getObjectY() >= shooter.getObjectY() && enemy.getHealth()) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasPlayerWon( ArrayList<GameObjectEnemy> enemies){
        for(GameObjectEnemy enemy: enemies){
            if(enemy.getHealth()){
                return false;
            }
        }
        return true;
    }
}
