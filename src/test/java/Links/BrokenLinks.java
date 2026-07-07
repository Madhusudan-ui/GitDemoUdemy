package Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		/*1. to get all urls tied up to the links using selenium
		 *2.java methods will call urls  an dgets you the status codes
		 *if status code >400 then that url is not working > link which tied to url is broken
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		SoftAssert a= new SoftAssert();
		
		//*1. to get all urls tied up to the links using selenium
		//String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		List<WebElement> allLinks=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		//2.java methods will call urls  an dgets you the status codes
		for(WebElement link:allLinks)
		{
			String url=link.getAttribute("href");
			
			URL linkUrl = new URL(url);
			HttpURLConnection conn=(HttpURLConnection) linkUrl.openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode=conn.getResponseCode();
			System.out.println(responseCode);
			
			//if status code >400 then that url is not working > link which tied to url is broken
			
//			if(responseCode>400)
//			{
//				System.out.println("The link with text "+link.getText()+" is broken with code "+ responseCode);
//				Assert.assertTrue(false);
//			}
			//insteaf of if loop, we can use soft asserts to check all links and return at the end
			a.assertTrue(responseCode<400, "The link with text "+link.getText()+" is broken with code "+ responseCode);
		}
		a.assertAll();
		
		

	}

}
