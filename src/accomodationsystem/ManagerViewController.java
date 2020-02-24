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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
    private Label hallName_Lbl;
    @FXML
    private Label hallNumber_Lbl;
    @FXML
    private Label roomNumber_Lbl;
    @FXML
    private Label leaseNumber;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentSurname;
    @FXML
    private Slider monthlyRate_S;
    @FXML
    private Slider leaseDuration_S;
    @FXML
    private Label monthlyRate_Lbl;
    @FXML
    private Label leaseDuration_Lbl;
    @FXML
    private CheckBox roomStatus_Box;
    @FXML
    private Label occupancyError_Lbl;
    @FXML
    private Label nameError_Lbl;
    @FXML
    private Label surnameError_Lbl;
    @FXML
    private Label leaseError_Lbl;
    @FXML
    private Label studentNumber_Lbl;
    
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
        initializeSliders();
        createLeaseView_V.setVisible(true);
        
        //prepare and load the data into the table
        table_T.setItems(specificsToTable(data,tableData));
        
        //set first item in table to be selected
        selectedRow = table_T.getItems().get(0);
        //update all of the values in GUI
        setSelectedLabels(selectedRow);
        setSelectedInput(selectedRow);
        hideCreateLease(event);
        
        //add the event listener to the table
        table_T.setOnMouseClicked(e -> {
            rowSelectionEvent();
        });
        
        //add an event listener to the slides
        leaseDuration_S.valueProperty().addListener(e ->{
            sliderEvent(leaseDuration_S, leaseDuration_Lbl);
        });
    }    
    
    /**
     * Event that decides if to show "CreateLease" button or display info
     */
    private void rowSelectionEvent(){
        selectedRow = table_T.getSelectionModel().getSelectedItem();
        
        if(selectedRow != null){
            if(selectedRow.getStudentName().equals("")){
                showCreateLease(event);
                occupancyError_Lbl.setText("");
            }else{
                //update all of the values in GUI
                setSelectedLabels(selectedRow);
                setSelectedInput(selectedRow);
                hideCreateLease(event);
            }
        } 
    }
    
    /**
     * Event that changes the values on the slider labels
     */
    private void sliderEvent(Slider input, Label labelToChange){
        labelToChange.setText(Double.toString(Math.round(input.getValue())));
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
                    tableData.get(elementIndex).setStudentName(data.getHalls().get(j).getRooms().get(i).getLease().getStudent().getFullName());
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
    
    public void initializeSliders(){
        //monthlyRate_S.setMin(0);
        //monthlyRate_S.setMax(2000);
        //monthlyRate_S.setShowTickLabels(true);
        //monthlyRate_S.setMajorTickUnit(1000);
        //monthlyRate_S.setMinorTickCount(999);
        //monthlyRate_S.setBlockIncrement(1);
        //monthlyRate_S.setSnapToTicks(true);
        
        leaseDuration_S.setMin(0);
        leaseDuration_S.setMax(24);
        leaseDuration_S.setShowTickLabels(true);
        leaseDuration_S.setShowTickMarks(true);
        leaseDuration_S.setMajorTickUnit(12);
        leaseDuration_S.setMinorTickCount(11);
        leaseDuration_S.setBlockIncrement(1);
        leaseDuration_S.setSnapToTicks(true);
    }
    
    /**
     * Function that shows the data in the labels from every selected row of the table
     */
    public void setSelectedLabels(ManagerTable row){
        hallName_Lbl.setText(row.getHallName());
        hallNumber_Lbl.setText(row.getHallNumber());
        roomNumber_Lbl.setText(Integer.toString(row.getRoomNumber()));
        if(row.getLeaseNumber().equals("")){
            leaseNumber.setText("N/A");
            studentNumber_Lbl.setText("N/A");
        }else{
            leaseNumber.setText(row.getLeaseNumber());
            //studentNumber_Lbl.setText("N/A");
        }
        
    }
    
    /**
     * Function that shows data from the table to the input fields
     */
    public void setSelectedInput(ManagerTable row){
        //show things got from table
        occupancy_CB.setValue(row.getOccupancyStatus());
        
        //set what to change
        AccommodationSpecifics data = getInstance();
        int roomIndex = row.getRoomNumber()-1;
        int hallIndex = Integer.parseInt(row.getHallNumber());
        
        //show things got from AccomodationSpecifics
        try{
            studentName.setText(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().getFirstName());
        }catch(Exception e){
            studentName.setText("");
        }
        try{
            studentSurname.setText(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().getLastName());
        }catch(Exception e){
            studentSurname.setText("");
        }
        //show monlty rate
        double monthlyRate = data.getHalls().get(hallIndex).getRooms().get(roomIndex).getMonthlyRentRate();
        //monthlyRate_S.setValue(monthlyRate);
        monthlyRate_Lbl.setText(Double.toString(monthlyRate));
        studentNumber_Lbl.setText(Integer.toString(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().getStudentNumber()));
        
        
        //show lease duration
        try{
            double leaseDuration = data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getDuration();
            leaseDuration_S.setValue(leaseDuration);
            leaseDuration_Lbl.setText(Double.toString(leaseDuration_S.getValue()));
        }catch(Exception e){
            leaseDuration_Lbl.setText("");
        }
    }
    
    /**
     * Function that resets all of GUI elements at the top
     */
    public void resetElements(ManagerTable row){
        //set what to change
        AccommodationSpecifics data = getInstance();
        int roomIndex = row.getRoomNumber()-1;
        int hallIndex = Integer.parseInt(row.getHallNumber());
        occupancy_CB.setValue(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomStatus());
        studentName.setText("");
        studentName.setPromptText("Student name");
        studentSurname.setText("");
        studentSurname.setPromptText("Student surname");
        //monthlyRate_S.setValue(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getMonthlyRentRate());
        monthlyRate_Lbl.setText(Float.toString(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getMonthlyRentRate()));
        leaseDuration_S.setValue(0);
        leaseDuration_Lbl.setText("");
        if(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomCleanliness().equals("Offline")){
            roomStatus_Box.setSelected(false);
        }else{
            roomStatus_Box.setSelected(true);
        }
        
    }
    
    /**
     * Function to set the room to online or offline
     */
    public void changeRoomStatus(){
        AccommodationSpecifics data = getInstance();
        
        
        if(selectedRow!=null){
            int roomIndex = selectedRow.getRoomNumber()-1;
            int hallIndex = Integer.parseInt(selectedRow.getHallNumber());
            if(roomStatus_Box.isSelected()){
                //change room status to unoccupied
                data.getHalls().get(hallIndex).getRooms().get(roomIndex).setRoomCleanliness(0);
                selectedRow.setCleanliness(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomCleanliness());
            }else{
                //change room status to offline
                data.getHalls().get(hallIndex).getRooms().get(roomIndex).setRoomCleanliness(2);
                selectedRow.setCleanliness(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomCleanliness());
            }
            //update the table
            table_T.refresh();
        }else{
            occupancyError_Lbl.setText("No room selected");
        }
    }
    
    /**
     * Function that hides the createLeaseView and the button createLease;
     */
    public void hideCreateLease(ActionEvent event){
        if(selectedRow!=null){
            //check if the status is set to online
            if(!selectedRow.getCleanliness().equals("Offline")){
                createLeaseView_V.setVisible(false);
                occupancyError_Lbl.setText("");
            }else{
                //print error
                occupancyError_Lbl.setText("Room is not online");
            }
        }else{
            occupancyError_Lbl.setText("No room selected");
        }
    }
    
    /**
     * Function that shows the createLeaseView and the button createLease;
     */
    public void showCreateLease(ActionEvent event){
        createLeaseView_V.setVisible(true);
        setSelectedLabels(selectedRow);
        //reset all of the input things
        resetElements(selectedRow);
    }
    
    /**
     * Function that deletes the selected row of data
     */
    public void delete(ActionEvent event){
        
        //get the values from the selected row (could use a global variable)
        //selectedRow = table_T.getSelectionModel().getSelectedItem();
        
        //change values in the table (wrong, must modify items in the observable list
        selectedRow.setStudentName("");
        selectedRow.setLeaseNumber("");
        selectedRow.setOccupancyStatus("Unoccupied");
        //selectedRow.setCleanliness("Offline");
        
        //set what to change
        AccommodationSpecifics data = getInstance();
        int roomIndex = selectedRow.getRoomNumber()-1;
        int hallIndex = Integer.parseInt(selectedRow.getHallNumber());
        
        //update the changes of the real data (not only the table data)
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).setLease(null);
        //data.getHalls().get(hallIndex).getRooms().get(roomIndex).setRoomCleanliness(2);
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).setRoomStatus(false);
        
        //show the create Lease page
        showCreateLease(event);
        
        //show the changes to the table
        table_T.refresh();
    }
    
    /**
     * Function that checks input data and sends it to the update function
     */
    public void confirm(ActionEvent event){
        boolean studentSurnameFlag = true;
        boolean studentNameFlag = true;
        boolean leaseDurationFlag = true;
        //check if the data in the fields are not null
        if(studentSurname.getText().equals("")){
            studentSurnameFlag = false;
            displayError(2);
        }else{
            surnameError_Lbl.setText("");
        }
        if(studentName.getText().equals("")){
            studentNameFlag = false;
            displayError(1);
        }else{
            nameError_Lbl.setText("");
        }
        if((int)leaseDuration_S.getValue()<1){
            leaseDurationFlag = false;
            displayError(3);
        }else{
            leaseError_Lbl.setText("");
        }
        
        //if everything is displayed correctly update data
        if(studentSurnameFlag && studentNameFlag && leaseDurationFlag){
            if(selectedRow.getOccupancyStatus().equals("Occupied")){
               updateLease();
            }else{
               addNewLease(); 
            }
            
        }
    }
    
    public void resetErrorLabels(){
        occupancyError_Lbl.setText("");
        leaseError_Lbl.setText("");
        nameError_Lbl.setText("");
        surnameError_Lbl.setText("");
    }
    /**
     * Function that updates the values form the Input fields to the AccomodationSpecifics
     */
    public void updateLease(){
        AccommodationSpecifics data = getInstance();
        int roomIndex = selectedRow.getRoomNumber()-1;
        int hallIndex = Integer.parseInt(selectedRow.getHallNumber());
        
        //update everything
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().setDuration((int)leaseDuration_S.getValue());
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().setFirstName(studentName.getText());
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().setLastName(studentSurname.getText());
        
        //update the table
        updateTableRow(data,roomIndex,hallIndex);
        
        //update Gui
        
        
    }
    
    /**
     * Function that Creates a new Lease and puts the values from the Input fields to the AccomodationSpecifics
     */
    public void addNewLease(){
        //get the values from the inputs and put them into the data
        AccommodationSpecifics data = getInstance();
        
        int roomIndex = selectedRow.getRoomNumber()-1;
        int hallIndex = Integer.parseInt(selectedRow.getHallNumber());
        
        //update the room status
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).setRoomStatus(true);
        
        //before setting the name we have to create a Lease and student.
        Student s = new Student(data.getStudentNumber(), studentName.getText(), studentSurname.getText());
        Lease l = new Lease(s,(int)leaseDuration_S.getValue(),data.getLeaseNumber());
        
        //update Specifics data
        data.getHalls().get(hallIndex).getRooms().get(roomIndex).setLease(l);
        
        //update the table
        updateTableRow(data,roomIndex,hallIndex);
        
        //update GUI
        leaseNumber.setText(selectedRow.getLeaseNumber());
        studentNumber_Lbl.setText(Integer.toString(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().getStudentNumber()));
        
    }
    
    /**
     * Function that shows modifications in the selected row
     * @param data
     * @param roomIndex
     * @param hallIndex
     */
    public void updateTableRow(AccommodationSpecifics data,int roomIndex, int hallIndex){
        //lease number
        selectedRow.setLeaseNumber(Integer.toString(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getLeaseNumber()));
        //student
        selectedRow.setStudentName(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getLease().getStudent().getFullName());
        //occupancy
        selectedRow.setOccupancyStatus(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomStatus());
        //cleanliness
        selectedRow.setCleanliness(data.getHalls().get(hallIndex).getRooms().get(roomIndex).getRoomCleanliness());
        table_T.refresh();
    }
    
    
    /**
     * Function to display what was not entered correctly (will take in a label variable)
     */
    public void displayError(int errorNumber){
        //get the values from the inputs and put them into the data
        System.out.println("data not entered correctly");
        
        //put a switch case
        switch(errorNumber){
            case 1:
                nameError_Lbl.setText("Name error!");
                break;
                
            case 2:
                surnameError_Lbl.setText("Surname error!");
                break;
                
            case 3:
                leaseError_Lbl.setText("Insert Value!");
                break;
        }
             
    }
    
    
    
}
