package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicSimpleTest {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports = new ExtentReports();   //report engine
		
		//1.create html report using string
		//(i)using absolute path > reprts stored in project folder
		//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\madhu\\eclipse-workspace\\PracticeSelenium\\src\\test\\reports.html");
		
		//(ii)using relative path > reprots stored in project directory in eclipse
		//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports.html");
		
		//2. using file
		File file= new File("reports.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		//add status or logs > 
		ExtentTest test1=extentReports.createTest("Test 1");
		test1.pass("This is passed"); // simplified version
		
		ExtentTest test2=extentReports.createTest("Test 2");
		test2.log(Status.FAIL,"This is failed");
		
		extentReports.createTest("Test 3").skip("This is skipped");
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
