package DatePickerSDETQA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingDataPicker {
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//click on date picker box
		driver.findElement(By.id("datepicker")).click();
		
		//select month and year
		String expectedYear="2028";
		String expectedMonth="July";
		String expectedDate="8";
		
		//dont know how many time to iterated, so using while loop
		//select month and yera
		while(true)
		{
			String actualYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			if(actualYear.equals(expectedYear)&&actualMonth.equals(expectedMonth))
			{
				break;
			}
			//next button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//Select date
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement actualDate:allDates)
		{
			if(actualDate.getText().equals(expectedDate))
			{
				actualDate.click();
				break;
			}
		}
		
		
	}

}
