package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.comcost.genericeutlity.WebDriverUtility;
/**
 * 
 * @author NIKHIL RAJ
 *
 */
public class CreateNewContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "lastname")
	private WebElement getLastName;
	
	@FindBy (xpath = "//input[@name='account_id']/../img")
	private WebElement getOrginationName;
	
	@FindBy (id = "search_txt")
	private WebElement getSearchOrginationName;
	
	@FindBy (name = "search")
	private WebElement getSearchNowOrginationName;
	
	
	@FindBy (id = "1")
	private WebElement clickOnOrginationName;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement getSaveButton;
	
	@FindBy (id = "1")
	private WebElement clickVenderName;
	
	
	@FindBy (xpath = "(//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement clickonsignout;
	
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement valisation;
	//---------------------------------------
	public WebDriver getDriver() 
	{
		return driver;
	}
	public WebElement getGetLastName() 
	
	{
		return getLastName;
	}
	public WebElement getGetOrginationName()
	{
		return getOrginationName;
	}
	
	public WebElement getValisation() {
		return valisation;
	}
	
	public WebElement getGetSearchOrginationName() 
	{
		return getSearchOrginationName;
	}
	public WebElement getGetSearchNowOrginationName() 
	
	{
		return getSearchNowOrginationName;
	}
	public WebElement getClickOnOrginationName()
	{
		return clickOnOrginationName;
	}
	public WebElement getGetSaveButton() 
	{
		return getSaveButton;
	}
	public WebElement getSignout()
	{
		return signout;
	}
	public WebElement getClickonsignout() 
	{
		return clickonsignout;
	}
	//---------------------------------------------
	public void withMandateryFild(String lastname)
	{
		getLastName.sendKeys(lastname);
	}
	public void withOrginationField(String childWindowTitle, String enterOrginationName,String partialWindowTitle)
	{
		
		getOrginationName.click();
		swithToWindow(driver, childWindowTitle);
		getSearchOrginationName.sendKeys(enterOrginationName);
		getSearchNowOrginationName.click();
		clickOnOrginationName.click();
		swithToWindow(driver, partialWindowTitle);
					
	}
	public void clickOnsaveButton()
	{
		getSaveButton.click();
		
	}
	public void signoutAction()
	{
		mouseOverOnElement(driver,signout);
		clickonsignout.click();
	}
	
	public void validationof(String lastname)
	{
		String text=valisation.getText();
		Assert.assertTrue(text.contains(lastname));
		
	}
	
	
	
}
