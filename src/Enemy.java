public class Enemy {
    private int enemyX;
    private int enemyY;
    private Boolean isAlive = true;

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public Enemy(int enemyX, int enemyY) {
        this.enemyX = enemyX;
        this.enemyY = enemyY;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(int enemyX) {
        this.enemyX = enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(int enemyY) {
        this.enemyY = enemyY;
    }
}
