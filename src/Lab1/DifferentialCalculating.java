package Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public abstract class DifferentialCalculating {

    private double delta;

    public DifferentialCalculating(double delta) {        /// throw Exception
        if (delta >= 0)
            this.delta = delta;
        else {                                            /// стоит ли в конструкторе выбрасывать ошибку?
            System.out.println("Неверно введенна дельта");
            this.delta = 0;                               // throw new Exception("Неверно введенна дельта");
        }
    }

    public abstract double calcDifferential(UnaryOperator<Double> function, double xDote);


    public double getDelta() {                              /// инкапсуляция
        return delta;
    }

    public void setDelta(double delta) {                    /// инкапсуляция
        if (delta >= 0)
            this.delta = delta;
        else {
            System.out.println("Неверно введенна дельта");
            this.delta = 0;
        }
    }

}

class MidDifferentialCalculation extends DifferentialCalculating {  /// наследование
    public MidDifferentialCalculation(double delta) {
        super(delta);
    }

    @Override
    public double calcDifferential(UnaryOperator<Double> function, double xDote) {
        return (function.apply(xDote) - function.apply(xDote - getDelta())) / getDelta();
    }

    @Override
    public String toString() {
        return "Средняя производная";
    }

}


class LowDifferentialCalculating extends DifferentialCalculating { /// наследование


    public LowDifferentialCalculating(double delta) {
        super(delta);
    }


    @Override
    public double calcDifferential(UnaryOperator<Double> function, double xDote) {
        return (function.apply(xDote + getDelta()) - function.apply(xDote)) / getDelta();
    }

    @Override
    public String toString() {
        return "Нижняя производная";
    }

}


class HighDifferentialCalculating extends DifferentialCalculating {         /// наследование


    public HighDifferentialCalculating(double delta) {
        super(delta);
    }


    @Override
    public double calcDifferential(UnaryOperator<Double> function, double xDote) {
        return (function.apply(xDote + getDelta()) - function.apply(xDote - getDelta())) / 2* getDelta();
    }

    @Override
    public String toString() {
        return "Верхняя производная";
    }

}

class Controller {
    public static void main(String[] args) {
        double delta = 0.1;
        List<DifferentialCalculating> calculatings = new ArrayList<>();
        calculatings.add(new LowDifferentialCalculating(delta));         // полиморфизм
        calculatings.add(new MidDifferentialCalculation(delta));         // полиморфизм
        calculatings.add(new HighDifferentialCalculating(delta));        // полиморфизм
        for (DifferentialCalculating calc : calculatings) {
            /*double result = 0;
            for (int i = 0; i < 10; i++) {
                result += calc.calcDifferential(Controller::function, i); // полиморфизм
            }

            System.out.println(result + " " + calc);*/
            System.out.println((calc.calcDifferential(Controller::function, 5)) + " " + calc);
        }
    }

    private static double function(double x) {
        return x * x;
    }

}




