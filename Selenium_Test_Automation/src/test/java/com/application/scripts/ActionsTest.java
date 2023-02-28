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

public class ActionsTest extends BaseClass {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void actionsMethods() throws InterruptedException {
		WebElement addons = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
	
		Actions action = new Actions(driver);
		action.click(addons).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'SpiceFlex')]")).click();
		Thread.sleep(2000);
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
