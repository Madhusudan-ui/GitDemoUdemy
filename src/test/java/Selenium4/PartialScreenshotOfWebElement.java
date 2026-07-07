package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshotOfWebElement {

	public static void main(String[] args) throws IOException {
		
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
		
		WebElement name=driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(copiedtext);
		
		//taking screen shot of webelement name
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
				
		

	}

}
