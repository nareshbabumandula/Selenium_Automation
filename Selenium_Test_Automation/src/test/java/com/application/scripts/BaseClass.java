package com.application.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public static ExtentTest test;
	public static ExtentReports report;
    
	//The annotated method will be run before all tests in this suite have run.
	@BeforeSuite
	public void startReport() {
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
	}

	//The annotated method will be run after all tests in this suite have run.
	@AfterSuite
	public void endReport() {
		report.endTest(test);
		report.flush();
	}

}
