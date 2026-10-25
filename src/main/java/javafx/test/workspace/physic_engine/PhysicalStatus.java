package javafx.test.workspace.physic_engine;

public class PhysicalStatus {

    private double weight;
    private Vector pos, velocity, acceleration;
    private double frictionCoefficient;


    public PhysicalStatus(double weight, Vector pos, Vector velocity, Vector acceleration,
                          double frictionCoefficient) {
        this.weight = weight;
        this.pos = pos;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.frictionCoefficient = frictionCoefficient;
    }

    public double getWeight() {
        return weight;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public double getFrictionCoefficient() {
        return frictionCoefficient;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public void setFrictionCoefficient(double frictionCoefficient) {
        this.frictionCoefficient = frictionCoefficient;
    }
}
