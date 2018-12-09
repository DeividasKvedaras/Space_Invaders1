package Game;

import java.util.ArrayList;

abstract class AbstractRules {
    abstract void isEnemyShotDown(ArrayList<GameObjectEnemy> enemies, ArrayList<GameObject> missiles, Score score);

    abstract Boolean hasEnemiesArrived(GameObject shooter, ArrayList<GameObjectEnemy> enemies);
}
