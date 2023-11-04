package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LetterWriter {

    public enum ConsoleColor {
        YELLOW("\u001B[33m"), BLUE("\033[0;34m"), PURPLE("\033[0;35m");

        private final String color;

        ConsoleColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

    }

    private static final LetterWriter letterWriter = new LetterWriter();
    private boolean isBigFont;
    private List<Letter> alphabet;

    public static void main(String[] args) {
        LetterWriter writer = LetterWriter.getLetterWriter();
        writer.changeSizeOfFont();
        writer.writeText(ConsoleColor.PURPLE, "HELLO AMIGO");
        writer.writeText(ConsoleColor.BLUE, "ANOTHER AMIGO");



//        HashMap<String, List<String>> hashMap = new HashMap<>();
    }

    private LetterWriter() {
        alphabet = new ArrayList<>();
        try {
            getLetters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void changeSizeOfFont(){
        try {
            isBigFont = !isBigFont;
            alphabet = new ArrayList<>();
            getLetters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<List<String>> readFile() throws IOException {
        String path = "D:\\Development\\JavaProject\\Desktop\\OOP labs\\src\\Lab3\\5.txt";
        if (isBigFont) {
            path = "D:\\Development\\JavaProject\\Desktop\\OOP labs\\src\\Lab3\\7.txt";
        }
        List<List<String>> letters = new ArrayList<>();
        File file = new File(path);
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
                for (List<String> strings : array) {
                    if (!strings.get(index).equals(" ")) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    List<String> strArray = new ArrayList<>();
                    for (List<String> strings : array) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = startIndex; j < index; j++) {
                            stringBuilder.append(strings.get(j));
                        }
                        strArray.add(stringBuilder.toString());
                    }
                    alphabet.add(new Letter(String.valueOf(idLetter++), strArray));
                    startIndex = index + 1;
                }
            }
        }
        addSpace();
    }

    private void addSpace() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < alphabet.get(0).getArrayLetter().size(); i++)
            str.add("     ");
        alphabet.add(new Letter(" ", str));
    }

    public void writeText(ConsoleColor consoleColor, String text) {
        List<String> splitText = List.of(text.split(""));
        List<Letter> textArray = new ArrayList<>();
        if (checkText(text)) {
            for (String item : splitText) {
                for (Letter letter : alphabet) {
                    if (letter.getNameOfLetter().equals(item)) {
                        textArray.add(letter);
                        splitText.iterator().next();
                    }
                }
            }
        } else throw new RuntimeException("Incorrect world!!!");
        outText(consoleColor, textArray);
    }

    private void outText(ConsoleColor consoleColor, List<Letter> textArray){
        for (int i = 0; i < alphabet.get(0).getArrayLetter().size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (Letter item : textArray) {
                builder.append(item.getArrayLetter().get(i)).append(" ");
            }
            System.out.println(consoleColor.getColor() + builder.toString());
        }
    }

    private boolean checkText(String expression) {
        for (char item : expression.toCharArray())
            if (!(((64 < item) && (item < 91)) || (32 == item)))
                return false;
        return true;
    }

    public static LetterWriter getLetterWriter() {
        return letterWriter;
    }

    private static class Letter {
        private List<String> arrayLetter;

        private String nameOfLetter;

        public Letter(String nameOfLetter, List<String> arrayLetter) {
            this.nameOfLetter = nameOfLetter;
            this.arrayLetter = arrayLetter;
        }

        public String getNameOfLetter(){
            return nameOfLetter;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String item: arrayLetter) {
                stringBuilder.append(item).append("\n");
            }
            return stringBuilder.toString();
        }

        public List<String> getArrayLetter() {
            return arrayLetter;
        }
    }

}
