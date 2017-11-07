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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class CustomerManagementPageController implements Initializable {

    @FXML
    private Button backToNavButton;
    
    @FXML
    private Button changeNameButton;
    
    private Stage stage;
    
    private Parent root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
     public void toManagerNavPageButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Back to Manager Nav Page (from Customer Mgmt) Button Clicked");
        
        //get refrence to stage
        stage = (Stage)backToNavButton.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("ManagerFunctionsNavPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
     
    public void changeCustomerNameButtonHandler(ActionEvent event) throws IOException {
        
    }
    
    public void changeAddressButtonHandler(ActionEvent event) throws IOException {
        
    }
    
    public void changeSalesNumButtonHandler(ActionEvent event) throws IOException {
        
    }
    
    public void changeSalesValButtonHandler(ActionEvent event) throws IOException {
        
    }
            
    public void addNewCustomerButtonHandler(ActionEvent event) throws IOException {
        
    }
    
}
