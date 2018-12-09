package Game;

public class GameObjectEnemy extends GameObject{
    private Boolean isAlive = true;

    public GameObjectEnemy(int enemyX, int enemyY) {
        super(enemyX,enemyY);
    }

    public Boolean getHealth() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }
}
