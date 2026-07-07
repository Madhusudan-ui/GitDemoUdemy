package Selenium4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsOrTabs {

	public static void main(String[] args) {
		
		/*scenario:
		 * navigate to https://rahulshettyacademy.com/angularpractice/
		 * fill name feild with some text available at https://rahulshettyacademy.com/
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//driver.switchTo().newWindow(WindowType.TAB); //open new tab beside first
		driver.switchTo().newWindow(WindowType.WINDOW); // 2 windows opened
		
		driver.get("https://rahulshettyacademy.com/");
		
		//broswer active in first window
		Set<String> handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		
		driver.switchTo().window(childWindow);
		String copiedtext=driver.findElement(By.xpath("//h1[text()='An Academy to']")).getText();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(copiedtext);
		
		

	}

}
