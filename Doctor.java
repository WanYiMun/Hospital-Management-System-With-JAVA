import java.util.*;

public class Doctor {
	private String doc_id;
	private String doc_name;
	private String doc_specialist;
	private String doc_workTime;
	private String doc_qualification;
	private int room_number;
	Scanner input = new Scanner(System.in);
	
	public Doctor() {
		super();
	}
	
	public Doctor(String doc_id, String doc_name,
			String doc_specialist, String doc_workTime,
			String doc_qualification , int room_number) {
		this.doc_id = doc_id;
		this.doc_name=doc_name;
		this.doc_specialist = doc_specialist;
		this.doc_workTime=doc_workTime;
		this.doc_qualification=doc_qualification;
		this.room_number = room_number;
	}
	
	// a. Display doctor details
	public String showDoctorInfo() {
		return (doc_id + "\t"+ doc_name + "\t" + doc_specialist + "\t" +  doc_workTime + "\t" + doc_qualification + "\t" + room_number) ;
	}
	
	
	//b. Edit Doctor 
	public String getdoctorid() {
		return doc_id;
	}
	
//	public String getdoctorname() {
//		return doc_name;
//	}
//	
//	public String getdocspecialist() {
//		return doc_specialist;
//		
//	}
//	
//	public String getdocworkTime() {
//		return doc_workTime;
//	}
//	
//	public String getdocqualification() {
//		return doc_qualification;
//	}
//	
//	public int getroomnumber() {
//		return room_number;
//	}
	public void setdoctorID(String doc_id) {
		
		this.doc_id = doc_id;
		checkID(doc_id);
		
		while (checkID(doc_id) == false) {
			System.out.println("Invalid id. Please Enter again. Eg:004");
			System.out.print("Enter id : ");
			this.doc_id = input.nextLine();
			checkID(doc_id);
		}
	}
	
	public void setdoctorName(String doc_name) {
		
		if (doc_name.length() < 20) {
			int doc_name_length = 20 - doc_name.length();
			for (int i = 0 ; i <=doc_name_length ; i++ ) {
				doc_name += (" ");
			}
		}
		this.doc_name = doc_name;
	}
	
	public void setdoctorspecialist(String doc_specialist) {
		this.doc_specialist = doc_specialist;
	}

	public void setdoctorworkTime(String doc_workTime) {
		this.doc_workTime=doc_workTime;
	}
	
	public void setqualification(String doc_qualification) {
		this.doc_qualification=doc_qualification;
	}
	
	public void setroom_number (int room_number) {
		this.room_number = room_number;
	}
	
	
	// c. Add doctor  
	public void newDoctor() {
		
		System.out.print("Enter id : ");
		this.doc_id = input.nextLine();
		checkID(doc_id);
		
		while (checkID(doc_id) == false) {
			System.out.println("Invalid id. Please Enter again. Eg:004");
			System.out.print("Enter id : ");
			this.doc_id = input.nextLine();
			checkID(doc_id);
		};
		
		System.out.print("Enter doctor name :");
		this.doc_name = input.nextLine();
		if (doc_name.length() < 20 ){
			int doc_name_length = 20 - doc_name.length();
			for (int i = 0 ; i <doc_name_length ; i++ ) {
				doc_name += (" ");
			}
		}
		
		System.out.print("Enter doctor specialist :");
		this.doc_specialist = input.nextLine();
		if (doc_specialist.length() < 10){
			int doc_specialist_length = 10 - doc_specialist.length();
			for (int i = 0 ; i <doc_specialist_length ; i++ ) {
				doc_specialist += (" ");
			}
		}
		
		System.out.print("Enter doctor work Time :");
		this.doc_workTime = input.nextLine();
		
		System.out.print("Enter doctor qualification :");
		this.doc_qualification = input.nextLine();
		if (doc_qualification.length() < 10){
			int doc_qualification_length = 10 - doc_qualification.length();
			for (int i = 0 ; i < doc_qualification_length ; i++ ) {
				doc_qualification += (" ");
			}
		}
		
		System.out.print("Enter doctor room number :");
		this.room_number = input.nextInt();
	}
	
	public boolean checkID(String doc_id) {
		// TODO Auto-generated method stub
		if (doc_id.length() != 3) {
			return false;
		}
		else if (!(Character.isDigit((doc_id.charAt(0)))) || !(Character.isDigit((doc_id.charAt(1))))||
				!(Character.isDigit((doc_id.charAt(2)))))
			return false;
		else
			return true;
	
	}
	
	
}
