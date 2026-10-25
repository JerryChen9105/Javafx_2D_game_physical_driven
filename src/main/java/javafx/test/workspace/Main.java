package javafx.test.workspace;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox root = new HBox(10, new Text("TEST"));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
