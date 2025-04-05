package gameBrain;

import utils.Settings;

import java.awt.*;
import java.util.ArrayList;

import static utils.Settings.getGameSize;

public class Tower {

    private ArrayList<Disk> disks = new ArrayList<>();

    private Point baseCorner;
    private int baseWidth;
    private int baseHeight;

    private Point pillarCorner;
    private int pillarWidth;
    private int pillarHeight;

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Tower(int numberOfDisks, Point corner) {
        x1 = corner.x;
        x2 = corner.x + (getGameSize().width / 4);
        y1 = corner.y;
        y2 = (getGameSize().height / 12) * 11;

        this.baseWidth = getGameSize().width / 4;
        this.baseHeight = getGameSize().height / 20;
        this.baseCorner = new Point(x1, y2 - (baseHeight));

        this.pillarWidth = getGameSize().width / 40;
        this.pillarHeight = getGameSize().height / 12 * 9;
        this.pillarCorner = new Point(x1 + (baseWidth - pillarWidth) / 2, y1);

        for (int i = 0; i < numberOfDisks; i++) {
            int size = 8 - i;
            int diskWidth = (size + 1) * getGameSize().width / 40;
            disks.add(
                    new Disk(
                            diskWidth,
                            new Point(
                                    x1 + (baseWidth - diskWidth) / 2,
                                    y2 - (baseHeight + Disk.height * (i + 1))
                            ),
                            Settings.diskColorsList.get(i))
            );
        }
    }

    public Disk getTopDisk() {
        return disks.getLast();
    }

    public void removeTopDisk() {
        if (!disks.isEmpty()) {
            disks.removeLast();
        }
    }

    public void addDiskOnTop(Disk disk) {
        disk.setCorner(new Point(
                x1 + (baseWidth - disk.getWidth()) / 2,
                y2 - (baseHeight + Disk.height * (disks.size() + 1))
        ));
        disks.add(disk);
    }

    public Point getBaseCorner() {
        return baseCorner;
    }

    public Point getPillarCorner() {
        return pillarCorner;
    }

    public int getBaseWidth() {
        return baseWidth;
    }

    public int getBaseHeight() {
        return baseHeight;
    }

    public int getPillarWidth() {
        return pillarWidth;
    }

    public int getPillarHeight() {
        return pillarHeight;
    }

    public ArrayList<Disk> getDisks() {
        return disks;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}