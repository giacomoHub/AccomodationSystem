/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author jitojar
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private Label label1;
    @FXML private Button managerButton;
    @FXML private Button button;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    /**
     * Change view
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void changeScene(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ManagerView.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    
    @FXML
    public void changeSceneWarden(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("WardenView.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
