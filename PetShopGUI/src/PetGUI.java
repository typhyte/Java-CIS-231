import java.io.File;
import java.lang.classfile.Label;
import java.util.ArrayList;

import javax.swing.text.html.ImageView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public class PetGUI extends Application {
    // scenes
    Scene scene1, scene2;
    Stage myStage;

    // elements for scene 1 //
    // elements in GUI //
    Label nameL, ageL, costL;
    TextField nameT, ageT, costT;
    Button next, prev, exit, addPet, updatePet, delete;
    ImageView iv;
    String imageLink;
    // arrangement in GUI //
    BorderPane root;
    GridPane grid;
    GridPane bigGrid;
    HBox image;
    HBox navButtons;
    HBox manipButtons;
    // data //
    ArrayList<Pet> pets;
    int ptr;

    /*--------------------------------------------*/

    // scene 2
    // scene arrangement
    BorderPane root2; 
    GridPane dataGrid2, bigGrid2;

    // elements
    Label nameL2, ageL2, costL2;
    TextField nameT2, ageT2, costT2;
    Button cancel, addPetConfirm, imagePick;
    ImageView iv2;
    String imageLink2;
    FileChooser fileChooser;
    HBox buttons2;
    HBox content;

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
        scene1 = new Scene(root, 600, 600);
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

    void saveData(ArrayList<Pet> petList) {
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i < pets.size(); i++) {
            list.add(pets.get(i).toString());
        }
        MyFile.writeFile(list, "data.csv");
    }

    void initialize1() {
        // labels //
        nameL = new Label("Pet Name");
        ageL = new Label("Pet Age");
        costL = new Label("Cost of Adoption");
        iv = new ImageView();
        iv.setFitHeight(250);
        iv.setFitWidth(250);
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
        delete = new Button("Delete Record");
        // arrangement //
        root = new BorderPane();
        grid = new GridPane();
        navButtons = new HBox();
        manipButtons = new HBox();
        image = new HBox();
        // place the elements //
        grid.addRow(0, nameL, ageL, costL);
        grid.addRow(1, nameT, ageT, costT);
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(20);
        grid.setHgap(20);

        bigGrid = new GridPane();
        bigGrid.setPadding(new Insets(20, 20, 20, 20));
        bigGrid.setVgap(20);
        bigGrid.setHgap(20);

        image.getChildren().addAll(iv);

        bigGrid.addRow(0, grid);
        bigGrid.addRow(1, image);

        navButtons.getChildren().addAll(prev, exit, next);
        manipButtons.getChildren().addAll(addPet, updatePet, delete);
        
        bigGrid.addRow(2, navButtons);
        navButtons.setAlignment(Pos.CENTER);
        manipButtons.setAlignment(Pos.CENTER);
        image.setAlignment(Pos.CENTER);
        root.setBottom(manipButtons);
        root.setCenter(bigGrid);
    }

    void setData(int index) {
        nameT.setText(pets.get(index).getName());
        ageT.setText(pets.get(index).getAge()+"");
        costT.setText(pets.get(index).getCost()+"");
        imageLink = pets.get(index).getLink();
        iv.setImage(new Image("file:" + pets.get(index).getLink()));
    }

    @SuppressWarnings("unused")
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

        iv.setOnMouseClicked(e -> {
            File userImage = fileChooser.showOpenDialog(myStage);

            try {
                if (userImage != null) {
                    String name = userImage.getPath();
                    imageLink = name;
                    iv.setImage(new Image("file:" + imageLink));
                }
            } catch (Exception exp){}
        });

        updatePet.setOnAction(e -> {
            Alert a = new Alert(AlertType.CONFIRMATION);

            a.setTitle("Warning");
            a.setContentText("Are you sure you want to update this entry?");
            a.showAndWait();
            if (a.getResult() == ButtonType.OK) {
                Pet pet = pets.get(ptr);

                pet.setName(nameT.getText().trim());
                pet.setAge(Integer.parseInt(ageT.getText().trim()));
                pet.setCost(Double.parseDouble(costT.getText().trim()));
                pet.setLink(imageLink);

                saveData(pets);
            }
        });

        delete.setOnAction(e -> {
            if (pets.size()==1) {
                Alert a = new Alert(AlertType.INFORMATION);
                a.setTitle("Warning");
                a.setContentText("This is the only record. You cannot delete it.");
                a.show();
            } else {
                Alert a = new Alert(AlertType.CONFIRMATION);
                a.setTitle("Confirm Delete");
                a.setContentText("This will permanently delete the data! Are you sure you want to delete?");
                a.showAndWait();
                if (a.getResult() == ButtonType.OK) {
                    pets.remove(ptr);

                    if (ptr == 0) {
                        ptr = pets.size() - 1;
                    } else {
                        ptr--;
                    }

                    saveData(pets);

                    setData(ptr);
                }
            }
        });
    }

    void initialize2() {
        root2 = new BorderPane();

        // labels //
        nameL2 = new Label("Pet Name");
        ageL2 = new Label("Pet Age");
        costL2 = new Label("Cost of Adoption");
        // text //
        nameT2 = new TextField();
        ageT2 = new TextField();
        costT2 = new TextField();
        // buttons //
        cancel = new Button("Cancel");
        addPetConfirm = new Button("Add pet");
        imagePick = new Button("Choose Image");
    
        dataGrid2 = new GridPane();
        buttons2 = new HBox();
        content = new HBox();

        // set elements
        dataGrid2.setPadding((new Insets(20, 20, 20, 20)));
        dataGrid2.setVgap(20);
        dataGrid2.setHgap(20);

        dataGrid2.addRow(0, nameL2, ageL2, costL2);
        dataGrid2.addRow(1, nameT2, ageT2, costT2);
        
        buttons2.getChildren().addAll(addPetConfirm, cancel, imagePick);

        iv2 = new ImageView();
        iv2.setFitHeight(200);
        iv2.setFitWidth(200);
        iv2.setImage(new Image("file:cat_pics/placeholder.jpg"));

        content.getChildren().addAll(iv2);

        bigGrid2 = new GridPane();
        bigGrid2.addRow(0, dataGrid2);
        bigGrid2.addRow(1, content);

        content.setAlignment(Pos.CENTER);
        buttons2.setAlignment(Pos.CENTER);

        root2.setCenter(bigGrid2);
        root2.setBottom(buttons2);
    }

    void setButtonActions2() {
        fileChooser = new FileChooser();
        
        iv2.setOnMouseClicked(e -> {
            File userImage = fileChooser.showOpenDialog(myStage);

            try {
                if (userImage != null) {
                    String name = userImage.getPath();
                    imageLink2 = name;
                    iv2.setImage(new Image("file:" + imageLink2));
                }
            } catch (Exception exp){}
            
        });

        imagePick.setOnAction(e -> {
            File userImage = fileChooser.showOpenDialog(myStage);

            try {
                if (userImage != null) {
                    String name = userImage.getPath();
                    imageLink2 = name;
                    iv2.setImage(new Image("file:" + imageLink2));
                }
            } catch (Exception exp){}
            
        });

        cancel.setOnAction(e -> {
            myStage.setScene(scene1);
        });

        addPetConfirm.setOnAction(e -> {
            String name = nameT2.getText().trim();
            int age = Integer.parseInt(ageT2.getText().trim());
            double cost = Double.parseDouble(costT2.getText().trim());
            
            Pet pet = new Pet(name, age, cost, imageLink2);
            pets.add(pet);

            ptr = pets.size() - 1;
            setData(ptr);

            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Save Records");
            a.setContentText("Would you like to save these changes?");
            a.showAndWait();

            if (a.getResult() == ButtonType.OK) {
                saveData(pets);
            }

            // revert everything to default
            nameT2.setText("Pet");
            ageT2.setText("0");
            costT2.setText("0.0");
            imageLink2 = "cat_pics/placeholder.jpg";
            iv2.setImage(new Image("file:"+imageLink2));
            
            myStage.setScene(scene1);
        });
    }
}
