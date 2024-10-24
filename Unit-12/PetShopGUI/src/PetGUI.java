import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class PetGUI extends Application {
    // elements in GUI //
    Label nameL, ageL, costL;
    TextField nameT, ageT, costT;
    Button next, prev, exit;
    // arrangement in GUI //
    BorderPane root;
    GridPane grid;
    HBox buttons;
    // data //
    ArrayList<Pet> pets;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pet Shop");
        
        initialize();

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    void loadData(String fName) {
        pets = new ArrayList<>();
        ArrayList<String> list = MyFile.readFile(fName);

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] fields = str.split(",");
            Pet pet = new Pet(fields[0].trim(),
                              Integer.parseInt(fields[1].trim()),
                              Double.parseDouble(fields[2].trim()));

            pets.add(pet);
        }
    }

    void initialize() {
        // labels //
        nameL = new Label("Pet Name");
        ageL = new Label("Pet Age");
        costL = new Label("Cost of Adoption");
        // text //
        nameT = new TextField();
        ageT = new TextField();
        costT = new TextField();
        // navigation //
        next = new Button("Next ->");
        prev = new Button("<- Previous");
        exit = new Button("Exit");
        // arrangement //
        root = new BorderPane();
        grid = new GridPane();
        buttons = new HBox();

        grid.addColumn(0, nameL, ageL, costL);
        grid.addColumn(1, nameT, ageT, costT);
        buttons.getChildren().addAll(prev, exit, next);
        root.setCenter(grid);
        root.setBottom(buttons);
    }
}
