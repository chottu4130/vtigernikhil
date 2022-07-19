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


public class ListenerImplemination extends BaseClass implements ITestListener
{
	

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
		    EventFiringWebDriver eve=new EventFiringWebDriver(driver);
		    File src=eve.getScreenshotAs(OutputType.FILE);
			
		    File dst=new File("./errorScreenshort/"+withtitle+"_"
				+JavaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_ssss")+".png");
		   try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
		
}
	

