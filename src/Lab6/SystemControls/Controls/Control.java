package Lab6.SystemControls.Controls;

public abstract class Control {
    private Double x_position;
    private Double y_position;


    public Control(double x, double y) {
        this.x_position = x;
        this.y_position = y;
    }

    public abstract Control setName(String name);

    public void setPosition(double x, double y) {
        this.x_position = x;
        this.y_position = y;
        System.out.println("Вызван метод setPosition");
    }

    /**
     * Возвращает массив, который содержит X и Y контроллера в позициях 0 и 1 соответственно
     */
    public double[] getPosition() {
        if (x_position != null && y_position != null) {
            System.out.println("Вызван метод getPosition и данный Control имеет координаты: " + x_position + " и " + y_position);
            return new double[]{x_position, y_position};
        }
        throw new RuntimeException("Позиция не определенна!");
    }
}
