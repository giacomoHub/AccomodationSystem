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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jitojar
 */
public class ManagerViewController implements Initializable {
    
    
    @FXML
    private Button createLease_Btn;
    @FXML
    private AnchorPane createLeaseView_V;
    @FXML
    private ChoiceBox<String> occupancy_CB;
    @FXML
    private Button delete_Btn;
    
    //fxml table variables
    @FXML private TableView<Hall> table_T;
    @FXML private TableColumn<Hall, String> hallName_Col;
    @FXML private TableColumn<Hall, String> hallNumber_Col;
    @FXML private TableColumn<Hall, String> room_Col;
    @FXML private TableColumn<Hall, String> lease_Col;
    @FXML private TableColumn<Hall, String> student_Col;
    @FXML private TableColumn<Hall, String> Occupancy_Col;
    @FXML private TableColumn<Hall, String> Cleanliness_Col;
    
    
    
    
    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //populate the table
        //AccomodationSystem.halls.get(0);
        
        //add the options to the choice box
        occupancy_CB.getItems().add("Occupied");
        occupancy_CB.getItems().add("Unoccupied");
        occupancy_CB.getItems().add("Offline");
        
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        room_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        lease_Col.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        student_Col.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
        Occupancy_Col.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        Cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
        
        //this loads the dummy data
        table_T.setItems(getHalls());
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
    
    public ObservableList<Hall> getHalls()
    {
        
        ObservableList<Hall> hall = FXCollections.observableArrayList();
        hall.add(AccomodationSystem.halls.get(0));
        
        return hall;
    }
    
    /**
     * Function that updates the table data;
     */
    public void setTableData(){
        
    }
    
    /**
     * Function that hides the createLeaseView and the button createLease;
     */
    public void hideCreateLease(ActionEvent event){
        createLeaseView_V.setVisible(false);
    }
    
    /**
     * Function that shows the createLeaseView and the button createLease;
     */
    public void showCreateLease(ActionEvent event){
        createLeaseView_V.setVisible(true);
    }
    
    
    
    
    
    
    
    
}
