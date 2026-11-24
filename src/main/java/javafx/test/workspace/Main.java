package javafx.test.workspace;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.test.workspace.gametick_system.GameTickSystem;
import javafx.test.workspace.physic_model.entity.Ball;
import javafx.test.workspace.physic_model.entity.Entity;
import javafx.test.workspace.physic_model.obstacle.Boundary;
import javafx.test.workspace.physic_engine.PhysicalStatus;
import javafx.test.workspace.math_object.Vector;



public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Group primaryRoot = new Group();

        Circle circle = new Circle(15, Paint.valueOf("red"));
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
        Boundary boundary = new Boundary(50, 1400, 20, 750);
        Entity ballModel = new Ball(physicalStatus, boundary, 15);


        Rectangle lb = new Rectangle(10, 2000);
        lb.setFill(Paint.valueOf("black"));
        lb.setX(boundary.getLeftBound() - 10);

        Rectangle rb = new Rectangle(10, 2000);
        rb.setFill(Paint.valueOf("black"));
        rb.setX(boundary.getRightBound());

        Rectangle tb = new Rectangle(2000, 10);
        tb.setFill(Paint.valueOf("black"));
        tb.setY(boundary.getTopBound() - 10);

        Rectangle bb = new Rectangle(2000, 10);
        bb.setFill(Paint.valueOf("black"));
        bb.setY(boundary.getBottomBound());


        primaryRoot.getChildren().addAll(
                circle,
                lb, rb, tb, bb
        );
        Scene scene = new Scene(primaryRoot);



        GameTickSystem tickSystem = new GameTickSystem(
                ballModel,
                () -> {circle.setCenterX(ballModel.getStatus().getPos().getX());
                    circle.setCenterY(ballModel.getStatus().getPos().getY());},
                1000
        );


        scene.setOnKeyPressed(press -> {
            switch (press.getCode()) {
                case UP -> tickSystem.setUpPressed(true);
                case DOWN -> tickSystem.setDownPressed(true);
                case LEFT -> tickSystem.setLeftPressed(true);
                case RIGHT -> tickSystem.setRightPressed(true);
                case ENTER -> tickSystem.startGameTick();
                case ESCAPE -> tickSystem.stopGameTick();
            }
        });
        scene.setOnKeyReleased(release -> {
            switch (release.getCode()) {
                case UP -> tickSystem.setUpPressed(false);
                case DOWN -> tickSystem.setDownPressed(false);
                case LEFT -> tickSystem.setLeftPressed(false);
                case RIGHT -> tickSystem.setRightPressed(false);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Physical simulation Engine");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}


/*

public class Main extends Application {


    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Group primaryRoot = new Group();

        Circle circle = new Circle(15, Paint.valueOf("red"));
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
        Entity ballModel = new Ball(physicalStatus, boundary, 15);


        Rectangle lb = new Rectangle(10, 1000);
        lb.setFill(Paint.valueOf("black"));
        lb.setX(100 - 10);

        Rectangle rb = new Rectangle(10, 1000);
        rb.setFill(Paint.valueOf("black"));
        rb.setX(900);

        Rectangle tb = new Rectangle(1200, 10);
        tb.setFill(Paint.valueOf("black"));
        tb.setY(50 - 10);

        Rectangle bb = new Rectangle(1200, 10);
        bb.setFill(Paint.valueOf("black"));
        bb.setY(700);


        primaryRoot.getChildren().addAll(
                circle,
                lb, rb, tb, bb
        );
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

                double deltaTime = (now - lastTime) / 500_000_000.0;
                lastTime = now;

                double pushForce = 1500.0;
                if (upPressed) ballModel.getStatus().applyForce(new Vector(0, -pushForce));
                if (downPressed) ballModel.getStatus().applyForce(new Vector(0, pushForce));
                if (leftPressed) ballModel.getStatus().applyForce(new Vector(-pushForce, 0));
                if (rightPressed) ballModel.getStatus().applyForce(new Vector(pushForce, 0));

                ballModel.getStatus().update(deltaTime);

                ballModel.resolveBoundaryCollision();


                circle.setCenterX(ballModel.getStatus().getPos().getX());
                circle.setCenterY(ballModel.getStatus().getPos().getY());
            }
        };
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Physical simulation Engine");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
*/


