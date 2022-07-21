package sample;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.pomrepository.CreateNewVenderPage;
import com.crm.comcost.pomrepository.CreateVenderPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.VenderInformationPage;
@Listeners(com.crm.comcost.genericeutlity.ListenerImplemination.class)
public class CreateVenderTNGTest extends BaseClass 
{
	@Test
	public void vender() throws Throwable
	{
		String vender=elib.getDataFromExcel("vender", 0, 0)+jlib.getRanDomNumber();
		HomePage home =new HomePage(driver);
		home.clickOnvender();
		CreateVenderPage v=new CreateVenderPage(driver);
		v.clickcreateVender();
		CreateNewVenderPage ve=new CreateNewVenderPage(driver);
		ve.entervendorname(vender);
		ve.clickonsave();
		VenderInformationPage ven=new VenderInformationPage(driver);
		ven.inf(vender);
	}
}
