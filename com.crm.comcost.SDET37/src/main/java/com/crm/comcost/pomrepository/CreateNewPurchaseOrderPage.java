package com.crm.comcost.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcost.genericeutlity.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "subject")
	private WebElement subject;
	
	@FindBy (xpath = "(//img[@title='Select'])[1]")
	private WebElement vendername;
	
	@FindBy (id = "search_txt")
	private WebElement venderName;
	
	@FindBy (name = "search")
	private WebElement searchnowvender;
	
	@FindBy (id = "1")
	private WebElement clickonvendername;
	
	@FindBy (xpath = "(//img[@title='Select'])[2]")
	private WebElement contactname;
	
	@FindBy (id = "search_txt")
	private WebElement contactName;
	
	@FindBy (name = "search")
	private WebElement searchnowcontact;
	
	@FindBy (id = "1")
	private WebElement clickoncontact;
	
	@FindBy (name = "bill_street")
	private WebElement bulldingaddres;
	
	@FindBy (name = "ship_street")
	private WebElement shippingaddres;
	
	@FindBy (id = "searchIcon1")
	private WebElement itemname;
	
	@FindBy (id = "search_txt")
	private WebElement product;
	
	@FindBy (name = "search")
	private WebElement searchnow;
	
	@FindBy (xpath = "//input[@name='selected_id']/../../td[2]/a")
	private WebElement clickonproduct;
	
	@FindBy (id = "qty1")
	private WebElement qty;
	
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement save;
	

	//------------------------------------------------------
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getSubject() 
	{
		return subject;
	}

	public WebElement getVendername()
	{
		return vendername;
	}

	public WebElement getVenderName()
	{
		return venderName;
	}

	public WebElement getSearchnowvender() 
	{
		return searchnowvender;
	}

	public WebElement getClickonvendername() 
	{
		return clickonvendername;
	}

	public WebElement getContactname()
	{
		return contactname;
	}

	public WebElement getContactName() 
	{
		return contactName;
	}

	public WebElement getSearchnowcontact()
	{
		return searchnowcontact;
	}

	public WebElement getClickoncontact() 
	{
		return clickoncontact;
	}

	public WebElement getBulldingaddres() 
	{
		return bulldingaddres;
	}

	public WebElement getShippingaddres() 
	{
		return shippingaddres;
	}

	public WebElement getItemname()
	{
		return itemname;
	}

	public WebElement getProduct()
	{
		return product;
	}

	public WebElement getSearchnow()
	{
		return searchnow;
	}

	public WebElement getClickonproduct()
	{
		return clickonproduct;
	}

	public WebElement getQty()
	{
		return qty;
	}
	
	public WebElement getSave()
	{
		return save;
	}
//---------------------------------------------	
	
	public void entertsubject(String subjectname)
	{
		subject.sendKeys(subjectname);
	}
	
	public void clickonvender(String childWindowTitle,String entervenderName,String partialWindowTitle)
	{
		vendername.click();
		swithToWindow(driver, childWindowTitle);
		venderName.sendKeys(entervenderName);
		searchnowvender.click();
		clickonvendername.click();
		swithToWindow(driver, partialWindowTitle);
	}
	
	public void clickoncontactname(String childWindowTitle,String entercontactname,String partialWindowTitle)
	{
		contactname.click();
		swithToWindow(driver, childWindowTitle);
		contactName.sendKeys(entercontactname);
		searchnowvender.click();
		
		clickoncontact.click();
		swithToAlertWindowAndAccpect(driver, "Overwrite the existing address with this selected");
		swithToWindow(driver, partialWindowTitle);
	}
	
	public void enterbulldingaddres(String bulldingAddres)
	{
		bulldingaddres.sendKeys(bulldingAddres);
	}
	
	public void entershippingaddres(String shippingAddres)
	{
		shippingaddres.sendKeys(shippingAddres);
	}
	
	public void clickonitemname(String childWindowTitle,String enterproduct,String partialWindowTitle)
	{
		itemname.click();
		swithToWindow(driver,childWindowTitle);
		product.sendKeys(enterproduct);
		searchnow.click();
		clickonproduct.click();
		swithToWindow(driver, partialWindowTitle);
	}
	public void enterqty(String enterqty)
	{
		qty.sendKeys(enterqty);
	}
	
	public void clickonsave()
	{
		save.click();
	}
	
	
	
	
	
	
	
	
	
}
