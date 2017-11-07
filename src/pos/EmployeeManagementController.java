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
    private TextField pw0Field;
    
    @FXML
    private TextField pw1Field;
    
    @FXML
    private TextField pw2Field;
    
    @FXML
    private TextField permField;
    
    @FXML
    private TextField nu1Field;
    
    @FXML
    private TextField nu2Field;
    
    @FXML
    private TextField new1Field;
    
    @FXML
    private TextField new2Field;
    
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
        //display change username pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeUsernamePopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Change Employee Username");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changePermissionsButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewUsernameButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Username Button Clicked");
        Boolean isValid = false;
        User user;
        
        try {
            
            njc = new NinjaConn();

            if (nu1Field.getText().equals(nu2Field.getText()) ) {
                
                user = new User(usernameField.getText(), njc);
                
                njc.updateDBString("tbUsers", "username", nu1Field.getText(), user.getID());
                
                isValid = true;
                
            } else {
                System.out.println("Error: New Username Fields Do Not Match!");
            }
            
        } catch(Exception exc) {
            System.out.println("setNewUsername fail! " + exc.toString());
        } finally {
            njc.close();
            user = null;
        }
        
        if (isValid) {

            stage = (Stage)nu1Field.getScene().getWindow();
            stage.close();
        }
    }
    
    public void changeNameButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Employee Name Button Clicked");
        
        //display change employee name pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeEmployeeNamePopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Set New Employee Name");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changePermissionsButton.getScene().getWindow());
        stage.showAndWait();
        
    }   
    
    public void setNewNameButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Employee Name Button Clicked");
        Boolean isValid = false;
        User user;
        
        try {
            
            njc = new NinjaConn();
            
            if ( (usernameField.getLength() > 0) && (new1Field.getLength() > 0) && (new2Field.getLength() > 0) )  {
            
                user = new User(usernameField.getText(), njc);
                   
                if (new1Field.getText().equals(new2Field.getText())) {
                    
                    njc.updateDBString("tbUsers", "name", new1Field.getText(), user.getID());
                    isValid = true;
                    
                } else {
                    
                    System.out.println("Error: the new name fields do not match");
                    
                }
              
            } else {
                System.out.println("Error: enter valid names in all fields");
            }
            
            
        } catch(Exception exc) {
            System.out.println("setNewName fail! " + exc.toString());
        } finally {
            njc.close();
            user = null;        
        }
        
        if (isValid) {
            
            stage = (Stage)new1Field.getScene().getWindow();
            stage.close();
        
        }
        
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
        Boolean isValid = false;
        User user;
        
        try {
            
            njc = new NinjaConn();
            
            if ( (usernameField.getLength() > 0) && (pw0Field.getLength() > 0) && (pw1Field.getLength() > 0) && (pw2Field.getLength() > 0) ) {
                
                user = new User(usernameField.getText(), njc);
                
                if (njc.getAndD(user.getUsername()).equals(pw0Field.getText())) {
                
                    if (pw1Field.getText().equals(pw2Field.getText())) {
                        
                        njc.eAndStore(user.getName(), pw1Field.getText());
                        isValid = true;
                        
                    } else {
                        System.out.println("Error: The New Password Fields Do Not Match!");
                    }
                    
                } else {
                    System.out.println("Error: incorrect password!");
                }
                
            } else {
                System.out.println("Error: Enter Valid Data for All Fields");
            }
            
        } catch(Exception exc) {
            System.out.println("Set New Password Fail! " + exc.toString());
        } finally {
            njc.close();
            user = null;
        }
        
        
        if (isValid) {
            stage = (Stage)usernameField.getScene().getWindow();
            stage.close();
        }
        
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

            if ( (nameField.getLength() > 0) && (addressField.getLength() > 0) && (usernameField.getLength() > 0) 
               && (pw1Field.getLength() > 0) && (permField.getLength() > 0) ) {

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
