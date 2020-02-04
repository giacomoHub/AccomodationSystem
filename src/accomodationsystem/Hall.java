package accomodationsystem;
import java.util.ArrayList;
public class Hall {

        /* ATTRIBUTES  */
	private String name;
	private Address address;
	private Telephone telephone;
	private ArrayList<Room> rooms;
        
        /* CONSTRUCTOR */
	public Hall(String name, Address address, Telephone telephone, Room room) {
            this.name = name;
            this.address = address;
            this.telephone = telephone;
            rooms.add(room);
	}

        public void addRoom(Room room){
            rooms.add(room);
        }
	public ArrayList<Room> getRooms() {
		return rooms;
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
