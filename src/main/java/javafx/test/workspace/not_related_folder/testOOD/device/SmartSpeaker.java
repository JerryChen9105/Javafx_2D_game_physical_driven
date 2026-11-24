package javafx.test.workspace.not_related_folder.testOOD.device;

public class SmartSpeaker implements MessageReceiver<String> {

    private int volume;

    public SmartSpeaker(int valume) {
        this.volume = valume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void receive(String message) {
        System.out.println(message);
    }
}

