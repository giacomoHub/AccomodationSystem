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
    
    //fxml variables set options and confirming
    @FXML private ChoiceBox cleanliness_CB;
    @FXML private Button confirmChange_Bt;
    
    ObservableList<WardenTable> tableData = FXCollections.observableArrayList();
    AccommodationSpecifics data = AccommodationSpecifics.getInstance();
    
    WardenTable dataSelected;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        //set columns in table
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        roomNumber_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatus_Col.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("roomCleanliness"));
        
        //Buttons and Labels
        cleanliness_CB.getItems().add("Clean");
        cleanliness_CB.getItems().add("Dirty");

        /** LOADS DUMMY DATA **/
        tableView.setItems(specificsToTable(data, tableData));
        
        /** GET DATA CLICKED **/
        tableView.setOnMouseClicked(e -> {
            setSelectedLabels(getDataFromTable());
            
        });
        
        confirmChange_Bt.setOnMouseClicked(e ->{
            
            int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
            System.out.println("Current index returned from tableView: " + selectedIndex);
            
            ConfirmEdit(data, tableData.get(selectedIndex), selectedIndex);
            
            setSelectedLabels(getDataFromTable());
            tableView.refresh();
               
        });
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
    
    public void ConfirmEdit(AccommodationSpecifics dataToModify, WardenTable UpdateTable , int index) {
        
        //UPDATE TABLE VIEW FROM CHIOCEBOX
        String cleanlinessUpdate = cleanliness_CB.getSelectionModel().getSelectedItem().toString(); //this returns the value of the choiceBox
        
        UpdateTable.setRoomCleanliness(cleanlinessUpdate);
        
        //UPDATE ACTUAL DATA 
        int currentHallIndex = tableData.get(index).getHallNumber();
        int roomIndexToChange = UpdateTable.getRoomNumber() - 1;
        
        dataToModify.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).setRoomCleanliness(convertCleanlinessDataDype(cleanlinessUpdate));
        System.out.println(dataToModify.getHalls().get(currentHallIndex).getRooms().get(roomIndexToChange).getRoomCleanliness());
        
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


//                System.out.println("size i is going around for rooms: " + i);

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


//    public ObservableList<WardenTable> specificsToTable(AccommodationSpecifics data, ObservableList<WardenTable> tableData){
//        //loop through every hall in the system
//        for(int j = 0; j<data.getHalls().size();j++){
//            
////            System.out.println("size j is going around: " + j);
//            //loop through every room in the system
//            for(int i=0; i<data.getHalls().get(j).getRooms().size();i++){
//                
//                
////                System.out.println("size i is going around for rooms: " + i);
//                
//                //add new row of data
//                tableData.add(new WardenTable());
//                int elementIndex = tableData.size() - 1; //
//
//                //set the hall name
//                tableData.get(elementIndex).setHallName(data.getHalls().get(j).getHallName());
//
//                //set the hall number
//                tableData.get(elementIndex).setHallNumber(j);
//
//                //set the room number
//                tableData.get(elementIndex).setRoomNumber(data.getHalls().get(j).getRooms().get(i).getRoomNumber());
//
//                //set the room status
//                tableData.get(elementIndex).setRoomStatus(data.getHalls().get(j).getRooms().get(i).getRoomStatus());
//
//                //set the cleanliness
//                tableData.get(elementIndex).setRoomCleanliness(data.getHalls().get(j).getRooms().get(i).getRoomCleanliness());
//            }
//            
//        }
//        
//        return tableData;
//    }
    

    
    


