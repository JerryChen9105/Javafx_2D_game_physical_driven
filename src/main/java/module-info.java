module javafx.test.workspace {

    requires javafx.graphics;
    requires java.desktop;
    requires javafx.controls;

    exports javafx.test.workspace to javafx.graphics;
    exports javafx.test.workspace.aMVC.UIFactory to javafx.graphics;
    exports javafx.test.workspace.event to javafx.graphics;

}