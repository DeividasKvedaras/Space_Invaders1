import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Rules {

    private Shooter shooter;
    private ArrayList<Enemy> enemies;
    private ArrayList<Missile> missiles;

    public Rules(ArrayList<Enemy> enemies, Shooter shooter, ArrayList<Missile> missiles) {
        this.enemies = enemies;
        this.shooter = shooter;
        this.missiles = missiles;
    }

    public void isEnemyShotDown() {
        for (Enemy enemy : enemies) {
            if (missiles != null) {
                for (Iterator<Missile> iterator = missiles.iterator(); iterator.hasNext();) {
                    Missile missile = iterator.next();
                    if (enemy.getEnemyX() == missile.getMissileX() && enemy.getEnemyY() == missile.getMissileY()) {
                        enemy.setAlive(false);
                        iterator.remove();

                    }
                }
            }
        }
    }

    public Boolean hasEnemiesArrived() {
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyY() >= shooter.getShooterY() && enemy.getAlive()) {
                return true;
            }
        }
        return false;
    }
}
