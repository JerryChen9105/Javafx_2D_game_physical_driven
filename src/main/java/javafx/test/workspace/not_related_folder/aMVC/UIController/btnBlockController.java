package javafx.test.workspace.not_related_folder.aMVC.UIController;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.test.workspace.not_related_folder.aMVC.UIFactory.TestBtn;
import javafx.test.workspace.not_related_folder.aMVC.UIFactory.TestBtnInterface;

public class btnBlockController implements Controller {

    TestBtnInterface testBtnInterface = new TestBtn();



    HBox selectBlockRoot = new HBox(20);




    @Override
    public Node init() {
        return null;
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
