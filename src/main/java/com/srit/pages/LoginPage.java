package com.srit.pages;

import org.openqa.selenium.By;

import com.srit.enums.WaitStrategy;
import com.srit.reports.ExtentLogger;

public final class LoginPage  extends BasePage{
	
	private final By textbox_username=By.id("mat-input-0");
	private final By textbox_password=By.id("mat-input-1");
	private final By button_login=By.xpath("//button[@type='submit']");
	
	public LoginPage enter_username(String username) throws Exception
	{
		sendkeys(textbox_username, username, WaitStrategy.PRESENCE);
		ExtentLogger.pass("entered the user name", true);

		return this;
		
	}
	
	public LoginPage enter_password(String password) throws Exception
	{
		sendkeys(textbox_password, password, WaitStrategy.PRESENCE);
		ExtentLogger.pass("password entered", true);

		return this;
	}	
	
	public HomePage clickLogin() throws Exception
	{
		click(button_login, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("clicked on homepage", true);
	    return new HomePage();
	}
	
}
