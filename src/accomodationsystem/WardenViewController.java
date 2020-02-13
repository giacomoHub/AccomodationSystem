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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author juanestebanvargassalamanca
 */
public class WardenViewController implements Initializable {

    //fxml variables to display in GUI for warden only

    @FXML private TableView<WardenTable> tableView;
    @FXML private TableColumn<WardenTable, String> hallNameColumn;
    @FXML private TableColumn<WardenTable, String> hallNumberColumn;
    @FXML private TableColumn<WardenTable, String > roomNumberColumn;
    @FXML private TableColumn<WardenTable, String> roomStatusColumn;
    @FXML private TableColumn<WardenTable, String> cleanlinessColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        ArrayList<WardenTable> tableData = new ArrayList<WardenTable>();
        
        specificsToTable(data,tableData);

        //set columns in table
        hallNameColumn.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        //hallNumberColumn.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatusColumn.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        cleanlinessColumn.setCellValueFactory(new PropertyValueFactory<>("roomCleanliness"));

        /** LOADS DUMMY DATA **/
        tableView.setItems(getInfo(tableData));
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

    public void specificsToTable(AccommodationSpecifics data, ArrayList<WardenTable> tableData){
        //loop through every hall in the system
        for(int j = 0; j<data.getHalls().size();j++){
            //loop through every room in the system
            for(int i=0; i<data.getHalls().get(j).getRooms().size();i++){
                //add new row of data
                tableData.add(new WardenTable());
                int elementIndex = tableData.size() - 1;

                //set the hall name
                tableData.get(elementIndex).setHallName(data.getHalls().get(j).getHallName());

                //set the hall number
                tableData.get(elementIndex).setHallNumber(Integer.toString(j));

                //set the room number
                tableData.get(elementIndex).setRoomNumber(data.getHalls().get(j).getRooms().get(i).getRoomNumber());

                //set the room status
                tableData.get(elementIndex).setRoomStatus(data.getHalls().get(j).getRooms().get(i).getRoomStatus());

                //set the cleanliness
                tableData.get(elementIndex).setRoomCleanliness(data.getHalls().get(j).getRooms().get(i).getRoomCleanliness());
            }
        }
    }
    
    /**
     * Function that converts the list managerTable items into observable list;
     */
    public ObservableList<WardenTable> getInfo(ArrayList<WardenTable> tableData){
        ObservableList<WardenTable> info = FXCollections.observableArrayList();
        for(int i = 0; i<tableData.size(); i++){
            info.add(tableData.get(i));
        }
        return info;
    }
}

