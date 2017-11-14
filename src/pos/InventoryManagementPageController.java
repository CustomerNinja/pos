/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class InventoryManagementPageController implements Initializable {
    
    //@FXML private ImageView selectedItemImage;
    
    //@FXML private Text selectedItemNameText;
    
    //@FXML private Text selectedItemPriceText;
    
    //@FXML private Text selectedItemStockText;
    
    //@FXML private Button adjustPriceButton;
    
    @FXML private TextField newPriceField;
    
    @FXML private TextField newQuantityField;
    
    @FXML private TextField newDiscountField;
    
    @FXML private TextField newImageField;
    
    @FXML private Button cancelButton;
    
    Stage stage;
    
    Parent root;
    
    //this will be the selected item when the GridPane select method works
    //@FXML private Item selectedItem;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
//    @FXML
//    public void selectItemHandler(ActionEvent event) throws IOException {
//        //need to figure out how to select from the GridPane
//        
//    }
//    
//    
//    @FXML
//    public void adjustPriceButtonHandler(ActionEvent event) throws IOException {
//        
//        System.out.println("Adjust Price Button Clicked");
//        
//        //display adjust price pop-up window
//        stage = new Stage();
//        root = FXMLLoader.load(getClass().getResource("AdjustPricePopUp.fxml"));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Adjust Item Price");
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(adjustPriceButton.getScene().getWindow());
//        stage.show();
//        
//        //selectedItem.setPrice(newPriceField.getText() );
//        
//    }
    
    @FXML
    public void setPriceButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Price Button Clicked");
        
        stage = (Stage)newPriceField.getScene().getWindow();
        stage.close();
        
    }
    
    
//    @FXML
//    public void adjustQuantityButtonHandler(ActionEvent event) throws IOException {
//        
//        System.out.println("Adjust Quantity Button Clicked");
//        
//        //display adjust quantity pop-up window
//        stage = new Stage();
//        root = FXMLLoader.load(getClass().getResource("AdjustQuantityPopUp.fxml"));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Adjust Item Quantity");
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(adjustPriceButton.getScene().getWindow());
//        stage.showAndWait();
//        
//        //selectedItem.setQuantity(newQuantity);
//        
//    }
    
    @FXML
    public void setQuantityeButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Quantity Button Clicked");
        
        //change slected item quantity
        
        stage = (Stage)newQuantityField.getScene().getWindow();
        stage.close();
        
        
        
    }
    
    /**
     *
     * @param event - a mouse click
     * @throws IOException
     * creates and stores new item in inventory
     */
//    @FXML
//    public void addNewItemButtonHandler(ActionEvent event) throws IOException {
//        //needs to be able to manipulate the inventory list and database
//        
//        System.out.println("Add New Item Button Clicked");
//      
//        
//        //njc.addRowInventory(name, quantity, price, description, discount, imgFile);
//    }
    
    
//    @FXML
//    public void adjustDiscountButtonHandler(ActionEvent event) throws IOException {
//        
//        System.out.println("Adjust Discount Button Clicked");
//        
//        //display adjust discount pop-up window
//        stage = new Stage();
//        root = FXMLLoader.load(getClass().getResource("AdjustDiscountPopUp.fxml"));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Adjust Item Discount Value");
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(adjustPriceButton.getScene().getWindow());
//        stage.showAndWait();
//        
//        //selectedItem.setOnSale(newDiscount);
//        
//    }
    
    @FXML
    public void setDiscountButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Discount Button Clicked");
        
        //change selected item discount value
        
        stage = (Stage)newDiscountField.getScene().getWindow();
        stage.close();
        
    }
    
//    @FXML
//    public void removeItemButtonHandler(ActionEvent event) throws IOException {
//        
//        System.out.println("Remove Item Button Clicked");
//        
//        //display adjust quantity pop-up window
//        //new controller??
//        
//        //njc.rmRowInventory(selectedItem.getID() );
//        
//    }
    
//    @FXML
//    public void adjustImageFileButtonHandler(ActionEvent event) throws IOException {
//        
//        System.out.println("Change Image File Button Clicked");
//        
//        //display adjust image file pop-up window
//        stage = new Stage();
//        root = FXMLLoader.load(getClass().getResource("AdjustImageFilePopUp.fxml"));
//        stage.setScene(new Scene(root));
//        stage.setTitle("Adjust Item Image File");
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initOwner(adjustPriceButton.getScene().getWindow());
//        stage.showAndWait();
//            
//    }
    
    @FXML
    public void setImageFileButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Image File Button Clicked");
        
        //change selected item image file path
        
        stage = (Stage)newImageField.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void removeItemButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Remove Item Button Clicked");
        
        //remove selected item from inventory
        
        stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Cancel Remove Item Button Clicked");
        
        //cancel remove item (do nothing but close window)
        
        stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    protected void browseForNewImageFileHandler() throws IOException {
        
        System.out.println("Browse for New Image File Button Clicked");
        
        FileChooser fc = new FileChooser();
        
        stage = (Stage)newImageField.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        
        newImageField.setText(file.getPath());
    }
    
} //end cotroller class