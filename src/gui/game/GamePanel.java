package gui.game;

import utils.Settings;
import gameBrain.Disk;
import gameBrain.Tower;
import gameBrain.GameBrain;

import java.awt.*;
import javax.swing.*;
import java.util.Objects;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class GamePanel extends JPanel {

    GameBrain gameBrain;
    Tower giverTower;
    Disk selectedDisk;
    Point mousePointWhenPressed;
    Point selectedDiskCornerBeforeDrag;

    public GamePanel() {
        gameBrain = new GameBrain();
        selectedDisk = null;

        this.setPreferredSize(Settings.getGameSize());

        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g2D);

        for (Tower tower : gameBrain.getTowers()) {

            g2D.setColor(Color.BLACK);
            // Drawing tower base:
            g2D.fillRoundRect(
                    tower.getBaseCorner().x,
                    tower.getBaseCorner().y,
                    tower.getBaseWidth(),
                    tower.getBaseHeight(),
                    10,
                    10
            );

            // Drawing tower pillar:
            g2D.fillRect(
                    tower.getPillarCorner().x,
                    tower.getPillarCorner().y,
                    tower.getPillarWidth(),
                    tower.getPillarHeight()
            );
        }

        // Drawing disks:
        for (Disk disk : gameBrain.getDisksFromAllTowers()) {
            g2D.setColor(disk.getColor());
            g2D.fillRoundRect(
                    disk.getCorner().x,
                    disk.getCorner().y,
                    disk.getWidth(),
                    disk.getHeight(),
                    10,
                    10
            );
        }
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            mousePointWhenPressed = e.getPoint();
            giverTower = gameBrain.getTowerByMousePoint(mousePointWhenPressed);
            if (!Objects.isNull(giverTower) && !giverTower.getDisks().isEmpty()) {
                Disk topDisk = giverTower.getTopDisk();
                if (topDisk.isMouseOnDisk(mousePointWhenPressed)) {
                    selectedDisk = topDisk;
                    selectedDiskCornerBeforeDrag = new Point(selectedDisk.getCorner().x, selectedDisk.getCorner().y);
                }
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (!Objects.isNull(selectedDisk)) {
                Tower selectedTower = gameBrain.getTowerByMousePoint(selectedDisk.getMiddlePoint());
                if (!Objects.isNull(selectedTower) && selectedTower.getDisks().isEmpty()) {
                    selectedTower.addDiskOnTop(selectedDisk);
                    giverTower.removeTopDisk();
                } else if (!Objects.isNull(selectedTower) && selectedDisk.getWidth() < selectedTower.getTopDisk().getWidth()) {
                    selectedTower.addDiskOnTop(selectedDisk);
                    giverTower.removeTopDisk();
                } else if (!Objects.isNull(selectedDisk)) {
                    selectedDisk.setCorner(selectedDiskCornerBeforeDrag);
                }

            }
            if (gameBrain.isLastTowerFull()) {
                System.out.println("WINNER!!!");
            }
            repaint();
            selectedDisk = null;
            giverTower = null;
        }
    }

    private class DragListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {
            Point currentMousePoint = e.getPoint();

            if (!Objects.isNull(selectedDisk)) {
                selectedDisk.moveCorner(
                        (int) (currentMousePoint.getX() - mousePointWhenPressed.getX()),
                        (int) (currentMousePoint.getY() - mousePointWhenPressed.getY())
                );

                mousePointWhenPressed = currentMousePoint;
                repaint();
            }
        }
    }
}