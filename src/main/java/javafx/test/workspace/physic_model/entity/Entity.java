package javafx.test.workspace.physic_model.entity;

import javafx.test.workspace.physic_engine.PhysicalStatus;
import javafx.test.workspace.physic_model.obstacle.Boundary;

public abstract class Entity {

    protected PhysicalStatus status;
    protected Boundary boundary;


    public Entity(PhysicalStatus status, Boundary boundary) {
        this.status = status;
        this.boundary = boundary;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    // getter
    public PhysicalStatus getStatus() {
        return this.status;
    }

    public Boundary getBoundary() {
        return boundary;
    }


    // setter
    public void setStatus(PhysicalStatus status) {
        this.status = status;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }


    // collision check
    public abstract void resolveBoundaryCollision();

    public abstract void resolveEntityCollision();


    // move actions
    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void moveLeft();

    public abstract void moveRight();

}
