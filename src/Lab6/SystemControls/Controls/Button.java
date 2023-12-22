package Lab6.SystemControls.Controls;

public class Button extends Control {
    private String text;
    private String name;

    public Button(double x, double y) {
        super(x, y);
    }

    @Override
    public Control setName(String name) {
        this.name = name;
        return this;
    }

    public void setText(String text){
        this.text = text;
        System.out.println("Установлен текст в Бутон");
    }
    public String getText(){
        return this.text;
    }

    public boolean click(){
        System.out.println("Кнопка нажата " + name);
        return true;
    }
}
