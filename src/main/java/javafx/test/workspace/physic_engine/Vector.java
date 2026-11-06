package javafx.test.workspace.physic_engine;

public class Vector {

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

    public void setLen() {
        this.len = Math.sqrt(x * x + y * y);
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
        setLen();
    }

    public void setXY(Vector pos) {
        this.setXY(pos.getX(), pos.getY());
    }

    public Vector copy(Vector pos) {
        return new Vector(pos.getX(), pos.getY());
    }



    // vector operation
    public Vector add(Vector v) {
        return new Vector(this.x + v.getX(), this.y + v.getY());
    }

    public Vector subtract(Vector v) {
        return new Vector(this.x - v.getX(), this.y - v.getY());
    }

    public Vector multiply(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public Vector normalize() {
        if (len == 0) return new Vector(0, 0);
        return new Vector(this.x / len, this.y / len);
    }
}

