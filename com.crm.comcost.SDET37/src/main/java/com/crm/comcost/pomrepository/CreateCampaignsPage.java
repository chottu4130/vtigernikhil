package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage 

{
	WebDriver driver;
	public CreateCampaignsPage(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaigns;
	
	@FindBy (name = "search_text")
	private WebElement searchFor;
	
	@FindBy (name = "submit")
	private WebElement searchNow;
	
	
	//--------------------------
	
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getCampaigns()
	{
		return campaigns;
	}

	public WebElement getSearchFor() 
	{
		return searchFor;
	}

	public WebElement getSearchNow()
	{
		return searchNow;
	}
	//---------------------------------
	
	
	public void createcampaigns()
	{
		campaigns.click();
	}
	
	public void searchfor(String campainsno)
	{
		searchFor.sendKeys(campainsno);
	}
	
	public void searchnow()
	{
		searchNow.click();
	}
	
	
	
}
