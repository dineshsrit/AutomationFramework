package com.srit.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.srit.constants.FrameworkConstants;

public final  class ExtentReport {

	
	
	private ExtentReport()
	{
		
	}
	
	private static ExtentReports extent;
	public static ExtentTest test;
	public static void initReports() throws Exception
	{
		
		if(Objects.isNull(extent))
		{
		 extent= new ExtentReports();
		 System.out.println("the extent report file path:"+ FrameworkConstants.getExtentreportpath());
		 ExtentSparkReporter spark= new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
		
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("AutomationReport");
		spark.config().setReportName("Sample report");

	}
	
	}
	public static void flushReports() throws Exception
	{
		if(Objects.nonNull(extent))
		{
		extent.flush();
		}
		ExtentManager.unLoad();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
	}
	


public static  void createTest(String testcasename) throws IOException
{
	 test=	extent.createTest(testcasename);
	ExtentManager.setExtentTest(test);

	
}

}
