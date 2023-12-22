package Lab6.SystemControls;

import Lab6.SystemControls.Controls.Control;
import Lab6.SystemControls.Controls.Frame;

import java.util.ArrayList;
import java.util.List;

public class WindowControls extends SystemControls {

    public WindowControls(List<Control> controls) {
        super(controls);
    }

    @Override
    public void useControls() {
        if (getControls() != null) {
            for (Control control : getControls()) {
                ((Frame) control).setVisible(true);
                control.getPosition();
            }
        }
    }
}
