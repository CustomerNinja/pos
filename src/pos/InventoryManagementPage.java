package pos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static pos.InventoryPage.getGridPane;
//import static pos.InventoryPage.ITEM_CLICKED;

//extends the InventoryPage
public class InventoryManagementPage{

   

    public static Scene getPage(int inventorypointer) throws FileNotFoundException{
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        Menu menu0 = new Menu();
        MenuItem  menuItem0 = new MenuItem();
        Menu menu1 = new Menu();
        MenuItem menuItem1 = new MenuItem();
        MenuItem logOutMenuItem = new MenuItem();
        Pane previewPane = new Pane();
        AnchorPane anchorPane = new AnchorPane();
        Pane itemPane = new Pane();
        ImageView imageView = new ImageView();
        Text selectedItemPriceText = new Text();
        Text selectedItemNameText = new Text();
        Text item_label = new Text();
        Text price_label = new Text();
        Text quantity_label = new Text();
        Text selectedItemStockText = new Text();
        TextFlow textFlow = new TextFlow();
        Pane buttonPane = new Pane();
        Button adjustPriceButton = new Button();
        Button adjust_stock_button = new Button();
        Button new_item_button = new Button();
        Button adjust_discount_button = new Button();
        Button remove_inventory_button = new Button();
        Button select_image_button = new Button();
        //added manager nav page button
        Button toManagerNavPageButton = new Button();
        AnchorPane root = new AnchorPane();
        GridPane gridpane = getGridPane(0);

        //create the menu bar
        menuBar.setId("menubar");
        menuBar.setPrefHeight(29.0);
        menuBar.setPrefWidth(1280.0);
        menu.setMnemonicParsing(false);
        menu.setText("File");
        menuItem.setMnemonicParsing(false);
        menuItem.setText("Close");
        logOutMenuItem.setMnemonicParsing(false);
        logOutMenuItem.setText("Sign Out");
        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");
        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Delete");
        menu1.setMnemonicParsing(false);
        menu1.setText("Help");
        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("About");
        menu.getItems().add(menuItem);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.getItems().add(logOutMenuItem);
        logOutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                    Stage stage = (Stage)menuBar.getScene().getWindow();
                    stage.setScene(new Scene(root) );
                    stage.show();
                } catch(Exception exc) {
                    System.out.println("Logout Fail! " + exc.toString());
                }
            }
        });
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItem0);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(menuItem1);
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("AboutPopUp.fxml"));
                    stage.setScene(new Scene(root));
                } catch (IOException ex) {
                    System.out.println("About Page Fail! " + ex.toString());
                }
                stage.setTitle("About CustomerNinja");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            }
        });
        menuBar.getMenus().add(menu1);

        //create the item preview pane
        previewPane.setLayoutX(720.0);
        previewPane.setLayoutY(29.0);
        previewPane.setPrefHeight(260.0);
        previewPane.setPrefWidth(556.0);

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(258.0);
        anchorPane.setPrefWidth(536.0);

        itemPane.setId("itempane");
        itemPane.setLayoutX(720.0);
        itemPane.setLayoutY(29.0);
        itemPane.setPrefHeight(260.0);
        itemPane.setPrefWidth(541.0);

        imageView.setFitHeight(80.0);
        imageView.setFitWidth(80.0);
        imageView.setId("preview_image");
        imageView.setLayoutX(37.0);
        imageView.setLayoutY(66.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        //set the image
       // imageView.setImage(new Image(getClass().getResource("Documents/Icon_Boost_EnergyDrink.png").toExternalForm()));

        selectedItemPriceText.setLayoutX(128.0);
        selectedItemPriceText.setLayoutY(91.0);
        selectedItemPriceText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        selectedItemPriceText.setStrokeWidth(0.0);
        selectedItemPriceText.setText("$99.99");

        selectedItemNameText.setId("preview_name");
        selectedItemNameText.setLayoutX(40.0);
        selectedItemNameText.setLayoutY(159.0);
        selectedItemNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        selectedItemNameText.setStrokeWidth(0.0);
        selectedItemNameText.setText("Item Name");

        item_label.setId("item_label");
        item_label.setLayoutX(46.0);
        item_label.setLayoutY(43.0);
        item_label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        item_label.setStrokeWidth(0.0);
        item_label.setText("Item");
        item_label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        item_label.setFont(new Font(15.0));

        price_label.setId("price_label");
        price_label.setLayoutX(131.0);
        price_label.setLayoutY(44.0);
        price_label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        price_label.setStrokeWidth(0.0);
        price_label.setText("Price");
        price_label.setFont(new Font(15.0));

        quantity_label.setId("quantity_label");
        quantity_label.setLayoutX(214.0);
        quantity_label.setLayoutY(44.0);
        quantity_label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        quantity_label.setStrokeWidth(0.0);
        quantity_label.setText("Quantity");
        quantity_label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        quantity_label.setFont(new Font(15.0));

        selectedItemStockText.setLayoutX(231.0);
        selectedItemStockText.setLayoutY(91.0);
        selectedItemStockText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        selectedItemStockText.setStrokeWidth(0.0);
        selectedItemStockText.setText("100");

        textFlow.setId("textbox");
        textFlow.setLayoutX(6.0);
        textFlow.setLayoutY(163.0);
        textFlow.setPrefHeight(92.0);
        textFlow.setPrefWidth(531.0);

        buttonPane.setId("buttonpane");
        buttonPane.setLayoutX(720.0);
        buttonPane.setLayoutY(297.0);
        buttonPane.setPrefHeight(412.0);
        buttonPane.setPrefWidth(556.0);
        buttonPane.setStyle("-fx-background-color: gray;");

        adjustPriceButton.setId("adjust_price");
        adjustPriceButton.setLayoutX(52.0);
        adjustPriceButton.setLayoutY(57.0);
        adjustPriceButton.setMnemonicParsing(false);
        adjustPriceButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                     System.out.println("adjusted price");
                                    //display adjust discount pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("AdjustPricePopUp.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("CustomerNinja - Item Price");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                }
                            });
        adjustPriceButton.setText("Adjust Price");

        adjust_stock_button.setId("adjust_stock");
        adjust_stock_button.setLayoutX(151.0);
        adjust_stock_button.setLayoutY(57.0);
        adjust_stock_button.setMnemonicParsing(false);
        adjust_stock_button.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                     System.out.println("adjusted quantity");
                                    //display adjust discount pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("AdjustQuantityPopUp.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("CustomerNinja - Item Quantity");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                }
                            });
        adjust_stock_button.setText("Adjust Quantity in Stock");

        new_item_button.setId("new_item");
        new_item_button.setLayoutX(52.0);
        new_item_button.setLayoutY(296.0);
        new_item_button.setMnemonicParsing(false);
        new_item_button.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                     System.out.println("added new item");
                                    //display adjust discount pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("AddItemPage.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("CustomerNinja - New Item");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                    //adjustDiscountButtonHandler();
                                }
                            });
        new_item_button.setText("New Item");

        adjust_discount_button.setId("adjust_discount");
        adjust_discount_button.setLayoutX(314.0);
        adjust_discount_button.setLayoutY(57.0);
        adjust_discount_button.setMnemonicParsing(false);
        adjust_discount_button.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                    System.out.println("adjusted discount");
                                    //display adjust discount pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("AdjustDiscountPopUp.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("Adjust Item Discount Value");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                }
                            });
        adjust_discount_button.setText("Adjust Discount Value");

        remove_inventory_button.setId("remove_inventory");
        remove_inventory_button.setLayoutX(52.0);
        remove_inventory_button.setLayoutY(194.0);
        remove_inventory_button.setMnemonicParsing(false);
        remove_inventory_button.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t) {

                                    removeItemButtonHandler();
                                    
                                    //display remove item pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("RemoveItemPopUp.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        System.out.println("Remove Item Pop Up Display Fail! " + ex.toString());
                                    }
                                    
                                    stage.setTitle("CustomerNinja - Remove Item");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                }
                            });
        remove_inventory_button.setText("Remove Selected Item from Inventory");

        select_image_button.setId("select_image_button");
        select_image_button.setLayoutX(52.0);
        select_image_button.setLayoutY(115.0);
        select_image_button.setMnemonicParsing(false);
        select_image_button.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                     System.out.println("changed image");
                                    //display adjust discount pop-up window
                                    Stage stage = new Stage();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("AdjustImageFilePopUp.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("CustomerNinja - Select Image File");
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.showAndWait();
                                }
                            });
        select_image_button.setText("Change Selected Item Image File");

        //To Manager Navigation Page Button Below
        toManagerNavPageButton.setId("select_image_button");
        toManagerNavPageButton.setLayoutX(200.0);
        toManagerNavPageButton.setLayoutY(350.0);
        toManagerNavPageButton.setMnemonicParsing(false);
        toManagerNavPageButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

                                @Override
                                public void handle(MouseEvent t){

                                    System.out.println("to Manager Nav Page Button Clicked");
                                    //display adjust discount pop-up window
                                    Stage stage = (Stage)toManagerNavPageButton.getScene().getWindow();
                                    Parent root;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("ManagerFunctionsNavPage.fxml"));
                                        stage.setScene(new Scene(root));
                                    } catch (IOException ex) {
                                        Logger.getLogger(InventoryManagementPage.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    stage.setTitle("CustomerNinja - Manager Navigation Page");
                                    stage.show();
                                }
                            });
        toManagerNavPageButton.setText("to Manager Navigation Page");
        
        itemPane.getChildren().add(imageView);
        itemPane.getChildren().add(selectedItemPriceText);
        itemPane.getChildren().add(selectedItemNameText);
        itemPane.getChildren().add(item_label);
        itemPane.getChildren().add(price_label);
        itemPane.getChildren().add(quantity_label);
        itemPane.getChildren().add(selectedItemStockText);
        itemPane.getChildren().add(textFlow);
       
        buttonPane.getChildren().add(adjustPriceButton);
        buttonPane.getChildren().add(adjust_stock_button);
        buttonPane.getChildren().add(new_item_button);
        buttonPane.getChildren().add(adjust_discount_button);
        buttonPane.getChildren().add(remove_inventory_button);
        buttonPane.getChildren().add(select_image_button);
        buttonPane.getChildren().add(toManagerNavPageButton);
        
       //problems be here
       
        root.getChildren().add(menuBar);
        root.getChildren().add(gridpane);
        root.getChildren().add(buttonPane);
        root.getChildren().add(itemPane);
        root.getChildren().add(previewPane);

        Scene scene = new Scene(root,1280,720);
        return scene;
    }
    
     protected static GridPane getGridPane(int inventorypointer) throws FileNotFoundException{
        //create the gridpane and set it's layout position on the scene    
	GridPane gridpane = new GridPane();
        gridpane.setLayoutY(29.0);
        NinjaConn njc = new NinjaConn();
        Inventory inventory = new Inventory(njc);
        LinkedList<Item> itemList = inventory.getItemList();
      
        //values for the rows and columns of the displayed inventory
        int COLUMNS = 8;
	int ROWS = 6;

        //create the necessary columns and rows on the gridpane
        for(int i = 0; i < COLUMNS; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints();
            gridpane.getColumnConstraints().add(columnConstraints);      
        }
        for(int i = 0; i < ROWS; i++){
            RowConstraints rowConstraints = new RowConstraints();
            gridpane.getRowConstraints().add(rowConstraints);
        }

        //create the item counter to iterate through list
        int itemCounter = 0;

        //add and generate the items
        for(int i = 0; i < ROWS; i++){

            for(int j = 0; j < COLUMNS; j++){
                //get the next item
                if(itemCounter < itemList.size()){
                Item currentItem = itemList.get(itemCounter);
                    //increment the itemCounter
                    itemCounter++;

                    //the image for each of the items 80x80 pixels, also acts as the button
                    ImageView itemButton = new ImageView();
                    itemButton.setFitHeight(80.0);
                    itemButton.setFitWidth(80.0);
                    itemButton.setLayoutX(12.0);
                    itemButton.setPickOnBounds(true);
                    itemButton.setPreserveRatio(true);    

                    //get the imagefile path for the item
                    
                    System.out.println((System.getProperty("user.dir") + System.getProperty("file.separator") + "Images" + System.getProperty("file.separator") + currentItem.getImagePath()));

                    String imgFile = currentItem.getImagePath();
                    FileInputStream inStreamImage = new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "Images" + System.getProperty("file.separator") + currentItem.getImagePath());
                    Image imageObject = new Image(inStreamImage);
                    itemButton.setImage(imageObject);

                    //item panes will be 90x90 pixels
                    Pane pane = new Pane();
                    pane.setPrefHeight(90.0);
                    pane.setPrefWidth(90.0);

                    //create the quantity text
                    Text quantity = new Text();
                    quantity.setFill(javafx.scene.paint.Color.RED);
                    quantity.setLayoutX(5.0);
                    quantity.setLayoutY(50.0);
                    quantity.setStroke(javafx.scene.paint.Color.WHITE);
                    quantity.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                    //set quantity text
                    quantity.setText(Integer.toString(currentItem.getQuantity()));
                    quantity.setTextOrigin(javafx.geometry.VPos.BOTTOM);
                    quantity.setWrappingWidth(24.85107421875);

                    //create the item title
                    Text itemTitle = new Text();
                    itemTitle.setLayoutX(12.0);
                    itemTitle.setLayoutY(88.0);
                    itemTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                    itemTitle.setStrokeWidth(0.0);
                    //set the item title
                    itemTitle.setText(currentItem.getName());

                    //create the invisible itemID text
                    Text itemID = new Text();
                    itemID.setVisible(false);
                    itemID.setText(Integer.toString(currentItem.getID()));


                    pane.getChildren().add(itemButton);
                    pane.getChildren().add(itemTitle);
                    pane.getChildren().add(quantity);

                    Button button = new Button("",pane);

                    gridpane.add(button,j,i);

                    //create the handler for the generated item
                    pane.setOnMouseClicked(new EventHandler<MouseEvent>(){

                        @Override
                        public void handle(MouseEvent t){
                               System.out.println("clicked item: " + currentItem.getID());
//                            ITEM_CLICKED(Integer.toString(currentItem.getID()));
                        }
                    });

                }

            }
        
        }
        njc.close();
        gridpane.setGridLinesVisible(true);    
        gridpane.setLayoutY(29.0);

        return gridpane;

    }

    protected static void adjustPriceButtonHandler(){
        System.out.println("adjusted price");
    };

    protected static void adjustQuantityButtonHandler(){
        System.out.println("adjusted quantity");
    };
    
    protected static void addNewItemButtonHandler(){
        System.out.println("added item");
    };
    
    /**
     *
     * @throws IOException
     */
    protected void adjustDiscountButtonHandler() throws IOException{
        System.out.println("adjusted discount");
        //display adjust discount pop-up window
        Stage stage = new Stage();
        
        //Class<?> cl=new Object(){}.getClass().getEnclosingClass();
        Parent root = FXMLLoader.load(getClass().getResource("AdjustDiscountPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Adjust Item Discount Value");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    };
    
    protected static void removeItemButtonHandler() {
        System.out.println("removed item");
    };
    
    protected static void adjustImageFileButtonHandler(){
        System.out.println("changed image");
    };

    protected static void ITEM_CLICKED(String s){
            System.out.println("clicked item: " + s);
    }

}
