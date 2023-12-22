package Lab6.SystemControls.Controls;

public class CheckBox extends Control {
    private String name;

    public CheckBox(double x, double y) {
        super(x, y);
    }

    @Override
    public Control setName(String name) {
        this.name = name;
        return this;
    }

    public void setSelected(boolean selected){
        System.out.println("Вызван метод setSelected " + "из мкласса " + name);
    }


}
