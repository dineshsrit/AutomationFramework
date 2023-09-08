package com.srit.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

private static ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
	return  dr.get();
			
	}
 	

	public static void setDriver(WebDriver ref)
	{
		dr.set(ref);
	}
	
	public static void unLoad()
	{
		dr.remove();
	}
}
