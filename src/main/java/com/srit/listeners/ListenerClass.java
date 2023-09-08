package com.srit.listeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.srit.reports.ExtentLogger;
import com.srit.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	public void onStart(ISuite suite) {
		
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		try {
			ExtentReport.createTest(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() +" "+ "is Passed");
	
	}

	public void onTestFailure(ITestResult result) {
	
		//ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed");
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() +" "+ "is Failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		ExtentLogger.skip(result.getMethod().getMethodName() + "is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		/*ExtentReport.initReports();*/
	
	}

	public void onFinish(ITestContext context) {
		/*try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	}




	}


