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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class AboutPopUpController implements Initializable {
    
    @FXML
    private Button okButton;
    
    Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleOKButton(ActionEvent event) throws IOException {
        
        System.out.println("About Page OK Button Clicked");
        
        stage = (Stage)okButton.getScene().getWindow();
        stage.close();
        
        
    }
    
    
}
