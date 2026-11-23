package javafx.test.workspace.folder.testOOD.office;

public abstract class Sensor extends Device {

    protected boolean detected;

    public Sensor(String selfMacAddress, boolean detected) {
        super(selfMacAddress);
        this.detected = detected;
    }

    public abstract void alert();

    public abstract void stop();

}
