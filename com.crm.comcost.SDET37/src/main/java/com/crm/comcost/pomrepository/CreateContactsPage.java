package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateContactsPage(WebDriver driver )
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//img[@alt='Create Contact...']")
	private WebElement getCreateContact;
	
	@FindBy (name = "search_text")
	private WebElement getSearchFor;
	
	@FindBy (name = "submit")
	private WebElement getSearchnow;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	//=========================
	public WebElement getGetCreateContact() 
	{
		return getCreateContact;
	}
	public WebElement getGetSearchFor() 
	{
		return getSearchFor;
	}
	public WebElement getGetSearchnow() 
	{
		return getSearchnow;
	}
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	//================================
	public void createContact() 
	{
		getCreateContact.click();
	}
	public WebElement searchFor(String searchfor,WebDriver driver ,WebElement element)
	{
		getSearchFor.sendKeys(searchfor);
		waitForElement(driver ,element);
		return element;
	}
	public void searchNow()
	{
		getSearchnow.click();
	}
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
	
}
