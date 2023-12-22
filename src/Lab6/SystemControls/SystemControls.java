package Lab6.SystemControls;

import Lab6.SystemControls.Controls.Control;

import java.util.List;

public abstract class SystemControls {
   private List<Control> controls;
   public SystemControls(List<Control> controls){
       this.controls = controls;
   }

    public List<Control> getControls() {
        return controls;
    }

    abstract public void useControls();
}
