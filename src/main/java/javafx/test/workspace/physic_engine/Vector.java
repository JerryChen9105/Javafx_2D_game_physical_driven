package javafx.test.workspace.physic_engine;

public class Vector {

    private double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }


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



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void setXY(Vector pos) {
        this.setXY(pos.getX(), pos.getY());
    }

    public Vector copy(Vector pos) {
        return new Vector(pos.getX(), pos.getY());
    }
}
