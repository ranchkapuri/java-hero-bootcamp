
public class Players {
	
	String firstName;
	String lastName;
	
	
	public Players(String firstName, String lastName) {
		
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public String getLastName() {
		
		return lastName;
	}
	

	@Override
	public String toString() {
		return "Players [fistName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
