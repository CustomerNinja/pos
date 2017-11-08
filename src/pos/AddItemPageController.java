/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import static java.nio.file.Files.move;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author mellon
 */
public class AddItemPageController{
    
    protected String IMAGE_DIRECTORY = (System.getProperty("user.dir") + System.getProperty("file.separator") + "Images");
    protected String image_filename = "";
   
    
    @FXML ImageView item_preview;
  
    @FXML Button confirm_button;
    
    @FXML TextField item_price_field;
    
    @FXML TextField item_quantity_field;
    
    @FXML TextField item_title_field;
    
    @FXML TextArea item_description_field;
    
    @FXML CheckBox sale_checkbox;

    /**
     *
     * @param event
     * @throws IOException
     */
    public void ConfirmButtonHandler(ActionEvent event) throws IOException, Exception{


        //check to see if the imagefilename and other values are valid
        if((image_filename).equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("CustomerNinja - Error");
           alert.setContentText("No Image File Selected");
           alert.showAndWait();
           return;
        }


        if(item_description_field.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("CustomerNinja - Error");
           alert.setContentText("No Item Description Provided");
           alert.showAndWait(); 
           return;
        }

        if(item_price_field.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("CustomerNinja - Error");
           alert.setContentText("No Item Price Provided");
           alert.showAndWait(); 
           return;
        }

        if(item_quantity_field.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("CustomerNinja - Error");
           alert.setContentText("No Item Quantity Provided");
           alert.showAndWait(); 
           return;
        }
        if(item_title_field.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("CustomerNinja - Error");
           alert.setContentText("No Item Title Provided");
           alert.showAndWait(); 
           return;
        }
     
        //0 if the item is not a sale item, 1 if the item is a sale item
        int discount = 0;
        if(sale_checkbox.isSelected()){
            discount = 1;
        }
        
        //I'm using a little hack here to utilize non-static method in a static context
        NinjaConn njc = new NinjaConn();
        new Inventory(njc).addNewItem(item_title_field.getText(), Integer.parseInt(item_quantity_field.getText()),
            Double.parseDouble(item_price_field.getText()), item_description_field.getText(), discount, image_filename);

        njc.close();

    }
    
    //returns the image string
     public void SelectImageButtonHandler(ActionEvent event) throws IOException{
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select New Image");
        
        //reference to stage from the event
        Stage stage = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
        File image_file = filechooser.showOpenDialog(stage); 
        
        //move the image
        java.nio.file.Path path = Paths.get(IMAGE_DIRECTORY);
        Files.move(image_file.toPath(),path.resolve(image_file.getName()));
        
        this.image_filename = image_file.getName();

        
     }
    
}
