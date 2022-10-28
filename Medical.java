import java.util.*;

public class Medical {
	private String medical_name ;
	private String medical_manufacturer;
	private String medical_expiryDate;
	private int medical_cost;
	private int medical_count;
	
	Scanner input = new Scanner(System.in);
	
	public Medical() {
		super();
	}
	
	public Medical(String medical_name, String medical_manufacturer,String medical_expiryDate, int medical_cost, int medical_count) {
		this.medical_name = medical_name;
		this.medical_manufacturer = medical_manufacturer;
		this.medical_expiryDate = medical_expiryDate;
		this.medical_cost = medical_cost;
		this.medical_count = medical_count;
	}
	
	// Display medical details
	public String findMedical() {
		return (medical_name + "\t"+ medical_manufacturer + "\t" + medical_expiryDate + "\t" +  medical_cost + "\t" + medical_count) ;
	}
	
	
	// Edit medical
	public String getmedical_name() {
		return medical_name;
	}
	
	
	public void setmedical_name(String medical_name) {
		if (medical_name.length() < 23){
			int medical_name_length = 23 - medical_name.length();
			for (int i = 0 ; i <=medical_name_length ; i++ ) {
				medical_name += (" ");
			}
		}
		this.medical_name = medical_name;
	}
	
	public void setmedicalmanufacturer(String medical_manufacturer) {
		this.medical_manufacturer = medical_manufacturer;
	}
	
	public void setmedicalExpiryDate(String medical_expiryDate) {
		this.medical_expiryDate = medical_expiryDate;
	}

	public void setmedicalcost(int medical_cost) {
		this.medical_cost = medical_cost;
	}
	
	public void setmedicalcount(int medical_count) {
		this.medical_count = medical_count ;
	}
	
	
	//  Add medical
	public void newmedical() {
		
		System.out.print("Enter medical name: ");
		this.medical_name = input.nextLine();
		if (medical_name.length() < 10){
			int medical_name_length = 10 - medical_name.length();
			for (int i = 0 ; i <medical_name_length ; i++ ) {
				medical_name += (" ");
			}
		}
		
		System.out.print("Enter medical manufacturer :");
		this.medical_manufacturer = input.nextLine();
		if (medical_manufacturer.length() < 20){
			int medical_manufacturer_length = 20 - medical_manufacturer.length();
		for (int i = 0 ; i < medical_manufacturer_length ; i++ ) {
			medical_manufacturer += (" ");
		}
	}
		
		System.out.print("Enter medical expiry date :");
		this.medical_expiryDate = input.nextLine();
		
		System.out.print("Enter medical cost :");
		this.medical_cost = input.nextInt();
		
		System.out.print("Enter medical count :");
		this.medical_count = input.nextInt();
		
	}
	

}