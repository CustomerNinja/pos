/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author mellon
 */
public class InventoryPage{
    
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
    
    protected static Scene getPage() throws FileNotFoundException{
        //create the stage and the main anchorpane
        Scene scene;
        AnchorPane root = new AnchorPane();
        GridPane gridpane = getGridPane(0);

        //create the inventory navigation buttons
        Button rightButton = new Button();
        Button leftButton = new Button();

        rightButton.setMaxHeight(USE_PREF_SIZE);
        rightButton.setMinHeight(USE_PREF_SIZE);
        rightButton.setMinWidth(USE_PREF_SIZE);
        rightButton.setPrefHeight(27.0);
        rightButton.setPrefWidth(80.0);

        rightButton.setLayoutX(574.0);
        rightButton.setLayoutY(686.0);
        rightButton.setMnemonicParsing(false);
        rightButton.setPrefWidth(80.0);
        rightButton.setText("-->");

        leftButton.setLayoutX(15.0);
        leftButton.setLayoutY(686.0);
        leftButton.setMinHeight(USE_PREF_SIZE);
        leftButton.setMinWidth(USE_PREF_SIZE);
        leftButton.setMnemonicParsing(false);
        leftButton.setPrefHeight(27.0);
        leftButton.setPrefWidth(80.0);
        leftButton.setText("<--");

        //create the handler for the inventory navigation
        rightButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            private Object itemlist;

                        @Override
                        public void handle(MouseEvent t){

    //                            //if it
    //                            if(itemListPointer + 42 <= itemList.size()){
    //                                //calls the parent
    //                                
    //                            }



                        }
            });

                //create the inventory scene and return
                root.getChildren().add(rightButton);
                root.getChildren().add(leftButton);
                root.getChildren().add(gridpane);
                scene = new Scene(root,1280,720);
                return scene;

    }
//    protected static void ITEM_CLICKED(String s){
//        System.out.println("clicked item: " + s);
//    }

}
