package TableHandle;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SumValuesInTheTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,550)"); //scroll the page
		Thread.sleep(3000);
		
		
		//.tableFixHead > webelement using css
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //scroll table handler
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			String value=values.get(i).getText();
			sum+=Integer.parseInt(value); //convert string to integer
		}
		System.out.print(sum);
		
		String totalAmount=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim(); //Total Amount Collected: 296
		
		int total=Integer.parseInt(totalAmount);
		Assert.assertEquals(total, sum);
		
		

	}

}
