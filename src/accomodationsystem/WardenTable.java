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
public class WardenTable {
    
// Class Attributes
    private final String hallName;
    private final Integer hallNumber;
    private final Integer roomNumber;
    private final String roomStatus;
    private final String roomCleanliness;
//    private final Integer leaseNumber;
//    private final String studentName;


    public WardenTable(Hall hallDetails, Room roomDetails){
    
        hallName = hallDetails.getHallName();
        hallNumber = 10;
        roomNumber = roomDetails.getRoomNumber();
        roomStatus = roomDetails.getRoomStatus();
        roomCleanliness = roomDetails.getRoomCleanliness();
        //leaseNumber = leaseDetails.getLeaseNumber();
//        studentName = leaseDetails.getStudent().getFullName();
    }
    
    public String getHallName() {
        
        return hallName;
    }

    public Integer getHallNumber() {
        return hallNumber;
    }
    
    /* NOTE THIS IS CURRENTLY RETURNING AN INT*/
    public Integer getRoomNumber() {
        
        return roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getCleanliness() {
        return roomCleanliness;
    }

//    public Integer getLeaseNumber() {
//        return leaseNumber;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
    
    
    
    
    
    
}
