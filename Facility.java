import java.util.*;

public class Facility {
	private String facility;
	Scanner input = new Scanner(System.in);
	
	public Facility() {
		super();
	}
	public Facility(String facility) {
		this.facility = facility;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	public void newFacility() {
		// prompts user to enter facility.
	
		System.out.print("Enter facility: ");
		this.facility = input.nextLine();
	}
	
	public String showFacility() {
		return("\t [" + facility + "]");
	}
}