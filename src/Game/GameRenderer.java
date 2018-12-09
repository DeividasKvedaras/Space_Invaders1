package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GameRenderer {

    private BufferedImage shooterImg;
    private BufferedImage enemyImg;
    private BufferedImage sceneImg;
    private BufferedImage missileImg;
    private Map map;

    public GameRenderer(Map map) throws Exception {
        this.map = map;

        shooterImg = ImageIO.read(new FileInputStream("shooter.jpg"));
        enemyImg = ImageIO.read(new FileInputStream("enemy.jpg"));
        sceneImg = ImageIO.read(new FileInputStream("scene.jpg"));
        missileImg = ImageIO.read(new FileInputStream("missile.png"));
    }

    void render(Graphics g, GameObject shooter, ArrayList<GameObjectEnemy> enemies, ArrayList<GameObject> missiles) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                g.drawImage(sceneImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                if (shooter.getObjectX() == x && shooter.getObjectY() == y) {
                    g.drawImage(shooterImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                }
                for (GameObjectEnemy enemy : enemies) {
                    if (enemy.getObjectX() == x && enemy.getObjectY() == y && enemy.getHealth()) {
                        g.drawImage(enemyImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                    }
                }
                if (missiles != null) {
                    for (GameObject missile : missiles) {
                        if (missile.getObjectX() == x && missile.getObjectY() == y) {
                            g.drawImage(missileImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                        }
                    }
                }
            }
        }
    }
}
