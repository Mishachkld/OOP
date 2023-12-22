package Lab6.SystemControls;

import Lab6.SystemControls.Controls.Control;

import java.util.List;

public class LinuxControls extends SystemControls {
    public LinuxControls(List<Control> controls) {
        super(controls);
    }

    @Override
    public void useControls() {
        if (getControls() != null) {
            for (Control control : getControls()) {
                control.getPosition();
            }
        }
    }
}
