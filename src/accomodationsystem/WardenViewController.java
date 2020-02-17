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
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML private TextField room_Dis;
    @FXML private TextField currentStatus_Dis;
    
    //fxml variables set options and confirming
    @FXML private ChoiceBox cleanliness_CB;
    @FXML private Button confirmChange_Bt;
    
    WardenTable dataSelected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        ObservableList<WardenTable> tableData = FXCollections.observableArrayList();
       
         
        //set columns in table
        hallName_Col.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        hallNumber_Col.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        roomNumber_Col.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatus_Col.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        cleanliness_Col.setCellValueFactory(new PropertyValueFactory<>("roomCleanliness"));
        
        //Buttons and Labels
        cleanliness_CB.getItems().add("");
        cleanliness_CB.getItems().add("Clean");
        cleanliness_CB.getItems().add("Dirty");
        cleanliness_CB.getItems().add("Off-Line");

        /** LOADS DUMMY DATA **/
        tableView.setItems(specificsToTable(data, tableData));
        
        /** GET DATA CLICKED **/
        tableView.setOnMouseClicked(e -> {
            eventCicked();
        });
        
    
    }
    
    public void eventCicked(){
        dataSelected = tableView.getSelectionModel().getSelectedItem();
        setSelectedLabels(dataSelected);
        System.out.println(dataSelected.getHallName());  
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
        //loop through every hall in the system
        for(int j = 0; j<data.getHalls().size();j++){
            //loop through every room in the system
            for(int i=0; i<data.getHalls().get(j).getRooms().size();i++){
                //add new row of data
                tableData.add(new WardenTable());
                int elementIndex = tableData.size() - 1; //

                //set the hall name
                tableData.get(elementIndex).setHallName(data.getHalls().get(j).getHallName());

                //set the hall number
//                System.out.println(j); // Hall number is not being printed appropiately --\> CHECK
                tableData.get(elementIndex).setHallNumber(Integer.toString(j));

                //set the room number
                tableData.get(elementIndex).setRoomNumber(data.getHalls().get(j).getRooms().get(i).getRoomNumber());

                //set the room status
                tableData.get(elementIndex).setRoomStatus(data.getHalls().get(j).getRooms().get(i).getRoomStatus());

                //set the cleanliness
                tableData.get(elementIndex).setRoomCleanliness(data.getHalls().get(j).getRooms().get(i).getRoomCleanliness());
            }
        }
        
        return tableData;
    }
    

    public void setSelectedLabels(WardenTable row){
        room_Dis.setText(row.getHallName());
        currentStatus_Dis.setText(row.getRoomStatus());
    }
}

