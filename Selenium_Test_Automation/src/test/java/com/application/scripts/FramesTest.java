package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FramesTest {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void frameMethods() throws InterruptedException {
		driver.findElement(By.linkText("Autocomplete")).click();
		Thread.sleep(2000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of frames exists are : " + size);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // Switch to frame based on frame webelement
		//driver.switchTo().frame(0); // Switch to frame based on frame index
		driver.findElement(By.id("tags")).sendKeys("Selenium");
		//driver.switchTo().defaultContent(); // Switches out from the frame
		driver.switchTo().parentFrame(); // Switch to immediate parent iframe using method
		driver.findElement(By.linkText("Draggable")).click();
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
