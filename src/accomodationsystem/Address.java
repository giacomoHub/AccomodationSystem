package accomodationsystem;
public class Address {

	private String streetName;
	private String buildingName;
	private int houseNumber_floorNumber;
	private String postcode;
	private String city;
	private String county;
	private String country;
        
        
	public Address(String streetName, String buildingName, int houseFloorNumber, String postcode, String city, String county, String country) {
            this.streetName = streetName;
            this.buildingName = buildingName;
            this.houseNumber_floorNumber = houseFloorNumber;
            this.postcode = postcode;
            this.city = city;
            this.county = county;
            this.country = country;
	}

	public void setStreeName(String streetName) {

	}

	public String getStreetName() {
		return streetName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public int getHouseFloorNumber() {
		return houseNumber_floorNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getCountry() {
		return country;
	}

    @Override
    public String toString() {
    return  "------------------------- ADDRESS START -----------------------------------" 
            + "\nStreet: " + getStreetName() + "\nBuilding Name: " + getBuildingName() + "\nFloor/House No: " + getHouseFloorNumber() + "\nPostcode: " + getPostcode() + "\nCity: " + getCity() 
            + "\nCounty: " + getCounty() + "\nCountry: " + getCountry() + 
            "\n------------------------- ADDRESS FINISH --------------------------------\n";
    }
        
        

}
