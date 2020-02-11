package accomodationsystem;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;


public class Hall {

        /* ATTRIBUTES  */
	private SimpleStringProperty hallName;
	private static Address address;
	private Telephone telephone;
	private ArrayList<Room> rooms;
        
        /* CONSTRUCTOR */
	public Hall(String name, Address address, Telephone telephone) {
            rooms = new ArrayList<>(); 
            this.hallName
                    = new SimpleStringProperty(name);
            this.address = address;
            this.telephone = telephone;
            
	}

        public void addRoom(Room room){
            rooms.add(room);
        }
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public String getName() {
		return hallName.get();
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

    @Override
    public String toString() {
        return "------------------------- HALL START -----------------------------------" + 
                "\nHall Name: " + getName() + "\n" + getAddress() + getTelephone() + getRooms() +
                "\n------------------------- HALL FINISH -----------------------------------\n";
    }

}
