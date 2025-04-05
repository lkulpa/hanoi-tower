package utils;

import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Settings {

    private static Dimension gameSize;
    private static int numberOfDisks;
    public final static ArrayList<Color> diskColorsList = new ArrayList<>(Arrays.asList(Color.magenta, Color.GREEN, Color.blue, Color.darkGray, Color.pink, Color.red, Color.yellow, Color.ORANGE));

    public static Dimension getGameSize() {
        return gameSize;
    }

    public static void setGameSize(Dimension gameSize) {
        Settings.gameSize = gameSize;
    }

    public static int getNumberOfDisks() {
        return numberOfDisks;
    }

    public static void setNumberOfDisks(int numberOfDisks) {
        Settings.numberOfDisks = numberOfDisks;
    }
}