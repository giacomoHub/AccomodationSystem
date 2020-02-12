/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import static accomodationsystem.AccommodationSpecifics.getInstance;
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
    @FXML private TableView<ManagerTable> table_T;
    @FXML private TableColumn<ManagerTable, String> hallName_Col;
    @FXML private TableColumn<ManagerTable, String> hallNumber_Col;
    @FXML private TableColumn<ManagerTable, String> room_Col;
    @FXML private TableColumn<ManagerTable, String> lease_Col;
    @FXML private TableColumn<ManagerTable, String> student_Col;
    @FXML private TableColumn<ManagerTable, String> Occupancy_Col;
    @FXML private TableColumn<ManagerTable, String> Cleanliness_Col;
    
    
    
    
    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //get the data
        AccommodationSpecifics data = getInstance();
        ArrayList<ManagerTable> tableData = new ArrayList<ManagerTable>();
        
        //prepare the data to go in the table
        specificsToTable(data,tableData);
        
        //add the options to the choice box
        occupancy_CB.getItems().add("Occupied");
        occupancy_CB.getItems().add("Unoccupied");
        occupancy_CB.getItems().add("Offline");
        
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        room_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        lease_Col.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        student_Col.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        Occupancy_Col.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        Cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
        
        //load the data into the table
        table_T.setItems(getInfo(tableData));
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
    
    /**
     * Function that gets the AcoomodationSpecifics data and converts it into ManagerTable;
     */
    public void specificsToTable(AccommodationSpecifics data, ArrayList<ManagerTable> tableData){
        //loop through every hall in the system
        for(int j = 0; j<data.getHalls().size();j++){
            //loop through every room in the system
            for(int i=0; i<data.getHalls().get(j).getRooms().size();i++){
                //add new row of data
                tableData.add(new ManagerTable());
                int elementIndex = tableData.size() - 1;

                //set the hall name
                tableData.get(elementIndex).setHallName(data.getHalls().get(j).getHallName());

                //set the hall number
                tableData.get(elementIndex).setHallNumber(Integer.toString(j));

                //set the room number
                tableData.get(elementIndex).setRoomNumber(data.getHalls().get(j).getRooms().get(i).getRoomNumber());

                //set the room lease
                tableData.get(elementIndex).setLeaseNumber(Integer.toString(data.getHalls().get(j).getRooms().get(i).getLease().getLeaseNumber()));

                //set the student name
                tableData.get(elementIndex).setStudentName(data.getHalls().get(j).getRooms().get(i).getLease().getStudent().getFirstName());

                //set the occupancy
                tableData.get(elementIndex).setOccupancyStatus(data.getHalls().get(j).getRooms().get(i).getRoomStatus());

                //set the cleanliness
                tableData.get(elementIndex).setCleanliness(data.getHalls().get(j).getRooms().get(i).getRoomCleanliness());

            }
            
        }
    }
    
    
    /**
     * 
     * !GETTING RID OF THIS IN FUTURE UPDATE!! CONVERTING ArrayList<ManagerTable> tableData to ObservableList<ManagerTable> in declaration
     * Function that converts the list managerTable items into observable list;
     * This function will be deleted
     */
    public ObservableList<ManagerTable> getInfo(ArrayList<ManagerTable> tableData){
        ObservableList<ManagerTable> info = FXCollections.observableArrayList();
        for(int i = 0; i < tableData.size(); i++){
            info.add(tableData.get(i));
        }
        return info;
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
