package com.crm.comcost.genericeutlity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

/**
 *  its contains WebDriver specific reusable actions 
 * @author nikhil
 *
 */

public class WebDriverUtility 
{
	
	WebDriver driver;
	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} 
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForElement(WebDriver driver ,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) 
	{
	       Set<String>set = driver.getWindowHandles();
	       Iterator<String>it = set.iterator();

	while (it.hasNext()) 
	{
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) 
			{
				break;
		     }
		}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) 
	{
		Alert alt = driver.switchTo().alert();
	
		if(alt.getText().contains(expectedMsg)) 
		{
			System.out.println("Alert Message is verified");
		}
		else
		{
			System.out.println("Alert Message is not verified");
		 }
		
		alt.accept();
	}
	
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equals(expectedMsg)) 
		{
			System.out.println("Alert Message is verified");
		}
		else 
		{
			System.out.println("Alert Message is not verified");
		 }
		alt.dismiss();
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) 
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) 
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @paramjavaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void waitAndClick(WebElement element) throws InterruptedException 
	   {
		int count=0;
		while(count<20)
			try
		      {
			   element.click();
			   break;
		      }
		      catch(Throwable e)
		   {
			Thread.sleep(1000);
			count++;
		   }
	   }
	

	
	/**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	public void passEnterKey(WebDriver driver)
		{
		   Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	   }
	
	
	public void takescreenshort(WebDriver driver,ITestResult result) 
	{
		
	     	String withtitle=result.getMethod().getMethodName();
		   // EventFiringWebDriver eve=new EventFiringWebDriver(driver);
		    //File src=eve.getScreenshotAs(OutputType.FILE);
			TakesScreenshot ts=(TakesScreenshot)driver;
		    File src=ts.getScreenshotAs(OutputType.FILE);
			
		    File dst=new File("./errorScreenshort/"+withtitle+"_"
				+JavaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_ssss")+".png");
		   try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

		

}
