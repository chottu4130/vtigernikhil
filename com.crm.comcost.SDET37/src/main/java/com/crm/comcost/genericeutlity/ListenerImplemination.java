package com.crm.comcost.genericeutlity;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplemination implements ITestListener
{
	private ExtentReports reports;
	private ExtentTest test;	
	public static ExtentTest testReport;

	//@BeforeMethod
	public void onTestStart(ITestResult result)
	{
		test=reports.createTest(result.getMethod().getMethodName());
		testReport =test;
	}

	//@AfterMethod
	public void onTestSuccess(ITestResult result) 
	{
		test.pass(result.getMethod().getMethodName()+" is pass");
	}

	//@AfterMethod
	public void onTestFailure(ITestResult result) 
	{
		
		/*
		public void takeScreenShortPage(WebDriver driver,JavaUtility javaUtility) throws IOException
		{
			String withtitle=driver.getTitle();
			TakesScreenshot ts=(TakesScreenshot)driver;
		    File src=ts.getScreenshotAs(OutputType.FILE);
			
		   File dst=new File("./errorScreenshort/"+withtitle+"_"
				+JavaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_ssss")+".png");
		   FileUtils.copyFile(src, dst);   
		}
		*/
	
			String withtitle=result.getMethod().getMethodName();
		   // EventFiringWebDriver eve=new EventFiringWebDriver(driver);
		    //File src=eve.getScreenshotAs(OutputType.FILE);
			TakesScreenshot ts=(TakesScreenshot)BaseClass.ldriver;
		    File src=ts.getScreenshotAs(OutputType.FILE);
		   
			
		    File dst=new File("./errorScreenshort/"+withtitle+"_"
				+JavaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_ssss")+".png");
		    String path = dst.getAbsolutePath();
		   try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   test.fail(result.getMethod().getMethodName()+" is fail");
			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath(path);
		
	}

	//@AfterMethod
	public void onTestSkipped(ITestResult result) 
	{
		test.skip(result.getMethod().getMethodName()+" is skip");
		test.skip(result.getThrowable());
	}

	//@AfterMethod
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
			
	}

	//@AfterMethod
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	//@BeforeTest
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./extent_output/emailable-extentReport.html");
		spark.config().setDocumentTitle("Extent report Document title");
		spark.config().setReportName("Report Name of ExtentReport");
		spark.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Reporter name","Nikhil raj");
		reports.setSystemInfo("platform", "window 10");
		reports.setSystemInfo("Browser", "chrome");
		
		
		
	}

	//@AfterTest
	public void onFinish(ITestContext context) 
	{
		
		reports.flush();

	}
	

	
		
}
	

