package javafx.test.workspace.folder.testOOD.office;

public class SmokeSensor extends Sensor {

    public SmokeSensor(String selfMacAddress, boolean detected) {
        super(selfMacAddress, detected);
    }

    @Override
    public void connectWifi(String wifiMacAddress) {}

    @Override
    public void alert() {}

    @Override
    public void stop() {}
}
