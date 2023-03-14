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
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class DragDropTest extends BaseClass{

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		test = report.startTest("DragDropTest");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	void actionsMethods() throws InterruptedException {

		try {
			driver.findElement(By.linkText("Draggable")).click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement source = driver.findElement(By.id("draggable"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(source, 390, 100).perform();
			driver.switchTo().defaultContent();
			driver.findElement(By.linkText("Droppable")).click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			
			WebElement src = driver.findElement(By.id("draggable"));
			WebElement dest = driver.findElement(By.id("droppable"));
			action.dragAndDrop(src, dest).perform();
			// Hard Assertion
			//Assert.assertEquals(dest.getText(), "Dropped", "Failed to drop the webelement");
			SoftAssert softassert = new SoftAssert();
			// Soft Assertion
			softassert.assertEquals(dest.getText(), "Dropped", "Failed to drop the webelement");
			test.log(LogStatus.PASS, "Successfully dropped the object");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to drop the object");
			e.printStackTrace();
		}
			
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
