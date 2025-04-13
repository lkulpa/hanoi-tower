package gameBrain;

import utils.Helpers;
import utils.Settings;

import java.awt.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

import static utils.Settings.getGameSize;
import static utils.Settings.getNumberOfDisks;

public class GameBrain {

    Tower goalTower;
    Tower middleTower;
    Tower startingTower;
    ArrayList<Tower> towers = new ArrayList<>();

    public GameBrain() {
        Settings.setGameStartTime(LocalDateTime.now());
        Settings.setIsGameActive(true);

        int gameWidth = getGameSize().width;
        int gameHeight = getGameSize().height;

        startingTower = new Tower(Settings.getNumberOfDisks(), new Point(gameWidth / 16, (gameHeight / 60) * 7));
        middleTower = new Tower(0, new Point(startingTower.getX2() + gameWidth / 16, (gameHeight / 60) * 7));
        goalTower = new Tower(0, new Point(middleTower.getX2() + gameWidth / 16, (gameHeight / 60) * 7));

        towers.add(startingTower);
        towers.add(middleTower);
        towers.add(goalTower);
    }

    public boolean isLastTowerFull() {
        if (goalTower.getDisks().size() == getNumberOfDisks()) {
            Settings.setIsGameActive(false);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public Tower getTowerByMousePoint(Point mousePoint) {
        for (Tower tower : towers) {
            if (Helpers.isMousePointerInsideBounds(mousePoint, tower.getX1(), tower.getX2(), tower.getY1(), tower.getY2())) {
                return tower;
            }
        }
        return null;
    }

    public ArrayList<Disk> getDisksFromAllTowers() {
        ArrayList<Disk> allDisks = new ArrayList<>();
        for (Tower tower : towers) {
            allDisks.addAll(tower.getDisks());
        }
        return allDisks;
    }
}