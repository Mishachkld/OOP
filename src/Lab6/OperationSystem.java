package Lab6;

import Lab6.SystemControls.SystemControls;

public enum OperationSystem {
    WINDOW, LINUX, MACOS;

    public static void main(String[] args) {
        SystemControls controls = ControlFactory.controlFactory(OperationSystem.LINUX);
        controls.useControls();
    }
}
