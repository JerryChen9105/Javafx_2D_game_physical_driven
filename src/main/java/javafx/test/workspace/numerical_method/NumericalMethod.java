package javafx.test.workspace.numerical_method;

import javafx.test.workspace.math_object.Operation.Algebra.Multiply;

public interface NumericalMethod<T extends Multiply<Double, T>> {

    public T estimateIncrement(T derivative, double dt);

}

