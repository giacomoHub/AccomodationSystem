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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author jitojar
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    /**
     * Change view
     */
    public void changeScene(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ManagerView.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    
    public void changeSceneWarden(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("WardenView.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /* STUDENTS */
        Student s1 = new Student(1111, "juan", "Giacommo");
        Student s2 = new Student(1112, "Giacomo", "Pellizzari");
        Student s3 = new Student(1113, "Mohammed", "Solair");
        
        /* ROOMS address and lease  */
        Room r1 = new Room(1, true, 300, 1, new Lease(s1, 1, 1));
        Room r2 = new Room(2, true, 300, 1, new Lease(s2, 1, 1));
        Room r3 = new Room(3, true, 300, 1, new Lease(s3, 1, 1));
        
        
        //initialising system
        // HALL TELEPHONE
        Telephone tel1 = new Telephone(+44, 0132, 65445);
        
        ArrayList<Hall> halls = new ArrayList<Hall>();
        halls.add(new Hall("juantoc", new Address("Frenchay UWE", "Q-Block" ,1, "BSX 111", "Brisol", "Somerset", "England"), tel1, r1));
        halls.get(0).addRoom(r2);
        halls.get(0).addRoom(r3);
        
        //test print the fake data
        System.out.println("Accomodation System");
        for (int i = 0; i < 3; i++) {
            System.out.println("Student1:" + halls.get(0).getRooms().get(i).getLease().getStudent());
        }
    }    
    
}
