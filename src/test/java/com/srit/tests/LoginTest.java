package com.srit.tests;

import com.srit.config.DataproviderUtils;
import com.srit.listeners.RetryFailedTests;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srit.config.PropertyUti;
import com.srit.driver.DriverManager;
import com.srit.enums.ConfigProperties;
import com.srit.pages.HomePage;
import com.srit.pages.LoginPage;

import java.util.Map;

public class LoginTest extends BaseTest {

	private LoginTest()
	{
		
	}

	@Test(dataProvider = "getData", dataProviderClass = DataproviderUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void logintest(Map<String, String> data) throws Exception
	{
		//ExtentReport.createTest("Login Test");
		//DriverManager.getDriver().get(PropertyUti.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		HomePage hp=new LoginPage().enter_username("tdr.bargarh").enter_password("Pass@1231").clickLogin();
		//hp.dashBoardWidgetClick();
		
			Assertions.assertThat(hp.verifyhomePage())
			.containsIgnoringCase("Dashboard Widgets");
		
}
	
	@Test(dataProvider = "getData", dataProviderClass = DataproviderUtils.class, retryAnalyzer = RetryFailedTests.class)
	public void newtest(Map<String, String> data) throws Exception
	{
		//ExtentReport.createTest("Login Test");
		//DriverManager.getDriver().get(PropertyUti.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		HomePage hp=new LoginPage().enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin();
		//hp.dashBoardWidgetClick();
		
			Assertions.assertThat(hp.verifyhomePage())
			.containsIgnoringCase("Dashboard Widgets");
		
}
	
	/*@DataProvider(name="logintestdata", parallel=true)
	public Object[][] getdata()
	{
		
		return new Object[][]{
			{"csc1.sundar", "Pass@123"},
			{"tdr.bargarh", "Pass@123"},
			{"tdr1.bonai", "Pass@1231"}
		};
		
	}*/

}