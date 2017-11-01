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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class EmployeeManagementController implements Initializable {
    
    @FXML
    private TextField employeeIDField;
    
    @FXML
    private TextField newPermissionsField;
    
    @FXML
    private Button changePermissionsButton;
    
    protected Stage stage;
    
    protected Parent root;
    
    private NinjaConn njc;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void changePermissionsButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Permissions Button clicked");
        
        //display change permissions pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangePermissionsPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Adjust Employee Permissions Level");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changePermissionsButton.getScene().getWindow());
        stage.showAndWait();
        
        
        
    }
    
    @FXML
    public void setPermissionsButtonHandler (ActionEvent event) throws IOException {
        
        System.out.println("Set Permissions Button clicked");
        
        njc = new NinjaConn();
        
        njc.updateDBInt("tbUsers", "permissions", Integer.parseInt(newPermissionsField.getText() ), Integer.parseInt(employeeIDField.getText() ));
        
        stage = (Stage)employeeIDField.getScene().getWindow();
        stage.close();
        
        
    }
    
    
}
