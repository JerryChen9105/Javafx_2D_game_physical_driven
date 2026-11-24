package javafx.test.workspace.numerical_method;

import javafx.test.workspace.math_object.Operation.Algebra.Multiply;
import javafx.test.workspace.math_object.Vector;

public class EulerMethod<T extends Multiply<Double, T>> implements NumericalMethod<T> {

    @Override
    public T estimateIncrement(T derivative, double dt) {
        return derivative.multiply(dt);
    }

}
