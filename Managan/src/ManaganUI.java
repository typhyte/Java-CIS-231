

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class ManaganUI extends Application {
    // program-wide vars
    int money;
    ArrayList<ManaganCard> cardList;
    
    // scenes
    Scene titleScene, collectionScene, shopScene, cardInspectionScene;
    Stage currentStage;

    // utility functions
    void loadData(String fileName) { // loads data into a arraylist for easy storage
        cardList = new ArrayList<>();
        ArrayList<String> list = MyFile.readFile(fileName);

        for (int i = 0; i < list.size(); i++) {
            String curItem = list.get(i);
            String[] fields = curItem.split(",");
            ManaganCard card = new ManaganCard(fields[0].trim(), 
                                               Integer.parseInt(fields[1].trim()), 
                                               Double.parseDouble(fields[2].trim()), 
                                               Boolean.parseBoolean(fields[3].trim()), 
                                               fields[4].trim(),
                                               Integer.parseInt(fields[5].trim()));
            System.out.println(card.toString());
            cardList.add(card);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        currentStage = primaryStage;
        primaryStage.setTitle("Managan");

        loadData("card_data.csv");
        // preps each scene so it can load the scenes as they're called
        prepTitleScene();
        prepCollectionScene();
        // TODO: make createShopScene() and setCardInspectionSceneButtonActions()
        // TODO: create prepShopScene(), createShopScene(), and setShopSceneButtonActions()

        primaryStage.setScene(titleScene);
        primaryStage.show();
    }
    
    // collection of roots for each scene
    BorderPane titleRoot, collectionRoot, cardInspectionRoot, shopRoot;

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
        //TODO: draw title screen graphic
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
    

    // scene elements
    ImageView[][] cardImages;
    ColorAdjust monochrome;

    // gets everything ready to switch
    void prepCollectionScene() {
        createCollectionScene();
        setCollectionSceneButtonActions();
        collectionScene = new Scene(collectionRoot, 1600, 900);
    }

    // creates all elements of collection scene
    void createCollectionScene() {
        // arrangement
        collectionRoot = new BorderPane();
        cardCollection = new GridPane();
        // elements
        currentCollection = new Label("You currently have 0 cards!");
        cardImages = new ImageView[3][5];
        cardCollectionRow = new HBox[3];

        monochrome = new ColorAdjust();
        monochrome.setSaturation(-0.8);

        for (int i = 0; i < 3; i++) {
            cardCollectionRow[i] = new HBox(20);
            for (int j = 0; j < 5; j++) {
                cardImages[i][j] = new ImageView();
                cardImages[i][j].setFitHeight(252);
                cardImages[i][j].setFitWidth(180);
                /* implementation's weird, but adding j by the product of i + 5 should return
                 * the correct one dimensional index number.*/
                cardImages[i][j].setImage(new Image("file:" + cardList.get(j+(5*i)).getCardArt()));

                // if card is not collected, make it a different shade.
                if (cardList.get(j+(5*i)).isOwned() == false) {
                    cardImages[i][j].setEffect(monochrome);
                }
            }
            cardCollectionRow[i].getChildren().addAll(cardImages[i][0], cardImages[i][1], cardImages[i][2], cardImages[i][3], cardImages[i][4]);
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

    void setCollectionSceneButtonActions() {
        for (int i = 0; i < cardImages.length; i++) {
            final int cardArtRow = i;
            for (int j = 0; j < cardImages[i].length; j++) {
                final int cardArtColumn = j;
                cardImages[i][j].setOnMouseClicked(e -> {
                    System.out.println("I've been clicked!!! My ID is... " + cardList.get(cardArtColumn + (cardArtRow*5)).getId());
                    prepCardInspectionScene(cardArtColumn+(cardArtRow*5));
                    currentStage.setScene(cardInspectionScene);

                });
            }
        }
    }

    // start of card inspection scene
    // organization
    GridPane inspectorView;
    VBox cardProperties;

    // elements
    ImageView cardView;
    Label cardName, cardRarity, cardPrice;

    void prepCardInspectionScene(int currentClickedCard) {
        createCardInspectionScene(currentClickedCard);
        setCardInspectionSceneButtonActions();
        cardInspectionScene = new Scene(cardInspectionRoot, 1600, 900);
    }

    void createCardInspectionScene(int currentClickedCard) {
        cardInspectionRoot = new BorderPane();
        inspectorView = new GridPane();

        cardProperties = new VBox(8);

        cardView = new ImageView();
        cardView.setFitHeight(756);
        cardView.setFitWidth(540);

        cardName = new Label("Name: " + cardList.get(currentClickedCard).getName());
        cardRarity = new Label("Rarity: " + cardList.get(currentClickedCard).getRarity());
        cardPrice = new Label("Price" + cardList.get(currentClickedCard).getPrice());

        cardView.setImage(new Image("file:"+cardList.get(currentClickedCard).getCardArt()));

        cardProperties.getChildren().addAll(cardName, cardRarity, cardPrice);
        inspectorView.addRow(0, cardView, cardProperties);
        inspectorView.setPadding(new Insets(20, 20, 20, 20));
        inspectorView.setVgap(20);
        inspectorView.setHgap(20);

        cardInspectionRoot.getChildren().add(inspectorView);
    }

    void setCardInspectionSceneButtonActions() {

    }
}
