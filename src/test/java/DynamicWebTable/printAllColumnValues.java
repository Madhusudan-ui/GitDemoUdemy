package DynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printAllColumnValues {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 350)");
		
		//no of rows
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		System.out.println("no of rows: "+rows.size());
		
		//print all column options
		for(int r=0;r<rows.size();r++)
		{
		List<WebElement> columns= rows.get(r).findElements(By.tagName("td"));
		 System.out.println("\nRow " + (r + 1) + ":");
		 
			for(int c=0;c<columns.size();c++)
			{
				System.out.print(columns.get(c).getText()+ " | ");
			}
			
		}
		

	}

}
