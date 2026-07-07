package Assignment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectOptions {

	public static void main(String[] args) {
		
		/*1.Select any checkbox
		 *2.Grab the label of the selected check box
		 *3.select an option in dropdown.Here option to select should come from step 2 
		 *4.enter the step 2 grabbed label text  in editbox
		 *click alert and then verify if text grabbed from step 2 is present  in the pop up message 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1
		driver.findElement(By.id("checkBoxOption2")).click();
		//2
		String opt=driver.findElement(By.xpath("//label[@for='benz']")).getText(); //Option2
		//3
		WebElement dropDown=driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(opt);
		//4
		driver.findElement(By.cssSelector("input[class='inputs']")).sendKeys(opt);
		//5
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText=driver.switchTo().alert().getText();
		
//		if(alertText.contains(opt))
//		{
//			System.out.println("Alert message succress");
//		}
//		else
//		{
//			System.out.println("Alert message not succress");
//		}
		//Assert assert= new Assert();
		Assert.assertTrue(alertText.contains(opt));

	}

}
