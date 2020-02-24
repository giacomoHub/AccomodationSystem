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
p ublic class WardenViewController implements Initializable {

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
    @FXML private Label selectPrintMessage;
    @FXML private Label selectPrintErrorMessage;
    
    
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

        tableView.setItems(specificsToTable(data, tableData)); /** LOADS DUMMY DATA **/
        
        /** GET DATA CLICKED **/
        tableView.setOnMouseClicked(e -> {
            setSelectedLabels(getDataFromTable());
            
        });
        
//        confirmChange_Bt.setOnMouseClicked(e ->{ 
////            System.out.println("made it this far");
////            String cleanlinessUpdate = cleanliness_CB.getSelectionModel().getSelectedItem().toString(); //this returns the value of the choiceBox
////            System.out.println("choice box no selection: " + cleanlinessUpdate);
//            
////            int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
//            
////            ConfirmEdit(data, tableData.get(selectedIndex), selectedIndex);
//            
////            setSelectedLabels(getDataFromTable());
//            tableView.refresh();
//               
//        });
    }
    
    
    public void addChoiceboxOptions(){
        //Buttons and Labels
        cleanliness_CB.getItems().add("Offline");
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
    
    public void printMessageLabels(boolean pleaseSelectMessage , boolean errorMessage){
        selectPrintMessage.setVisible(pleaseSelectMessage);
        selectPrintErrorMessage.setVisible(errorMessage);
    }
    
    
//    public void ConfirmEdit(AccommodationSpecifics dataToModify, WardenTable UpdateTable , int index) {
//        
//        //UPDATE TABLE VIEW FROM CHIOCEBOX
//        String cleanlinessUpdate = cleanliness_CB.getSelectionModel().getSelectedItem().toString(); //this returns the value of the choiceBox
//        System.out.println("choice box no selection: " + cleanlinessUpdate);
//        if (cleanlinessUpdate.equals("")) {
//            printMessageLabels(false, true);
//        }
//        UpdateTable.setRoomCleanliness(cleanlinessUpdate);
//        
//        //UPDATE ACTUAL DATA 
//        int currentHallIndex = tableData.get(index).getHallNumber();
//        int roomIndexToChange = UpdateTable.getRoomNumber() - 1;
//        
//        dataToModify.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).setRoomCleanliness(convertCleanlinessDataDype(cleanlinessUpdate));
//        System.out.println(dataToModify.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).getRoomCleanliness());
//        
//        //set labels after edit
//        setSelectedLabels(getDataFromTable());
//        
//    }
    
    
    public int checkTableSelection(){
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex == -1) {
            selectPrintErrorMessage();
        }
        
        return selectedIndex;
    }
    
    public void confirmEdit() {
        
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        
        try {
            String cleanlinessUpdate = cleanliness_CB.getSelectionModel().getSelectedItem().toString(); //this returns the value of the choiceBox
            System.out.println("choicebox returned:" + cleanlinessUpdate);
            
        } catch (NullPointerException e) {
            
            System.out.println("null pointer exeption occured --> FIX IT BRO !!");
        }
        
        //UPDATE TABLE VIEW FROM CHIOCEBOX
//        System.out.println("choice box no selection: " + cleanlinessUpdate);
//        
//        if (cleanlinessUpdate.equals("")) {
//            printMessageLabels(false, true);
//        } else {
//            System.out.println("skipped passed check!!");
//        }
//        
//        tableData.get(selectedIndex).setRoomCleanliness(cleanlinessUpdate);
        
        //UPDATE ACTUAL DATA 
        int currentHallIndex = tableData.get(selectedIndex).getHallNumber();
        int roomIndexToChange = tableData.get(selectedIndex).getRoomNumber() - 1;
        
//        data.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).setRoomCleanliness(convertCleanlinessDataDype(cleanlinessUpdate));
//        System.out.println(data.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).getRoomCleanliness());
        
        //set labels after edit
        setSelectedLabels(getDataFromTable());
        
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

    
    


