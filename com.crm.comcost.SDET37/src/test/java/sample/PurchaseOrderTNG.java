package sample;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.BaseClass;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewContactsPage;
import com.crm.comcost.pomrepository.CreateNewProduct;
import com.crm.comcost.pomrepository.CreateNewPurchaseOrderPage;
import com.crm.comcost.pomrepository.CreateNewVenderPage;
import com.crm.comcost.pomrepository.CreateProductPage;
import com.crm.comcost.pomrepository.CreatePurchaseOrderPage;
import com.crm.comcost.pomrepository.CreateVenderPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.PurchaseOrderInformantionPage;
@Listeners(com.crm.comcost.genericeutlity.ListenerImplemination.class)
public class PurchaseOrderTNG extends BaseClass
{
	@Test
	public void purchase() throws Throwable
	{
		String product=elib.getDataFromExcel("Sheet2", 0, 0)+jlib.getRanDomNumber();
		String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
		String vender=elib.getDataFromExcel("vender", 0, 0)+jlib.getRanDomNumber();
		String subj=elib.getDataFromExcel("subj", 0, 0)+jlib.getRanDomNumber();
		String add=elib.getDataFromExcel("add", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnProducts();
		//product
		CreateProductPage cc=new CreateProductPage(driver);
		cc.clickOnCreateProduct();
		CreateNewProduct pr=new CreateNewProduct(driver);
		pr.enterProductname(product);
		pr.ClickOnsaveButton();
		
		
		//vender
		
		home.clickOnvender();
		CreateVenderPage ve=new CreateVenderPage(driver);
		ve.clickcreateVender();
		CreateNewVenderPage pa=new CreateNewVenderPage(driver);
		pa.entervendorname(vender);
		pa.clickonsave();
		
		
		
		//purchaseorder
		
		
		home.clickOnpurchaseOrder();
		CreatePurchaseOrderPage pp=new CreatePurchaseOrderPage(driver);
		pp.clickonPurchaseorder();
		CreateNewPurchaseOrderPage ccc=new CreateNewPurchaseOrderPage(driver);
		ccc.entertsubject(subj);
		ccc.clickonvender("Vendors", vender, "Purchase Order");
		ccc.clickoncontactname("Contacts", lastname, "Purchase Order");
		ccc.enterbulldingaddres(add);
		ccc.entershippingaddres(add);
		ccc.clickonitemname("Products", product, "Purchase Order");
		ccc.enterqty("10");
		ccc.clickonsave();
		
		PurchaseOrderInformantionPage o=new PurchaseOrderInformantionPage(driver);
		o.informantion();
		
		
		
	}
	
	@Test
	public void purchaseAndContactWithDelete() throws Throwable
	{
		String product=elib.getDataFromExcel("Sheet2", 0, 0)+jlib.getRanDomNumber();
		String lastname=elib.getDataFromExcel("lastname", 0, 0)+jlib.getRanDomNumber();
		String vender=elib.getDataFromExcel("vender", 0, 0)+jlib.getRanDomNumber();
		String subj=elib.getDataFromExcel("subj", 0, 0)+jlib.getRanDomNumber();
		String add=elib.getDataFromExcel("add", 0, 0)+jlib.getRanDomNumber();
		HomePage home=new HomePage(driver);
		home.clickOnProducts();
		//product
		CreateProductPage cc=new CreateProductPage(driver);
		cc.clickOnCreateProduct();
		CreateNewProduct pr=new CreateNewProduct(driver);
		pr.enterProductname(product);
		pr.ClickOnsaveButton();
		
		//contact
		home.clickOnContacts();
		CreateContactsPage c=new CreateContactsPage(driver);
		c.createContact();
		CreateNewContactsPage cre=new CreateNewContactsPage(driver);
		cre.withMandateryFild(lastname);
		cre.clickOnsaveButton();
		
		//vender
		
		home.clickOnvender();
		CreateVenderPage ve=new CreateVenderPage(driver);
		ve.clickcreateVender();
		CreateNewVenderPage pa=new CreateNewVenderPage(driver);
		pa.entervendorname(vender);
		pa.clickonsave();
		
		
		
		//purchase order
		
		
		home.clickOnpurchaseOrder();
		CreatePurchaseOrderPage pp=new CreatePurchaseOrderPage(driver);
		pp.clickonPurchaseorder();
		CreateNewPurchaseOrderPage ccc=new CreateNewPurchaseOrderPage(driver);
		ccc.entertsubject(subj);
		ccc.clickonvender("Vendors", vender, "Purchase Order");
		ccc.clickoncontactname("Contacts", lastname, "Purchase Order");
		ccc.enterbulldingaddres(add);
		ccc.entershippingaddres(add);
		ccc.clickonitemname("Products", product, "Purchase Order");
		ccc.enterqty("10");
		ccc.clickonsave();
		
		PurchaseOrderInformantionPage o=new PurchaseOrderInformantionPage(driver);
		o.informantion();
		o.clickondelet();
		
	}
	
}
