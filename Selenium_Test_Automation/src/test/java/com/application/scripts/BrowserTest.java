package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	WebDriver driver;
	
	@Parameters({"BROWSER"})
	@BeforeClass
	public void launchBrowser(String browserType) {

		switch (browserType) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff": case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			//System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser..!");
			break;
		}
				
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
