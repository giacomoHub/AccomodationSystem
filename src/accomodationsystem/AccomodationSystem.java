/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jitojar
 */
public class AccomodationSystem extends Application {
    
    static ArrayList<Hall> halls;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("UWE Accomodation System");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
        //make new fake data
        /* STUDENTS */
        Student s1 = new Student(1111, "juan", "Giacommo");
        Student s2 = new Student(1112, "Giacomo", "Pellizzari");
        Student s3 = new Student(1113, "Mohammed", "Solair");
        
        /* ROOMS address and lease  */
        Room r1 = new Room(1, true, 300, 1);
        Room r2 = new Room(2, true, 300, 1);
        Room r3 = new Room(3, true, 300, 1);
        
        
        //initialising system
        // HALL TELEPHONE
        Telephone tel1 = new Telephone(+44, 0132, 65445);
        
        halls = new ArrayList<>();
        halls.add(new Hall("buildin1", new Address("Frenchay UWE", "Q-Block" ,1, "BSX 111", "Brisol", "Somerset", "England"), tel1));
        halls.get(0).addRoom(r2);
        halls.get(0).addRoom(r3);
        
        //test print the fake data
        System.out.println("Accomodation System");
        for (int i = 0; i < 3; i++) {
            System.out.println("Student1:" + halls.get(0).getRooms().get(i).getLease().getStudent());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println("hello there");
    }
    
}
