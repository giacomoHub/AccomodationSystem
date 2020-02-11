/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juanestebanvargassalamanca
 */
public class WardenViewController implements Initializable {

    
    //fxml variables to display in GUI for warden only
    @FXML private TableView<Hall> tableView;
    @FXML private TableColumn<Hall, String> hallNameColumn;
    @FXML private TableColumn<Hall, String> hallNumberColumn;
    @FXML private TableColumn<Hall, String> roomColumn;
    @FXML private TableColumn<Hall, String> roomStatusColumn;
    @FXML private TableColumn<Hall, String> cleanlinessColumn;
    
    /**
     * @param event
     * @throws IOException 
     * Description: Changes to main menu
     */
    
    public void changeScene(ActionEvent event) throws IOException {
        
        // Gets FXML Documents and makes a new scene
        Parent backToMenu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menuScene = new Scene(backToMenu);
                
        //Windows is cast as a stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }
    
    
    /**
     * @param url
     * @param rb 
     * Description: loads everything needed for GUI when loaded
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set columns in table
        hallNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hallNumberColumn.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("roomColumn"));
        roomStatusColumn.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        cleanlinessColumn.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
        
        //this loads the dummy data
        tableView.setItems(getHalls());
    }   
    
    
     public ObservableList<Hall> getHalls()
    {
        
//        AccomodationSystem.halls.get(0);
        
        Address address_test = new Address( "frenchay", "Fr_block", 3, "BR10", "Bristol", "Somerset", "England");
        Telephone tel_tes = new Telephone("+44", "0103", "64645");
        Room room_test = new Room(1, true, 300, 0);
//        Hall hall_test = new Hall("Wallscourt",address_test , tel_tes );
        Student stu_test = new Student(0010, "juju", "rogers");
        Lease lease_test = new Lease(stu_test, 300, 4);
   
        ObservableList<Hall> hall = FXCollections.observableArrayList();
        hall.add(new Hall("Wallscourt",address_test , tel_tes ));
        
        return hall;
    }
}
