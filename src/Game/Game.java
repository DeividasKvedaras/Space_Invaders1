package Game;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener {
    Map map = new Map();
    ArrayList<GameObjectEnemy> enemies = new ArrayList();
    ArrayList<GameObject> missiles = new ArrayList();
    GameObject shooter = new GameObject(map.getWidth() / 2, map.getHeight() - 2);
    UserInput userInput = new UserInput();
    Rules gameRules = new Rules();
    Movement movement = new Movement(map);
    GameRenderer gameRenderer = new GameRenderer(map);
    Score score = new Score();

    public Game() throws Exception {
        super.setPreferredSize(new Dimension(400, 400));
        super.pack();
        super.setVisible(true);
        super.addKeyListener(this);
        for (int i = 0; i < 10; i += 2) {
            for (int j = 0; j < 5; j++) {
                GameObjectEnemy enemy = new GameObjectEnemy(1 + i, 1 + j);
                enemies.add(enemy);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        gameRenderer.render(g, shooter, enemies, missiles);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            Command command = userInput.getCommand(e.getKeyChar());
            if (command == Command.INFO) {
                score.showScore();
            } else {
                movement.moveMissiles(missiles);
                movement.moveEnemy(enemies);
                gameRules.isEnemyShotDown(enemies, missiles, score);
                movement.readCommand(command, shooter, missiles);

                if (gameRules.hasEnemiesArrived(shooter, enemies)) {
                    GameInfo.printGameOver(score);
                    System.exit(0);
                }

                if(gameRules.hasPlayerWon(enemies)){
                    GameInfo.printWinningText(score);
                    System.exit(0);
                }
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
