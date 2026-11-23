package javafx.test.workspace.physic_engine;

public class PhysicalStatus {

    // variables
    private double mass;
    private Vector pos, velocity, acceleration;
    private double friction;
    private double restitution;



    // constructor
    public PhysicalStatus(double mass, Vector pos, Vector velocity, Vector acceleration,
                          double friction, double restitution) {
        this.mass = mass;
        this.pos = pos;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.friction = friction;
        this.restitution = restitution;
    }



    // getter
    public double getMass() {
        return mass;
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
        return friction;
    }

    public double getRestitution() {
        return restitution;
    }



    // setter
    public void setMass(double mass) {
        this.mass = mass;
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

    public void setFrictionCoefficient(double friction) {
        this.friction = friction;
    }

    public void setRestitution(double restitution) {
        this.restitution = restitution;
    }



    // Newton's law of motion
    public void applyForce(Vector force) {
        double ax = force.getX() / this.mass;
        double ay = force.getY() / this.mass;

        this.acceleration.setXY(this.acceleration.getX() + ax, this.acceleration.getY() + ay);
    }

    public void applyFriction() {
        if (this.velocity.getLen() > 0) {
            Vector oppositeDirection = this.velocity.normalize().multiply(-1);

            double frictionMagnitude = this.friction * this.mass * PhysicsConstant.g;
            Vector frictionForce = oppositeDirection.multiply(frictionMagnitude);

            double speed = this.velocity.getLen();
            double deceleration = (frictionMagnitude / this.mass);

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


