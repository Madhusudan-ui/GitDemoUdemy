package HTTPAndSSLCertifications;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class deleteCookies {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		driver.manage().deleteAllCookies(); // delete all cookies
		
		//driver.manage().deleteCookieNamed("sessionkey");// delete specific cookie using cookie name
		//driver.manage().addCookie(null); //adding cookie
		
		
		driver.get("https://expired.badssl.com/");
		
	
	}

}
