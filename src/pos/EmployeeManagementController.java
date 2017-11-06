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
    
    @FXML
    private TextField oldPasswordField;
    
    @FXML
    private TextField newPasswordField;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField pw1Field;
    
    @FXML
    private TextField pw2Field;
    
    @FXML
    private TextField permField;
    
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
        njc.close();
        
        stage = (Stage)employeeIDField.getScene().getWindow();
        stage.close();
        
    }
    
    public void changeUsernameButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Username Button Clicked");
        
        
    }
    
    public void changeNameButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Name Button Clicked");
        
        
    }        
    
    public void changePasswordButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Password Button Clicked");
        
        //display change password pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangePasswordPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Set New Password");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changePermissionsButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewPasswordButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Password Button clicked");
        
        //DO NOTHING
        //need to figure out how to safely do this
        
        //close change password pop-up
        stage = (Stage)employeeIDField.getScene().getWindow();
        stage.close();
        
    }
    
    public void addNewUserButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Add New User Button Clicked");
        
        //display change password pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AddNewUserPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add New User");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changePermissionsButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewUserButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New User Button Clicked");
        Boolean isValid = false;
        String sql = "";
        
        try {
        
            njc = new NinjaConn();

            if (nameField.getText() != null && addressField.getText() != null && usernameField.getText() != null 
               && pw1Field.getText() != null && permField.getText() != null) {

                if (pw1Field.getText().equals(pw2Field.getText())) {
                    
                    sql = "\"" + nameField.getText() + "\", \"" + addressField.getText() + "\", 0, 0,\"" + 
                        usernameField.getText() + "\", " + permField.getText() + ", " + "0, 0";

                    njc.addRowUsers(sql);
                    njc.eAndStore(nameField.getText(), pw1Field.getText());
                    isValid = true;

                } else {
                    System.out.println("Error: Password Fields Do Not Match!");
                }

            } else {

                System.out.println("Error: Data is Required for All Fields!");

            }
            
        } catch(Exception exc) {
            System.out.println("Add New User Handler Error! " + exc.toString());
        }
        
        njc.close();
        if (isValid) {
            
            stage = (Stage)nameField.getScene().getWindow();
            stage.close();

        }
    }
    
    public void toManagerNavPageButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Back to Manager Nav Page (from Employee Mgmt) Button Clicked");
        
        //get refrence to stage
        stage = (Stage)changePermissionsButton.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("ManagerFunctionsNavPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
} //end controller
