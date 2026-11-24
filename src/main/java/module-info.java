module javafx.test.workspace {

    requires javafx.graphics;
    requires java.desktop;
    requires javafx.controls;

    exports javafx.test.workspace to javafx.graphics;
    exports javafx.test.workspace.not_related_folder.aMVC.UIFactory to javafx.graphics;
    exports javafx.test.workspace.not_related_folder.event to javafx.graphics;
    exports javafx.test.workspace.not_related_folder.test to javafx.graphics;
    exports javafx.test.workspace.gametick_system to javafx.graphics;

}