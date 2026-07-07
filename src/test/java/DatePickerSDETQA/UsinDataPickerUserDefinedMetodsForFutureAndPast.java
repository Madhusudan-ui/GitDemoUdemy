package DatePickerSDETQA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsinDataPickerUserDefinedMetodsForFutureAndPast {

	//Future dates
	static void selectFutureDates(WebDriver driver, String expectedYear, String expectedMonth, String expectedDate) {
		// select month and Year
		while (true) {
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (actualYear.equals(expectedYear) && actualMonth.equals(expectedMonth)) {
				break;
			}
			// next button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		// Select date
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement actualDate : allDates) {
			if (actualDate.getText().equals(expectedDate)) {
				actualDate.click();
				break;
			}
		}
	}
	
	//select past dates
	static void selectPastDates(WebDriver driver, String expectedYear, String expectedMonth, String expectedDate) {
		// select month and Year
		while (true) {
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (actualYear.equals(expectedYear) && actualMonth.equals(expectedMonth)) {
				break;
			}
			// previous button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		// Select date
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement actualDate : allDates) {
			if (actualDate.getText().equals(expectedDate)) {
				actualDate.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// switch to frame
		driver.switchTo().frame(0);

		// click on date picker box
		driver.findElement(By.id("datepicker")).click();

	
      //pass directly values to method instead of creating variable for expected dates
		//selectFutureDates(driver, "2028", "July", "8");
		selectPastDates(driver, "2025", "August", "15");

	}

}
