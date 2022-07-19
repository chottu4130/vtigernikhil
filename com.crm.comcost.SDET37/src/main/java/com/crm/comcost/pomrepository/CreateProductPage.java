package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//img[@alt='Create Product...']")
	private WebElement createProduct;
	
	@FindBy (name = "search_text")
	private WebElement searchfor;
	
	@FindBy (name = "submit")
	private WebElement searchNow;
	
	
	
	//----------------------------------------
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getCreateProduct()
	{
		return createProduct;
	}

	public WebElement getSearchfor()
	{
		return searchfor;
	}

	public WebElement getSearchNow() 
	{
		return searchNow;
	}
	//-----------------------------------------------
	
	public void clickOnCreateProduct()
	{
		createProduct.click();
	}
	
	public void searchForProduct(String productName)
	{
		searchfor.sendKeys(productName);
	}
	
	public void clickOnsearchNow()
	{
		searchNow.click();
	}
	
	
}
