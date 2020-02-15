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
import javafx.scene.control.TextField;
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
    @FXML
    private Label hallName;
    @FXML
    private Label hallNumber;
    @FXML
    private Label roomNumber;
    @FXML
    private TextField leaseNumber;
    @FXML
    private TextField studentName;
    
    
    ActionEvent event = new ActionEvent();
    
    
    //fxml table variables
    @FXML private TableView<ManagerTable> table_T;
    @FXML private TableColumn<ManagerTable, String> hallName_Col;
    @FXML private TableColumn<ManagerTable, String> hallNumber_Col;
    @FXML private TableColumn<ManagerTable, String> room_Col;
    @FXML private TableColumn<ManagerTable, String> lease_Col;
    @FXML private TableColumn<ManagerTable, String> student_Col;
    @FXML private TableColumn<ManagerTable, String> Occupancy_Col;
    @FXML private TableColumn<ManagerTable, String> Cleanliness_Col;
    
    //data of the currently selected row
    ManagerTable selectedRow;
    
    
    
    
    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //get the data
        AccommodationSpecifics data = getInstance();
        ObservableList<ManagerTable> tableData = FXCollections.observableArrayList();
        
        //add the options to the choice box
        occupancy_CB.getItems().add("Occupied");
        occupancy_CB.getItems().add("Unoccupied");
        occupancy_CB.getItems().add("Offline");
        
        initializeTableColumns();
        
        //prepare and load the data into the table
        table_T.setItems(specificsToTable(data,tableData));
        
        //add the event listener to the table
        table_T.setOnMouseClicked(e -> {
            rowSelectionEvent();
        });
    }    
    
    /**
     * Event that decides if to show "CreateLease" button or display info
     */
    private void rowSelectionEvent(){
        selectedRow = table_T.getSelectionModel().getSelectedItem();
        setSelectedLabels(selectedRow);
        setSelectedInput(selectedRow);
        
        if(selectedRow.getStudentName().equals("")){
            showCreateLease(event);
        }else{
            hideCreateLease(event);
        }
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
     * @param data
     * @param tableData
     * @return type ObservableList<ManagerTable>
     */
    public ObservableList<ManagerTable> specificsToTable(AccommodationSpecifics data, ObservableList<ManagerTable> tableData){
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
                try{
                    tableData.get(elementIndex).setLeaseNumber(Integer.toString(data.getHalls().get(j).getRooms().get(i).getLease().getLeaseNumber()));
                }catch(Exception e){
                    tableData.get(elementIndex).setLeaseNumber("");
                }
                //set the student name
                try{
                    tableData.get(elementIndex).setStudentName(data.getHalls().get(j).getRooms().get(i).getLease().getStudent().getFirstName());
                }catch(Exception e){
                    tableData.get(elementIndex).setStudentName("");
                }
                //set the occupancy
                try{
                    tableData.get(elementIndex).setOccupancyStatus(data.getHalls().get(j).getRooms().get(i).getRoomStatus());
                }catch(Exception e){
                    tableData.get(elementIndex).setOccupancyStatus("Offline");
                }
                //set the cleanliness
                tableData.get(elementIndex).setCleanliness(data.getHalls().get(j).getRooms().get(i).getRoomCleanliness());

            } 
        }
        return tableData;
    }
    
    
    /**
     * Function that updates the table data;
     */
    public void initializeTableColumns(){
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        room_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        lease_Col.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        student_Col.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        Occupancy_Col.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        Cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("cleanliness"));
    }
    
    /**
     * Function that shows the data in the labels from every selected row of the table
     */
    public void setSelectedLabels(ManagerTable row){
        hallName.setText(row.getHallName());
        hallNumber.setText(row.getHallNumber());
        roomNumber.setText(Integer.toString(row.getRoomNumber()));
    }
    
    /**
     * Function that shows data from the table to the input fields
     */
    public void setSelectedInput(ManagerTable row){
        leaseNumber.setText(row.getLeaseNumber());
        studentName.setText(row.getStudentName());
        occupancy_CB.setValue(row.getOccupancyStatus());
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
    
    /**
     * Function that deletes the selected row of data
     */
    public void delete(ActionEvent event){
        
        //get the values from the selected row (could use a global variable)
        selectedRow = table_T.getSelectionModel().getSelectedItem();
        
        //change values in the table (wrong, must modify items in the observable list
        selectedRow.setStudentName("");
        selectedRow.setLeaseNumber("");
        selectedRow.setOccupancyStatus("Unoccupied");
        selectedRow.setCleanliness("Offline");
        
        //update the changes of the real data (not only the table data)
        AccommodationSpecifics data = getInstance();
        data.getHalls().get(Integer.parseInt(selectedRow.getHallNumber())).getRooms().get(selectedRow.getRoomNumber()).setLease(null);
        data.getHalls().get(Integer.parseInt(selectedRow.getHallNumber())).getRooms().get(selectedRow.getRoomNumber()).setRoomCleanliness(2);
        data.getHalls().get(Integer.parseInt(selectedRow.getHallNumber())).getRooms().get(selectedRow.getRoomNumber()).setRoomStatus(false);
        
        //show the create Lease page
        showCreateLease(event);
        
        //show the changes to the table
        table_T.refresh();
    }
    
    /**
     * Function that checks and sends the data to the update function
     */
    public void confirm(ActionEvent event){
    
    }
    
    /**
     * Function that updates updates the values from the Input fields to the AccomodationSpecifics
     */
    public void update(){
        //get the values from the inputs and put them into the data
        
    }
    
    
    
    
    
    
    
    
}
