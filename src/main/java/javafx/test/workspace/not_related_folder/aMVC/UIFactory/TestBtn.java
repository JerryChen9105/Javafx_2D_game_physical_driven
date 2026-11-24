package javafx.test.workspace.not_related_folder.aMVC.UIFactory;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestBtn implements TestBtnInterface {

    HashMap<Integer, Button> btnMap = new LinkedHashMap<>();

    VBox testBlock = new VBox(20);

    Button selectBtn = null;



    public TestBtn() {
        btnMap.put(0, new Button("apple"));
        btnMap.put(1, new Button("orange"));
        btnMap.put(2, new Button("pear"));
        btnMap.put(3, new Button("grape"));
        btnMap.put(4, new Button("banana"));

        btnMap.values().forEach(btn -> {
            testBlock.getChildren().add(btn);
        });
        testBlock.setAlignment(Pos.CENTER);
    }



    @Override
    public Node node() {
        return testBlock;
    }

    @Override
    public void select(int index) {
        selectBtn = btnMap.get(index);
    }

    @Override
    public void clearSelect() {
        selectBtn = null;
    }
}
