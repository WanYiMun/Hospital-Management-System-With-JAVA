import java.util.Scanner;

public class Lab {
	private String lab ;
	private int cost;
	Scanner input = new Scanner(System.in);
	
	public Lab() {
		super();
	}
	
	public Lab(String lab, int cost) {
		this.lab = lab;
		this.cost = cost;
	}
	
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	// prompts user to enter facility and cost.
	public void newLab() {
		//Enter new lab
		System.out.print("Enter lab: ");
		this.lab = input.nextLine();
		
		//Enter new cost
		System.out.print("Enter cost: RM");
		this.cost = input.nextInt();
	}
	
	// to show the content of the lab
	public String labList() {
		return("\t  ["+ lab +"]\t\t  ["+ cost +"]");
	}
}

