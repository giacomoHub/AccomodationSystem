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
    
    public void Initialiser(){
        //make new fake data
        /* STUDENTS */
        Student s1 = new Student(1111, "juan", "Giacommo");
        Student s2 = new Student(1112, "Giacomo", "Pellizzari");
        Student s3 = new Student(1113, "Mohammed", "Solair");
        
        /* ROOMS  */
        Room r1 = new Room(1, true, 300, 1);
        Room r2 = new Room(2, true, 300, 1);
        Room r3 = new Room(3, true, 300, 1);
        
        /** LEASES */
        Lease l1 = new Lease(s1,3,1);
        Lease l2 = new Lease(s2,7,2);
        Lease l3 = new Lease(s3,4,3);
        
        r1.setLease(l1);
        r2.setLease(l2);
        r3.setLease(l3);
        
        /** TELEPHONES */
        Telephone tel1 = new Telephone("+44", "0132", "65445");
        Telephone tel2 = new Telephone("+88", "01364", "009128");
        
        /** ADDRESS */
//        Address add_1 = new Address("Frenchay UWE", "Q-Block" ,1, "BS3 111", "Brisol", "Somerset", "England");
//        Address add_2 = new Address("Bristol", "Zipper-Block" ,1, "B12 S13", "Somerset", "Somewhere in the UK", "England");
//        Address add_3 = new Address("Cardiff", "Rangers" ,1, "BSE R10", "Bath", "Somerset", "England");
//        Address add_4 = new Address("UWE", "Quck" ,1, "BSX 212", "Brisol", "Somerset", "England");
        
        halls.add(new Hall("building_1", new Address("Frenchay UWE", "Q-Block" ,1, "BS3 111", "Brisol", "Somerset", "England"), tel1));
        halls.add(new Hall("building_2", new Address("Bristol", "Zipper-Block" ,1, "B12 S13", "Somerset", "Somewhere in the UK", "England"), tel2));
        halls.add(new Hall("building_3", new Address("Cardiff", "Rangers" ,1, "BSE R10", "Bath", "Somerset", "England"), tel2));
        halls.add(new Hall("building_4", new Address("UWE", "Quck" ,1, "BSX 212", "Brisol", "Somerset", "England"), tel1));
        
        for(int j = 0; j < 4; j++){
            //Variable creates 4 halls 
            for (int i = 1; i <= 20; i++) {
                
                if(i % 2 == 0){
                    halls.get(j).addRoom(new Room(i, true, i*100, i));
                } else {
                    halls.get(j).addRoom(new Room(i, false, i*50, i));
                }
            }
        }
        
    }
   
    public ArrayList<Hall> getHalls(){
        return halls;
    }
}
