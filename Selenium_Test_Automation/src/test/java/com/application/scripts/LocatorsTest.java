package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocatorsTest {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
	}

	@Test
	void locatorsExample() throws InterruptedException {

		// Absolute XPath
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/form/fieldset/div/input")).sendKeys("juweria");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/form/fieldset/div/input")).clear();

		// Relative XPath from the node of our choice
		driver.findElement(By.xpath("//form/fieldset/div/input")).sendKeys("satyaleela");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form/fieldset/div/input")).clear();

		// Relative XPath with attributes Syntax: //html tag[@attribute='value']
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("Naresh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user']")).clear();

		// Relative XPath with and operator
		driver.findElement(By.xpath("//input[@id='user' and @name='user']")).sendKeys("Sateesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user' and @name='user']")).clear();

		// Relative XPath with | operator
		driver.findElement(By.xpath("//input[@id='user']|//input[@name='user']")).sendKeys("Padma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user']|//input[@name='user']")).clear();

		// Relative XPath with or operator
		driver.findElement(By.xpath("//input[@id='user' or @name='user123']")).sendKeys("Jaipal");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user' or @name='user123']")).clear();

		// Relative XPath with * operator
		driver.findElement(By.xpath("//input[@*='user']")).sendKeys("Ravi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@*='user']")).clear();
		
		// Relative XPath with starts-with function
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).sendKeys("Teja");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).clear();
		
		// Relative XPath with contains function
		driver.findElement(By.xpath("//input[contains(@id,'se')]")).sendKeys("Tirumal");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'se')]")).clear();
		
	}

	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


}
