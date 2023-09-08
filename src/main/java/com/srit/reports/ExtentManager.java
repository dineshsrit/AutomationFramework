package com.srit.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	
	private ExtentManager()
	{
		
	}
	
	
	private static ThreadLocal<ExtentTest> ext= new ThreadLocal<ExtentTest>();
	
	 static ExtentTest getExtentTest()
	{
	return  ext.get();
			
	}
 	

	 static void setExtentTest(ExtentTest extref)
	{
		ext.set(extref);
	}
	
	 static void unLoad()
	{
		ext.remove();
	}

}
