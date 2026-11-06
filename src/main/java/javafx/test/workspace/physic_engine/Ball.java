package javafx.test.workspace.physic_engine;

public class Ball {

    // variable
    private PhysicalStatus ballStatus;
    private Boundary boundary;
    private double radius;



    // constructor
    public Ball(PhysicalStatus ballStatus, Boundary boundary, double radius) {
        this.ballStatus = ballStatus;
        this.boundary = boundary;
        this.radius = radius;
    }



    // getter
    public PhysicalStatus getBallStatus() {
        return ballStatus;
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public double getRadius() {
        return radius;
    }



    // setter
    public void setBallStatus(PhysicalStatus ballStatus) {
        this.ballStatus = ballStatus;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



    // boundary check
    public void resolveBoundaryCollision() {
        Vector pos = ballStatus.getPos();
        Vector vel = ballStatus.getVelocity();
        double restitution = ballStatus.getRestitution();

        if (pos.getX() - radius < boundary.getLeftBound()) {
            pos.setX(boundary.getLeftBound() + radius);
            vel.setX(-vel.getX() * restitution);
        }

        // 2. 检查右边界
        else if (pos.getX() + radius > boundary.getRightBound()) {
            pos.setX(boundary.getRightBound() - radius);
            vel.setX(-vel.getX() * restitution);
        }

        // 3. 检查上边界
        if (pos.getY() - radius < boundary.getTopBound()) {
            pos.setY(boundary.getTopBound() + radius);
            vel.setY(-vel.getY() * restitution);
        }

        // 4. 检查下边界
        else if (pos.getY() + radius > boundary.getBottomBound()) {
            pos.setY(boundary.getBottomBound() - radius);
            vel.setY(-vel.getY() * restitution);
        }
    }



    // move actions
    public void moveUp() {
        double speed = ballStatus.getVelocity().getLen();
        double newY = ballStatus.getPos().getY() - speed;

        if (newY < boundary.getTopBound()) {
            newY = boundary.getTopBound();
        }
        ballStatus.getPos().setY(newY);
    }

    public void moveDown() {
        double speed = ballStatus.getVelocity().getLen();
        double newY = ballStatus.getPos().getY() + speed;
        if (newY > boundary.getBottomBound()) {
            newY = boundary.getBottomBound();
        }
        ballStatus.getPos().setY(newY);
    }

    public void moveLeft() {
        double speed = ballStatus.getVelocity().getLen();
        double newX = ballStatus.getPos().getX() - speed;
        if (newX < boundary.getLeftBound()) {
            newX = boundary.getLeftBound();
        }
        ballStatus.getPos().setX(newX);
    }

    public void moveRight() {
        double speed = ballStatus.getVelocity().getLen();
        double newX = ballStatus.getPos().getX() + speed;
        if (newX > boundary.getRightBound()) {
            newX = boundary.getRightBound();
        }
        ballStatus.getPos().setX(newX);
    }
}


