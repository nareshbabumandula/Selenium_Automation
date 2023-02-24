package com.application.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListboxTest {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/samples.php");
		driver.manage().window().maximize();
	}
	
	@Test
	void listboxMethods() throws InterruptedException {
		WebElement canadianprovinces = driver.findElement(By.id("q10"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", canadianprovinces);
		Select select = new Select(canadianprovinces);
		select.selectByIndex(0); // First element from the dropdown will be selected
		Thread.sleep(2000);
		select.selectByIndex(1); // Second element from the dropdown will be selected
		Thread.sleep(2000);
		select.selectByVisibleText("Ontario");
		Thread.sleep(2000);
		
		List<WebElement> options = select.getOptions();
		options.forEach(option->System.out.println(option.getText()));
		Thread.sleep(2000);
		System.out.println("Selecting last but one option from the dropdown");
		select.selectByIndex(options.size()-1);
		
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
