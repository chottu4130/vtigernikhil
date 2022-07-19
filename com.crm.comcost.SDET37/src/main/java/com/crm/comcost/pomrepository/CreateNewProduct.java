package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateNewProduct extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (name = "productname")
	private WebElement productName;
	
	@FindBy (xpath = "//img[@title='Select']")
	private WebElement venderName;
	
	@FindBy (id = "search_txt")
	private WebElement searchvender;
	
	@FindBy (name = "search")
	private WebElement searchNow;
	
	
	@FindBy (id = "1")
	private WebElement clickVenderName;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;
	
	
	//============================
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getProductName() 
	{
		return productName;
	}

	public WebElement getVenderName()
	{
		return venderName;
	}

	public WebElement getSearchvender() 
	{
		return searchvender;
	}

	public WebElement getSearchNow()
	{
		return searchNow;
	}

	public WebElement getClickVenderName() 
	{
		return clickVenderName;
	}

	public WebElement getSavebutton() 
	{
		return savebutton;
	}
	
	//------------------------------------------------
	public void enterProductname(String enterproductName)
	{
		productName.sendKeys(enterproductName);
	}
	
	public void venderWithProduct(String childWindowTitle,String enterVenderName,String partialWindowTitle)
	{
		venderName.click();
		swithToWindow(driver, childWindowTitle);
		searchvender.sendKeys(enterVenderName);
		searchNow.click();
		clickVenderName.click();
		swithToWindow(driver, partialWindowTitle);
		
	}
	
	public void ClickOnsaveButton()
	{
		savebutton.click();
	}
	
	

	
}
