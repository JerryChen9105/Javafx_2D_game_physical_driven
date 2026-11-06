package javafx.test.workspace;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.test.workspace.physic_engine.Ball;
import javafx.test.workspace.physic_engine.Boundary;
import javafx.test.workspace.physic_engine.PhysicalStatus;
import javafx.test.workspace.physic_engine.Vector;

import java.lang.classfile.attribute.RuntimeInvisibleAnnotationsAttribute;


public class Main extends Application {


    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Group primaryRoot = new Group();

        Circle circle = new Circle(15, Paint.valueOf("black"));
        circle.setCenterX(250);
        circle.setCenterY(250);

        PhysicalStatus physicalStatus = new PhysicalStatus(
                5,
                new Vector(250, 250),
                new Vector(0, 0),
                new Vector(0, 0),
                0.5,
                0.55
        );
        Boundary boundary = new Boundary(100, 900, 50, 700);
        Ball ballModel = new Ball(physicalStatus, boundary, 15);

        primaryRoot.getChildren().add(circle);
        Scene scene = new Scene(primaryRoot);

        scene.setOnKeyPressed(press -> {
            switch (press.getCode()) {
                case UP -> upPressed = true;
                case DOWN -> downPressed = true;
                case LEFT -> leftPressed = true;
                case RIGHT -> rightPressed = true;
            }
        });

        scene.setOnKeyReleased(release -> {
            switch (release.getCode()) {
                case UP -> upPressed = false;
                case DOWN -> downPressed = false;
                case LEFT -> leftPressed = false;
                case RIGHT -> rightPressed = false;
            }
        });


        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double deltaTime = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                double pushForce = 1500.0;
                if (upPressed) ballModel.getBallStatus().applyForce(new Vector(0, -pushForce));
                if (downPressed) ballModel.getBallStatus().applyForce(new Vector(0, pushForce));
                if (leftPressed) ballModel.getBallStatus().applyForce(new Vector(-pushForce, 0));
                if (rightPressed) ballModel.getBallStatus().applyForce(new Vector(pushForce, 0));

                ballModel.getBallStatus().update(deltaTime);

                ballModel.resolveBoundaryCollision();


                circle.setCenterX(ballModel.getBallStatus().getPos().getX());
                circle.setCenterY(ballModel.getBallStatus().getPos().getY());
            }
        };
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Test Physic Engine");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}


