import java.util.*;

public class Staff {
	private String staff_id;
	private String staff_name;
	private String staff_designation;
	private String staff_sex;
	private int staff_salary;
	Scanner input = new Scanner(System.in);
	
	public Staff() {
		super();
	}
	
	public Staff(String staff_id, String staff_name,String staff_designation, String staff_sex, int staff_salary) {
		this.staff_id = staff_id;
		this.staff_name=staff_name;
		this.staff_designation = staff_designation;
		this.staff_sex = staff_sex;
		this.staff_salary = staff_salary;
	}
	
	// Display staff details
	public String showStaffInfo() {
		return (staff_id + "\t"+ staff_name + "\t" + staff_designation + "\t" +  staff_sex + "\t" + staff_salary) ;
	}
	
	
	// Edit Staff
	public String getstaffid() {
		return staff_id;
	}
	
	
	public void setstaffID(String staff_id) {
		
		this.staff_id = staff_id;
		checkID(staff_id);
		
		while (checkID(staff_id) == false) {
			System.out.println("Invalid id. Please Enter again. Eg:004");
			System.out.print("Enter id : ");
			this.staff_id = input.nextLine();
			checkID(staff_id);
		}
	}
	
	public void setstaffName(String staff_name) {
		if (staff_name.length() < 23){
			int staff_name_length = 23 - staff_name.length();
			for (int i = 0 ; i <= staff_name_length ; i++ ) {
				staff_name += (" ");
			}
		}
		this.staff_name = staff_name;
	}
	
	public void setstaffDesignation(String staff_designation) {
		if (staff_designation.length() < 25){
			int staff_designation_length = 25 - staff_designation.length();
			for (int i = 0 ; i <= staff_designation_length ; i++ ) {
				staff_designation+= (" ");
			}
		}
		this.staff_designation = staff_designation;
	}

	public void setstaffSex(String staff_sex) {
		this.staff_sex = staff_sex;
	}
	
	public void setstaffSalary(int staff_salary) {
		this.staff_salary = staff_salary;
	}
	
	
	//  Add Staff
	public void newStaff() {
		
		System.out.print("Enter id:");
		this.staff_id = input.nextLine();
		checkID(staff_id);
		
		while (checkID(staff_id) == false) {
			System.out.println("Invalid id. Please Enter again. Eg:004");
			System.out.print("Enter id : ");
			this.staff_id = input.nextLine();
			checkID(staff_id);
		};
		
		System.out.print("Enter staff name :");
		this.staff_name = input.nextLine();
		if (staff_name.length() < 15){
			int staff_name_length = 15 - staff_name.length();
			for (int i = 0 ; i < staff_name_length ; i++ ) {
				staff_name += (" ");
			}
		}
		
		System.out.print("Enter staff designation :");
		this.staff_designation = input.nextLine();
		if (staff_designation.length() < 25){
			int staff_designation_length = 25 - staff_designation.length();
			for (int i = 0 ; i < staff_designation_length ; i++ ) {
				staff_designation += (" ");
			}
		}
	
		
		
		System.out.print("Enter staff sex :");
		this.staff_sex = input.nextLine();
		
		System.out.print("Enter staff salary :");
		this.staff_salary = input.nextInt();
	}
		
	
	
	public boolean checkID(String staff_id) {
		// TODO Auto-generated method stub
		if (staff_id.length() != 3) {
			return false;
		}
		else if (!(Character.isDigit((staff_id.charAt(0)))) || !(Character.isDigit((staff_id.charAt(1))))||
				!(Character.isDigit((staff_id.charAt(2)))))
			return false;
		else
			return true;
	
	}
	
}
