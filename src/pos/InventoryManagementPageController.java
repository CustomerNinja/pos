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
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
        
        //selectedItem.setPrice(newPrice);
        
        
    }
    
    
    @FXML
    public void adjustQuantityButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Adjust Quantity Button Clicked");
        
        //display adjust quantity pop-up window
        
        //selectedItem.setQuantity(newQuantity);
        
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
        //new controller??
        
        //selectedItem.setOnSale(newDiscount);
        
    }
    
    
    @FXML
    public void removeItemButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Remove Item Button Clicked");
        
        //display adjust quantity pop-up window
        //new controller??
        
        //njc.rmRowInventory(selectedItem.getID() );
        
    }
    
} //end cotroller class