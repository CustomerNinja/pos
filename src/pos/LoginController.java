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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author mellon
 */
public class LoginController implements Initializable {
    
   
    
     
   
  // @FXML
   //private TextField user_field = new TextField();
    
   @FXML private PasswordField pw_field;
   
   @FXML private TextField user_field;
   
   @FXML private Button submit_button;

   @FXML private Label userLabel;
    
   @FXML
   public void submitButtonClicked(ActionEvent event) throws IOException {
       
       //attempt to create a new session
       Session currentSession = new Session(user_field.getText(),pw_field.getText());
       
       //if the connection is valid = true
       if(currentSession.connectionValid){
           
           if (currentSession.getAdminStatus() == false) {
                //show the inventory window if the current user is an employee
               System.out.println("The connection was valid");
               System.out.println("Curent User: " + currentSession.currentUser.getName() );
               userLabel.setText(currentSession.currentUser.getName() );

               Stage stage;
               Parent root;

               //get refrence to stage
               stage = (Stage) submit_button.getScene().getWindow();

               root = FXMLLoader.load(getClass().getResource("InventoryPage.fxml"));

               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
               
           } else if (currentSession.getAdminStatus() == true) {
               //show the management window if the current user is a manager
               System.out.println("The connection was valid");
               System.out.println("Curent User: " + currentSession.currentUser.getName() );
               userLabel.setText(currentSession.currentUser.getName() );

               Stage stage;
               Parent root;

               //get refrence to stage
               stage = (Stage) submit_button.getScene().getWindow();

               root = FXMLLoader.load(getClass().getResource("ManagerFunctionsNavPage.fxml"));

               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
           }
        
       } else if(!currentSession.connectionValid){
           Alert alert = new Alert(AlertType.ERROR);
           alert.setTitle("Customer Ninja");
           alert.setContentText("Invalid Login Provided");
           alert.showAndWait();
           System.out.println("Connection invalid");
       }
    
     
     //System.out.println( user_field.getText() + " " + pw_field.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
