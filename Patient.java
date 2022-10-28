import java.util.*;

public class Patient {
	private String patient_id;
	private String patient_name;
	private String patient_disease;
	private String patient_sex;
	private String patient_admitStatus;
	private int patient_age;
	
	Scanner input = new Scanner(System.in);
	
	public Patient() {
		super();
	}
	
	public Patient(String patient_id, String patient_name, String patient_disease, String patient_sex, String patient_admitStatus, int patient_age) {
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_disease = patient_disease;
		this.patient_sex = patient_sex;
		this.patient_admitStatus = patient_admitStatus;
		this.patient_age = patient_age;
	}
	
	//Display patient details
	public String showPatientInfo() {
		return( patient_id + "\t" + patient_name + "\t" + patient_disease + "\t" + patient_sex + "\t" + patient_admitStatus + "\t" + patient_age);				
	}
	
	//edit patient
	public String getpatientid() {
		return patient_id;
	}
	
	public void setpatientID(String patient_id) {
		this.patient_id = patient_id;
		checkID(patient_id);
		while(checkID(patient_id) == false) {
			System.out.println("Invalid id. Please Enter again. Eg:004");
			System.out.println("Enter id: ");
			this.patient_id = input.nextLine();
			checkID(patient_id);
		}
	}
	
	public void setpatientName(String patient_name) {
		if (patient_name.length() < 23){
			int patient_name_length = 23 - patient_name.length();
			for (int i = 0 ; i <= patient_name_length ; i++ ) {
				patient_name += (" ");
			}
		}
		this.patient_name = patient_name;
	}
	
	
	public void setpatientDisease(String patient_disease) {
		this.patient_disease = patient_disease;
	}
	
	public void setpatientSex(String patient_sex) {
		this.patient_sex = patient_sex;
	}
	
	public void setpatientadmitStatus(String patient_admitStatus) {
		this.patient_admitStatus = patient_admitStatus;
	}
	
	public void setpatientAge(int patient_age) {
		this.patient_age = patient_age;
	}
	//Add patient
	public void newPatient() {
		System.out.print("Enter id: ");
		this.patient_id = input.nextLine();
		checkID(patient_id);
		
		while(checkID(patient_id) == false) {
			System.out.println("Invalid id.Please Enter again. Eg:001");
			System.out.print("Enter id: ");
			this.patient_id = input.nextLine();
			checkID(patient_id);
		};
		
		System.out.print("Enter patient name: ");
		this.patient_name = input.nextLine();
		if (patient_name.length() < 10){
			int doc_specialist_length = 10 - patient_name.length();
			for (int i = 0 ; i <doc_specialist_length ; i++ ) {
				patient_name += (" ");
			}
		}
		
		System.out.print("Enter patient disease: ");
		this.patient_disease = input.nextLine();
		if (patient_disease.length() < 10){
			int patient_disease_length = 10 - patient_disease.length();
			for (int i = 0 ; i < patient_disease_length ; i++ ) {
				patient_disease += (" ");
			}
		}
		
		System.out.print("Enter patient sex: ");
		this.patient_sex = input.nextLine();
		
		System.out.print("Enter patient admit status: ");
		this.patient_admitStatus = input.nextLine();
		
		System.out.print("Enter patient age: ");
		this.patient_age = input.nextInt();
	}
	
	public boolean checkID(String patient_id) {
		if(patient_id.length() != 3) {
			return false;
		}
		else if (!(Character.isDigit((patient_id.charAt(0))))|| !(Character.isDigit((patient_id.charAt(1)))) || !(Character.isDigit((patient_id.charAt(2)))))
				return false;
		else
			return true;
	}

	


}