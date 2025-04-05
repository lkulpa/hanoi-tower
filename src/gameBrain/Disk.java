package gameBrain;

import java.awt.*;

import static utils.Settings.getGameSize;
import static utils.Helpers.isMousePointerInsideBounds;

public class Disk {

    private Point corner;

    private Color color;

    private int width;
    public static int height = getGameSize().height / 12;

    public Disk(int width, Point corner, Color color) {
        this.corner = corner;
        this.width = width;
        height = getGameSize().height / 12;

        this.color = color;
    }

    public boolean isMouseOnDisk(Point mousePoint) {
        return isMousePointerInsideBounds(
                mousePoint,
                corner.x,
                corner.x + width,
                corner.y,
                corner.y + height
        );
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public Point getCorner() {
        return corner;
    }

    public void setCorner(Point corner) {
        this.corner = corner;
    }

    public Point getMiddlePoint() {
        return new Point(
                corner.x + (width / 2),
                corner.y + (height / 2)
        );
    }

    public void moveCorner(int x, int y) {
        this.corner.translate(x, y);
    }
}