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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jitojar
 */
public class ManagerViewController implements Initializable {
    
    @FXML
    private TableView<ArrayList<Hall>> table;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //populate the table
        AccomodationSystem.halls.get(0);
        
        //table.setItems(AccomodationSystem.data.getHalls());
    }    
    
    /**
     * Change view
     */
    public void changeScene(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    
    
    
}
