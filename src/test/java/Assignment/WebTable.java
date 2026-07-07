package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		
		/*1.print no of rows
		 * 2.no of coulumns
		 * 3.print second row , all column options
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> totalRows=driver.findElements(By.xpath("//table[@class='table-display']//tbody//tr"));
		System.out.println("totalRows "+totalRows.size());
		
		List<WebElement> totalColumns=driver.findElements(By.xpath("//table[@class='table-display']//tbody//tr//td"));
		System.out.println("totalColumns "+totalColumns.size());
		
		List<WebElement> secondRowColumns=driver.findElements(By.xpath("//table[@class='table-display']//tbody//tr[3]//td"));
		
		for(int i=0;i<secondRowColumns.size();i++)
		{
			System.out.println(secondRowColumns.get(i).getText());
		}

	}

}
