module javafx.test.workspace {

    requires javafx.graphics;
    requires java.desktop;
    requires javafx.controls;

    exports javafx.test.workspace to javafx.graphics;
    exports javafx.test.workspace.folder.aMVC.UIFactory to javafx.graphics;
    exports javafx.test.workspace.folder.event to javafx.graphics;
    exports javafx.test.workspace.folder.test to javafx.graphics;

}