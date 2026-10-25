package javafx.test.workspace.aMVC.EventSetter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.function.Consumer;

public class StringObserver {

    ObjectProperty<String> currentfruitStr = null;

    ArrayList<Consumer<?>> eventSubscriberList = new ArrayList<>();

    public StringObserver() {
        currentfruitStr = new SimpleObjectProperty<String>(this, null);
    }

    public <T> void addSubscriber(Class<T> eventType, Consumer<T> handler) {
        eventSubscriberList.add(handler);
    }

}
