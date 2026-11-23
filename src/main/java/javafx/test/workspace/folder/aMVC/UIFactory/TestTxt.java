package javafx.test.workspace.folder.aMVC.UIFactory;

import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TestTxt implements TestTxtInterface {

    Text fruitDetailTxt = new Text("please select a button");

    public TestTxt() {
        fruitDetailTxt.setFont(Font.font(30));
    }

    @Override
    public Node node() {
        return fruitDetailTxt;
    }

    @Override
    public void changeTxt(String str) {
        if (str == null) str = "please select a button";
        fruitDetailTxt.setText(str);
    }
}
