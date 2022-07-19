package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateOrginationPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateOrginationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//img[@alt='Create Organization...']")
	private WebElement clickOnCreateOrgination;
	
	@FindBy (name = "search_text")
	private WebElement searchForOrgination;
	
	@FindBy (name = "submit")
	private WebElement getSearchNow;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	
	//----------------------
	public WebElement getClickOnCreateOrgination() 
	{
		return clickOnCreateOrgination;
	}
	public WebElement getSearchForOrgination() 
	{
		return searchForOrgination;
	}
	public WebElement getGetSearchNow() 
	{
		return getSearchNow;
	}
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	
	//-----------------------------
	public void ClickOnCreateOrgination()
	{
		clickOnCreateOrgination.click();
	}
	public void enterOrginationName(String orginationName)
	{
		searchForOrgination.sendKeys(orginationName);
	}
	public void clickOnSearchNow()
	{
		getSearchNow.click();
	}
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
	
}
