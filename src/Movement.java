import java.util.ArrayList;

public class Movement {

    private Shooter shooter;
    private ArrayList<Enemy> enemies;
    private ArrayList<Missile> missiles;
    private Map map;

    private int enemyMovementDirection = 1;//1 - right, -1 - left
    private Boolean levelJustDecreased = true;

    public Movement(Shooter shooter, Map map, ArrayList<Enemy> enemies, ArrayList<Missile> missiles) {
        this.shooter = shooter;
        this.map = map;
        this.enemies = enemies;
        this.missiles = missiles;
    }

    public void readCommand(Command command) {
        switch (command) {
            case LEFT:
                moveShooter(-1);
                break;
            case RIGHT:
                moveShooter(1);
                break;
            case SPACE:
                shooterShoot();
                break;
        }
    }

    public void moveShooter(int direction) {
        int shooterXCord = shooter.getShooterX();
        int newShooterXCord = shooterXCord + direction;

        if (newShooterXCord != 0 && newShooterXCord != map.getWidth() - 1) {
            shooter.setShooterX(shooterXCord + direction);
        }
    }

    public void moveEnemy() {
        Enemy firstEnemy = enemies.get(0);
        Enemy lastEnemy = enemies.get(enemies.size() - 1);

        int firstEnemyX = firstEnemy.getEnemyX();
        int lastEnemyX = lastEnemy.getEnemyX();

        if (firstEnemyX == 1 || lastEnemyX == map.getWidth() - 2) {
            if (levelJustDecreased) {
                levelJustDecreased = !levelJustDecreased;
            } else {
                enemyMovementDirection *= -1;
                for (Enemy enemy : enemies) {
                    enemy.setEnemyY(enemy.getEnemyY() + 1);
                }
                levelJustDecreased = true;
            }
        }
        if (!levelJustDecreased) {
            for (Enemy enemy : enemies) {
                enemy.setEnemyX(enemy.getEnemyX() + enemyMovementDirection);
            }
        }
    }

    public void shooterShoot() {
        Missile missile = new Missile(shooter.getShooterX(), shooter.getShooterY()-1);
        missiles.add(missile);
    }

    public void moveMissiles(){
        for (Missile missile : missiles) {
            missile.setMissileY(missile.getMissileY() - 1);
        }
    }
}
