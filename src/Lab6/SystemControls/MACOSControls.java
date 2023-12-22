package Lab6.SystemControls;

import Lab6.SystemControls.Controls.Button;
import Lab6.SystemControls.Controls.Control;

import java.util.List;

public class MACOSControls extends SystemControls {

    public MACOSControls(List<Control> controls) {
        super(controls);
    }

    @Override
    public void useControls() {
        if (getControls() != null)
            for (Control control : getControls()) {
                ((Button) control).click();
            }
    }
}
