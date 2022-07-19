package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;
/**
 * 
 * @author NIKHIL RAJ
 *
 */
public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (linkText  = "Contacts")
	private WebElement contactlink;
	
	@FindBy (linkText = "Products")
	private WebElement productlink;
	
	@FindBy (linkText = "Organizations")
	private WebElement organizationlink;
	
	@FindBy (xpath = "//a[text()='More']")
	private WebElement moreAction;
	
	@FindBy (xpath = "//a[text()='Campaigns']")
	private WebElement campaignslink;
	
	@FindBy (xpath = "//a[text()='Purchase Order']")
	private WebElement purchaseOrderlink;
	
	@FindBy (xpath = "//a[text()='Vendors']")
	private WebElement venderlink;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	//--------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getContactlink() 
	{
		return contactlink;
	}
	public WebElement getProductlink() 
	{
		return productlink;
	}
	public WebElement getOrganizationlink() 
	
	{
		return organizationlink;
	}
	public WebElement getMoreAction()
	{
		return moreAction;
	}
	public WebElement getCampaignslink()
	{
		return campaignslink;
	}
	public WebElement getPurchaseOrderlink()
	{
		return purchaseOrderlink;
	}
	public WebElement getVenderlink() 
	{
		return venderlink;
	}
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	
	//---------------------------------
	public void clickOnContacts() 
	{
		contactlink.click();
	}
	public void clickOnProducts() 
	{
		productlink.click();
	}
	public void clickOnOrgination()
	{
		organizationlink.click();
	}
	public void clickOncampaigns()
	{
		mouseOverOnElement(driver,moreAction);
		campaignslink.click();
	}
	public void clickOnpurchaseOrder()
	{
		mouseOverOnElement(driver,moreAction);
		purchaseOrderlink.click();
	}
	public void clickOnvender()
	{
		mouseOverOnElement(driver,moreAction);
		venderlink.click();
	}
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
	
	
	/*
	public WebElement getContactlink()
	{
		return contactlink;
	}
	public WebElement getProductlink() 
	{
		return productlink;
	}
	public WebElement getOrganizationlink() 
	{
		return organizationlink;
	}
	public void clickOnContacts() 
	{
		contactlink.click();
	}
	public void clickOnProducts() 
	{
		productlink.click();
	}
	public void clickOnOrgination()
	{
		organizationlink.click();
	}
	*/
}
