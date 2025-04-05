package gui.mainMenu;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class DifficultyPanel extends JPanel {

    JLabel sliderLabel;
    JSlider difficultySlider;

    public DifficultyPanel() {
        this.setLayout(new FlowLayout());

        difficultySlider = new JSlider(3, 8, 5);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintLabels(true);
        difficultySlider.addChangeListener(this::stateChanged);

        sliderLabel = new JLabel();
        sliderLabel.setText("Difficulty: " + difficultySlider.getValue());

        this.add(difficultySlider);
        this.add(sliderLabel);
    }

    public void stateChanged(ChangeEvent e) {
        sliderLabel.setText("Difficulty: " + difficultySlider.getValue());
    }
}