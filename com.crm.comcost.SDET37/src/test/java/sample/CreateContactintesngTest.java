package sample;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.pomrepository.ContactsInformationPage;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewContactsPage;
import com.crm.comcost.pomrepository.HomePage;
@Listeners(com.crm.comcost.genericeutlity.ListenerImplemination.class)
public class CreateContactintesngTest extends BaseClass
{
	@Test(groups = "smoke")
	public void createContTest() throws Throwable
	{
		
		
		//String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
	    String lastname=elib.getDataFromExcelusingDataFormatter("lastname", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnContacts();
		CreateContactsPage cc=new CreateContactsPage(driver);
		cc.createContact();
		CreateNewContactsPage c=new CreateNewContactsPage(driver);
		c.withMandateryFild(lastname);
		c.withOrginationField("Organizations", lastname, "Contacts");
		c.clickOnsaveButton();
		c.validationof(lastname);
		
		
	}
	@Test(groups = "regration")
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
	c.validationof(lastname);
	ContactsInformationPage con=new ContactsInformationPage(driver);
	con.clickOndelitButtin();
	
	}
	
	@Test
	public void logout()
	{
		System.out.println("hiii");
	}
}

