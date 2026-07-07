package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) {
		/*1.send string "ind"
		 * 2.move mouse to india and select
		 * 3.check india is added correctly in box or not
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
 
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
//		   driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//	   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
//		
		List<WebElement> countryNames= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for(WebElement country:countryNames)
		{
			if(country.getText().equalsIgnoreCase("india"))
			{
				country.click();
				break;
			}
		}
		 System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
