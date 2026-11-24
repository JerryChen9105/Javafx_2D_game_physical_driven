package javafx.test.workspace.physic_model.entity;

import javafx.test.workspace.physic_engine.PhysicalStatus;
import javafx.test.workspace.math_object.Vector;
import javafx.test.workspace.physic_model.obstacle.Boundary;

public class Ball extends Entity {

    // variable
    private double radius;


    // constructor
    public Ball(PhysicalStatus status, Boundary boundary, double radius) {
        super(status, boundary);
        this.radius = radius;
    }


    // getter
    public PhysicalStatus getStatus(PhysicalStatus status) {
        return super.getStatus();
    }

    public Boundary getBoundary() {
        return super.getBoundary();
    }

    public double getRadius() {
        return radius;
    }


    // setter
    public void setStatus(PhysicalStatus status) {
        super.setStatus(status);
    }

    public void setBoundary(Boundary boundary) {
        super.setBoundary(boundary);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    // collision check
    @Override
    public void resolveBoundaryCollision() {
        Vector pos = status.getPos();
        Vector vel = status.getVelocity();
        double restitution = status.getRestitution();

        if (pos.getX() - radius < boundary.getLeftBound()) {
            pos.setX(boundary.getLeftBound() + radius);
            vel.setX(-vel.getX() * restitution);
        }
        else if (pos.getX() + radius > boundary.getRightBound()) {
            pos.setX(boundary.getRightBound() - radius);
            vel.setX(-vel.getX() * restitution);
        }

        if (pos.getY() - radius < boundary.getTopBound()) {
            pos.setY(boundary.getTopBound() + radius);
            vel.setY(-vel.getY() * restitution);
        }
        else if (pos.getY() + radius > boundary.getBottomBound()) {
            pos.setY(boundary.getBottomBound() - radius);
            vel.setY(-vel.getY() * restitution);
        }
    }


    @Override
    public void resolveEntityCollision() {

    }


    // move actions
    @Override
    public void moveUp() {
        double speed = status.getVelocity().getLen();
        double newY = status.getPos().getY() - speed;

        if (newY < boundary.getTopBound()) {
            newY = boundary.getTopBound();
        }
        status.getPos().setY(newY);
    }

    @Override
    public void moveDown() {
        double speed = status.getVelocity().getLen();
        double newY = status.getPos().getY() + speed;
        if (newY > boundary.getBottomBound()) {
            newY = boundary.getBottomBound();
        }
        status.getPos().setY(newY);
    }

    @Override
    public void moveLeft() {
        double speed = status.getVelocity().getLen();
        double newX = status.getPos().getX() - speed;
        if (newX < boundary.getLeftBound()) {
            newX = boundary.getLeftBound();
        }
        status.getPos().setX(newX);
    }

    @Override
    public void moveRight() {
        double speed = status.getVelocity().getLen();
        double newX = status.getPos().getX() + speed;
        if (newX > boundary.getRightBound()) {
            newX = boundary.getRightBound();
        }
        status.getPos().setX(newX);
    }
}


