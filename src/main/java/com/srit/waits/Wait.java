package com.srit.waits;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.srit.driver.DriverManager;

public final class Wait {

	private  static WebDriverWait wait;

	private Wait()
	{
		
	}

	public static WebDriverWait getWait()
	{
		
		return wait= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	}
}
