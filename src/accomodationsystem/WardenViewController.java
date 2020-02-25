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
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author juanestebanvargassalamanca
 */
public class WardenViewController implements Initializable {

    //fxml variables to display in GUI for warden only
    @FXML private TableView<WardenTable> tableView;
    @FXML private TableColumn<WardenTable, String> hallName_Col;
    @FXML private TableColumn<WardenTable, String> hallNumber_Col;
    @FXML private TableColumn<WardenTable, String> roomNumber_Col;
    @FXML private TableColumn<WardenTable, String> roomStatus_Col;
    @FXML private TableColumn<WardenTable, String> cleanliness_Col;
    
    //fxml variables to see clicked data
    @FXML private Label room_Display;
    @FXML private Label currentStatus_Display;
    @FXML private Label hallName_Display;
    @FXML private Label hallNumber_Display;
    @FXML private Label choiceboxSelection;
    @FXML private Label selectTablePrintErrorMessage;
    @FXML private Label choiceboxSelectionNeededError;
    @FXML private Label offlineEditingErrorLabel;
    
    
    //fxml variables set options and confirming
    @FXML private ChoiceBox cleanliness_CB;
    @FXML private Button confirmChange_Bt;
    
    ObservableList<WardenTable> tableData = FXCollections.observableArrayList();
    AccommodationSpecifics data = AccommodationSpecifics.getInstance();
    WardenTable dataSelected;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setUpTableColumnsNames();
        addChoiceboxOptions();
        printMessageLabels(true, false, false, false);

        tableView.setItems(specificsToTable(data, tableData)); /** LOADS DUMMY DATA **/
        
        /** GET DATA CLICKED **/
        tableView.setOnMouseClicked(e -> {
            setSelectedLabels(getDataFromTable());
            checkOfflineRoom(getDataFromTable());
            
        });
    }

    public void printMessageLabels(boolean choiceboxOriginalPrompt, boolean tableErrorMessage, boolean choiceboxSelectionErrorMessage, boolean offlineErrorMessage){
        //first is prompt message
        choiceboxSelection.setVisible(choiceboxOriginalPrompt);
        
        //other two are error messages
        selectTablePrintErrorMessage.setVisible(tableErrorMessage);
        choiceboxSelectionNeededError.setVisible(choiceboxSelectionErrorMessage);
        offlineEditingErrorLabel.setVisible(offlineErrorMessage);
    }

    public int checkTableSelection(){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
//        System.out.println("tbale error index returned: " + selectedIndex);
        
        if (selectedIndex == -1) {
            printMessageLabels(false, true, false, false);
        }
        
        return selectedIndex;
    }
    
    public String checkChoiceBoxSelection(WardenTable rowSelected, int tableError){
        
        boolean selectionMade = cleanliness_CB.getSelectionModel().isEmpty();
        String currentCleanlinessStatus = null; 

        if (tableError != -1) {
            currentCleanlinessStatus = rowSelected.getRoomCleanliness();
        
            if (selectionMade) {
                printMessageLabels(false, false, true, false);
            } else {
                printMessageLabels(true, false, false, false);
                currentCleanlinessStatus = cleanliness_CB.getSelectionModel().getSelectedItem().toString();
            }
        }
  
       return currentCleanlinessStatus;
    }
    
        
    public void checkOfflineRoom(WardenTable selection){
        String cleanlinessStatus = selection.getRoomCleanliness();
        
            if(cleanlinessStatus.equals("Offline")){
                System.out.println("made it this far");
                cleanliness_CB.setDisable(true);
                confirmChange_Bt.setDisable(true);
                printMessageLabels(false, false, false, true);

            } else {
                printMessageLabels(true, false, false, false);
                cleanliness_CB.setDisable(false);
                confirmChange_Bt.setDisable(false);
            }
    }
    
    public void confirmEdit() {
        
        int indexReturned = checkTableSelection(); //first check there has been a selection from the table so we have an index
        String cleanlinessSelected = checkChoiceBoxSelection(getDataFromTable(), indexReturned); //no we want to check there's a value to update hence there's a 
        
        try {
            tableData.get(indexReturned).setRoomCleanliness(cleanlinessSelected);// update table data      
            updateDummyData(indexReturned, cleanlinessSelected); //update dummy data with new value
            //set labels after edit
            setSelectedLabels(getDataFromTable());
        } catch (Exception e) {
            System.out.println("Exeption kicked becasue of -1 returned from tablev");
        }
        
        tableView.refresh();
        
    }
    
    public void updateDummyData(int indexFromTableClickedReturned ,String cleanlinessUpdate){
        int currentHallIndex = tableData.get(indexFromTableClickedReturned).getHallNumber();
        int roomIndexToChange = tableData.get(indexFromTableClickedReturned).getRoomNumber() - 1;
        
        data.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).setRoomCleanliness(convertCleanlinessDataDype(cleanlinessUpdate));
//        System.out.println(data.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).getRoomCleanliness());
    }
    
            
            
    public void addChoiceboxOptions(){
        //Buttons and Labels
//        cleanliness_CB.getItems().add("Offline");
        cleanliness_CB.getItems().add("Clean");
        cleanliness_CB.getItems().add("Dirty");
    }
    
    public void setUpTableColumnsNames(){
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        roomNumber_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatus_Col.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("roomCleanliness"));
    }
    
    public int convertCleanlinessDataDype(String cleanlinessStatus){
        int valueToReturn = 0;
        switch (cleanlinessStatus) {
                case "Clean":
                    valueToReturn = 0;
                    break;
                case "Dirty":
                    valueToReturn = 1;
                    break;
                case "Offline":
                    valueToReturn = 2;
            }
        return valueToReturn;
    }
    
    public WardenTable getDataFromTable(){
        /**
         * This function warden object of row clicked on tableView
         */
        return dataSelected = tableView.getSelectionModel().getSelectedItem();
    }
    
    public void setSelectedLabels(WardenTable row){
        room_Display.setText(Integer.toString(row.getRoomNumber()));
        currentStatus_Display.setText(row.getRoomCleanliness());
        hallName_Display.setText(row.getHallName());
        hallNumber_Display.setText(Integer.toString(row.getHallNumber()));
    }
    
    public void tableClicked(WardenTable rowclicked){
        /**
         * this function gets the row clicked and changes the values of the labels --> 
         * so you can see what you're about to change
         */
        setSelectedLabels(rowclicked);
        
    }
    
    public void changeScene(ActionEvent event) throws IOException {

        // Gets FXML Documents and makes a new scene
        Parent backToMenu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menuScene = new Scene(backToMenu);

        //Windows is cast as a stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }
    
    public ObservableList<WardenTable> specificsToTable(AccommodationSpecifics data, ObservableList<WardenTable> tableData){
        
        int addHallToTable = data.getWardenHallToTable();
        
        //loop through every room in the system
        for(int i=0; i<data.getHalls().get(addHallToTable).getRooms().size();i++){

            //add new row of data
            tableData.add(new WardenTable());
            int elementIndex = tableData.size() - 1; //

            //set the hall name
            tableData.get(elementIndex).setHallName(data.getHalls().get(addHallToTable).getHallName());

            //set the hall number
            tableData.get(elementIndex).setHallNumber(addHallToTable);

            //set the room number
            tableData.get(elementIndex).setRoomNumber(data.getHalls().get(addHallToTable).getRooms().get(i).getRoomNumber());

            //set the room status
            tableData.get(elementIndex).setRoomStatus(data.getHalls().get(addHallToTable).getRooms().get(i).getRoomStatus());

            //set the cleanliness
            tableData.get(elementIndex).setRoomCleanliness(data.getHalls().get(addHallToTable).getRooms().get(i).getRoomCleanliness());
        }
        
        return tableData;
    }
}