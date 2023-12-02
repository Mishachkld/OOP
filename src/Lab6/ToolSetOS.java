package Lab6;

import Lab6.Controls.Button;
import Lab6.Controls.Frame;

import java.util.List;

public class ToolSetOS {

    public static void main(String[] args) {
        ToolSetOS factoryOS = ControlFactory.controlFactory(OperationSystem.LINUX);
        List<Control> list = factoryOS.getControlList();
        for (Control c : list) {
            ((Frame) c).setVisible(true);
            c.getPosition();
        }

        //factoryOS.makeSmthWithElements();
    }

    private final List<Control> controlList;

    public ToolSetOS(List<Control> controlList) {
        this.controlList = controlList;
    }

    public List<Control> getControlList() {
        return controlList;
    }


    public void makeSmthWithElements() {
        for (Control control : controlList) {
            control.getPosition();
        }

    }
}
