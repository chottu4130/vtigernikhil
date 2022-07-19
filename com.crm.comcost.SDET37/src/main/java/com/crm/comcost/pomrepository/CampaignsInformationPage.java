package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CampaignsInformationPage extends WebDriverUtility
{
	WebDriver driver;
	public CampaignsInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement delete;
	
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement campaignInformation;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	
	//-----------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getDelete()
	{
		return delete;
	}

	public WebElement getCampaignInformation() 
	{
		return campaignInformation;
	}
	
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
//-----------------------------------------------
	
	public void clickOndeleteButton()
	{
		delete.click();
		
	}
	
	public void campaigninformation()
	{
		campaignInformation.getText();
	}
	
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
}
