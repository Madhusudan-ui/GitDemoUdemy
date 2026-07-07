package Links;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		
		//1.total links count on page
		//2.links count on footer section
		//3.links in footer column

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//total links on page
		List<WebElement> totalLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total links in page "+totalLinks.size());
		
//		//links on footer section
//		List<WebElement> footerSectionLinks=driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
//		System.out.println("links in footer section "+ footerSectionLinks.size());
		
		//or we can limit the scope of webdriver
		WebElement footerDriver= driver.findElement(By.id("gf-BIG"));
		List<WebElement>footerLinks=footerDriver.findElements(By.tagName("a"));
		System.out.println("links in footer section "+footerLinks.size());
		
		//links in each first footer column
		/*//div[@id='gf-BIG']//table//tbody//tr//td[1]/ul =footderDriver.findElement()*/
		WebElement columnDriver=footerDriver.findElement(By.xpath("//table//tbody//tr//td[1]/ul"));
		List<WebElement> columnLinks=columnDriver.findElements(By.tagName("a"));
		System.out.println("column section links "+columnLinks.size());
		
		//check colum link open
		for(int i=1;i<columnLinks.size();i++)
		{
			columnLinks.get(i).click();
			driver.navigate().back();
			
		}
		
		
		
		
	}

}
