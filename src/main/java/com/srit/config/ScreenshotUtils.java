package com.srit.config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.srit.driver.DriverManager;

import java.io.File;

public final class ScreenshotUtils {

	
	private ScreenshotUtils()
	{
		
	}
	
	public static String getBaseImage()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);


	}
	
	
}
