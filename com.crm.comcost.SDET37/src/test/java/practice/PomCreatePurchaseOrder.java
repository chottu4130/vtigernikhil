package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewContactsPage;
import com.crm.comcost.pomrepository.CreateNewProduct;
import com.crm.comcost.pomrepository.CreateNewPurchaseOrderPage;
import com.crm.comcost.pomrepository.CreateNewVenderPage;
import com.crm.comcost.pomrepository.CreateProductPage;
import com.crm.comcost.pomrepository.CreatePurchaseOrderPage;
import com.crm.comcost.pomrepository.CreateVenderPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.LoginPage;

public class PomCreatePurchaseOrder 
{
	public static void main(String[] args) throws Throwable 
	{
		
	
	WebDriverUtility wb=new WebDriverUtility();
	JavaUtility ja= new JavaUtility();
	FileUTility fi=new FileUTility();
	ExcelUtlity ex=new ExcelUtlity();

    String url=fi.getPropertyKeyValue("url");
	String un=fi.getPropertyKeyValue("username");
	String pw=fi.getPropertyKeyValue("password");
	String br=fi.getPropertyKeyValue("browser");
	String product=ex.getDataFromExcel("Sheet2", 0, 0)+ja.getRanDomNumber();
	String lastname=ex.getDataFromExcel("lastname", 0, 0)+ja.getRanDomNumber();
	String vender=ex.getDataFromExcel("vender", 0, 0)+ja.getRanDomNumber();
	String subj=ex.getDataFromExcel("subj", 0, 0)+ja.getRanDomNumber();
	String add=ex.getDataFromExcel("add", 0, 0)+ja.getRanDomNumber();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	wb.waitForElementInDOM(driver);
	LoginPage p1=new LoginPage(driver);
	p1.loginVtiger(url,un,pw);
	HomePage h1=new HomePage(driver);
	h1.clickOnContacts();
	CreateContactsPage cc=new CreateContactsPage(driver);
	cc.createContact();
	CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
	cnp.withMandateryFild(lastname);
	cnp.clickOnsaveButton();
	
	h1.clickOnProducts();
	CreateProductPage cp=new CreateProductPage(driver);
	cp.clickOnCreateProduct();
	CreateNewProduct cn=new CreateNewProduct(driver);
	cn.enterProductname(product);
	cn.ClickOnsaveButton();
	h1.clickOnvender();
	CreateVenderPage cv= new CreateVenderPage(driver);
	cv.clickcreateVender();
	CreateNewVenderPage c1= new CreateNewVenderPage(driver);
	c1.entervendorname(vender);
	c1.clickonsave();
	h1.clickOnpurchaseOrder();
	CreatePurchaseOrderPage cpo =new CreatePurchaseOrderPage(driver);
	cpo.clickonPurchaseorder();
	CreateNewPurchaseOrderPage cnpo=new CreateNewPurchaseOrderPage(driver);
	cnpo.entertsubject(subj);
	cnpo.clickonvender("Vendors",vender ,"Purchase Order");
	cnpo.clickoncontactname("Contacts",lastname ,"Purchase Order");
	cnpo.enterbulldingaddres(add);
	cnpo.entershippingaddres(add);
	cnpo.clickonitemname("Products", product,"Purchase Order");
	cnpo.enterqty("10");
	cnpo.clickonsave();
	h1.signoutAction();
	
	
	
	
	
	
	
	
	
}
}
