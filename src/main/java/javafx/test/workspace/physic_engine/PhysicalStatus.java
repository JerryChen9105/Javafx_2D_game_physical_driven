package javafx.test.workspace.physic_engine;

public class PhysicalStatus {

    // variables
    private double weight;
    private Vector pos, velocity, acceleration;
    private double frictionCoefficient;
    private double restitution;



    // constructor
    public PhysicalStatus(double weight, Vector pos, Vector velocity, Vector acceleration,
                          double frictionCoefficient, double restitution) {
        this.weight = weight;
        this.pos = pos;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.frictionCoefficient = frictionCoefficient;
        this.restitution = restitution;
    }



    // getter
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

    public double getRestitution() {
        return restitution;
    }



    // setter
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

    public void setRestitution(double restitution) {
        this.restitution = restitution;
    }



    // Newton's law of motion
    public void applyForce(Vector force) {
        double ax = force.getX() / this.weight;
        double ay = force.getY() / this.weight;

        this.acceleration.setXY(this.acceleration.getX() + ax, this.acceleration.getY() + ay);
    }

    public void applyFriction() {
        if (this.velocity.getLen() > 0) {
            Vector oppositeDirection = this.velocity.normalize().multiply(-1);

            double frictionMagnitude = this.frictionCoefficient * this.weight * PhysicsConstant.g;
            Vector frictionForce = oppositeDirection.multiply(frictionMagnitude);

            double speed = this.velocity.getLen();
            double deceleration = (frictionMagnitude / this.weight);

            this.applyForce(frictionForce);
        }
    }



    // Euler numerical method
    public void update(double deltaTime) {
        applyFriction();

        Vector deltaVelocity = this.acceleration.multiply(deltaTime);
        this.velocity = this.velocity.add(deltaVelocity);

        if (this.velocity.getLen() < 0.01) {
            this.velocity.setXY(0, 0);
        }

        Vector deltaPos = this.velocity.multiply(deltaTime);
        this.pos = this.pos.add(deltaPos);

        this.acceleration.setXY(0, 0);
    }
}


