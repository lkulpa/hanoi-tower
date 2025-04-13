package gui.game;

import utils.Settings;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionListener;

public class TimerPanel extends JPanel {

    Timer timer;
    JLabel clockLabel;
    LocalDateTime startTime;
    DecimalFormat decimalFormat = new DecimalFormat("00");

    public TimerPanel() {
        this.startTime = LocalDateTime.now();
        this.clockLabel = new JLabel();
        this.clockLabel.setText("00:00");
        timer = new Timer(1000, updateClock);
        timer.start();

        this.add(clockLabel);
    }

    ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Settings.isGameActive()) {
                int timeDeltaSeconds = (int) ChronoUnit.SECONDS.between(startTime, LocalDateTime.now());
                int minutes = timeDeltaSeconds / 60;
                int seconds = timeDeltaSeconds % 60;
                clockLabel.setText(decimalFormat.format(minutes) + ":" + decimalFormat.format(seconds));
            }
        }
    };
}