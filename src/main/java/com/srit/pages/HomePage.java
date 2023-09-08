package com.srit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srit.enums.WaitStrategy;
import com.srit.waits.Wait;

public final class HomePage extends BasePage{

	//WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	
	
	private final By dashboardwidgets=By.linkText("Dashboard Widgets");


	
	
	public String verifyhomePage()
	{
	return Wait.getWait().until(ExpectedConditions.visibilityOfElementLocated(dashboardwidgets)).getText();
	}
	
	
	
	public void dashBoardWidgetClick()
	{
	
		click(dashboardwidgets, WaitStrategy.CLICKABLE);

	}


	

}
