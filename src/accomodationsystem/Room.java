package accomodationsystem;

import accomodationsystem.Lease;
import accomodationsystem.Address;

public class Room {

	private int roomNumber;
	private float monthlyRentRate;
	private int roomCleanliness;
	private Lease lease;
	private Address address;

        
	public Room(int roomNumber, boolean roomStatus, float monthlyRentRate, int roomCleanliness, Lease lease) {
            this.roomNumber = roomNumber;
            this.monthlyRentRate = monthlyRentRate;
            this.roomCleanliness = roomCleanliness;
            this.lease = lease;
	}

	public void setMontlyRentRate(int monthly) {
            this.monthlyRentRate = monthly;
	}

	public void setRoomCleanliness(int roomCleanliness) {
            this.roomCleanliness = roomCleanliness;
	}

	public boolean isOccupied() {
		return true;
	}

	public float getMonthlyRentRate() {
		return monthlyRentRate;
	}

	public String getRoomCleanliness() {
		return null;
	}

	public void setLease(Lease lease) {

	}

	public void deleteLease() {

	}

	public int getRoomNumber() {
		return roomNumber;
	}

}
