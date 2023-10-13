package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LetterWriter {
    public enum ConsoleColor {
        YELLOW("\033[0m"), BLUE("\033[0;34m"), PURPLE("\033[0;35m");

        private String color;

        ConsoleColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

    }

    private boolean isBigFont;
    private final List<List<String>> letters = new ArrayList<>();

    private int[] tecCoordinates = {0, 0};

    public static void main(String[] args) {
        LetterWriter writer = new LetterWriter();
    }

    public LetterWriter() {
        try {
            getLetters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void getLetters() throws IOException {
        File file = new File("Lab3/5.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        letters.get(0).add(reader.readLine());

    }


    public void writeText(ConsoleColor consoleColor, String text, int x, int y) {
        StringBuilder strBuilder = new StringBuilder();
        if (checkCoordinates(x, y) && checkText(text)) {
            tecCoordinates[0] = x;
            tecCoordinates[1] = y;
            if (isBigFont) {


            } else {


            }
            System.out.println(consoleColor.getColor() + strBuilder.toString());
        }
    }

    private boolean checkText(String expression) {
        for (char item : expression.toCharArray())
            if (!((64 < item) && (item < 123)))
                return false;
        return true;
    }

    public boolean checkCoordinates(int x, int y) {
        return (x >= 0) && (y >= 0);
    }


    public int getTecCoordinatesX() {
        return tecCoordinates[0];
    }

    public int getTecCoordinatesY() {
        return tecCoordinates[1];
    }


    public static class ColorsForConsole {

        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE
    }
}
