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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
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
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private TextField newNameField;
    
    @FXML
    private TextField newAddrField;
    
    @FXML
    private TextField newSalesNumField;
    
    @FXML
    private TextField newSalesValField;
    
    @FXML
    private Label custNameLabel;
    
    @FXML
    private Label custAddrLabel;
    
    @FXML
    private Label custSaleNumLabel;
    
    @FXML
    private Label custSaleValLabel;
    
    @FXML
    private Label custIDLabel;
    
    private Stage stage;
    
    private Parent root;
    
    private NinjaConn njc;
    
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
        
        System.out.println("Change Customer Name Button Clicked");
        
        //display change name pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeCustomerNamePopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Change Customer Name");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
        
    }
    
    public void setNewNameButtonHander(ActionEvent event) throws IOException {
        
        System.out.println("Set New Customer Name Button Clicked");
        Boolean isValid = false;
        Customer cust;
        
        if ( (nameField.getLength() > 0) && (newNameField.getLength() > 0) ) {
            
            try {
                
                njc  = new NinjaConn();
                
                cust = new Customer(nameField.getText(), njc);
                
                njc.updateDBString("tbCustomers", "name", newNameField.getText(), cust.getID());
                
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Set New Customer Name Fail! " + exc.toString());
            } finally {
                njc.close();
                cust = null;
            }
            
        } else {
            System.out.println("Error: enter valid data in all fields!");
        }
        
        if (isValid) {
            stage = (Stage)newNameField.getScene().getWindow();
            stage.close();
        }
    }
    public void changeAddressButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Customer Address Button Clicked");
        
        //display change address pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeCustomerAddressPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Change Customer Address");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewAddressButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Customer Address Button Clicked");
        Boolean isValid = false;
        Customer cust;
        
        if ( (nameField.getLength() > 0) && (newAddrField.getLength() > 0) ) {
            
            try {
                
                njc = new NinjaConn();
                
                cust = new Customer(nameField.getText(), njc);
                
                njc.updateDBString("tbCustomers", "address", newAddrField.getText(), cust.getID());
                
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Set New Customer Address Fail! " + exc.toString());
            } finally {
                njc.close();
                cust = null;
            }
            
        } else {
            System.out.println("Error: enter valid data for all fields!");
        }
        
        if (isValid) {
            stage = (Stage)newAddrField.getScene().getWindow();
            stage.close();
        }
        
    }
    
    public void changeSalesNumButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Customer Sales Number Button Clicked");
        
        //display change sales num pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeCustomerSalesNumPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Change Customer Sales Number");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewSalesNumButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set Customer Sales Number Button Clicked");
        Boolean isValid = false;
        Customer cust;
        
        if ( (nameField.getLength() > 0) && (newSalesNumField.getLength() > 0) ) {
            
            try {
                 
                njc = new NinjaConn();
                
                cust = new Customer(nameField.getText(), njc);
                
                njc.updateDBInt("tbCustomers", "sales", Integer.parseInt(newSalesNumField.getText() ), cust.getID() );
                
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Set New Customer Sales Num Fail! " + exc.toString());
            } finally {
                njc.close();
                cust = null;
            }
            
        } else {
            System.out.println("Error: enter valid data for all fields!");
        }
        
        if (isValid) {
            stage = (Stage)newSalesNumField.getScene().getWindow();
            stage.close();
        }
        
    }
    
    public void changeSalesValButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Change Customer Sales Value Button Clicked");
        
        //display change sales val pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeCustomerSalesValPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Change Customer Total Sales Value");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
           
    }
    
    public void setNewSalesValButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Customer Sales Value Button Clicked");
        Boolean isValid = false;
        Customer cust;
        
        if ( (nameField.getLength() > 0) && (newSalesValField.getLength() > 0) ) {
            
            try {
                
                njc = new NinjaConn();
                
                cust = new Customer(nameField.getText(), njc);
                
                njc.updateDBDouble("tbCustomers", "sales_val", Double.parseDouble(newSalesValField.getText() ), cust.getID() );
                
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Set New Sales Value Fail! " + exc.toString());
            } finally {
                njc.close();
            }
            
        } else {
            System.out.println("Error: eneter valid data for all fields!");
        }
        
        if (isValid) {
            stage = (Stage)newSalesValField.getScene().getWindow();
            stage.close();
        }
        
    }
            
    public void addNewCustomerButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Add New Customer Button Clicked");
        
        //display add new customer pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AddNewCustomerPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add New Customer to Database");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void setNewCustomerButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Customer Button Clicked");
        Boolean isValid = false;
        
        if ( (nameField.getLength() > 0) && (addressField.getLength() > 0) ) {
            
            try {
                
                njc = new NinjaConn();
                
                njc.addRowCustomers(nameField.getText(), addressField.getText());
               
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Add New Customer Fail! " + exc.toString());
            } finally {
                njc.close();
            }
            
        } else {
            System.out.println("Error: All fields must include valid data!");
        }
        
        if (isValid) {
            stage = (Stage)nameField.getScene().getWindow();
            stage.close();
        }
        
    }
    
    @FXML
    protected void lookUpCustomerButtonHandler() throws IOException {
        
        System.out.println("Customer Look-Up Button Clicked");
        
        //diaplay customer look-up pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("CustomerLookUpPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Look Up Customer");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
        
    }
    
    @FXML
    protected void customerLookUpHandler() throws IOException {
        
        Customer cust;
        
        njc = new NinjaConn();
        
        cust = new Customer(nameField.getText(),njc);
        
        
        custNameLabel.setText(cust.getName());
        custAddrLabel.setText(cust.getAddress());
        custSaleNumLabel.setText(Integer.toString(cust.getSalesNum() ) );
        custSaleValLabel.setText(Double.toString(cust.getSalesVal() ) );
        custIDLabel.setText(Integer.toString(cust.getID() ) );
        
    }
    
    @FXML
    protected void closeLookUpButtonHandler() throws IOException {
        
        stage = (Stage)custNameLabel.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    protected void signOutMenuHandler() throws IOException {
        
        System.out.println("Sign Out Menu Item Clicked");
        
        //return to LogInPage
        stage = (Stage)backToNavButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage.setScene(new Scene(root));
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
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    
}// end controller class
