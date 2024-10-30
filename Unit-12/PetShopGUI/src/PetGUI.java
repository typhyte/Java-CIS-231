import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class PetGUI extends Application {
    // scenes
    Scene scene1, scene2;
    Stage myStage;

    // elements for scene 1 //
    // elements in GUI //
    Label nameL, ageL, costL;
    TextField nameT, ageT, costT;
    Button next, prev, exit, addPet, updatePet;
    ImageView iv;
    // arrangement in GUI //
    BorderPane root;
    GridPane grid;
    GridPane bigGrid;
    Rectangle rectangle;
    HBox buttons;
    // data //
    ArrayList<Pet> pets;
    int ptr;

    /*--------------------------------------------*/

    // scene 2
    BorderPane root2;
    Button cancel;

    // elements
    Label nameL2, ageL2, costL2;
    TextField nameT2, ageT2, costT2;
    ImageView vi2;
    GridPane dataGrid2;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        myStage = primaryStage;
        primaryStage.setTitle("Pet Shop");
        
        loadData("data.csv");
        makeScene1();
        makeScene2();

        setData(ptr);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    void makeScene1() {
        initialize1();
        setButtonActions1();
        scene1 = new Scene(root, 500, 500);
    }

    void makeScene2() {
        initialize2();
        setButtonActions2();
        scene2 = new Scene(root2, 500, 500);
    }

    void loadData(String fName) {
        pets = new ArrayList<>();
        ArrayList<String> list = MyFile.readFile(fName);

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] fields = str.split(",");
            Pet pet = new Pet(fields[0].trim(),
                              Integer.parseInt(fields[1].trim()),
                              Double.parseDouble(fields[2].trim()),
                              fields[3].trim());

            pets.add(pet);
        }
    }

    void initialize1() {
        // labels //
        nameL = new Label("Pet Name");
        ageL = new Label("Pet Age");
        costL = new Label("Cost of Adoption");
        iv = new ImageView();
        iv.setFitHeight(150);
        iv.setFitWidth(150);
        // text //
        nameT = new TextField();
        ageT = new TextField();
        costT = new TextField();
        // navigation //
        next = new Button("Next ->");
        prev = new Button("<- Previous");
        exit = new Button("Exit");
        addPet = new Button("Add a Pet");
        updatePet = new Button("Update Pet");
        // arrangement //
        root = new BorderPane();
        grid = new GridPane();
        buttons = new HBox();
        // place the elements //
        grid.addColumn(0, nameL, ageL, costL);
        grid.addColumn(1, nameT, ageT, costT);
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(20);
        grid.setHgap(20);

        bigGrid = new GridPane();
        bigGrid.setPadding(new Insets(20, 20, 20, 20));
        bigGrid.setVgap(20);
        bigGrid.setHgap(20);

        // rectangle = new Rectangle(200, 400);
        // rectangle.setFill(Color.BLUE);

        bigGrid.addRow(0, grid, iv);

        buttons.getChildren().addAll(prev, exit, next, addPet, updatePet);
        
        root.setCenter(bigGrid);
        root.setBottom(buttons);
    }

    void setData(int index) {
        nameT.setText(pets.get(index).getName());
        ageT.setText(pets.get(index).getAge()+"");
        costT.setText(pets.get(index).getCost()+"");
        iv.setImage(new Image("file:" + pets.get(index).getLink()));
    }

    void setButtonActions1() {
        next.setOnAction(e -> {
            ptr++;

            if (ptr == pets.size()) {
                ptr = 0;
            }

            setData(ptr);
        });

        prev.setOnAction(e -> {
            ptr--;

            if (ptr == -1) {
                ptr = pets.size() - 1;
            }

            setData(ptr);
        });
    
        exit.setOnAction(e -> {
            System.exit(0);
        });

        addPet.setOnAction(e -> {
            myStage.setScene(scene2);
        });
    }

    void initialize2() {
        root2 = new BorderPane();
        cancel = new Button("Cancel");
        root2.setCenter(cancel);
    }

    void setButtonActions2() {
        cancel.setOnAction(e -> {
            myStage.setScene(scene1);
        });
    }
}
