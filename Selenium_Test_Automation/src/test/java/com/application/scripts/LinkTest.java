package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinkTest {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void linkMethods() throws InterruptedException {
		//WebElement testimonials = driver.findElement(By.linkText(">> More Testimonials"));
		WebElement testimonials = driver.findElement(By.partialLinkText("Testimonials"));
		System.out.println(testimonials.getAttribute("href"));
		System.out.println(testimonials.getText());
		// Click on more testimonials link
		testimonials.click();
		Thread.sleep(4000);
		
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
