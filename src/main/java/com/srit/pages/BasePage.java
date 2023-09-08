package com.srit.pages;

import java.time.Duration;
import java.util.List;

import com.srit.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.enums.WaitStrategy;
import com.srit.factories.ExplicitWaitFactory;

public  class BasePage {

	protected BasePage()
	{
		
	}
	
	protected void click(By by, WaitStrategy waitstatergy )
	{
		WebElement element =ExplicitWaitFactory.performExplicityWait(waitstatergy, by);
		
		element.click();
	
	}
	
	protected void sendkeys(By by, String key, WaitStrategy waitstatergy)
	{
	  WebElement element =ExplicitWaitFactory.performExplicityWait(waitstatergy, by);
	  element.sendKeys(key);
	}

	protected void clear(By by, WaitStrategy waitstatergy)
	{
		WebElement element =ExplicitWaitFactory.performExplicityWait(waitstatergy, by);
		element.clear();
	}
	protected String getElementText(By by, WaitStrategy waitStrategy)
	{
	WebElement element=	ExplicitWaitFactory.performExplicityWait(waitStrategy, by);
	return element.getText();

	}
	
	protected String getPageTitle()
	{
		return DriverManager.getDriver().getTitle();
	}

	protected WebElement getWebElement(By by)
	{
		return DriverManager.getDriver().findElement(by);
	}

	protected List<WebElement> getListofElements(By by)
	{
		return DriverManager.getDriver().findElements(by);
	}



}
