package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateNewOrginationPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewOrginationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (name = "accountname")
	private WebElement getOrginationName;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement save;
	
	

	//----------------------
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getGetOrginationName() 
	{
		return getOrginationName;
	}
	
	public WebElement getSave() 
	{
		return save;
	}

	
	//-------------------------------
	
	
	
	public void sendOrginationName(String orginationName)
	{
		getOrginationName.sendKeys(orginationName);
	}
	
	public void clickonsave()
	{
		save.click();
	}
	
	
}
