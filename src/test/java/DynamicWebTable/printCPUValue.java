package DynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printCPUValue {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 350)");
		
		//no of rows
		List<WebElement> totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		System.out.println("no of rows: "+totalRows.size());
		
		//find chrome option from the columns
		for(int r=1;r<totalRows.size();r++)
		{
			WebElement name= driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+r+"]//td[1]"));
			if(name.getText().equals("Chrome"))
			{
				String cpuLoad=driver.findElement(By.xpath("//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
				
				String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				
				if(value.contains(cpuLoad))
				{
					System.out.println("CPU load of chrome is equal:");
				}
				else
				{
					System.out.println("CPU load of chrome is not equal:");
				}
				break;
			}
		}
		

	}

}
