package Lab6;

import Lab6.Controls.Button;
import Lab6.Controls.CheckBox;
import Lab6.Controls.Frame;

import java.util.ArrayList;
import java.util.List;

public class ControlFactory {
    public static ToolSetOS controlFactory(OperationSystem type) {
        List<Control> control = null;
        switch (type) {
            case WINDOW:
                control = new ArrayList<>(
                        List.of(new Button(12, 256).setName("Button for Window"),
                                new CheckBox(256, 12).setName("CheckBox for Window"),
                                new Frame(1221, 122).setName("Frame for Window")));

                break;
            case LINUX:
                control = new ArrayList<>(List.of(
                        new Frame(4561, 122).setName("Frame for LINUX"),
                        new Frame(4858, 7878).setName("Frame for LINUX"),
                        new Frame(1221, 122).setName("Frame for LINUX")));

                break;
            case MACOS:
                control = new ArrayList<>(List.of(new Button(256, 256).setName("Button for MACOS")));
                break;
        }
        return new ToolSetOS(control);
    }

}
