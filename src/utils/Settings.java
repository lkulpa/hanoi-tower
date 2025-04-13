package utils;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.ArrayList;

public class Settings {

    private static int numberOfDisks;
    private static Dimension gameSize;
    private static boolean isGameActive;
    private static LocalDateTime gameStartTime;

    public final static ArrayList<Color> diskColorsList = new ArrayList<>(Arrays.asList(Color.magenta, Color.GREEN, Color.blue, Color.darkGray, Color.pink, Color.red, Color.yellow, Color.ORANGE));

    public static boolean isGameActive() {
        return isGameActive;
    }

    public static void setIsGameActive(boolean isGameActive) {
        Settings.isGameActive = isGameActive;
    }

    public static LocalDateTime getGameStartTime() {
        return gameStartTime;
    }

    public static void setGameStartTime(LocalDateTime gameStartTime) {
        Settings.gameStartTime = gameStartTime;
    }

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