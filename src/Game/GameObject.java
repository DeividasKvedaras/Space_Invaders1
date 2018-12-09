package Game;

public class GameObject {
    private int objectX;
    private int objectY;

    public GameObject(int objectX, int objectY) {
        this.objectX = objectX;
        this.objectY = objectY;
    }

    public int getObjectX() {
        return objectX;
    }

    public void setObjectX(int objectX) {
        this.objectX = objectX;
    }

    public int getObjectY() {
        return objectY;
    }

    public void setObjectY(int objectY) {
        this.objectY = objectY;
    }
}
