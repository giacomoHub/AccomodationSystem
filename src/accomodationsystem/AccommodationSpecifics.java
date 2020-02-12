/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;


import java.util.ArrayList;

/**
 *
 * @author juanestebanvargassalamanca
 * @author giacomopellizzari
 */
public class AccommodationSpecifics {
    /**
     * THIS IS HANDLELING ALL OF THE DATA INTILIASATION
     */
    
    /**
     * Singleton pattern being used here
     */
    private static AccommodationSpecifics instance;
    private ArrayList<Hall> halls; //to be accessed
    private int numberOfRooms; //number of rooms for each hall

    
    /**
     * Constructor
     */
    private AccommodationSpecifics(){
        halls = new ArrayList<Hall>();
        Initialiser();
    } 
    
    
    /**
     * Class Methods
     */
    public static AccommodationSpecifics getInstance(){
        if (instance == null) {
            instance = new AccommodationSpecifics();
        }
        
        return instance;
    }
    
    public ArrayList<Hall> getHalls(){
        return halls;
    }
    
    public void Initialiser(){
        //make new fake data
        generateHalls();
        generateRooms();
        generateStudents();
        
        
    }
    
    //function that will generate all of the halls 
    private void generateHalls(){
        
        //telephones
        Telephone tel1 = new Telephone("+44", "0132", "654453");
        Telephone tel2 = new Telephone("+44", "0423", "009128");
        Telephone tel3 = new Telephone("+39", "0465", "554673");
        Telephone tel4 = new Telephone("+44", "0236", "097452");
        
        //address
        Address add1 = new Address("Frenchay UWE", "Q-Block" ,1, "BS3 111", "Brisol", "Somerset", "England");
        Address add2 = new Address("Bristol", "Zipper-Block" ,1, "B12 S13", "Somerset", "Somewhere in the UK", "England");
        Address add3 = new Address("Cardiff", "Rangers" ,1, "BSE R10", "Bath", "Somerset", "England");
        Address add4 = new Address("UWE", "Quck" ,1, "BSX 212", "Brisol", "Somerset", "England");
        
        //halls
        halls.add(new Hall("Bristol Hall", add1, tel1));
        halls.add(new Hall("Montebelluna", add2, tel2));
        halls.add(new Hall("Studio 58", add3, tel3));
        halls.add(new Hall("Wallscourt", add4, tel4));
    }
    
    private void generateRooms(){
        //add 20 rooms to the four halls
        for(int j = 0; j < halls.size(); j++){
            for (int i = 1; i <= numberOfRooms; i++) {
                if(i % 2 == 0){
                    halls.get(j).addRoom(new Room(i, true, i*100, i));
                } else {
                    halls.get(j).addRoom(new Room(i, false, i*50, i));
                }
            }
        }
    }
    
    //function that adds new leases and students to the rooms
    private void generateStudents(){
        int leaseNumber = 0;
        int studentNumber = 1000;
        
        //sets leases and students in half of the rooms
        for(int j = 0; j<halls.size(); j++){
            for(int i=0; i<halls.get(j).getRooms().size(); i++){
                //put only some students into the system
                if(i%2==0){
                    leaseNumber++;
                    studentNumber++;
                    halls.get(j).getRooms().get(i).setLease(new Lease(new Student(studentNumber,randomStudentName() ,randomStudentSurname()), i, leaseNumber));
                }
            }
        }
    }
    
    private String randomStudentName(){
        return null;
    }
    
    private String randomStudentSurname(){
        return null;
    }
    
   
}
