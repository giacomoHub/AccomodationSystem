package accomodationsystem;
public class Telephone {

	private String countryCode;
	private String areaCode;
	private String telephoneNumber;

	public Telephone(int countryCode, int areaCode, int telephoneNumber) {

	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

    @Override
    public String toString() {
        return "------------------------- TELEPHONE START -----------------------------------" +
                "\nCountry Code: " + getCountryCode() + "\nArea Code: " + getAreaCode() + "\nTel No: " + getTelephoneNumber() +
                "\n------------------------- TELEPHONE FINISH -------------------------------\n";
    }
        
        
}
