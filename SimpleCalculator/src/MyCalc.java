import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class MyCalc extends Application {
    Button sum, exit;
    Label num1L, num2L, sumL;
    TextField num1T, num2T, sumT;
    GridPane myGrid;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        initialize();
        buttonActions();

        primaryStage.setScene(new Scene(myGrid, 300, 250)); // make new scene with myGrid
        primaryStage.show();
    }

    void initialize() {
        num1L = new Label("Num1");
        num2L = new Label("Num2");
        sumL = new Label("Sum");
        sumT = new TextField("");
        sumT.setEditable(false);
        num1T = new TextField("0");
        num2T = new TextField("0");
        sum = new Button("Sum");
        exit = new Button("Exit");
        myGrid = new GridPane();

        myGrid.addColumn(0, num1L, num2L, sumL, sum);
        myGrid.addColumn(1, num1T, num2T, sumT, exit);
    }

    void buttonActions() {
        sum.setOnAction(e -> {
            System.out.println("Adding...");
            int n1 = Integer.parseInt(num1T.getText().trim()); // set first text field to int var
            int n2 = Integer.parseInt(num2T.getText().trim()); // set second text field to int var
            int total = n1 + n2; // sum the 2 text fields

            sumT.setText(total+"");
        });

        exit.setOnAction(e -> {
            System.out.println("Program is exiting!");
            System.exit(0);
        });
    }
}