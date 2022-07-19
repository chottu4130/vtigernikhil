package com.crm.comcost.genericeutlity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author nikhil
 */
public class JavaUtility 
{
	
	WebDriver driver;
	/**
	 * its used to generate random numbrt
	 * @return int data
	 */
	public int getRanDomNumber()
	{
		Random random=new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
		
	}
	/**
	 * used to get system date & time in IST format
	 * @return
	 */
	public String getSystemdateAndTime()
	{
		Date date =new Date();
		return date.toString();
		
	}
	/**
	 * used to get system date in YYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormate()
	{
		Date date=new Date();
		String dateAndTime=date.toString();
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormate = YYYY+"-"+MM+"-"+DD;
		return finalFormate;
		
		
	}
	
	public static String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
		
	}
	
	
	
	
	}


