package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.pomrepository.ContactsInformationPage;
import com.crm.comcost.pomrepository.CreateCampaignsPage;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewContactsPage;
import com.crm.comcost.pomrepository.HomePage;

public class Sampal extends BaseClass
{
	@Test
	public void createContTest() throws Throwable
	{
		
		
		String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnContacts();
		CreateContactsPage cc=new CreateContactsPage(driver);
		cc.createContact();
		CreateNewContactsPage c=new CreateNewContactsPage(driver);
		c.withMandateryFild(lastname);
		c.withOrginationField("Organizations", lastname, "Contacts");
		c.clickOnsaveButton();
		
		
	}
	@Test
	public void createcontAnddeleteTest() throws Throwable
	{
		
	String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
	HomePage home=new HomePage(driver);
	home.clickOnContacts();
	CreateContactsPage cc=new CreateContactsPage(driver);
	cc.createContact();
	CreateNewContactsPage c=new CreateNewContactsPage(driver);
	c.withMandateryFild(lastname);
	c.withOrginationField("Organizations", lastname, "Contacts");
	c.clickOnsaveButton();
	
	ContactsInformationPage con=new ContactsInformationPage(driver);
	con.clickOndelitButtin();
	
}
}
