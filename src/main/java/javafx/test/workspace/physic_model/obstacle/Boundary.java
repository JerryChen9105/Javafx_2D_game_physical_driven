package javafx.test.workspace.physic_model.obstacle;

public class Boundary {

    private double leftBound, rightBound, topBound, bottomBound;


    public Boundary(double leftBound,
                    double rightBound,
                    double topBound,
                    double bottomBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.topBound = topBound;
        this.bottomBound = bottomBound;
    }

    public double getLeftBound() {
        return leftBound;
    }

    public double getRightBound() {
        return rightBound;
    }

    public double getTopBound() {
        return topBound;
    }

    public double getBottomBound() {
        return bottomBound;
    }


    public void setLeftBound(double leftBound) {
        this.leftBound = leftBound;
    }

    public void setRightBound(double rightBound) {
        this.rightBound = rightBound;
    }

    public void setTopBound(double topBound) {
        this.topBound = topBound;
    }

    public void setBottomBound(double bottomBound) {
        this.bottomBound = bottomBound;
    }
}


