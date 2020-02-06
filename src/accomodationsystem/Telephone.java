package accomodationsystem;
public class Telephone {

	private String countryCode;
	private String areaCode;
	private String telephoneNumber;

	public Telephone(int countryCode, int areaCode, int telephoneNumber) {

	}

	public String getCountryCode() {
		return null;
	}

	public String getAreaCode() {
		return null;
	}

	public String getTelephoneNumber() {
		return null;
	}

    @Override
    public String toString() {
        return getCountryCode() + " " + getAreaCode() + " " + getTelephoneNumber();
    }
        
        
}
