/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class InventoryManagementPageController implements Initializable {
    
    @FXML private ImageView selectedItemImage;
    
    @FXML private Text selectedItemNameText;
    
    @FXML private Text selectedItemPriceText;
    
    @FXML private Text selectedItemStockText;
    
    @FXML private Button adjustPriceButton;
    
    @FXML private TextField newPriceField;
    
    @FXML private TextField newQuantityField;
    
    @FXML private TextField newDiscountField;
    
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
    
    @FXML
    public void selectItemHandler(ActionEvent event) throws IOException {
        //need to figure out how to select from the GridPane
        
    }
    
    
    @FXML
    public void adjustPriceButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Adjust Price Button Clicked");
        
        //display adjust price pop-up window
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AdjustPricePopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Adjust Item Price");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(adjustPriceButton.getScene().getWindow());
        stage.show();
        
        //selectedItem.setPrice(newPriceField.getText() );
        
    }
    
    @FXML
    public void setPriceButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Price Button Clicked");
        
        stage = (Stage)newPriceField.getScene().getWindow();
        stage.close();
        
    }
    
    
    @FXML
    public void adjustQuantityButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Adjust Quantity Button Clicked");
        
        //display adjust quantity pop-up window
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AdjustQuantityPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Adjust Item Quantity");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(adjustPriceButton.getScene().getWindow());
        stage.showAndWait();
        
        //selectedItem.setQuantity(newQuantity);
        
    }
    
    @FXML
    public void setQuantityeButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Quantity Button Clicked");
        
        stage = (Stage)newQuantityField.getScene().getWindow();
        stage.close();
        
    }
    
    
    @FXML
    public void addNewItemButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Add New Item Button Clicked");
        
        //display add item pop-up window
        
        //njc.addRowInventory(name, quantity, price, description, discount, imgFile);
    }
    
    
    @FXML
    public void adjustDiscountButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Adjust Discount Button Clicked");
        
        //display adjust discount pop-up window
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AdjustDiscountPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Adjust Item Discount Value");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(adjustPriceButton.getScene().getWindow());
        stage.showAndWait();
        
        //selectedItem.setOnSale(newDiscount);
        
    }
    
    @FXML
    public void setDiscountButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Discount Button Clicked");
        
        stage = (Stage)newDiscountField.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void removeItemButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Remove Item Button Clicked");
        
        //display adjust quantity pop-up window
        //new controller??
        
        //njc.rmRowInventory(selectedItem.getID() );
        
    }
    
} //end cotroller class