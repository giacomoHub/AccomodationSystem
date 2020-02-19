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
    private String hallName;
    private int hallNumber;
    private int roomNumber;
    private String roomStatus;
    private String roomCleanliness;
    
    public String getHallName() {
        return hallName;
    }
    
     public int getHallNumber() {
        return hallNumber;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getRoomCleanliness() {
        return roomCleanliness;
    }
    
    
    
     public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    
     public void setRoomCleanliness(String roomCleanliness) {
        this.roomCleanliness = roomCleanliness;
    }

}
