package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogDifferentTypesOfInformation {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports = new ExtentReports();   //report engine
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports.createTest("Text based test")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "<b>info2</b>")
		.log(Status.INFO, "<i>info3</i>")
		.log(Status.INFO, "<b><i>info4</b></i>");
		
//		ExtentTest test = extentReports.createTest("test 1");
//		test.pass("<b>pass</b>");

		String xmlData="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		//extentReports.createTest("XML based test")
		//.log(Status.INFO, xmlData); //due to this code, xml data not visible in Ui
		extentReports.createTest("XML based test")
		.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		
		String jsonData="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		//extentReports.createTest("JSON based test")
		//.log(Status.INFO, jsonData); // due to this data is in normal format, not in json format
		extentReports.createTest("JSON based test")
		.log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		List<String> listData = new ArrayList<>();
		listData.add("yadagiri");
		listData.add("Jeevan");
		listData.add("Raj");
		
		extentReports.createTest("List based test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		Map<Integer, String> mapData= new HashMap<>();
		mapData.put(101, "yadagiri");
		mapData.put(102, "Jeevan");
		mapData.put(103, "Raj");
		
		extentReports.createTest("Map based test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		Set<Integer> setData = mapData.keySet();
		
		extentReports.createTest("Set based test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));
		
		
		extentReports.createTest("HighLight log test")
		.info("This is not a highlighted message")
		.info(MarkupHelper.createLabel("This is a highlighted message", ExtentColor.RED));
		
		
		try //automatic generated exception thrown by code itself
		{
			int i=5/0;
		} catch (Exception e)
		{
			extentReports.createTest("Exception test1")
			.info(e);
		}
		
		//run time exception
		Throwable t = new RuntimeException("This is custome exception");
		extentReports.createTest("Exception test2")
		.info(t);
		
		extentReports.createTest("Exception test3")
		.fail(t);
		
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
