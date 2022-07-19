package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class PurchaseOrderInformantionPage extends WebDriverUtility
{
	WebDriver driver;
	public PurchaseOrderInformantionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement delet;
	
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement informantion;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	
	//---------------------------
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getDelet()
	{
		return delet;
	}

	public WebElement getInformantion() 
	{
		return informantion;
	}
	
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	//-------------------------------------
	
	public void clickondelet()
	{
		delet.click();
		swithToAlertWindowAndAccpect(driver,"Are you sure you want to delete");
	}
	
	
	public void informantion()
	{
		String text=informantion.getText();
		Assert.assertTrue(text.contains("Purchase Order Information"));
	}
	
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
}
