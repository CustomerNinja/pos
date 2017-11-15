/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JTS
 */
public class SalesStatsPageController implements Initializable {
    
    
    @FXML
    private Button genListButton;
    
    @FXML
    private TableView salesTable;
    
    @FXML
    private Button backToNavButton;
    
    @FXML
    private Label totalLabel;
    
    @FXML
    private TextField dateField;
    
    @FXML
    private TextField valueField;
    
    @FXML
    private TextField nameField;
            
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
    
    @FXML
    protected void displaySalesTable() throws IOException {
        
        System.out.println("Display Sales Stats Button Clicked");
        System.out.println(Session.getCurrentUsername());
        
        njc = new NinjaConn();
        //get Sale list
        try {
            ObservableList<Sale> tData = salesTable.getItems();
            tData.clear();
            LinkedList<Sale> salesList = new LinkedList<Sale>();
            ResultSet rSet = njc.quGetAll("tbSales");
            int rows = 0;
            while (rSet.next() ) {
                rows++;
            }
            System.out.println("rows= " + rows);
            int[] idList = new int[rows];
            Double total = 0.0;
            rSet = njc.quGetAll("tbSales");
            rSet.next();
            for (int i=0; i<rows; i++) {
                    idList[i] = rSet.getInt("id");
                    total += rSet.getDouble("value");
                    rSet.next();
            }
            //System.out.println(Arrays.toString(idList) );
            njc.close();
            for (int i=0; i<rows; i++) {
                    salesList.add(new Sale(idList[i]) );
            }
            //add custList to tData
            tData.addAll(salesList);
            //set totalLabel to summed total
            String totalString;
            totalString = String.format("$%.2f", total);
            totalLabel.setText(totalString);
            
        } catch (Exception exc) {
            System.out.println("Display Customer List Fail! " + exc.toString());
        } finally {
            njc.close();
        }
        
    }
    
    @FXML
    protected void signOutMenuHandler() throws IOException {
        
        System.out.println("Sign Out Menu Item Clicked");
        
        //return to LogInPage
        stage = (Stage)genListButton.getScene().getWindow();
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
        
        //display about pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AboutPopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("About Customer Ninja");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(genListButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    public void toManagerNavPageButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Back to Manager Nav Page (from Sales Stats) Button Clicked");
        
        //get refrence to stage
        stage = (Stage)backToNavButton.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("ManagerFunctionsNavPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer Ninja - Manager Functions Navigation");
        stage.show();
        
    }
    
    public void setNewSaleButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Set New Sale Button Clicked");
        Boolean isValid = false;
        
        if ( (dateField.getLength() > 0) && (valueField.getLength() > 0) && (nameField.getLength() > 0) ) {
            
            try {
                
                njc = new NinjaConn();
                
                njc.addRowSales(dateField.getText(), Double.parseDouble(valueField.getText()), nameField.getText());
               
                isValid = true;
                
            } catch(Exception exc) {
                System.out.println("Add New Sale Fail! " + exc.toString());
            } finally {
                njc.close();
            }
            
        } else {
            System.out.println("Error: All fields must include valid data!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Error: All fields must contain valid data");
            alert.showAndWait();
        }
        
        if (isValid) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("New Sale Added");
            alert.setContentText("New Sale Sueccessfully Added");
            alert.showAndWait();
            stage = (Stage)nameField.getScene().getWindow();
            stage.close();
        }
        
    }
    
    public void addNewSaleButtonHandler(ActionEvent event) throws IOException {
        
        System.out.println("Add New Sale Button Clicked");
        
        //display add new sale pop-up
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("AddNewSalePopUp.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Add New Manual Sale to Database");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(backToNavButton.getScene().getWindow());
        stage.showAndWait();
        
    }
    
}
