/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

/**
 *
 * @author jitojar
 */
public class ManagerTable {
    
    private String hallName;
    private String HallNumber;
    private int roomNumber;
    private String leaseNumber;
    private String studentNumber;
    private String studentName;
    private String occupancyStatus;
    private String cleanliness;
    
    
    

    public String getHallName() {
        return hallName;
    }

    public String getHallNumber() {
        return HallNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getLeaseNumber() {
        return leaseNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    
    public String getStudentName(){
        return studentName;
    }

    public String getOccupancyStatus() {
        return occupancyStatus;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setHallNumber(String HallNumber) {
        this.HallNumber = HallNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }
    
    
    
}
