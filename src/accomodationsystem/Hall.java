package accomodationsystem;
import java.util.ArrayList;
public class Hall {

        /* ATTRIBUTES  */
	private String name;
	private Address address;
	private Telephone telephoneNumber;
	private ArrayList<Room> rooms;
	private Telephone telephone;
        
        /* CONSTRUCTOR */
	public void Hall(String name, Address address, Telephone telephone) {
            this.name = name;
            this.address = address;
            this.telephoneNumber = telephone;
	}

	public ArrayList<Room> getRooms() {
		return null;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfRooms() {
		return rooms.size();
	}

	public Address getAddress() {
		return address;
	}

	public Telephone getTelephone() {
		return telephone; // remeber to look at this
	}

	public ArrayList<Room> getAvailableRooms() {
		return null;
	}

}
