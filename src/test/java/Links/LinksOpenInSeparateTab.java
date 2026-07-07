package Links;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinksOpenInSeparateTab {

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
			Actions act= new Actions(driver);
			act.keyDown(Keys.CONTROL).click(columnLinks.get(i)).keyUp(Keys.CONTROL).build().perform();//links open in separate tab
		}
		
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it= windows.iterator(); //stores window handles
			
			while(it.hasNext()) //it tells if there is window present or not // it.next() >>actually moves to next,  print window id
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			
		
		
		
		
		
	}

}
