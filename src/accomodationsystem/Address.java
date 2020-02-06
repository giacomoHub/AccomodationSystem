package accomodationsystem;
public class Address {

	private String streetName;
	private String buildingName;
	private int houseNumber_floorNumber;
	private String postcode;
	private String city;
	private String county;
	private String country;
        
        
	public Address(String streetName, String buildingName, int houseNumber, String postcode, String city, String county, String country) {
            this.streetName = streetName;
            this.buildingName = buildingName;
            this.houseNumber_floorNumber = houseNumber;
            this.postcode = postcode;
            this.city = city;
            this.county = county;
            this.country = country;
	}

	public void setStreeName(String streetName) {

	}

	public String getStreetName() {
		return null;
	}

	public String getBuildingName() {
		return null;
	}

	public int getHouseNumber_floorNumber() {
		return 0;
	}

	public String getPostcode() {
		return null;
	}

	public String getCity() {
		return null;
	}

	public String getCounty() {
		return null;
	}

	public String getCountry() {
		return null;
	}

    @Override
    public String toString() {
        return getStreetName() + " " + getBuildingName() + " " + getHouseNumber_floorNumber() + " " + getPostcode() + " " + getCity() + " " +
                getCounty() + " " + getCountry();
    }
        
        

}
