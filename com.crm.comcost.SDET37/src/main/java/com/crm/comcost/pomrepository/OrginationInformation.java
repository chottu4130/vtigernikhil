package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class OrginationInformation extends WebDriverUtility
{
	WebDriver driver;
	public OrginationInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "/html[1]/body[1]/table[3]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[2]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[5]/input[3]")
	//@FindBy (name = "Delete")
	private WebElement deletebutton;
	
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement orginationInfo;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	@FindBy (id = "dtlview_Organization Name")
	private WebElement info;
	
    public WebElement getInfo() {
		return info;
	}

	

	public WebDriver getDriver() {
		return driver;
	}

	//-------------------------------------------------
	public WebElement getDeletebutton() 
	{
		return deletebutton;
	}

	public WebElement getOrginationInfo() 
	{
		return orginationInfo;
	}
	
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	
	//----------------------------------------------
	
	
	public void clickOndeleteButton() throws InterruptedException
	{
		//waitForElementInDOM(driver);
		//Thread.sleep(2000);
		deletebutton.click();
		swithToAlertWindowAndAccpect(driver, "Deleting this account will remove its related Opportunities & Quotes");
		
	}
	
	public void information()
	{
		orginationInfo.getText();
		
	}
	public void inform(String orginationName)
	{
		String te=info.getText();
		Assert.assertTrue(te.contains(orginationName));
	}
	
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
}
