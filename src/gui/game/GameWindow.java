package gui.game;

import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {

    GamePanel gamePanel;
    TimerPanel timerPanel;

    public GameWindow() {
        this.gamePanel = new GamePanel();
        this.timerPanel = new TimerPanel();

        this.setTitle("Hanoi Tower");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.add(timerPanel, BorderLayout.NORTH);
        this.add(gamePanel, BorderLayout.CENTER);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}