package com.srit.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.srit.config.PropertyUti;
import com.srit.config.ScreenshotUtils;
import com.srit.driver.DriverManager;
import com.srit.enums.ConfigProperties;

public final class ExtentLogger {

	private ExtentLogger()
	{
		
	}
	
	 public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}
	
	public  static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
	}
	
	public  static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message, boolean isScreenshotNeeded ) throws Exception
	{
		if(PropertyUti.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		}
		else
		{
			pass(message);
		}
	}
	
	public static void fail(String message, boolean isScreenshotNeeded ) throws Exception
	{
		if(PropertyUti.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		}
		else
		{
			fail(message);
		}
	}
	
	public static void skip(String message, boolean isScreenshotNeeded ) throws Exception
	{
		if(PropertyUti.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenshotNeeded)
		{
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBaseImage()).build());
		}
		else
		{
			skip(message);
		}
	}
	

	
}
