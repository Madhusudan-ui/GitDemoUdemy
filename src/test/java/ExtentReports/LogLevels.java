package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogLevels {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports = new ExtentReports();   //report engine
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports.html");
		extentReports.attachReporter(sparkReporter);
		
		//add status or logs > 
		extentReports.createTest("Test 1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2")
		.log(Status.PASS, "pass")
		.log(Status.WARNING, "warning")
		.log(Status.SKIP, "skip")
		.log(Status.FAIL, "fail"); //tes status is based on execution order > here fail
		
//		ExtentTest test = extentReports.createTest("test 1");
//		test.pass("pass");
//		test.fail("fail");
//		test.skip("skip");
//		test.warning("warning");
//		test.info("info");
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
