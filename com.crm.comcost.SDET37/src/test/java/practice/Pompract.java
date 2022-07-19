package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;
import com.crm.comcost.pomrepository.CreateCampaignsPage;
import com.crm.comcost.pomrepository.CreateContactsPage;
import com.crm.comcost.pomrepository.CreateNewCampaignsPage;
import com.crm.comcost.pomrepository.CreateNewContactsPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.LoginPage;

public class Pompract {

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriverUtility wb=new WebDriverUtility();
		JavaUtility ja= new JavaUtility();
		FileUTility fi=new FileUTility();
		ExcelUtlity ex=new ExcelUtlity();
	
	    String url=fi.getPropertyKeyValue("url");
		String un=fi.getPropertyKeyValue("username");
		String pw=fi.getPropertyKeyValue("password");
		String product=ex.getDataFromExcel("Sheet2", 0, 0)+ja.getRanDomNumber()+ja.getRanDomNumber();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		LoginPage p1=new LoginPage(driver);
		p1.loginVtiger(url,un,pw);
		HomePage h1=new HomePage(driver);
				h1.clickOnContacts();
		CreateContactsPage c1=new CreateContactsPage(driver);
		c1.createContact();
		CreateNewContactsPage c2=new CreateNewContactsPage(driver);
		c2.withMandateryFild(product);	
		c2.withOrginationField("Organizations",product,"Contacts");
		c2.clickOnsaveButton();
		
		/*
		h1.clickOncampaigns();
		CreateCampaignsPage c=new CreateCampaignsPage(driver);
		c.createcampaigns();
		CreateNewCampaignsPage cp=new CreateNewCampaignsPage(driver);
		cp.entercsmpainName(product);
		cp.clickonproduct("Products", product, "Campaigns");
		cp.clickonSaveButton();
		*/
		h1.signoutAction();
		
		
		
		
		
		
				
		

	}

}
