package com.srit.driver;

import java.io.File;
import java.util.Objects;

import com.srit.config.PropertyUti;
import com.srit.enums.ConfigProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.srit.constants.FrameworkConstants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static WebDriver driver;
	
	
	public static void initDriver() throws Exception {
		//System.out.println(Thread.currentThread().getId()+" : " +Driver.driver );
		if(Objects.isNull(DriverManager.getDriver()))
		{

			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
			ChromeOptions options=new ChromeOptions();
			options.addExtensions(new File (FrameworkConstants.getSignerPath()));
			driver = new ChromeDriver(options);
			DriverManager.setDriver(driver);

			/*if (browser.equalsIgnoreCase("null"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}

			else if(browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				//System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}*/

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUti.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		DriverManager.getDriver().quit();
		DriverManager.unLoad();
	}

	/*public static WebDriver getDriver()
	{
		return driver;
		
	}*/
}
