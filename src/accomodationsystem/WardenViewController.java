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
    @FXML
    private TableView<UWE_AccommodationTable> tableView;
    @FXML
    private TableColumn<UWE_AccommodationTable, String> hallNameColumn;
    @FXML
    private TableColumn<UWE_AccommodationTable, Integer> hallNumberColumn;
    @FXML
    private TableColumn<UWE_AccommodationTable, Integer > roomNumberColumn;
    @FXML
    private TableColumn<UWE_AccommodationTable, String> roomStatusColumn;
    @FXML
    private TableColumn<UWE_AccommodationTable, String> cleanlinessColumn;

    /**
     * @param event
     * @throws IOException Description: Changes to main menu
     */
    public void changeScene(ActionEvent event) throws IOException {

        // Gets FXML Documents and makes a new scene
        Parent backToMenu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menuScene = new Scene(backToMenu);

        //Windows is cast as a stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    /**
     * @param url
     * @param rb Description: loads everything needed for GUI when loaded
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //set columns in table
        hallNameColumn.setCellValueFactory(new PropertyValueFactory<UWE_AccommodationTable, String>("HallName"));
//        hallNumberColumn.setCellValueFactory(new PropertyValueFactory<UWE_AccommodationTable, Integer >("HallNumber"));
//        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<UWE_AccommodationTable, Integer>("RoomNumber"));
//        roomStatusColumn.setCellValueFactory(new PropertyValueFactory<UWE_AccommodationTable, String>("RoomStatus"));
//        cleanlinessColumn.setCellValueFactory(new PropertyValueFactory<UWE_AccommodationTable,String >("RoomCleanliness"));

        //this loads the dummy data
        tableView.setItems(getData());

    }

    public ObservableList<UWE_AccommodationTable> getData() {

        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        
        ObservableList<UWE_AccommodationTable> tableData = FXCollections.observableArrayList();

        for (int j = 0; j < data.getHalls().size(); j++) {
            for (int i = 0; i < data.getHalls().get(0).getRooms().size(); i++) {
                tableData.add(new UWE_AccommodationTable(data.getHalls().get(j), data.getHalls().get(j).getRooms().get(i), data.getHalls().get(j).getRooms().get(i).getLease()));
            }
        }

        return tableData;
    }
}
