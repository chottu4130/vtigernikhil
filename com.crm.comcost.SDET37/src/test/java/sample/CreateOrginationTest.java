package sample;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.pomrepository.CreateNewOrginationPage;
import com.crm.comcost.pomrepository.CreateOrginationPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.OrginationInformation;
@Listeners(com.crm.comcost.genericeutlity.ListenerImplemination.class)
public class CreateOrginationTest extends BaseClass
{
	@Test(groups = "smoke")
	public void createContTest() throws Throwable
	{
		
		
		//String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
	    String lastname=elib.getDataFromExcelusingDataFormatter("lastname", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnOrgination();
		CreateOrginationPage oo=new CreateOrginationPage(driver);
		oo.ClickOnCreateOrgination();
		CreateNewOrginationPage c=new CreateNewOrginationPage(driver);
		c.sendOrginationName(lastname);
		c.clickonsave();
		OrginationInformation o=new OrginationInformation(driver);
		o.inform(lastname);
}
	
	@Test(groups = "regration")
	public void createAndDelete() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String lastname=elib.getDataFromExcelusingDataFormatter("lastname", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnOrgination();
		CreateOrginationPage oo=new CreateOrginationPage(driver);
		oo.ClickOnCreateOrgination();
		CreateNewOrginationPage c=new CreateNewOrginationPage(driver);
		c.sendOrginationName(lastname);
		c.clickonsave();
		OrginationInformation o=new OrginationInformation(driver);
		o.inform(lastname);
		o.clickOndeleteButton();
	}
	
}