package javafx.test.workspace.not_related_folder.testOOD.office;

public abstract class Device {

    protected String selfMacAddress;

    public Device(String selfMacAddress) {
        this.selfMacAddress = selfMacAddress;
    }

    public abstract void connectWifi(String wifiMacAddress);

}
