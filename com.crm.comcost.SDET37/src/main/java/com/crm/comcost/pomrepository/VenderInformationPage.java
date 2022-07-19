package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class VenderInformationPage extends WebDriverUtility
{
	WebDriver driver;
	public VenderInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement delete;
	
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement information;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	@FindBy (id = "dtlview_Vendor Name")
	private WebElement info;
	
	

	

	//------------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getDelete() 
	{
		return delete;
	}

	public WebElement getInformation() 
	{
		return information;
	}

	public WebElement getSignout()
	{
		return signout;
	}

	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	
	public WebElement getInfo() 
	{
		return info;
	}
	
	//-----------------------------
	
	public void clickondelete()
	{
		delete.click();
	}
	
	public void information()
	{
		String text=information.getText();
		Assert.assertTrue(text.contains("Vendor Information "));
	}
	
	
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	public void inf(String vendorName)
	{
		String text=info.getText();
		Assert.assertTrue(text.contains(vendorName));
		
	}
}
