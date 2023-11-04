package Lab4.Constants;

import java.awt.*;

public class Constants {

    public static final String TITLE = "Мега вирт клавиатура";

    public static Dimension SIZE = new Dimension(1080, 500);
    public static Point POSITION = new Point(400,200);
    public static final String[][] ALL_ROWS = {{"Create command", "Run command", "UNDO"}, {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Del"}, {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"}, {"A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter"}, {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?"},
            {"               Space                "}};

    public static final int ROWS = ALL_ROWS.length;
}
