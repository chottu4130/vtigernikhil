package com.crm.comcost.genericeutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver ldriver;
	
	
	/*Object Creation for Lib*/
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUTility flib = new FileUTility();
	public ExcelUtlity elib = new ExcelUtlity();
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS()
	
	{
		System.out.println("--------conaction to data base----------");
		
	}
	
	//@Parameters("browser")
//	@BeforeClass(groups = {"smoke","regration"})
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable 
	{
	System.out.println("-----------Launch the Browser---------------");
	//driver = new ChromeDriver();
	Reporter.log("open browser",true);
	String browser=flib.getPropertyKeyValue("browser");
	if(browser.equalsIgnoreCase("chrome"))
	    driver=new ChromeDriver();
	else if(browser.equalsIgnoreCase("firefox"))
	    driver=new FirefoxDriver();
	else
		driver=new ChromeDriver();	
	wlib.waitForElementInDOM(driver);
	ldriver=driver;
	driver.manage().window().maximize();
	}
	
	
	//@BeforeMethod(groups = {"smoke","regration"})
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
	    String url=flib.getPropertyKeyValue("url");
		String un=flib.getPropertyKeyValue("username");
		String pw=flib.getPropertyKeyValue("password");
		LoginPage login= new LoginPage(driver);
		login.loginVtiger(url, un, pw);
		
		
	}
	
	
	//@AfterMethod(groups = {"smoke","regration"})
	@AfterMethod(alwaysRun = true)
	public void configAM()
	
	{
		HomePage home=new HomePage(driver);
		home.signoutAction();
	}
	
	//@AfterClass(groups = {"smoke","regration"})
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
	     System.out.println("---------------Close the Browser------------");
	     driver.quit();
	}
	
	
	
	
	@AfterSuite public void configAS()
	{
	     System.out.println("-------------close data base------------------------");
	}
	
}
