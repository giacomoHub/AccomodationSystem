package accomodationsystem;

import accomodationsystem.Lease;
import accomodationsystem.Address;

public class Room {

	private int roomNumber;

	private float montlyRentRate;

	private int roomCleanliness;

	private Lease lease;

	private Address address;

	public Room(int roomNumber, boolean roomStatus, float monthlyRentRate, int roomCleanliness) {

	}

	public void setMontlyRentRate(int monthly) {

	}

	public void setRoomCleanliness(int roomCleanliness) {

	}

	public boolean isOccupied() {
		return false;
	}

	public float getMonthlyRentRate() {
		return 0;
	}

	public String getRoomCleanliness() {
		return null;
	}

	public void setLease(Lease lease) {

	}

	public void deleteLease() {

	}

	public int getRoomNumber() {
		return 0;
	}

}
