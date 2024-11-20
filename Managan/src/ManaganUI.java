

import java.lang.ProcessBuilder.Redirect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class ManaganUI extends Application {
    // program-wide vars
    int money;
    
    // scenes
    Scene titleScene, collectionScene, shopScene;
    Stage currentStage;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        currentStage = primaryStage;
        primaryStage.setTitle("Managan");

        // TODO: add and load data saved to disk from this game.
        // preps each scene so it can load the scenes as they're called
        prepTitleScene();
        prepCollectionScene();
        // TODO: create prepShopScene(), createShopScene(), and setShopSceneButtonActions()

        primaryStage.setScene(titleScene);
        primaryStage.show();
    }
    
    // collection of roots for each scene
    BorderPane titleRoot, collectionRoot, shopRoot;

    // start of title scene creation
    // scene elements
    Button startButton;

    // organizaiton elements
    GridPane titleOrganizer;
    
    void prepTitleScene() {
        createTitleScene();
        setTitleSceneButtonActions();
        titleScene = new Scene(titleRoot, 750, 750);
    }

    void createTitleScene() {
        // initialize elements
        titleOrganizer = new GridPane();
        startButton = new Button("Enter Managan");
        
        // create root (for placing stuff)
        titleRoot = new BorderPane();

        titleRoot.setCenter(startButton);
    }

    void setTitleSceneButtonActions() {
        startButton.setOnAction(e -> {
            currentStage.setScene(collectionScene);
        });
    }

    // start of collection scene creation
    // scene organization
    GridPane cardCollection;
    Label currentCollection;
    HBox cardCollectionRow[];
    HBox cardCollectionRow2;
    HBox cardCollectionRow3;

    // scene elements
    Rectangle[][] unknownCards;
    // gets everything ready to switch
    void prepCollectionScene() {
        createCollectionScene();
        // TODO: make button actions method
        collectionScene = new Scene(collectionRoot, 1600, 900);
    }

    // creates all elements of collection scene
    void createCollectionScene() {
        // arrangement
        collectionRoot = new BorderPane();
        cardCollection = new GridPane();
        // elements
        currentCollection = new Label("You currently have 0 cards!");
        unknownCards = new Rectangle[3][5];
        cardCollectionRow = new HBox[3];

        for (int i = 0; i < 3; i++) {
            cardCollectionRow[i] = new HBox(20);
            for (int j = 0; j < 5; j++) {
                switch (i) {
                    case 0:
                        unknownCards[i][j] = new Rectangle(180, 252, Color.RED);
                        break;
                    case 1:
                        unknownCards[i][j] = new Rectangle(180, 252, Color.GREEN);
                        break;
                    case 2:
                        unknownCards[i][j] = new Rectangle(180, 252, Color.BLUE);
                        break;
                }
            }
            cardCollectionRow[i].getChildren().addAll(unknownCards[i][0], unknownCards[i][1], unknownCards[i][2], unknownCards[i][3], unknownCards[i][4]);
        }


        cardCollection.addRow(0, currentCollection);
        cardCollection.addRow(1, cardCollectionRow[0]);
        cardCollection.addRow(2, cardCollectionRow[1]);
        cardCollection.addRow(3, cardCollectionRow[2]);

        cardCollection.setPadding(new Insets(50, 50, 50, 50));
        cardCollection.setVgap(20);
        cardCollection.setHgap(20);

        collectionRoot.setCenter(cardCollection);
    }
}
