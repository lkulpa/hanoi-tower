package gui.mainMenu;

import java.awt.*;
import javax.swing.*;

public class ResolutionPanel extends JPanel {

    ButtonGroup radioButtonGroup;
    JRadioButton lowResolutionButton;
    JRadioButton mediumResolutionButton;
    JRadioButton highResolutionButton;

    public ResolutionPanel() {
        this.setLayout(new FlowLayout());

        lowResolutionButton = new JRadioButton("Low (400x300)");
        mediumResolutionButton = new JRadioButton("Medium (800x600)");
        highResolutionButton = new JRadioButton("High (1200x900)");

        lowResolutionButton.doClick();

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(lowResolutionButton);
        radioButtonGroup.add(mediumResolutionButton);
        radioButtonGroup.add(highResolutionButton);

        this.add(lowResolutionButton);
        this.add(mediumResolutionButton);
        this.add(highResolutionButton);
    }
}