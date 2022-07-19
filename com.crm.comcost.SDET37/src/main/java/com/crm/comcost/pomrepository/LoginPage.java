package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;
/**
 * 
 * @author NIKHIL RAJ
 *
 */
public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="user_name")
	private WebElement uaerNameEdt;
	@FindBy (name="user_password")
	private WebElement uaerPwd;
	@FindBy (id="submitButton")
	private WebElement loginbutton;
	
	public WebElement getUaerNameEdt()
	{
		return uaerNameEdt;
	}
	public WebElement getUaerPwd() 
	{
		return uaerPwd;
	}
	public WebElement getLoginbutton()
	{
		return loginbutton;
	}
	
	public void loginVtiger(String url,String usename,String password) 
	{
		driver.get(url);
		uaerNameEdt.sendKeys(usename);
		uaerPwd.sendKeys(password);
		loginbutton.click();
	}
	
	
	

	
}
