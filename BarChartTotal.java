import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class BarChartTotal extends Application {
	


	@Override  
	public void start(Stage primaryStage) throws Exception {  
	    // TODO Auto-generated method stub  
	
	    //Configuring category and NumberAxis   
	    CategoryAxis xaxis= new CategoryAxis();  
	    NumberAxis yaxis = new NumberAxis(1,10,1);  
	    xaxis.setLabel("Category");  
	    yaxis.setLabel("Number");  
	      
	    //Configuring BarChart   
	    BarChart<String,Float> bar = new BarChart(xaxis,yaxis);  
	    bar.setTitle("Total Number of each category");  
	      
	    //Configuring Series for XY chart   
	    XYChart.Series<String,Float> series = new XYChart.Series<>();  
//	    series.getData().add(new XYChart.Data("Doctor",DocNum));  
//	    series.getData().add(new XYChart.Data("Facility",FacNum));  
//	    series.getData().add(new XYChart.Data("Lab",LabNum));  
//	    series.getData().add(new XYChart.Data("Medical",MedNum));  
//	    series.getData().add(new XYChart.Data("Patient",PatNum)); 
//	    series.getData().add(new XYChart.Data("Staff", StaffNum)); 
	    
	    series.getData().add(new XYChart.Data("Doctor",HospitalManagement.GlobalDoctorNumber));  
	    series.getData().add(new XYChart.Data("Facility",HospitalManagement.GlobalFacilityNumber));  
	    series.getData().add(new XYChart.Data("Lab",HospitalManagement.GlobalLabNumber));  
	    series.getData().add(new XYChart.Data("Medical",HospitalManagement.GlobalMedicalNumber));  
	    series.getData().add(new XYChart.Data("Patient",HospitalManagement.GlobalPatientNumber)); 
	    series.getData().add(new XYChart.Data("Staff", HospitalManagement.GlobalStaffNumber)); 
	      
	    //Adding series to the barchart   
	    bar.getData().add(series);  
	      
	    // configuring group and scene   
	    Group root = new Group();  
	    root.getChildren().add(bar);  
	    Scene scene = new Scene(root,600,400);  
	    primaryStage.setScene(scene);  
	    primaryStage.setTitle("Statistic Bar Chart");  
	    primaryStage.show();      
	}  
	public static void main(String[] args) {  
	    launch(args);  
	}  
}