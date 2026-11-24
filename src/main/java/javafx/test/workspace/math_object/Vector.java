package javafx.test.workspace.math_object;

import javafx.test.workspace.math_object.Operation.Abstract.CrossProduct;
import javafx.test.workspace.math_object.Operation.Abstract.DotProduct;
import javafx.test.workspace.math_object.Operation.Abstract.Norm;
import javafx.test.workspace.math_object.Operation.Abstract.Normalize;
import javafx.test.workspace.math_object.Operation.Algebra.Add;
import javafx.test.workspace.math_object.Operation.Algebra.Multiply;
import javafx.test.workspace.math_object.Operation.Algebra.Substract;

public class Vector
        implements Add<Vector>,
        Substract<Vector>,
        Multiply<Double, Vector>,
        Norm<Double>,
        Normalize<Vector>,
        DotProduct<Vector, Double>,
        CrossProduct<Vector, Double> {

    // variables
    private double x, y;
    private double len = 0;



    // constructors
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        setLen();
    }

    public Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
        setLen();
    }

    public static Vector copy(Vector pos) {
        return new Vector(pos.getX(), pos.getY());
    }

    public static Vector of(int x, int y) {
        return new Vector(x, y);
    }



    // identity methods
    @Override
    public String toString() {
        return "<" + x + ", " + y + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector other = (Vector)obj;
        return x == other.getX() && y == other.getY();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }



    // getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLen() {
        return len;
    }



    // setter
    public void setX(double x) {
        this.x = x;
        setLen();
    }

    public void setY(double y) {
        this.y = y;
        setLen();
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
        setLen();
    }

    private void setLen() {
        this.len = norm();
    }

    public void setXY(Vector pos) {
        this.setXY(pos.getX(), pos.getY());
    }



    // vector operation
    @Override
    public Vector add(Vector other) {
        return new Vector(this.x + other.getX(), this.y + other.getY());
    }

    @Override
    public Vector substract(Vector other) {
        return new Vector(this.x - other.getX(), this.y - other.getY());
    }

    @Override
    public Vector multiply(Double other) {
        return new Vector(this.x * other, this.y * other);
    }

    @Override
    public Double norm() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public Vector normalize() {
        if (len == 0) return new Vector(0, 0);
        return new Vector(this.x / len, this.y / len);
    }

    @Override
    public Double dotProduct(Vector other) {
        return x * other.getX() + y * other.getY();
    }

    @Override
    public Double crossProduct(Vector other) {
        return x * other.getY() - y * other.getX();
    }

}



