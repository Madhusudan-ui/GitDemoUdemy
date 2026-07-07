package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class releativeLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//above()
		WebElement nameEditBox=driver.findElement(By.cssSelector("input[name='name']"));
		WebElement labelName=driver.findElement(with(By.tagName("label")).above(nameEditBox));
		System.out.println(labelName.getText());
		
		//below()
		WebElement dob=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		WebElement below=driver.findElement(with(By.tagName("input")).below(dob));
		below.click(); //relative locators does not support flex elements , so its clicked on submit button
		
		//toLeftOf()
		WebElement icecreamText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		WebElement icecreamCheckBox=driver.findElement(with(By.id("exampleCheck1")).toLeftOf(icecreamText));
		icecreamCheckBox.click();
		
		//toRightOf()
		WebElement radioButton=driver.findElement(By.cssSelector("input[id='inlineRadio1']"));
		WebElement studentText=driver.findElement(with(By.tagName("label")).toRightOf(radioButton));
		System.out.println(studentText.getText());
		

	}

}
