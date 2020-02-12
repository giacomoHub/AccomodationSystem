package accomodationsystem;

import accomodationsystem.Lease;
import accomodationsystem.Address;

public class Room {

	private int roomNumber;
	private float monthlyRentRate;
        private boolean roomStatus; //occupied or unoccupied
	private int roomCleanliness;
	private Lease lease;

        
	public Room(int roomNumber, boolean roomStatus, float monthlyRentRate, int roomCleanliness) {
            this.roomNumber = roomNumber;
            this.roomStatus = roomStatus;
            this.monthlyRentRate = monthlyRentRate;
            this.roomCleanliness = roomCleanliness;
            
	}

	public void setMontlyRentRate(int monthly) {
            this.monthlyRentRate = monthly;
	}

	public void setRoomCleanliness(int roomCleanliness) {
            this.roomCleanliness = roomCleanliness;
	}

	public boolean isOccupied() {
		return roomStatus;
	}

	public float getMonthlyRentRate() {
		return monthlyRentRate;
	}

	public String getRoomCleanliness() {
            if (roomCleanliness == 1) {
                
                return "Clean";
                
            } else if (roomCleanliness == 2) {
                
                return "Dirty";
                
            } else return null;
	}
        
        public Lease getLease() {
            return lease;
	}

	public void setLease(Lease lease) {
            this.lease = lease;
            this.roomStatus = true;
	}

	public void deleteLease() {
            this.lease = null;
            this.roomStatus = false;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

    @Override
    public String toString() {
        return "\n------------------------- ROOM START -----------------------------------" +
                "\nRoom No:" + getRoomNumber() + "\nMothly Rent: " + getMonthlyRentRate() + "\nRoom Cleaniness: " + getRoomCleanliness() +"\nRoom Lease: " + getLease() +
                "\n------------------------- ROOM FINISH --------------------------------\n";
    }
        
        
}
