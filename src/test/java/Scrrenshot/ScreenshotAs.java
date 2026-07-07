package Scrrenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotAs {

	public static void main(String[] args) throws IOException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.manage().deleteAllCookies(); // delete all cookies
		driver.get("https://expired.badssl.com/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\madhu\\OneDrive\\Pictures\\EclipseScreenshot\\screenshot1.png");
		FileUtils.copyFile(src, dest);
	

	}

}
