package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserTest {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to demonstrate all the actions that we do on a browser using Selenium WebDriver methods
	 * @throws InterruptedException 
	 **/
	@Test
	public void browserMethods() throws InterruptedException {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sample Forms")).click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle()); // browser session ID
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit(); //Terminate the browser session
	}

}
