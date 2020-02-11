/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juanestebanvargassalamanca
 */
public class WardenViewController implements Initializable {

 
    /**
     * @param event
     * @throws IOException 
     * Description: Changes to main menu
     */
    
    public void changeScene(ActionEvent event) throws IOException {
        
        // Gets FXML Documents and makes a new scene
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Windows is cast as a stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    
    
    /**
     * @param url
     * @param rb 
     * Description: loads everything needed for GUI when loaded
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
