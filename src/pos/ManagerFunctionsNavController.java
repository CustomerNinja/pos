/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class ManagerFunctionsNavController implements Initializable {
    
    @FXML private Button invManButton;
    
    protected Stage stage;
    
    protected Parent root;
    
    protected Scene scene;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    protected void inventoryManagementButtonHandler() throws IOException {
        
        System.out.println("Inventory Management Button Clicked");
        
        //display InventoryManagementPage
        stage = (Stage)invManButton.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("InventoryManagementPage.fxml"));
        InventoryManagementPage imp = new InventoryManagementPage();
        scene = imp.getPage(0);
        stage.setScene(scene);
        stage.setTitle("CustomerNinja - Inventory");
        stage.show();
        
        
    }
    
    @FXML
    protected void employeeManagementButtonHandler() throws IOException {
        
        System.out.println("Employee Management Button Clicked");
        
        //display EmployeeManagementPage
        stage = (Stage)invManButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("EmployeeManagementPage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    protected void customerManagementButtonHandler() throws IOException {
        
        System.out.println("Customer Management Button Clicked");
        
        //display CustomerManagementPage
        stage = (Stage)invManButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CustomerManagementPage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    protected void salesStatsButtonHandler() throws IOException {
        
        System.out.println("Sales Statistics Button Clicked");
        
        //display SalesStatsPage
        stage = (Stage)invManButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("SalesStatsPage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer Ninja - Sales Statistics");
        stage.show();
        
    }
    
    @FXML
    protected void signOutMenuHandler() throws IOException {
        
        System.out.println("Sign Out Menu Item Clicked");
        
        //return to LogInPage
        stage = (Stage)invManButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    protected void closeMenuHandler() throws IOException {
        
        System.out.println("Close Menu Item Clicked");
        //close program
        System.exit(0);
    }
    
    @FXML
    protected void aboutMenuHandler() throws IOException {
        
        System.out.println("About Menu Item Clicked");
        
        //display change name pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AboutPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("About Customer Ninja");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(invManButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    
} //end controller
