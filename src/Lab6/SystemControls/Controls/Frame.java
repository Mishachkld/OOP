package Lab6.SystemControls.Controls;

public class Frame extends Control {
    private String name;

    public Frame(double x, double y) {
        super(x, y);
    }

    public void setVisible(boolean isVisible){
        System.out.println("Вызван метод setVisible " + name + " из класса Frame");
    }

    @Override
    public Control setName(String name) {
        this.name = name;
        return this;
    }
}
