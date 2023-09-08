package com.srit.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srit.driver.Driver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Map;

public class BaseTest {
	
	protected BaseTest()
	{
		
	}
	
	WebDriver driver;
	
	

/*	@BeforeSuite
	public void beforeSuite()
	{
		ExtentReport.initReports();
	}*/
	
/*	@AfterSuite
	public void afterSuite() throws IOException
	{
		ExtentReport.flushReports();
	}
	*/
	@Parameters("browsers")
	@BeforeMethod()
	public void setUp(@Optional String browser) throws Exception {
		//Map<String, String> map=(Map<String, String>)data[0];
		Driver.initDriver();
	}

	
	/*@AfterMethod
	public void tearDown() throws InterruptedException
	{

		Driver.quitDriver();
	}*/
}
