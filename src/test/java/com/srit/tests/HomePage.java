package com.srit.tests;

import org.testng.annotations.Test;

import com.srit.config.PropertyUti;
import com.srit.driver.DriverManager;
import com.srit.enums.ConfigProperties;

public final class HomePage extends BaseTest {
	
	
	private  HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() throws Exception
	{
		DriverManager.getDriver().get(PropertyUti.get(ConfigProperties.URL));
	}

	@Test
	public void test1() throws Exception
	{
		DriverManager.getDriver().get(PropertyUti.get(ConfigProperties.URL));
	}
	
	
}
