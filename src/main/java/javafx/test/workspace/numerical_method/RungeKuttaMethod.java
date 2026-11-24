package javafx.test.workspace.numerical_method;

import javafx.test.workspace.math_object.Operation.Algebra.Add;
import javafx.test.workspace.math_object.Operation.Algebra.Multiply;

public class RungeKuttaMethod<T extends Multiply<Double, T> & Add<T>> implements NumericalMethod<T> {

    @Override
    public T estimateIncrement(T derivative, double dt) {
        return null; // add code
    }

}
