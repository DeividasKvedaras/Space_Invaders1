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
    private Shooter shooter;
    private ArrayList<Enemy> enemies;
    private ArrayList<Missile> missiles;

    public GameRenderer(Map map, Shooter shooter, ArrayList<Enemy> enemies, ArrayList<Missile> missiles) throws Exception {
        this.map = map;
        this.shooter = shooter;
        this.enemies = enemies;
        this.missiles = missiles;

        shooterImg = ImageIO.read(new FileInputStream("shooter.jpg"));
        enemyImg = ImageIO.read(new FileInputStream("enemy.jpg"));
        sceneImg = ImageIO.read(new FileInputStream("scene.jpg"));
        missileImg = ImageIO.read(new FileInputStream("missile.png"));
    }

    void render(Graphics g) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                g.drawImage(sceneImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                if (shooter.getShooterX() == x && shooter.getShooterY() == y) {
                    g.drawImage(shooterImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                }
                for (Enemy enemy : enemies) {
                    if (enemy.getEnemyX() == x && enemy.getEnemyY() == y && enemy.getAlive()) {
                        g.drawImage(enemyImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                    }
                }
                if (missiles != null) {
                    for (Missile missile : missiles) {
                        if (missile.getMissileX() == x && missile.getMissileY() == y) {
                            g.drawImage(missileImg, 50 + x * 20, 50 + y * 20, 20, 20, null);
                        }
                    }
                }
            }
        }
    }
}
