package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class ProductInformationPage extends WebDriverUtility
{
	WebDriver driver;
	
	public ProductInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement delitbutton;
	
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement information;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
//-------------------------
	public WebElement getDelitbutton() 
	{
		return delitbutton;
	}

	public WebElement getInformation() 
	{
		return information;
	}
	
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	//----------------------------
	
	public void cliclkOnDelete()
	{
		delitbutton.click();
		swithToAlertWindowAndAccpect(driver,"Are you sure you want to");
	}
	
	public void information()
	{
		information.getText();
	}
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
	
}
