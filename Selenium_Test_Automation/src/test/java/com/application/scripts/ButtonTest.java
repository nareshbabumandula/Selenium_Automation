package com.application.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonTest {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void buttonMethods() {
		WebElement btnlogin = driver.findElement(By.name("btnSubmit"));
			
		System.out.println(btnlogin.isDisplayed());
		System.out.println(btnlogin.isEnabled());
		System.out.println(btnlogin.getAttribute("name"));
		System.out.println(btnlogin.getAttribute("type"));
		System.out.println(btnlogin.getAttribute("value"));
		System.out.println(btnlogin.getAttribute("class"));
		System.out.println(btnlogin.getAttribute("tabindex"));
		System.out.println(btnlogin.getTagName());
		
		// click on button login
		btnlogin.click();
				
		driver.navigate().to("https://www.mycontactform.com/samples.php");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("No of elements are : " + elements.size());
		
		// lambda expression
		elements.forEach(element->element.sendKeys("testing"));
		
		// stream api
		long nobjects = elements.stream().filter(element->element.getAttribute("type").equals("text")).count();
		System.out.println("No of text fields are : " + nobjects);
		
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
