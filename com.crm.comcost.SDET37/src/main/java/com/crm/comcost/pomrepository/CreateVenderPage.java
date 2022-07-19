package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateVenderPage extends WebDriverUtility

{
   WebDriver driver;
   
   public CreateVenderPage(WebDriver driver)
   {
	   this.driver=driver;
		PageFactory.initElements(driver, this);

   }
	@FindBy (xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVender;
	
	@FindBy (name = "search_text")
	private WebElement searchfor;
	
	@FindBy (name = "submit")
	private WebElement searchnow;
//------------------------------------------------
	public WebElement getCreateVender() 
	{
		return createVender;
	}

	public WebElement getSearchfor() 
	{
		return searchfor;
	}

	public WebElement getSearchnow() 
	{
		return searchnow;
	}
	
	//-----------------------------------------------------
	
	
	public void clickcreateVender()
	{
		createVender.click();
	}
	
	public void clickOnsearchfor(String searchvendername)
	{
		searchfor.sendKeys(searchvendername);
	}
	
	public void clickonsearchnow()
	{
		searchnow.click();
	}
	
}
