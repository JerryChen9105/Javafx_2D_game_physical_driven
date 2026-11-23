package javafx.test.workspace.folder.testOOD.device;

public class Hub {

    private MessageReceiver<String> stringReceiver;

    public Hub(MessageReceiver<String> stringReceiver) {
        this.stringReceiver = stringReceiver;
    }

    public MessageReceiver<String> getStringReceiver() {
        return stringReceiver;
    }

    public void setStringReceiver(MessageReceiver<String> stringReceiver) {
        this.stringReceiver = stringReceiver;
    }

    public void broadcastCommand(String cmd) {
        stringReceiver.receive(cmd);
    }

}

