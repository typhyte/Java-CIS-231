import java.sql.Time;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class HelloWorld extends Application {
    Rectangle rect1, rect2;
    PathTransition pt1, pt2;
    FadeTransition ft1, ft2;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Pane root = new Pane();
        StackPane stack = new StackPane();

        // make rect
        stack.setLayoutX(100);
        stack.setLayoutY(100);
        rect1 = new Rectangle(20,20,200,200);
        rect1.setFill((Color.BLUE));
        rect2 = new Rectangle(40, 40, 160, 160);
        rect2.setFill(Color.RED);

        // add all objects to scene
        stack.getChildren().addAll(rect1, rect2);
        root.getChildren().addAll(stack);

        // set defs for animation
        pt1 = new PathTransition();
        pt1.setDuration(Duration.millis(1000));
        pt1.setCycleCount(Timeline.INDEFINITE);

        // set track for animation to play
        pt1.setPath(new Line(10, 10, 550, 550));
        pt1.setAutoReverse(true);
        pt1.setNode(rect1);

        //play anim
        pt1.play();

        // set defs for animation
        pt2 = new PathTransition();
        pt2.setDuration(Duration.millis(1000));
        pt2.setCycleCount(Timeline.INDEFINITE);

        // set track for animation to play
        pt2.setPath(new Circle(10, 10, 100));
        pt2.setAutoReverse(true);
        pt2.setNode(rect2);

        //play anim
        pt2.play();

        // define fade transition properties
        ft1 = new FadeTransition(Duration.millis(2000));
        ft1.setFromValue(0);
        ft1.setToValue(1);
        ft1.setCycleCount(Timeline.INDEFINITE);
        ft1.setAutoReverse(true);
        // play fade transition
        ft1.play();

        // define second fade transition properties
        ft2 = new FadeTransition(Duration.millis(2000));
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.setCycleCount(Timeline.INDEFINITE);
        ft2.setAutoReverse(true);
        // play second fade transition
        ft2.play();

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
