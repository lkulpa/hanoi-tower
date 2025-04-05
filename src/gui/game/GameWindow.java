package gui.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    GamePanel gamePanel;

    public GameWindow() {
        this.gamePanel = new GamePanel();

        this.setTitle("Hanoi Tower");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(gamePanel);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}