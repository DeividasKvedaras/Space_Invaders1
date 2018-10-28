import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener {

    Map map = new Map();
    ArrayList<Enemy> enemies = new ArrayList();
    ArrayList<Missile> missiles = new ArrayList();
    Shooter shooter = new Shooter(map.getWidth() / 2, map.getHeight() - 2);
    UserInput userInput = new UserInput();
    Rules gameRules = new Rules(enemies, shooter, missiles);
    Movement movement = new Movement(shooter, map, enemies, missiles);
    GameRenderer gameRenderer = new GameRenderer(map, shooter, enemies, missiles);

    public Game() throws Exception {
        super.setPreferredSize(new Dimension(400, 400));
        super.pack();
        super.setVisible(true);
        super.addKeyListener(this);
        for (int i = 0; i < 10; i += 2) {
            for (int j = 0; j < 5; j++) {
                Enemy enemy = new Enemy(1 + i, 1 + j);
                enemies.add(enemy);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        gameRenderer.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            movement.moveEnemy();
            gameRules.isEnemyShotDown();
            movement.moveMissiles();
            Command command = userInput.getCommand(e.getKeyChar());
            movement.readCommand(command);

            if (gameRules.hasEnemiesArrived()) {
                System.out.println("Game overd");
                System.exit(0);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
