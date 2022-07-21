package sample;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewProduct;
import com.crm.comcost.pomrepository.CreateProductPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.ProductInformationPage;
@Listeners(com.crm.comcost.genericeutlity.ListenerImplemination.class)
public class CreateProductTNGTest extends BaseClass
{
	@Test(groups = "regration")
	public void product() throws Throwable
	{
		
		String product=elib.getDataFromExcel("Sheet2", 0, 0);
	HomePage home =new HomePage(driver);
	home.clickOnProducts(); 
	CreateProductPage c=new CreateProductPage(driver);
	c.clickOnCreateProduct();
	CreateNewProduct cc=new CreateNewProduct(driver);
	cc.enterProductname(product);
	cc.ClickOnsaveButton();
	Thread.sleep(2000);
	}
	@Test(groups = "smoke")
	public void createproductanddelete() throws Throwable
	{
		
		String product=elib.getDataFromExcel("Sheet2", 0, 0);
		HomePage home =new HomePage(driver);
		home.clickOnProducts(); 
		CreateProductPage c=new CreateProductPage(driver);
		c.clickOnCreateProduct();
		CreateNewProduct cc=new CreateNewProduct(driver);
		cc.enterProductname(product);
		cc.ClickOnsaveButton();
		ProductInformationPage p =new ProductInformationPage(driver);
		p.cliclkOnDelete();
		Thread.sleep(2000);		
	}
}
