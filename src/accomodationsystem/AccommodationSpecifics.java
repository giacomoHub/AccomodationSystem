/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;


import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author juanestebanvargassalamanca
 * @author giacomopellizzari
 */
public class AccommodationSpecifics {      
    /**
     * Singleton pattern being used here
     */
    private static AccommodationSpecifics instance;
    private ArrayList<Hall> halls; //to be accessed
    private int numberOfRooms; //number of rooms for each hall
    ArrayList<String> names;
    ArrayList<String> surnames;
    
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    private int wardenHallToTable;
    
    

    
    private int leaseNumber = 0;
    private int studentNumber = 1000;
    
    
    
    /**
     * Constructor
     */
    private AccommodationSpecifics(){
        halls = new ArrayList<Hall>();
        Initialiser();
    } 
    
    //Singleton
    public static AccommodationSpecifics getInstance(){
        if (instance == null) {
            instance = new AccommodationSpecifics();
        }
        
        return instance;
    }
    
     /**
     *  SET METHODS
     */
    
    public void setWardenHallToTable(int hall){
        wardenHallToTable = hall;
    }
    
    /**
     *  GET METHODS
     */
    
    
    
    public int getWardenHallToTable() {
        return wardenHallToTable;
    }

    public int getLeaseNumber() {
        leaseNumber++;
        return leaseNumber;
    }

    public int getStudentNumber() {
        studentNumber++;
        return studentNumber;
    }
    
    public ArrayList<Hall> getHalls(){
        return halls;
    }
    
    
    public ArrayList<String> getUsernames(){
        return usernames;
    }
    
    public ArrayList<String> getPasswords(){
        return passwords;
    }
    /**
     *  INITIALISES ALL DUMMY DATA FOR SYSTEM
     */
    
    public void Initialiser(){
        //make new fake data
        names = new ArrayList<String>();
        surnames = new ArrayList<String>();
        usernames = new ArrayList<String>();
        passwords = new ArrayList<String>();
        
        
        //read new names from file
        readNames();
        readSurnames();
        addUsernamesPasswords();
        
        numberOfRooms = 20;
        generateHalls();
        generateRooms();
        generateStudents();
        
        
    }
    
    private void addUsernamesPasswords(){
        usernames.add("w1");
        usernames.add("w2");
        usernames.add("w3");
        usernames.add("w4");
        
        passwords.add("warden1");
        passwords.add("warden2");
        passwords.add("warden3");
        passwords.add("warden4");
    }
    
    //function that will generate all of the halls 
    private void generateHalls(){
        
        //telephones
        Telephone tel1 = new Telephone("+44", "0132", "654453");
        Telephone tel2 = new Telephone("+44", "0423", "009128");
        Telephone tel3 = new Telephone("+39", "0465", "554673");
        Telephone tel4 = new Telephone("+44", "0236", "097452");
        
        //address
        Address add1 = new Address("Frenchay UWE", "Q-Block" ,1, "BS3 111", "Bristol", "Somerset", "England");
        Address add2 = new Address("Bristol", "Zipper-Block" ,1, "B12 S13", "Somerset", "Somewhere in the UK", "England");
        Address add3 = new Address("Cardiff", "Rangers" ,1, "BSE R10", "Bath", "Somerset", "England");
        Address add4 = new Address("UWE park", "Quck" ,1, "BSX 212", "Brisol", "Somerset", "England");
        
        //halls
        halls.add(new Hall("Bristol Hall", add1, tel1));
        halls.add(new Hall("Montebelluna", add2, tel2));
        halls.add(new Hall("Studio 58", add3, tel3));
        halls.add(new Hall("Wallscourt", add4, tel4));
    }
    
    private void generateRooms(){
        Random rand = new Random();
        //add 20 rooms to the four halls
        for(int j = 0; j < halls.size(); j++){
            for (int i = 1; i <= numberOfRooms; i++) {
                if(i % 2 == 0){
                    halls.get(j).addRoom(new Room(i, true, i*100, rand.nextInt(2)));
                } else {
                    halls.get(j).addRoom(new Room(i, false, i*50, rand.nextInt(2)));
                }
            }
        }
    }
    
    //function that adds new leases and students to the rooms
    private void generateStudents(){
        Random rand = new Random();
        
        
        //sets leases and students in half of the rooms
        for(int j = 0; j<halls.size(); j++){
            for(int i=0; i<halls.get(j).getRooms().size(); i++){
                //put only some students into the system
                //if(i%2==0){
                    leaseNumber++;
                    studentNumber++;
                    halls.get(j).getRooms().get(i).setLease(new Lease(new Student(studentNumber,randomStudentName() ,randomStudentSurname()), rand.nextInt(30), leaseNumber));
                //}
            }
        }
    }
    
    private void readNames(){
        names.add("Mario");
        names.add("Giacomo");
        names.add("Filippo");
        names.add("Roberto");
        names.add("James");
        names.add("Ludovico");
        names.add("Alfred");
        names.add("David");
        names.add("Pierre");
        names.add("John");
        names.add("Sarah");
        names.add("Ying");
        names.add("Emmanuel");
        names.add("Akuna");
        names.add("Walter");
        names.add("Jessie");
        names.add("Tuco");
        names.add("Walter");
        names.add("Jared");
        names.add("Jessica");
        names.add("Chris");
        names.add("Bob");
        names.add("Gus");
        names.add("Mike");
        names.add("Laura");
        names.add("Bill");
        names.add("Arthur");
        names.add("Adam");
        names.add("Alex");
        names.add("Chad");
        names.add("Daniel");
        names.add("Emma");
        names.add("Ella");
        names.add("Switch");
        names.add("Justin");
        names.add("jgjhhjg");
    }
    
    private void readSurnames(){
        surnames.add("Pellizzari");
        surnames.add("Vargas");
        surnames.add("Salamanca");
        surnames.add("Solair");
        surnames.add("Raynold");
        surnames.add("Smith");
        surnames.add("Bonifaz");
        surnames.add("Evans");
        surnames.add("Owens");
        surnames.add("Xiong");
        surnames.add("Zimbambue");
        surnames.add("Matata");
        surnames.add("Ronaldo");
        surnames.add("Graham");
        surnames.add("Brent");
        surnames.add("Kent");
        surnames.add("Einstein");
        surnames.add("White");
        surnames.add("Pinkman");
        surnames.add("Leto");
        surnames.add("Simpson");
        surnames.add("Martin");
        surnames.add("Gates");
        surnames.add("Cooper");
        surnames.add("Rubinstein");


    }
    
    private String randomStudentName(){
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        return names.get(index);
    }
    
    private String randomStudentSurname(){
        Random rand = new Random();
        return surnames.get(rand.nextInt(surnames.size()));
    }
    
   
}
