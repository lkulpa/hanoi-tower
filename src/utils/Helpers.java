package utils;

import java.awt.*;

public class Helpers {

    public static boolean isMousePointerInsideBounds(Point mousePointerPoint, int xLow, int xHigh, int yLow, int yHigh) {
        int pointerX = (int) mousePointerPoint.getX();
        int pointerY = (int) mousePointerPoint.getY();

        return pointerX >= xLow &&
                pointerX <= xHigh &&
                pointerY >= yLow &&
                pointerY <= yHigh;
    }
}