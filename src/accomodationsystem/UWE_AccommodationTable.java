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
public class UWE_AccommodationTable {
    
    // Class Attributes
    private String HallName;
    private String HallNumber;
    private ArrayList<Room> room;
    
    
    private int roomNumber;
    private String roomStatus;
    private String roomCleanliness;
    private int leaseNumber;
    private String studentName;


    public UWE_AccommodationTable(Hall hallDetails, int i){
    
        HallName = hallDetails.getHallName();
        HallNumber = null;
        room = hallDetails.getRooms();;
    }
    
    public String getHallName() {
        
        return HallName;
    }

    public String getHallNumber() {
        return HallNumber;
    }
    
    /* NOTE THIS IS CURRENTLY RETURNING AN INT*/
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getCleanliness() {
        return roomCleanliness;
    }
//
//    public String getLease() {
//        return lease;
//    }
//
//    public String getStudent() {
//        return student;
//    }
    
    
    
    
    
    
}