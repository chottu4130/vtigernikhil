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
public class ContactsInformationPage extends WebDriverUtility
{
	WebDriver driver;
	public ContactsInformationPage(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "(//input[@title='Duplicate [Alt+U]']/../input[3])[1]")
	private WebElement delitbutton;
	
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsInformation;
	
	
	//---------------------
	public WebElement getDelitbutton() 
	{
		return delitbutton;
	}
	public WebElement getContactsInformation()
	{
		return contactsInformation;
	}
	
	//-------------------------------------------
	public void clickOndelitButtin() throws InterruptedException
	{
		delitbutton.click();
		swithToAlertWindowAndAccpect(driver, "Deleting this account will remove its ");
	}
	
	public void information(String orginationName)
	{
		String text=contactsInformation.getText();
		Assert.assertTrue(text.contains(orginationName));
	}
	
	
}
