package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateNewVenderPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewVenderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "vendorname")
	private WebElement vendorname;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement save;
	
	//-------------------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getVendorname() 
	{
		return vendorname;
	}

	public WebElement getSave() 
	{
		return save;
	}
	
	
	//-------------------------------
	
	public void entervendorname(String vendorName)
	{
		vendorname.sendKeys(vendorName);
	}
	
	public void clickonsave()
	{
		save.click();
	}
}
