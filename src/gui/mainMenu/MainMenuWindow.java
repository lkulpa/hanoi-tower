package gui.mainMenu;

import utils.Settings;
import gui.game.GameWindow;
import utils.ResolutionVariables;

import java.awt.*;
import javax.swing.*;

public class MainMenuWindow extends JFrame {

    DifficultyPanel difficultyPanel;
    ResolutionPanel resolutionPanel;

    public MainMenuWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1, 0, 30));

        resolutionPanel = new ResolutionPanel();
        difficultyPanel = new DifficultyPanel();

        this.add(resolutionPanel);
        this.add(difficultyPanel);
        this.add(createStartButton());

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JButton createStartButton() {
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.setFocusable(false);
        startButton.addActionListener(_ -> {
            if (resolutionPanel.lowResolutionButton.isSelected()) {
                Settings.setGameSize(ResolutionVariables.lowRes);
            } else if (resolutionPanel.mediumResolutionButton.isSelected()) {
                Settings.setGameSize(ResolutionVariables.mediumRes);
            } else {
                Settings.setGameSize(ResolutionVariables.highRes);
            }
            Settings.setNumberOfDisks(difficultyPanel.difficultySlider.getValue());

            new GameWindow();
            MainMenuWindow.this.setVisible(false);
        });

        return startButton;
    }
}