package gameBrain;

import utils.Helpers;
import utils.Settings;

import java.awt.*;
import java.util.ArrayList;

import static utils.Settings.getGameSize;
import static utils.Settings.getNumberOfDisks;

public class GameBrain {

    Tower startingTower;
    Tower middleTower;
    Tower goalTower;
    ArrayList<Tower> towers = new ArrayList<>();

    public GameBrain() {
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
        return goalTower.getDisks().size() == getNumberOfDisks();
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