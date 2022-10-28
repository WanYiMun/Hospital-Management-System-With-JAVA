import java.text.SimpleDateFormat;
import java.util.*;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import javafx.application.Application;

import java.io.*;

public class HospitalManagement{
	
	//Use for transfering data from this class to BarChartTotal.java <8th Options>
	static int GlobalDoctorNumber = 0;
	static int GlobalFacilityNumber=0;
	static int GlobalLabNumber=0;
	static int GlobalMedicalNumber=0;
	static int GlobalPatientNumber=0;
	static int GlobalStaffNumber=0;
	private static Scanner input;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		input = new Scanner(System.in);
		Boolean main_status = false;
	
//Array	
				Doctor[] doctors = new Doctor[25];
				Facility[] facilities = new Facility[20];
				Lab[] labs = new Lab[20];
				Patient[] patients = new Patient[100];
				Medical[] medicals = new Medical[100];
				Staff[] staffs = new Staff[100];
				
		//Doctor
				
				doctors[0] = new Doctor("001", "Dr.Wan Yi Mun      "," Cardio   ","0900-1700","phd           ",1700);
				doctors[1] = new Doctor("002","Dr.Pang Tse Ki      "," Lung     ","0900-1700","phd           ",1701);
				doctors[2] = new Doctor("003","Dr.Kuit Ying Qian   "," Surgery  ","0900-1700","phd           ",1702);
				doctors[3] = new Doctor("004","Dr.BiBi lau         "," Surgery  ","0900-1700","phd           ",1703);
				doctors[4] = new Doctor("005","Dr.Alexi xixi       "," Surgery  ","0900-1700","phd           ",1704);
				
		//Facility
				
				facilities[0] = new Facility("Ambulatory surgical centers");
				facilities[1] = new Facility("Birth centers");
				facilities[2] = new Facility("Blood banks");
				facilities[3] = new Facility("Clinics and medical offices");
				facilities[4] = new Facility("Dialysis Centers");

		//Lab			
				labs[0] = new Lab("LAB01",782); 
				labs[1] = new Lab("LAB02",34);
				labs[2] = new Lab("LAB03",59);
				labs[3] = new Lab("LAB04",239);
				labs[4] = new Lab("LAB05",56);
				
		//Patient
				patients[0] = new Patient("001", "Wan Yi Mun","Heart Attack", "Female","Under Observation    ", 40);
				patients[1] = new Patient("002", "Kuit Ying Qian", "Liver Cirrhosis", "Female", "Inpatient  ", 25);
				patients[2] = new Patient("003", "Pang Tse Ki", "Gastritis", "Female", "Under Observation   ", 30);
				patients[3] = new Patient("004", "Alex Tan", "Tuberculosis", "Male","Inpatient              ", 50);
				patients[4] = new Patient("005", "Daniel Tan", "Pancreatitis", "Male", "Under Observation   ", 45);
				

		//Medical
				medicals[0] = new Medical("Alendronate","Hoe Pharmaceuticals    ","5/6/2030",25,1000);
				medicals[1] = new Medical("Bosentan"  ,"Noripharma             ","9/8/2029",20,500);
				medicals[2] = new Medical("Cefaclor"  ,"GoodScience            ","3/4/2030",30,300);
				medicals[3] = new Medical("Clobazam"  ,"Duopharma              ","10/2/2035",50,650);
				medicals[4] = new Medical("Dapsone"   ,"Pharmex                ", "7/3/2040",40,430);
				
				
		//Staff
				staffs[0]  = new Staff("001", "Wan Yi Mun     ", "Dietician               ", "Female", 3000);
				staffs[1]  = new Staff("002", "Kuit Ying Qian", "Occupational therapist  ", "Female",  3500);
				staffs[2]  = new Staff("003", "Pang Tse Ki   ", "Pharmacist              ", "Female", 3000);
				staffs[3]  = new Staff("004", "John Lim      ", "Anesthesiologist        ", "Male", 4000);
				staffs[4]  = new Staff("005", "Eason Chew    ", "Human resources manager ", "Male", 5000);
		
			
		
		
		
		do {
			String maintimeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
			System.out.println("------------------------------------------------------------------------------------------------------- ");
			System.out.println("                            Welcome to Hospital Mangement System        DateTime : " + maintimeStamp);
			System.out.println("------------------------------------------------------------------------------------------------------- ");
			System.out.println(" 1.  Doctor  ");
			System.out.println(" 2.  Facility ");
			System.out.println(" 3.  Lab ");
			System.out.println(" 4.  Patient ");
			System.out.println(" 5.  Medical ");
			System.out.println(" 6.  Staff ");
			System.out.println(" 7.  Generate report on total number of each parts ");
			System.out.println(" 8.  Display bar chart on total number of each parts ");
			System.out.println(" 9.  Exit");
			System.out.println("------------------------------------------------------------------------------------------------------- ");
			
			Boolean check_option_main = false;
			int optionmain = 0;	
			do {
				try {
					System.out.print(" option : ");
					optionmain= Integer.parseInt(input.nextLine());
					check_option_main = true;
				}
				catch(NumberFormatException ex){
					System.out.println(" Invalid input , Please try again");
				}
				
			}while(check_option_main == false);
			
			
			while (!(optionmain >= 1 && optionmain <= 8)) {
				System.out.print(" option : ");
				optionmain= Integer.parseInt(input.nextLine());
			}
		      
			if (optionmain == 1) {
				Boolean doctor_status = false;
				do {
				// a. Display doctor details
				int total_doc = 0;
				System.out.println("------------------------------------------------------------------------------------------------------- ");
				System.out.println("  Doctor Information  ");
				System.out.println("------------------------------------------------------------------------------------------------------- ");
				System.out.println("   id \t Name \t\t\t Specialist \t Timing \tQualification \t Room No ");
				System.out.println("------------------------------------------------------------------------------------------------------- ");
				for (int i = 0 ; i < doctors.length ; i++ ) {
					if(doctors[i]!=null) {
						System.out.println(doctors[i].showDoctorInfo());
						total_doc += 1;
					}
				};
				System.out.println("\nTotal Doctor : " + total_doc+"           (A)dd      (E)dit     (P)rint   (D)elete   (S)earch  (B)ack  ");
				System.out.println("------------------------------------------------------------------------------------------------------- ");
				String doctor_option;
				System.out.print(" option : ");
				doctor_option = input.nextLine();
				doctor_option.toUpperCase();
				
				// b. Add doctor
				if(doctor_option.equalsIgnoreCase("A")) { 
					for (int i = 0 ; i < doctors.length ; i++ ) {
						if(doctors[i]==null) {
								Doctor temp = new Doctor();
								temp.newDoctor();
								doctors[i] = temp;
								break;
							}
						}
				}
				
				// c. Edit doctor
				else if (doctor_option.equalsIgnoreCase("E")) {
					
					boolean checkdoc_id = false;
					int selectdoctor = 0 ;
					
					do {
						System.out.print("Enter you ID : ");
						String doctorsearchID = input.nextLine();
					
						for (int i = 0 ; i < doctors.length ; i++ ) {						
							if(doctors[i]!=null) { //Check if the  doctor is empty
								String compareDoctor = doctors[i].getdoctorid();
								if (doctorsearchID.equalsIgnoreCase(compareDoctor)) {
									System.out.println(i);
									selectdoctor = i;
									checkdoc_id = true;
								}
							}
						}
					}while (!(checkdoc_id));
					
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("Select information you want to edit.");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("1. ID");
					System.out.println("2. Name");
					System.out.println("3. Specialist");
					System.out.println("4. Timing");
					System.out.println("5. Qualification");
					System.out.println("6. Room No\n");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					
					Boolean check_doctor_edit = false;
					int optiondoctor = 0;

					
					do {
						try {
							System.out.print("Enter option :  ");
							optiondoctor= Integer.parseInt(input.nextLine());
							check_doctor_edit = true;
						}
						catch(NumberFormatException ex){
							System.out.println(" Invalid input , Please try again");
						}
						
					}while(check_doctor_edit == false);
					
					
					while (!(optiondoctor >= 1 && optiondoctor <= 6)) {
						System.out.print("Enter option :  ");
						optiondoctor = Integer.parseInt(input.nextLine());
					}
					
					if (optiondoctor == 1) {
						String doctor_id;
						System.out.print("Enter id :");
						doctor_id = input.nextLine();
						doctors[selectdoctor].setdoctorID(doctor_id);
					}
					
					else if (optiondoctor == 2) {
						String doctor_name;
						System.out.print("Enter Name :");
						doctor_name = input.nextLine();
						doctors[selectdoctor].setdoctorName(doctor_name);
					}
					
					else if (optiondoctor == 3) {
						System.out.print("Enter doctor specialist :");
						String doctor_specialist = input.nextLine();
						doctors[selectdoctor].setdoctorspecialist(doctor_specialist);
					}
					
					else if(optiondoctor == 4) {
						System.out.print("Enter doctor work Time :");
						String doctor_workTime = input.nextLine();
						doctors[selectdoctor].setdoctorworkTime(doctor_workTime);
					}
					
					else if (optiondoctor == 5) {
						System.out.print("Enter doctor qualification :");
						String doctor_qualification = input.nextLine();
						doctors[selectdoctor].setqualification(doctor_qualification);
					}
					
					else {
						System.out.print("Enter doctor room number : ");
						int doctor_roomnumber = input.nextInt();
						doctors[selectdoctor].setroom_number(doctor_roomnumber);
					}
				}
				
				// d. Print Doctor
				else if (doctor_option.equalsIgnoreCase("P")) {
					String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
					String DoctorFilename = "Doctor" + timeStamp;
					
					File sourceFile = new File(DoctorFilename + ".txt");
					PrintWriter writeFile = new PrintWriter(sourceFile);

					writeFile.println("------------------------------------------------------------------------------------------------------- ");
					writeFile.println("   id \t Name \t\t\t Specialist \t Timing \tQualification \t Room No ");
					writeFile.println("------------------------------------------------------------------------------------------------------- ");
					for (int i = 0 ; i < doctors.length ; i++ ) {
						if(doctors[i]!=null) {
							writeFile.println(doctors[i].showDoctorInfo());
						}
					}
					writeFile.close();		
				}
				
				// e. Delete Doctor
				else if (doctor_option.equalsIgnoreCase("D")) {
					boolean check_del_doc_id = false;
					
					do {
						System.out.print("Enter you ID : ");
						String doctorsearchID = input.nextLine();
					
						for (int i = 0 ; i < doctors.length ; i++ ) {						
							if(doctors[i]!=null) { //Check if the  doctor is empty
								String compareDoctor = doctors[i].getdoctorid();
								if (doctorsearchID.equalsIgnoreCase(compareDoctor)) {
									for (int j = 0 ; j < doctors.length; j++) {
										if (j == i) 
											continue;
										else
											doctors[i] = doctors[j];
									}
									check_del_doc_id = true;
								}
							}
						}
					}while (!(check_del_doc_id));			
				}
				
				// f. Search Doctor
				else if (doctor_option.equalsIgnoreCase("S")) {
					boolean check_search_doc_id = false;
					boolean check_back_option  = false;
					
					do {
						System.out.print("Enter you ID : ");
						String doctorsearchID = input.nextLine();
					
						for (int i = 0 ; i < doctors.length ; i++ ) {						
							if(doctors[i]!=null) { //Check if the  doctor is empty
								String compareDoctor = doctors[i].getdoctorid();
								if (doctorsearchID.equalsIgnoreCase(compareDoctor)) {
									System.out.println("------------------------------------------------------------------------------------------------------- ");
									System.out.println(" Doctor search ID :" + compareDoctor);
									System.out.println("------------------------------------------------------------------------------------------------------- ");
									System.out.println("   id \t Name \t\t\t Specialist \t Timing \tQualification \t Room No ");
									System.out.println("------------------------------------------------------------------------------------------------------- ");
									System.out.println(doctors[i].showDoctorInfo());
									
									System.out.println("                                                                                    (B)ack              ");
									System.out.println("------------------------------------------------------------------------------------------------------- ");
									
									do {
										String doctor_back_option;
										System.out.print(" option : ");
										doctor_back_option = input.nextLine();
										doctor_back_option.toUpperCase();
										
										if (doctor_back_option.equalsIgnoreCase("B")){
											check_back_option = true;
										}
										
									}while (!(check_back_option));
									
									check_search_doc_id = true;
								}
							}
						}
					}while (!(check_search_doc_id));
					
				}
				
				// g. Back Main Menu 
				else if (doctor_option.equalsIgnoreCase("B")) {doctor_status = true;}
				else {
					System.out.print(" Invalid Input. ");
					doctor_status = false;}
				}while (doctor_status == false);
				
				
			}
			else if (optionmain == 2) {
				// a. Display Facility 
				Boolean facility_status = false;
				do {
					System.out.println("-------------------------------------------------------------");
					System.out.println("\t\t   Facility  ");
					System.out.println("-------------------------------------------------------------");
					int totalFacility = 0;
					
					for(int i=0; i<facilities.length; i++ ) {
						if(facilities[i] != null) {
							System.out.println(facilities[i].showFacility());
							totalFacility += 1;
						}
					}
					System.out.println("\nTotal Lab : " + totalFacility +"           (A)dd  (E)dit  (P)rint  (D)elete  (S)earch  (B)ack  ");
					System.out.println("----------------------------------------------------------------------------");
					
					String option;
					
					System.out.println("Option : ");
					option = input.nextLine();
					option = option.toUpperCase();
					
					// b. Add Facility 
					if(option.equalsIgnoreCase("A")){
						for (int i = 0 ; i < facilities.length ; i++ ) {
							if(facilities[i]==null) {
								Facility nFacility = new Facility();
								nFacility.newFacility();
								facilities[i] = nFacility;
								break;
							}
						}
					}
					
					// c. Edit Facility 
					else if(option.equalsIgnoreCase("E")) {
						boolean checkFacility = false;
						int facilityIndex = 0 ;
	
						do {
							System.out.print("Enter Facility Name : ");
							String searchFacility = input.nextLine();
						
								for (int i = 0 ; i < facilities.length ; i++ ) {						
									if(facilities[i]!= null) { 
										String compareFacility = facilities[i].getFacility();
										//System.out.println(compareFacility);
										if (searchFacility.equalsIgnoreCase(compareFacility)) {
											facilityIndex = i;
											checkFacility = true;
										}
									}
								}
								
						}while (!(checkFacility));
						
						String facilityName;
						System.out.print("Enter facility :");
						facilityName = input.nextLine();
						facilities[facilityIndex].setFacility(facilityName);
						}
					
					// d. Print Facility 
					else if(option.equalsIgnoreCase("P")) {
						String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
						String LabFileName = "Facility" + timeStamp;
						
						File sourceFile = new File(LabFileName + ".txt");
						PrintWriter writeFile = new PrintWriter(sourceFile);

						writeFile.println("-------------------------------------------------------------");
						writeFile.println("\t\t   Facility  ");
						writeFile.println("-------------------------------------------------------------");
						for (int i = 0 ; i < facilities.length ; i++ ) {
							if(facilities[i]!=null) {
								writeFile.println(facilities[i].showFacility());
							}
						}
						writeFile.close();
					}
					
					// e. Delete facility 
					else if(option.equalsIgnoreCase("D")) {
						boolean check_del_doc_id = false;
						
						do {
							System.out.print("Enter Facility : ");
							String searchFacility = input.nextLine();
						
							for (int i = 0 ; i < facilities.length ; i++ ) {						
								if(facilities[i]!=null) { 
									String compareFacility = facilities[i].getFacility();
									if (searchFacility.equalsIgnoreCase(compareFacility)) {
										for (int j = 0 ; j < facilities.length; j++) {
											if (j == i) 
												continue;
											else
												facilities[i] = facilities[j];
										}
										check_del_doc_id = true;
									}
								}
							}
						}while (!(check_del_doc_id));
					}
					// f. Search facility 
					else if(option.equalsIgnoreCase("S")) {
						boolean check_search_facility = false;
						boolean s_facility_status  = false;
						
						do {
							System.out.print("Enter facility : ");
							String searchFacility = input.nextLine();
						
							for (int i = 0 ; i < facilities.length ; i++ ) {						
								if(facilities[i]!=null) { 
									String compareFacility = facilities[i].getFacility();
									if (searchFacility.equalsIgnoreCase(compareFacility)) {
										System.out.println("-------------------------------------------------------------");
										System.out.println(" Facility search :" + compareFacility);
										System.out.println("-------------------------------------------------------------");
										System.out.println("\t\t   Facility  ");
										System.out.println("-------------------------------------------------------------");
										System.out.println(facilities[i]. showFacility());
										
										System.out.println("                                                   (B)ack    ");
										System.out.println("-------------------------------------------------------------");
										
										do {
											String facility_back_option;
											System.out.print("option : ");
											facility_back_option = input.nextLine();
											facility_back_option.toUpperCase();
											
											if (facility_back_option.equalsIgnoreCase("B")){
												s_facility_status = true;
											}
											
										}while (!(s_facility_status));
										check_search_facility = true;
									}
								}
							}
						}while (!(check_search_facility));
					}
					
					//g. Back to Main Menu 
					else if(option.equalsIgnoreCase("B")) {
						facility_status = true;
					}
					else {
						System.out.print(" Invalid Input. ");
						facility_status = false;}
				}while(facility_status == false);
				
			}
			else if (optionmain == 3) {
				// a. Display labs and costs
				Boolean lab_status = false;
				do {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("\t   Lab  \t\t   Cost");
					System.out.println("----------------------------------------------------------------------------");
					int totalLab = 0;
					
					for(int i=0; i<labs.length; i++ ) {
						if(labs[i] != null) {
							System.out.println(labs[i].labList());
							totalLab += 1;
						}
					}
					System.out.println("\nTotal Lab : " + totalLab+"           (A)dd  (E)dit  (P)rint  (D)elete  (S)earch  (B)ack  ");
					System.out.println("----------------------------------------------------------------------------");
					
					String optionLab;
					System.out.println("Option : ");
					optionLab = input.nextLine();
					optionLab = optionLab.toUpperCase();
					
					// b. Add new lab
					if(optionLab.equalsIgnoreCase("A")){
						for (int i = 0 ; i < labs.length ; i++ ) {
							if(labs[i]==null) {
								Lab nLab = new Lab();
								nLab.newLab();
								labs[i] = nLab;
								break;
							}
						}
					}
					
					// c. Edit lab
					else if(optionLab.equalsIgnoreCase("E")) {
						
						boolean checkLab = false;
						int labIndex = 0;
						
						do{
							System.out.print("Enter Lab Name : ");
							String searchLab = input.nextLine();
						
							for (int i = 0 ; i < labs.length ; i++ ) {						
								if(labs[i]!=null) { 
									String compareLab = labs[i].getLab();
									//System.out.println(compareLab);
									if (searchLab.equalsIgnoreCase(compareLab)) {
										labIndex = i;
										checkLab = true;
									}
								}
							}
						}while(!checkLab);
						
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("Select information you want to edit.");
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("1. Lab");
						System.out.println("2. Cost");
						System.out.println("----------------------------------------------------------------------------");
						Boolean check_lab_edit = false;
						int optionLabEdit = 0;
						
						do {
							try {
								System.out.print("Enter option :  ");
								optionLabEdit = Integer.parseInt(input.nextLine()); 
								check_lab_edit = true;
							}
							catch(NumberFormatException ex){
								System.out.println(" Invalid input , Please try again");
							}
							
						}while(check_lab_edit == false);
						
						
						if (optionLabEdit == 1) {
							String labName;
							System.out.print("Enter lab :");
							labName = input.nextLine();
							labs[labIndex].setLab(labName);
						}
						
						else if (optionLabEdit == 2) {
							int labCost;
							System.out.print("Enter cost :");
							labCost = input.nextInt();
							labs[labIndex].setCost(labCost);
						}
					}
					
					// d. Print Lab 
					else if(optionLab.equalsIgnoreCase("P")) {
						String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
						String LabFileName = "Lab" + timeStamp;
						
						File sourceFile = new File(LabFileName + ".txt");
						PrintWriter writeFile = new PrintWriter(sourceFile);

						writeFile.println("----------------------------------------------------------------------------");
						writeFile.println("\t\t   Lab  \t\t   Cost");
						writeFile.println("----------------------------------------------------------------------------");
						for (int i = 0 ; i < labs.length ; i++ ) {
							if(labs[i]!=null) {
								writeFile.println(labs[i].labList());
							}
						}
						writeFile.close();
					}
					// e. Delete Lab	
					else if(optionLab.equalsIgnoreCase("D")) {
						boolean check_del_doc_id = false;
						
						do {
							System.out.print("Enter lab : ");
							String searchLab = input.nextLine();
						
							for (int i = 0 ; i < labs.length ; i++ ) {						
								if(labs[i]!=null) { 
									String compareLab = labs[i].getLab();
									if (searchLab.equalsIgnoreCase(compareLab)) {
										for (int j = 0 ; j < labs.length; j++) {
											if (j == i) 
												continue;
											else
												labs[i] = labs[j];
										}
										check_del_doc_id = true;
									}
								}
							}
						}while (!(check_del_doc_id));	
					}
					
					// f. Search Lab 
					else if(optionLab.equalsIgnoreCase("S")) {
						boolean check_search_lab = false;
						boolean s_lab_status  = false;
						
						do {
							System.out.print("Enter lab : ");
							String searchLab = input.nextLine();
						
							for (int i = 0 ; i < labs.length ; i++ ) {						
								if(labs[i]!=null) { 
									String compareLab = labs[i].getLab();
									if (searchLab.equalsIgnoreCase(compareLab)) {
										System.out.println("----------------------------------------------------------------------------");
										System.out.println(" Lab search :" + compareLab);
										System.out.println("----------------------------------------------------------------------------");
										System.out.println("\t   Lab  \t\t   Cost");
										System.out.println("----------------------------------------------------------------------------");
										System.out.println(labs[i].labList());
										
										System.out.println("                                                        (B)ack              ");
										System.out.println("----------------------------------------------------------------------------");
										
										do {
											String lab_back_option;
											System.out.print("option : ");
											lab_back_option = input.nextLine();
											lab_back_option.toUpperCase();
											
											if (lab_back_option.equalsIgnoreCase("B")){
												s_lab_status = true;
											}
											
										}while (!(s_lab_status));
										check_search_lab = true;
									}
								}
							}
						}while (!(check_search_lab));
					}
					
					// g. Back to Main Menu 
					else if(optionLab.equalsIgnoreCase("B")) {
						lab_status = true;
					}
					else {
						System.out.print(" Invalid Input. ");
						lab_status = false;}
				}while(lab_status == false);
			}
			else if (optionmain == 4) {
				
				// a. Display patient details
				Boolean patient_status = false;
				do {
					int total_patient = 0;
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("  Patient Information  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("   id \t Name \t\t Disease \t Sex \tAdmit Status \t\tAge");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					for (int i = 0 ; i < patients.length ; i++ ) {
						if(patients[i]!=null) {
							System.out.println(patients[i].showPatientInfo());
							total_patient += 1;
						}
					};
					System.out.println("\nTotal Patient : " + total_patient +"           (A)dd      (E)dit     (P)rint   (D)elete   (S)earch  (B)ack  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					String patient_option;
					System.out.print(" option : ");
					patient_option = input.nextLine();
					patient_option.toUpperCase();
					
					// b. Add patient
					if(patient_option.equalsIgnoreCase("A")) { 
						for (int i = 0 ; i < patients.length ; i++ ) {
							if(patients[i]==null) {
								Patient temp = new Patient();
								temp.newPatient();
								patients[i] = temp;
								break;
								}
							}
					}
					
					// c. Edit patient
					else if (patient_option.equalsIgnoreCase("E")) {
						
						boolean checkpatient_id = false;
						int selectpatient = 0 ;
						
						do {
							System.out.print("Enter you ID : ");
							String patientsearchID = input.nextLine();
						
							for (int i = 0 ; i < patients.length ; i++ ) {						
								if(patients[i]!=null) { //Check if the  doctor is empty
									String comparePatient = patients[i].getpatientid();
									if (patientsearchID.equalsIgnoreCase(comparePatient)) {
										System.out.println(i);
										selectpatient = i;
										checkpatient_id = true;
									}
								}
							}
						}while (!(checkpatient_id));
						
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("Select information you want to edit.");
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("1. ID");
						System.out.println("2. Name");
						System.out.println("3. Disease");
						System.out.println("4. Sex");
						System.out.println("5. Admit Status");
						System.out.println("6. Age\n");
						System.out.println("------------------------------------------------------------------------------------------------------- ");			
						Boolean check_patient_edit = false;
						int optionpatient = 0;
						
						do {
							try {
								System.out.print("Enter option :  ");
								optionpatient= Integer.parseInt(input.nextLine());								check_patient_edit = true;
							}
							catch(NumberFormatException ex){
								System.out.println(" Invalid input , Please try again");
							}
							
						}while(check_patient_edit == false);
						
						while (!(optionpatient >= 1 && optionpatient <= 6)) {
							System.out.print("Enter option :  ");
							optionpatient = Integer.parseInt(input.nextLine());
						}
						
						if (optionpatient == 1) {
							String patient_id;
							System.out.print("Enter id :");
							patient_id = input.nextLine();
							patients[selectpatient].setpatientID(patient_id);
						}
						
						else if (optionpatient == 2) {
							String patient_name;
							System.out.print("Enter Name :");
							patient_name = input.nextLine();
							patients[selectpatient].setpatientName(patient_name);
						}
						
						else if (optionpatient == 3) {
							System.out.print("Enter patient disease :");
							String patient_disease = input.nextLine();
							patients[selectpatient].setpatientDisease(patient_disease);
						}
						
						else if(optionpatient == 4) {
							System.out.print("Enter patient sex :");
							String patient_sex = input.nextLine();
							patients[selectpatient].setpatientSex(patient_sex);
						}
						
						else if (optionpatient == 5) {
							System.out.print("Enter patient admit Status :");
							String patient_admitStatus = input.nextLine();
							patients[selectpatient].setpatientadmitStatus(patient_admitStatus);
						}
						
						else {
							System.out.print("Enter patient age : ");
							int patient_age = input.nextInt();
							patients[selectpatient].setpatientAge(patient_age);
						}
					}
					
					// d. Print patient 
					else if (patient_option.equalsIgnoreCase("P")) {
						String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
						String PatientFilename = "Patient" + timeStamp;
						
						File sourceFile = new File(PatientFilename + ".txt");
						PrintWriter writeFile = new PrintWriter(sourceFile);

						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						writeFile.println("   id \t Name \t\t\t Disease \t Sex \t Admit Status \t Age ");
						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						for (int i = 0 ; i < patients.length ; i++ ) {
							if(patients[i]!=null) {
								writeFile.println(patients[i].showPatientInfo());
							}
						}
						writeFile.close();		
					}
					
					// e. Delete patient 
					else if (patient_option.equalsIgnoreCase("D")) {
						
						boolean check_del_patient_id = false;
						
						do {
							System.out.print("Enter you ID : ");
							String patientsearchID = input.nextLine();
						
							for (int i = 0 ; i < patients.length ; i++ ) {						
								if(patients[i]!=null) { //Check if the  doctor is empty
									String comparePatient = patients[i].getpatientid();
									if (patientsearchID.equalsIgnoreCase(comparePatient)) {
										for (int j = 0 ; j < patients.length; j++) {
											if (j == i) 
												continue;
											else
												patients[i] = patients[j];
										}
										check_del_patient_id = true;
									}
								}
							}
						}while (!(check_del_patient_id));			
					}
					
					// f . Search Patient 
					else if (patient_option.equalsIgnoreCase("S")) {						
						boolean check_search_patient_id = false;
						boolean check_back_option  = false;
						
						do {
							System.out.print("Enter you ID : ");
							String patientsearchID = input.nextLine();
						
							for (int i = 0 ; i < patients.length ; i++ ) {						
								if(patients[i]!=null) { 
									String comparePatient = patients[i].getpatientid();
									if (patientsearchID.equalsIgnoreCase(comparePatient)) {
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(" Doctor search ID :" + comparePatient);
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println("   id \t Name \t\t\t Disease \t Sex \tAdmit Status \t Age ");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(patients[i].showPatientInfo());
										
										System.out.println("                                                                                    (B)ack              ");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										
										do {
											String patient_back_option;
											System.out.print(" option : ");
											patient_back_option = input.nextLine();
											patient_back_option.toUpperCase();
											
											if (patient_back_option.equalsIgnoreCase("B")){
												check_back_option = true;
											}
											
										}while (!(check_back_option));
										
										check_search_patient_id = true;
									}
								}
							}
						}while (!(check_search_patient_id));
						
					}
					// g. Back to Main Menu  
					else if (patient_option.equalsIgnoreCase("B")) {patient_status = true;}
					else {
						System.out.print(" Invalid Input. ");
						patient_status = false;}
					}while (patient_status == false);
					
					
				
			}
			else if (optionmain == 5) {
					// a. Display medical details
					Boolean medical_status = false;
					do {
					int total_medical = 0;
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("  Medical Information  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("  Name \t\t  Manufacturer  \tExpiry Date  \tCost  \t Count ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					for (int i = 0 ; i < medicals.length ; i++ ) {
						if(medicals[i]!=null) {
							System.out.println(medicals[i].findMedical());
							total_medical += 1;
						}
					};
					System.out.println("\nTotal Medical : " + total_medical+"           (A)dd      (E)dit     (P)rint   (D)elete   (S)earch  (B)ack  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					String medical_option;
					System.out.print(" option : ");
					medical_option = input.nextLine();
					medical_option.toUpperCase();
					
					// b. Add medical
					if(medical_option.equalsIgnoreCase("A")) { 
						for (int i = 0 ; i < medicals.length ; i++ ) {
							if(medicals[i]==null) {
								Medical temp = new Medical();
								temp.newmedical();
								medicals[i] = temp;
								break;
								}
							}
					}
					
					// c. Edit medical
					else if (medical_option.equalsIgnoreCase("E")) {
						
						boolean checkmedical_name = false;
						int selectmedical = 0 ;
						
						do {
							System.out.print("Enter Medical Name : ");
							String medicalsearchName = input.nextLine();
						
							for (int i = 0 ; i < medicals.length ; i++ ) {						
								if(medicals[i]!=null) { 
									String compareMedical = medicals[i].getmedical_name();
									if (medicalsearchName.equalsIgnoreCase(compareMedical)) {
										System.out.println(i);
										selectmedical= i;
										checkmedical_name = true;
									}
								}
							}
						}while (!(checkmedical_name));
						
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("Select information you want to edit.");
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("1. Medical Name");
						System.out.println("2. Manufacturer");
						System.out.println("3. Expiry Date");
						System.out.println("4. Cost");
						System.out.println("5. Count\n");
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						Boolean check_medical_edit = false;
						int optionmedical = 0;
						
						do {
							try {
								System.out.print("Enter option :  ");
								optionmedical= Integer.parseInt(input.nextLine());
								check_medical_edit = true;
							}
							catch(NumberFormatException ex){
								System.out.println(" Invalid input , Please try again");
							}
							
						}while(check_medical_edit == false);
						
						
						while (!(optionmedical >= 1 && optionmedical <= 5)) {
							System.out.print("Enter option :  ");
							optionmedical = Integer.parseInt(input.nextLine());
						}
						
						if (optionmedical == 1 ) {
							String medical_name;
							System.out.print("Enter Medical Name :");
							medical_name = input.nextLine();
							medicals[selectmedical]. setmedical_name(medical_name);
						}
						
						else if (optionmedical == 2) {
							System.out.print("Enter manufacturer :");
							String medical_manufacturer = input.nextLine();
							medicals[selectmedical].setmedicalmanufacturer(medical_manufacturer);
						}
						
						else if(optionmedical == 3) {
							System.out.print("Enter Expiry Date :");
							String medical_expiryDate = input.nextLine();
							medicals[selectmedical].setmedicalExpiryDate(medical_expiryDate);
						}
						
						else if (optionmedical == 4) {
							System.out.print("Enter cost :");
							Integer medical_cost = input.nextInt();
							medicals[selectmedical].setmedicalcost(medical_cost);
						}
						
						else {
							System.out.print("Enter medical count : ");
							int medical_count = input.nextInt();
							medicals[selectmedical].setmedicalcount(medical_count) ;
						}
					}
					// d. Print Medical 
					else if (medical_option.equalsIgnoreCase("P")) {
						String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
						String MedicalFilename = "Medical" + timeStamp;
						
						File sourceFile = new File(MedicalFilename + ".txt");
						PrintWriter writeFile = new PrintWriter(sourceFile);

						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						writeFile.println("  Medical Name \t\t Manufacturer\t\t Expiry Date \tCost \t Count ");
						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						for (int i = 0 ; i < medicals.length ; i++ ) {
							if(medicals[i]!=null) {
								writeFile.println(medicals[i].findMedical());
							}
						}
						writeFile.close();		
					}
					
					// e. Delete medical 
					else if (medical_option.equalsIgnoreCase("D")) {
						
						boolean check_del_medical_name = false;
						do {
							System.out.print("Enter medical name : ");
							String medicalsearchname = input.nextLine();
						
							for (int i = 0 ; i < medicals.length ; i++ ) {						
								if(medicals[i]!=null) { 
									String compareMedical = medicals[i].getmedical_name();
									if (medicalsearchname.equalsIgnoreCase(compareMedical)) {
										for (int j = 0 ; j < medicals.length; j++) {
											if (j == i) 
												continue;
											else
												medicals[i] = medicals[j];
										}
										check_del_medical_name = true;
									}
								}
							}
						}while (!(check_del_medical_name));			
					}
					
					// f. Save Medical 
					else if (medical_option.equalsIgnoreCase("S")) {						
						boolean check_search_medical_name = false;
						boolean check_back_option  = false;
						
						do {
							System.out.print("Enter medical name : ");
							String medicalsearchID = input.nextLine();
						
							for (int i = 0 ; i < medicals.length ; i++ ) {						
								if(medicals[i]!=null) { 
									String compareMedical = medicals[i].getmedical_name();
									if (medicalsearchID.equalsIgnoreCase(compareMedical)) {
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(" Medical search Name :" + compareMedical);
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println("    Name \t\t\t Manufacturer \t Expiry Date \tCost \t Count ");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(medicals[i].findMedical());
										
										System.out.println("                                                                                    (B)ack              ");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										
										do {
											String medical_back_option;
											System.out.print(" option : ");
											medical_back_option = input.nextLine();
											medical_back_option.toUpperCase();
											
											if (medical_back_option.equalsIgnoreCase("B")){
												check_back_option = true;
											}
											
										}while (!(check_back_option));
										
										check_search_medical_name = true;
									}
								}
							}
						}while (!(check_search_medical_name));
						
					}
					// g . Back to Main Menu 
					else if (medical_option.equalsIgnoreCase("B")) {medical_status = true;}
					else {
						System.out.print(" Invalid Input. ");
						medical_status = false;}
					}while (medical_status == false);
					
					
				}
			else if (optionmain == 6) {
				Boolean staff_status = false;
				do {
					// a. Display staff details
					int total_staff = 0;
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("  Staff Information  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					System.out.println("  id \t Name \t\t Designation \t\t\tSex  \tSalary ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					for (int i = 0 ; i < staffs.length ; i++ ) {
						if(staffs[i]!=null) {
							System.out.println(staffs[i].showStaffInfo());
							total_staff += 1;
						}
					};
					System.out.println("\nTotal Staff : " + total_staff+"           (A)dd      (E)dit     (P)rint   (D)elete   (S)earch  (B)ack  ");
					System.out.println("------------------------------------------------------------------------------------------------------- ");
					String staff_option;
					System.out.print(" option : ");
					staff_option = input.nextLine();
					staff_option.toUpperCase();
					
					// b. Add staff
					if(staff_option.equalsIgnoreCase("A")) { 
						for (int i = 0 ; i < staffs.length ; i++ ) {
							if(staffs[i]==null) {
								Staff temp = new Staff();
								temp.newStaff();
								staffs[i] = temp;
								break;
								}
							}
					}
					
					// c. Edit staff
					else if (staff_option.equalsIgnoreCase("E")) {
						
						boolean checkstaff_id = false;
						int selectstaff = 0 ;
						
						do {
							System.out.print("Enter your ID : ");
							String staffsearchID = input.nextLine();
						
							for (int i = 0 ; i < staffs.length ; i++ ) {						
								if(staffs[i]!=null) { //Check if the  doctor is empty
									String compareStaff = staffs[i].getstaffid();
									if (staffsearchID.equalsIgnoreCase(compareStaff)) {
										System.out.println(i);
										selectstaff = i;
										checkstaff_id = true;
									}
								}
							}
						}while (!(checkstaff_id));
						
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("Select information you want to edit.");
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						System.out.println("1. ID");
						System.out.println("2. Name");
						System.out.println("3. Designation");
						System.out.println("4. Sex");
						System.out.println("5. Salary");
						System.out.println("------------------------------------------------------------------------------------------------------- ");
						Boolean check_staff_edit = false;
						int optionstaff = 0;
						
						do {
							try {
								System.out.print("Enter option :  ");
								optionstaff= Integer.parseInt(input.nextLine());								
								check_staff_edit = true;
							}
							catch(NumberFormatException ex){
								System.out.println(" Invalid input , Please try again");
							}
							
						}while(check_staff_edit == false);
						
						while (!(optionstaff >= 1 && optionstaff <= 6)) {
							System.out.print("Enter option :  ");
							optionstaff = Integer.parseInt(input.nextLine());
						}
						
						if (optionstaff == 1) {
							String staff_id;
							System.out.print("Enter id :");
							staff_id = input.nextLine();
							staffs[selectstaff].setstaffID(staff_id);
						}
						
						else if (optionstaff == 2) {
							String staff_name;
							System.out.print("Enter Name :");
							staff_name = input.nextLine();
							staffs[selectstaff].setstaffName(staff_name);
						}
						
						else if (optionstaff == 3) {
							System.out.print("Enter staff designation :");
							String staff_designation = input.nextLine();
							staffs[selectstaff].setstaffDesignation(staff_designation);
						}
						
						else if(optionstaff == 4) {
							System.out.print("Enter sex :");
							String staff_sex = input.nextLine();
							staffs[selectstaff].setstaffSex(staff_sex) ;
						}
						
						else {
							System.out.print("Enter salary :");
							Integer staff_salary = input.nextInt();
							staffs[selectstaff].setstaffSalary(staff_salary);
						}
						
					}
					
					// d. Print staff
					else if (staff_option.equalsIgnoreCase("P")) {
						String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
						String StaffFilename = "Staff" + timeStamp;
						
						File sourceFile = new File(StaffFilename + ".txt");
						PrintWriter writeFile = new PrintWriter(sourceFile);

						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						writeFile.println("   id \t Name \t\t\t Designation \t Sex \tSalary \t Room No ");
						writeFile.println("------------------------------------------------------------------------------------------------------- ");
						for (int i = 0 ; i < staffs.length ; i++ ) {
							if(staffs[i]!=null) {
								writeFile.println(staffs[i].showStaffInfo());
							}
						}
						writeFile.close();		
					}
					
					// e . Delete staff
					else if (staff_option.equalsIgnoreCase("D")) {
						
						boolean check_del_staff_id = false;
						
						do {
							System.out.print("Enter you ID : ");
							String staffsearchID = input.nextLine();
						
							for (int i = 0 ; i < staffs.length ; i++ ) {						
								if(staffs[i]!=null) { 
									String compareStaff = staffs[i].getstaffid();
									if (staffsearchID.equalsIgnoreCase(compareStaff)) {
										for (int j = 0 ; j < staffs.length; j++) {
											if (j == i) 
												continue;
											else
												staffs[i] = staffs[j];
										}
										check_del_staff_id = true;
									}
								}
							}
						}while (!(check_del_staff_id));			
					}
					// f. Search Staff 
					else if (staff_option.equalsIgnoreCase("S")) {
						
						boolean check_search_staff_id = false;
						boolean check_back_option  = false;
						
						do {
							System.out.print("Enter you ID : ");
							String staffsearchID = input.nextLine();
						
							for (int i = 0 ; i < staffs.length ; i++ ) {						
								if(staffs[i]!=null) { 
									String compareStaff = staffs[i].getstaffid();
									if (staffsearchID.equalsIgnoreCase(compareStaff)) {
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(" Staff search ID :" + compareStaff);
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println("   id \t Name \t\t\t Designation \t Sex \tSalary");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										System.out.println(staffs[i].showStaffInfo());
										
										System.out.println("                                                                                    (B)ack              ");
										System.out.println("------------------------------------------------------------------------------------------------------- ");
										
										do {
											String staff_back_option;
											System.out.print(" option : ");
											staff_back_option = input.nextLine();
											staff_back_option.toUpperCase();
											
											if (staff_back_option.equalsIgnoreCase("B")){
												check_back_option = true;
											}
											
										}while (!(check_back_option));
										
										check_search_staff_id = true;
									}
								}
							}
						}while (!(check_search_staff_id));
						
					}
					// g. Back to Main Menu 
					else if (staff_option.equalsIgnoreCase("B")) {staff_status = true;}
					else {
						System.out.print(" Invalid Input. ");
						staff_status = false;}
					}while (staff_status == false);
					
					
				}
			
			else if(optionmain==7) {
				  main_status = false;
				  String timeStamp2 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
				  String ReportFilename = "Record_Report" + timeStamp2;
				  String filepath = "C:\\Users\\User\\Downloads\\JAVA Assignment\\"+ReportFilename+".pdf"; 
				  int DoctorNumber=0;
				  int FacilityNumber=0;
				  int LabNumber=0;
				  int MedicalNumber=0;
				  int PatientNumber=0;
				  int StaffNumber=0;
				  //created PDF document instance   
				  Document doc = new Document();  
				  try  
				  {  
					  //generate a PDF at the specified location  
					  PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(filepath));
					  
					  //Get the total number of Doctor
					  for(int i=0;i<doctors.length;i++) {
						  if(doctors[i]!=null) {
							  DoctorNumber++;
	 
						  }
					  }
					  
					  //Get total number of facility
					  for(int i=0;i<facilities.length;i++) {
						  if(facilities[i]!=null) {
							 FacilityNumber++;
	 
						  }
					  }
					  
					  //Get the total number of Lab
					  for(int i=0;i<labs.length;i++) {
						  if(labs[i]!=null) {
							  LabNumber++;
	 
						  }
					  }
					  
					  //Get the number of medical
					  for(int i=0;i<medicals.length;i++) {
						  if(medicals[i]!=null) {
							  MedicalNumber++;
	 
						  }
					  }
					  
					  //Get the number of patient
					  for(int i=0;i<patients.length;i++) {
						  if(patients[i]!=null) {
							  PatientNumber++;
	 
						  }
					  }
					  
					  //Get the number of staff
					  for(int i=0;i<staffs.length;i++) {
						  if(staffs[i]!=null) {
							  StaffNumber++;
	 
						  }
					  }
					  
					  //Create table for all
					  Table Table = new Table(2);
					  
					  //Create cell for "doctor" and doctor number 
					  Cell Doccell = new Cell("Doctors");
					  Table.addCell(Doccell);
					  
					  Cell DocNumcell = new Cell(String.valueOf(DoctorNumber));
					  Table.addCell(DocNumcell);
					  
					//Create cell for "facility" and facility number 
					  Cell Faccell = new Cell("Facilities");
					 Table.addCell(Faccell);
					  
					  Cell FacNumcell = new Cell(String.valueOf(FacilityNumber));
					  Table.addCell(FacNumcell);
					  
					//Create cell for "Labs" and lab number 
					  Cell Labcell = new Cell("Labs");
					  Table.addCell(Labcell);
					  
					  Cell LabsNumcell = new Cell(String.valueOf(LabNumber));
					  Table.addCell(LabsNumcell);
					  
					//Create cell for "medical" and Medical number 
					  Cell Meccell = new Cell("Medical");
					  Table.addCell(Meccell);
					  
					  Cell MecNumcell = new Cell(String.valueOf(MedicalNumber));
					  Table.addCell(MecNumcell);
					  
					//Create cell for "Patient" and Patient number 
					  Cell Patcell = new Cell("Patient");
					  Table.addCell(Patcell);
					  
					  Cell PatNumcell = new Cell(String.valueOf(PatientNumber));
					  Table.addCell(PatNumcell);
					  
					//Create cell for "Staff" and Staff number 
					  Cell Safcell = new Cell("Staff");
					  Table.addCell(Safcell);
					  
					  Cell SafNumcell = new Cell(String.valueOf(StaffNumber));
					  Table.addCell(SafNumcell);
				  
					  System.out.println("Report created successfully. Report FileName : " + ReportFilename + ".pdf");  
					  //opens the PDF  
					  doc.open();  
					  //adds paragraph to the PDF file  
					  doc.add(new Paragraph("Total Numbers"));   
					  doc.add(new Paragraph("---------------------------"));
					  doc.add(Table);
					  //close the PDF file  
					  doc.close();  
					  //closes the writer  
					  writer.close();  
				  }   
				  catch (DocumentException e)  
				  {  
				  e.printStackTrace();  
				  }   
				  catch (FileNotFoundException e)  
				  {  
				  e.printStackTrace();  
				  }  
			
			}
			else if (optionmain == 8) {
				main_status = false;
				

				
				 //Get the total number of Doctor
				  for(int i=0;i<doctors.length;i++) {
					  if(doctors[i]!=null) {
						  GlobalDoctorNumber++;

					  }
				  }
				  
				  //Get total number of facility
				  for(int i=0;i<facilities.length;i++) {
					  if(facilities[i]!=null) {
						  GlobalFacilityNumber++;

					  }
				  }
				  
				  //Get the total number of Lab
				  for(int i=0;i<labs.length;i++) {
					  if(labs[i]!=null) {
						  GlobalLabNumber++;

					  }
				  }
				  
				  //Get the number of medical
				  for(int i=0;i<medicals.length;i++) {
					  if(medicals[i]!=null) {
						  GlobalMedicalNumber++;

					  }
				  }
				  
				  //Get the number of patient
				  for(int i=0;i<patients.length;i++) {
					  if(patients[i]!=null) {
						  GlobalPatientNumber++;

					  }
				  }
				  
				  //Get the number of staff
				  for(int i=0;i<staffs.length;i++) {
					  if(staffs[i]!=null) {
						  GlobalStaffNumber++;

					  }
				  }
				  
				Application.launch(BarChartTotal.class,args);
			
			}
			else if (optionmain == 9) {
				main_status = true;
				
			}
		}while (main_status == false);	
		

	}
	
	
	
}



