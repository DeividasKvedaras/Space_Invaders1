package Game;

import java.util.ArrayList;

public class Movement {

    private Map map;

    private int enemyMovementDirection = 1;//1 - right, -1 - left
    private Boolean levelJustDecreased = true;

    public Movement(Map map) {
        this.map = map;
    }

    public void readCommand(Command command, GameObject shooter, ArrayList<GameObject> missiles) {
        switch (command) {
            case LEFT:
                moveShooter(-1, shooter);
                break;
            case RIGHT:
                moveShooter(1, shooter);
                break;
            case SPACE:
                shooterShoot(shooter, missiles);
                break;
        }
    }

    public void moveShooter(int direction, GameObject shooter) {
        int shooterXCord = shooter.getObjectX();
        int newShooterXCord = shooterXCord + direction;

        if (newShooterXCord != 0 && newShooterXCord != map.getWidth() - 1) {
            shooter.setObjectX(newShooterXCord);
        }
    }

    public void moveEnemy(ArrayList<GameObjectEnemy> enemies) {
        GameObject firstEnemy = enemies.get(0);
        GameObject lastEnemy = enemies.get(enemies.size() - 1);

        int firstEnemyX = firstEnemy.getObjectX();
        int lastEnemyX = lastEnemy.getObjectX();

        if (firstEnemyX == 1 || lastEnemyX == map.getWidth() - 2) {
            if (levelJustDecreased) {
                levelJustDecreased = !levelJustDecreased;
            } else {
                enemyMovementDirection *= -1;
                for (GameObjectEnemy enemy : enemies) {
                    enemy.setObjectY(enemy.getObjectY() + 1);
                }
                levelJustDecreased = true;
            }
        }
        if (!levelJustDecreased) {
            for (GameObjectEnemy enemy : enemies) {
                enemy.setObjectX(enemy.getObjectX() + enemyMovementDirection);
            }
        }
    }

    public void moveEnemy(boolean powerup) {
        //Bus atliktas su powerup funkcionalumu.
    }

    public void shooterShoot(GameObject shooter,  ArrayList<GameObject> missiles) {
        GameObject missile = new GameObject(shooter.getObjectX(), shooter.getObjectY() - 1);
        missiles.add(missile);
    }

    public void moveMissiles(ArrayList<GameObject> missiles) {
        for (GameObject missile : missiles) {
            missile.setObjectY(missile.getObjectY() - 1);
        }
    }
}
