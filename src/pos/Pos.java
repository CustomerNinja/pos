/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mellon
 */
public class Pos extends Application{
    Parent root;
    static Stage primarystage;
    //Notes
    // ANY unimplemented handlers will throw Invocation exception
    // DO NOT USE onMouseClick will throw several mismatch execeptions
    
    @Override
    public void start(Stage stage) throws Exception{
        //set a reference to the primary stage
        primarystage = stage;
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));//must have the fxml location
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * 
     * @param scene - the scene to be displayed next
     * @param title - the title of the new scene
     * @throws Exception
     */
    public static void changeScene(Scene scene, String title) throws Exception{ 
        primarystage.close();
        Scene newscene = scene;
        primarystage.setScene(newscene);
        primarystage.setTitle(title);
        primarystage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
    }
    
}
