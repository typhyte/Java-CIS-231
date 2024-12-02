import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class ManaganUI extends Application {
    // program-wide vars
    ArrayList<String> moneyCSV = MyFile.readFile("money.csv");

    int money = Integer.parseInt(moneyCSV.get(0));
    ArrayList<ManaganCard> cardList;
    
    // scenes
    Scene titleScene, collectionScene, shopScene, cardInspectionScene;
    Stage currentStage;

    // utility functions
    void saveData() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < cardList.size(); i++) {
            list.add(cardList.get(i).toString());
        }

        MyFile.writeFile(list, "card_data.csv");
        MyFile.writeFile(moneyCSV, "money.csv");
    }
    
    void loadData(String fileName) { // loads data into a arraylist for easy storage
        cardList = new ArrayList<>();
        ArrayList<String> list = MyFile.readFile(fileName);

        for (int i = 0; i < list.size(); i++) {
            String curItem = list.get(i);
            String[] fields = curItem.split(",");
            ManaganCard card = new ManaganCard(fields[0].trim(), 
                                               Integer.parseInt(fields[1].trim()), 
                                               Integer.parseInt(fields[2].trim()), 
                                               Boolean.parseBoolean(fields[3].trim()), 
                                               fields[4].trim(),
                                               Integer.parseInt(fields[5].trim()));
            cardList.add(card);
        }
    }

    void updateCardArt() {
        ColorAdjust monochrome = new ColorAdjust();
        monochrome.setSaturation(-0.8);

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (cardList.get(j+(5*i)).isOwned == false) {
                    cardImages[i][j].setEffect(monochrome);
                } else {
                    cardImages[i][j].setEffect(null);
                }
            }
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
        prepShopScene();

        primaryStage.setScene(titleScene);
        primaryStage.show();
    }
    
    // collection of roots for each scene
    BorderPane titleRoot, collectionRoot, shopRoot;
    StackPane cardInspectionRoot;

    // start of title scene creation
    // scene elements
    Button startButton;
    ImageView gameLogo;
    
    // organizaiton elements
    GridPane titleOrganizer;
    

    void prepTitleScene() {
        createTitleScene();
        setTitleSceneButtonActions();
        titleScene = new Scene(titleRoot, 1600, 900);
    }

    void createTitleScene() {
        // initialize elements
        titleOrganizer = new GridPane();
        gameLogo = new ImageView();
        gameLogo.setFitHeight(540);
        gameLogo.setFitWidth(960);
        gameLogo.setImage(new Image("file:logo.png"));
        startButton = new Button("Enter Managan");

        // create root (for placing stuff)
        titleRoot = new BorderPane();

        titleOrganizer.addRow(0, gameLogo);
        titleOrganizer.addRow(1, startButton);

        GridPane.setHalignment(startButton, HPos.CENTER);
        titleOrganizer.setAlignment(Pos.CENTER);
        titleOrganizer.setPadding(new Insets(20, 20, 20, 20));
        titleOrganizer.setVgap(20);
        titleRoot.setCenter(titleOrganizer);
    }

    void setTitleSceneButtonActions() {
        startButton.setOnAction(e -> {
            currentStage.setScene(collectionScene);
        });
    }

    // start of collection scene creation
    // scene organization
    GridPane cardCollection;
    HBox cardCollectionRow[];
    

    // scene elements
    ImageView[][] cardImages;
    Button toShopButton, debugOwnDeOwnButton;
    Label moneyOwned;

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
        cardImages = new ImageView[3][5];
        cardCollectionRow = new HBox[3];

        moneyOwned = new Label("$" + money);

        for (int i = 0; i < 3; i++) {
            cardCollectionRow[i] = new HBox(20);
            for (int j = 0; j < 5; j++) {
                cardImages[i][j] = new ImageView();
                cardImages[i][j].setFitHeight(252);
                cardImages[i][j].setFitWidth(180);
                /* implementation's weird, but adding j by the product of i + 5 should return
                 * the correct one dimensional index number.*/
                cardImages[i][j].setImage(new Image("file:" + cardList.get(j+(5*i)).getCardArt()));
            }
            cardCollectionRow[i].getChildren().addAll(cardImages[i][0], cardImages[i][1], cardImages[i][2], cardImages[i][3], cardImages[i][4]);
        }

        // if card is not collected, make it a different shade.
        updateCardArt();

        cardCollection.addRow(1, cardCollectionRow[0]);
        cardCollection.addRow(2, cardCollectionRow[1]);
        cardCollection.addRow(3, cardCollectionRow[2]);

        cardCollection.setPadding(new Insets(50, 50, 50, 50));
        cardCollection.setVgap(20);
        cardCollection.setHgap(20);

        toShopButton = new Button("Go to Shop");
        debugOwnDeOwnButton = new Button("Get rid of all cards");

        collectionRoot.setCenter(cardCollection);
        collectionRoot.setRight(toShopButton);
        collectionRoot.setLeft(moneyOwned);
    }

    void setCollectionSceneButtonActions() {
        for (int i = 0; i < cardImages.length; i++) {
            final int cardArtRow = i;
            for (int j = 0; j < cardImages[i].length; j++) {
                final int cardArtColumn = j;
                cardImages[i][j].setOnMouseClicked(e -> {
                    if (cardList.get(cardArtColumn + (cardArtRow * 5)).isOwned) {
                        prepCardInspectionScene(cardArtColumn+(cardArtRow*5));
                        currentStage.setScene(cardInspectionScene);
                    }
                });
            }
        }

        toShopButton.setOnAction(e -> {
            currentStage.setScene(shopScene);
        });
    }

    // start of card inspection scene
    // organization
    GridPane inspectorView;
    BorderPane buttonArea;
    VBox cardProperties;

    // elements
    ImageView cardView;
    Label cardName, cardRarity, cardPrice;
    Button returnButton, sellCardButton;

    void prepCardInspectionScene(int currentClickedCard) {
        createCardInspectionScene(currentClickedCard);
        setCardInspectionSceneButtonActions(currentClickedCard);
        cardInspectionScene = new Scene(cardInspectionRoot, 1600, 900);
    }

    void createCardInspectionScene(int currentClickedCard) {
        cardInspectionRoot = new StackPane();
        inspectorView = new GridPane();
        buttonArea = new BorderPane();
        

        cardView = new ImageView();
        cardView.setFitHeight(756);
        cardView.setFitWidth(540);

        cardView.setImage(new Image("file:"+cardList.get(currentClickedCard).getCardArt()));

        cardProperties = new VBox(8);

        cardName = new Label("Name: " + cardList.get(currentClickedCard).getName());
        cardRarity = new Label("Rarity: " + cardList.get(currentClickedCard).getRarity());
        cardPrice = new Label("Price" + cardList.get(currentClickedCard).getPrice());

        cardProperties.getChildren().addAll(cardName, cardRarity, cardPrice);
        
        returnButton = new Button("Return to Collection");
        sellCardButton = new Button("Sell this card");

        buttonArea.setRight(returnButton);
        buttonArea.setLeft(sellCardButton);
        BorderPane.setAlignment(buttonArea, Pos.CENTER);

        inspectorView.addRow(0, cardView, cardProperties);
        inspectorView.setPadding(new Insets(20, 20, 20, 20));
        inspectorView.setVgap(20);
        inspectorView.setHgap(20);
        inspectorView.setAlignment(Pos.CENTER);
        cardProperties.setAlignment(Pos.CENTER_LEFT);

        cardInspectionRoot.getChildren().add(inspectorView);
        cardInspectionRoot.getChildren().add(buttonArea);
    }

    void setCardInspectionSceneButtonActions(int currentClickedCard) {
        returnButton.setOnAction(e -> {
            currentStage.setScene(collectionScene);
        });

        sellCardButton.setOnAction(e -> {
            money += cardList.get(currentClickedCard).getPrice();
            cardList.get(currentClickedCard).isOwned = false;
            currentStage.setScene(collectionScene);

            moneyCSV.set(0, Integer.toString(money));
            updateCardArt();
            saveData();
            moneyOwned.setText("$"+money);
        });
    }

    // start of shop scene
    void prepShopScene() {
        createShopScene();
        setShopSceneButtonActions();
        shopScene = new Scene(shopRoot, 1600, 900);
    }

    GridPane shopMenu;
    Button buyApprenticePackButton, buyMagicalAnimalPackButton, buyFiveWiseOnesPackButton, shopExitButton;
    Label apprenticePackLabel, magicalAnimalLabel, fiveWiseOnesPack, toastCardGot;
    HBox shopExitContainer, toastContainer;
    FadeTransition toastFade;
    int[] cardsCollectedFromPack;
    // probs should be imageviews for card packs n stuff

    void createShopScene() {
        /*
         * this scene should do the following
         * buy a pack [done!]
         * packs contain 2 cards out of the row their associated [done!]
         *      (i.e apprentice pack will be row 0 from the collection scene, magical animal pack will be row 1, and five wise ones will be row 2)
         * after a pack is bought, update the two cards given in the arraylist/csv as owned [done]
         * randomly assign each card with a rarity 0-2 [done!]
         * randomly assign the card a price according to their rarity [done!]
         *      (i.e. rarity 0 gets a price between 1-3 while rarity 2 gets a price between 10-15)
         *      (prices will increase depending on the pack)
         * must use up currency [done!]
         */
        // element
        shopRoot = new BorderPane();
        shopMenu = new GridPane();
        shopExitContainer = new HBox();
        toastContainer = new HBox();
        

        buyApprenticePackButton = new Button("Buy Apprentice Pack!\n$5");
        buyMagicalAnimalPackButton = new Button("Buy Magical Animal Pack\n$10");
        buyFiveWiseOnesPackButton = new Button("Buy Five Wise Ones\n$15");

        shopExitButton = new Button("Exit Shop");

        toastCardGot = new Label();

        toastFade = new FadeTransition(Duration.millis(5000));
        toastFade.setNode(toastCardGot);
        toastFade.setFromValue(1.0);
        toastFade.setToValue(0);
        toastFade.setCycleCount(1);
        toastFade.setAutoReverse(false);

        shopMenu.addRow(0, buyApprenticePackButton, buyMagicalAnimalPackButton, buyFiveWiseOnesPackButton);

        shopExitContainer.getChildren().add(shopExitButton);
        shopExitContainer.setStyle("-fx-alignment: center;");

        toastContainer.getChildren().add(toastCardGot);
        toastContainer.setStyle("-fx-alignment: center;");
        toastCardGot.setFont(new Font(30));

        shopMenu.setPadding(new Insets(50, 50, 50, 50));

        shopMenu.setVgap(20);
        shopMenu.setHgap(20);

        shopMenu.setAlignment(Pos.CENTER);
        shopRoot.setTop(toastContainer);
        shopRoot.setCenter(shopMenu);
        shopRoot.setBottom(shopExitContainer);
    }

    private int randomizeCard(int cardPack) {
        return (int) (Math.random() * 5) + (5*cardPack);
    }

    private int randomizeRarity() {
        int probability = (int) (Math.random() * 100);

        // gives each rarity a different chance of happening instead of just 1 in 3
        if (probability <= 50) {
            return 0;
        } else if (probability < 90) {
            return 1;
        } else {
            return 2;
        }
    }

    private void getYourCards(int pack) {
        // allows us to keep track of the card collected in a pack throughout an entire method
        int curCardCollected = 0;
        int curRarity = 0;
        cardsCollectedFromPack = new int[2];

        for (int i = 0; i < 2; i++) {
            curCardCollected = randomizeCard(pack);
            curRarity = randomizeRarity();
            cardList.get(curCardCollected).isOwned = true;
            cardList.get(curCardCollected).setRarity(curRarity);

            cardsCollectedFromPack[i] = curCardCollected;

            // i have no idea what half of these randoms produce but im just gonna pretend it makes sense
            //  just allows me to calculate the money in order to make it easier to change down the line
            switch (pack) {
                case 0:
                    cardList.get(curCardCollected).setPrice((int) ((Math.random() * 5) + (curRarity * 5)) + 1);
                    break;
                case 1:
                    cardList.get(curCardCollected).setPrice((int) (Math.random() * 10) + (curRarity * 10) + 5);
                    break;
                case 2:
                    cardList.get(curCardCollected).setPrice((int) (Math.random() * 20) + (curRarity * 20) + 2);
                    break;
                default:
                    System.out.println("You got a counterfeit! Oh no!");
            
                    cardList.get(curCardCollected).setPrice(0);                       
            }
            toastCardGot.setText("You got " + cardList.get(cardsCollectedFromPack[0]).getName() + " and " + cardList.get(cardsCollectedFromPack[1]).getName());
            toastFade.playFromStart();


            saveData();
        }
    }

    void setShopSceneButtonActions() {
        buyApprenticePackButton.setOnAction(e -> {
            if (money >= 5) {
                getYourCards(0);
                money -= 5;
            } else {
                System.out.println("You don't have the money!");
            }
        });

        buyMagicalAnimalPackButton.setOnAction(e -> {
            if (money >= 10) {
                getYourCards(1);
                money -= 10;
            } else {
                System.out.println("You don't have the money!");
            }
        });

        buyFiveWiseOnesPackButton.setOnAction(e -> {
            if (money >= 15) {
                getYourCards(2);
                money -= 15;
            } else {
                System.out.println("You don't have the money!");
            }
        });

        shopExitButton.setOnAction(e -> {
            currentStage.setScene(collectionScene);
            updateCardArt();
            moneyOwned.setText("$" + money);
        });


    }
}