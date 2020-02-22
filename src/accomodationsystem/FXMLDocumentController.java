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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author jitojar
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private Label label1;
    @FXML private Button managerButton;
    @FXML private Button wardenButton;
    @FXML private Button loginButtonforWarden;
    @FXML private AnchorPane managerWardenTableChoice;
    @FXML private AnchorPane wardenLoginView;
    @FXML private TextField usernameInput;
    @FXML private PasswordField passwordInput;
    
    
    
    /**
     * Change view
     * @param event
     * @throws java.io.IOException
     */
    
    public void changeSceneManagerTable(ActionEvent event) throws IOException{
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ManagerView.fxml"));
        Scene otherScene = new Scene(tableViewParent);
                
        //Get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(otherScene);
        window.show();
    }
    
    public void changeSceneWardenTable(ActionEvent event) throws IOException{
        
        //prior to changing i want to check values being passed are correct
        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        checkUsernamePassword();
        handleUsernamePasswordEntered(data.getWardenHallToTable());
        
        if (data.getWardenHallToTable() < 4) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("WardenView.fxml"));
            Scene otherScene = new Scene(tableViewParent);

            //Get the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(otherScene);
            window.show();
        } else {
            System.out.print("handle data return utside halls create");
        }
        
    }
    
    public void changeSceneToLoadingPage(ActionEvent event) throws IOException {
         // Gets FXML Documents and makes a new scene
        Parent backToMenu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene menuScene = new Scene(backToMenu);

        //Windows is cast as a stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }

    public void wardenUsernamePasswordSetScene(){
        managerWardenTableChoice.visibleProperty().set(false);
        wardenLoginView.visibleProperty().set(true);
    }
    
    public void setLoginPage(){
        managerWardenTableChoice.visibleProperty().set(true);
        wardenLoginView.visibleProperty().set(false);
    }
    
    public void checkUsernamePassword(){
        
        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        
        String usernamePassed = usernameInput.getText().toString();
        String passwordPassed  = passwordInput.getText().toString();
         
        int counterToReturn = 4;
        
        boolean usernameNotEmpty = true;
        boolean passwordNotEmpty = true;
        
         if (usernamePassed.equals("")){
            usernameNotEmpty = false;
            System.out.println("username: clear and ERROR");
         }
            
        if (passwordPassed.equals("")){
            passwordNotEmpty = false;
            System.out.println("ppassword: clear and ERROR");
        }
        
        if(usernameNotEmpty && passwordNotEmpty) 
        {
            int indexCounter = 0;
            System.out.println("check for password");
            
            while (indexCounter < 4) {
            
                if (usernamePassed.equals(data.getUsernames().get(indexCounter)) && passwordPassed.equals(data.getPasswords().get(indexCounter))) 
                {
                        counterToReturn = indexCounter;
                        break;
                        
                } else {
                    indexCounter++;
                    System.out.println("no match username --> ++ counter\n");
                }
            }
        }
        
        System.out.println("\nindexcounter returned:" + counterToReturn);
        data.setWardenHallToTable(counterToReturn);
        
    }
    
    public void handleUsernamePasswordEntered(int passwordMatch){
        
        switch(passwordMatch) {
            case 0:
                System.out.println("print only hall 1");
                break;
            case 1:
                System.out.println("print only hall 2");
                break;
                
            case 2:
                System.out.println("print only hall 3");
                break;
                
            case 3:
                System.out.println("print only hall 4");
                break;
                
            case 4:
                System.out.println("no match");
                break;
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AccommodationSpecifics data = AccommodationSpecifics.getInstance();
        
        //hides wardenlogin unitl clicked
        setLoginPage();
        
//        loginButtonforWarden.setOnMouseClicked(e -> {
//            checkUsernamePassword();
//            handleUsernamePasswordEntered(data.getWardenHallToTable());
//        
//        });
               
    }
               
}
