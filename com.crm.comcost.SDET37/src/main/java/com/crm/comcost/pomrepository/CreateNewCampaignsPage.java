package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateNewCampaignsPage extends WebDriverUtility
{
	
	WebDriver driver;
	public CreateNewCampaignsPage(WebDriver driver  )
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "campaignname")
	private WebElement csmpainName;
	
	@FindBy (xpath = "//img[@title='Select']")
	private WebElement product;
	
	@FindBy (id = "search_txt")
	private WebElement searchproduct;
	
	@FindBy (name = "search")
	private WebElement searchNow;
	
	@FindBy (id = "1")
	private WebElement clickOnproduct;
	
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement save;
	
	//----------------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}


	public WebElement getCsmpainName() 
	{
		return csmpainName;
	}


	public WebElement getProduct() 
	
	{
		return product;
	}


	public WebElement getSearchproduct() 
	{
		return searchproduct;
	}


	public WebElement getSearchNow() 
	{
		return searchNow;
	}


	public WebElement getClickOnproduct() 
	{
		return clickOnproduct;
	}
	
	
	public WebElement getSave() {
		return save;
	}
	
	//--------------------------------
	
	public void entercsmpainName(String csmpainname)
	{
		csmpainName.sendKeys(csmpainname);
	}
	
	public void clickonproduct(String childWindowTitle,String productname,String partialWindowTitle)
	{
		product.click();
		swithToWindow(driver, childWindowTitle);
		searchproduct.sendKeys(productname);
		searchNow.click();
		clickOnproduct.click();
		swithToWindow(driver, partialWindowTitle);
		
	}
	
	public void clickonSaveButton()
	{
		save.click();
	}
	
	
	
}
