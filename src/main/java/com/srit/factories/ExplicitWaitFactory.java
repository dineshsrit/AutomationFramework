package com.srit.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.enums.WaitStrategy;

public class ExplicitWaitFactory {

	
	
	public static WebElement performExplicityWait(WaitStrategy waitstatergy, By by)
	{
	
	WebElement element=null;
	{
		if(waitstatergy == WaitStrategy.CLICKABLE )
		{
		 element=	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.elementToBeClickable(by));
			
		}
		else if (waitstatergy == WaitStrategy.PRESENCE)
		{
		element =	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
		else if(waitstatergy==WaitStrategy.NONE)
		{
			DriverManager.getDriver().findElement(by);
		}
		return element;
	
}
	}
}