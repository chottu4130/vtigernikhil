package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreatePurchaseOrderPage extends WebDriverUtility

{
	WebDriver driver;
	public CreatePurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@alt='Create Purchase Order...']")
	private WebElement purchaseorder;
	
	@FindBy (name = "search_text")
	private WebElement searchfor;
	
	@FindBy (name = "submit")
	private WebElement searchnow;
	
	
	//---------------------------
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getPurchaseorder() 
	{
		return purchaseorder;
	}

	public WebElement getSearchfor() 
	{
		return searchfor;
	}

	public WebElement getSearchnow() 
	{
		return searchnow;
	}
	
	//-----------------------------------
	
	public void clickonPurchaseorder()
	
	{
		purchaseorder.click();
	}
	
	public void searchFor(String purchaseorder)
	{
		searchfor.sendKeys(purchaseorder);
	}
	
	public void searchNow()
	{
		searchnow.click();
	}
}
