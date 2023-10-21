package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    private List<Letter> alphabet;

    public static void main(String[] args) {
        LetterWriter writer = new LetterWriter();
    }


    private int[] tecCoordinates = {0, 0};

    public LetterWriter() {
        alphabet = new ArrayList<>();
        try {
            getLetters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<List<String>> readFile() throws IOException {
        List<List<String>> letters = new ArrayList<>();
        File file = new File("D:\\Development\\JavaProject\\Desktop\\OOP labs\\src\\Lab3\\5 (2).txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            letters.add(new ArrayList<>(List.of(line.split(""))));
        }
        return letters;
    }

    private void getLetters() throws IOException {
        List<List<String>> array = readFile();
        int startIndex = 0;
        char idLetter = 65;
        List<String> arrayStart = array.get(0);
        for (int index = 0; index < arrayStart.size(); index++) {
            if (arrayStart.get(index).equals(" ")) {
                boolean flag = true;
                for (int i = 0; i < array.size(); i++) {
                    if (!arrayStart.get(index).equals(" ")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    StringBuilder strBuilder = new StringBuilder();
                    for (int i = 0; i < array.size(); i++) {
                        for (int j = startIndex; j < index; j++) {
                            strBuilder.append(array.get(i).get(j));
                        }
                        strBuilder.append("\n");
                    }
                    alphabet.add(new Letter(String.valueOf(idLetter++), strBuilder.toString()));
                    startIndex = index + 1;

                }

            }
        }
        for (Letter letter:alphabet){
            System.out.println(letter);
        }
    }


    /*
            for (int i = l; i < size - 8; i++) {
                for (List<String> letter : letters) {
                    strBuilder.append(letter.get(i));
                }
                strBuilder.append("\n");
            }
            arrayLetter.add(new Letter(String.valueOf(idLetter++), strBuilder.toString()));
            strBuilder = new StringBuilder();

    for (int j = 0; j < letters.get(i).size(); j++) {
                String item = letters.get(i).get(j);
                if (item.equals(" ")) {
                    if (!isAllSpace(i, j)){

                    }
                    else {
                        strBuilder = new StringBuilder();
                    }
                } else
                    strBuilder.append(item).append("\n");
            }*/

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
