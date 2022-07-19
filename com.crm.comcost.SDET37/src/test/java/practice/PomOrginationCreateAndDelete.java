package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;
import com.crm.comcost.pomrepository.CreateNewOrginationPage;
import com.crm.comcost.pomrepository.CreateOrginationPage;
import com.crm.comcost.pomrepository.HomePage;
import com.crm.comcost.pomrepository.LoginPage;
import com.crm.comcost.pomrepository.OrginationInformation;

public class PomOrginationCreateAndDelete
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
	String product=ex.getDataFromExcel("Sheet2", 0, 0)+ja.getRanDomNumber()+ja.getRanDomNumber();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	wb.waitForElementInDOM(driver);
	
	LoginPage p1=new LoginPage(driver);
	p1.loginVtiger(url,un,pw);
	HomePage h1=new HomePage(driver);
	h1.clickOnOrgination();
	CreateOrginationPage co=new CreateOrginationPage(driver);
	co.ClickOnCreateOrgination();
	CreateNewOrginationPage c1=new CreateNewOrginationPage(driver);
	c1.sendOrginationName(product);
	c1.clickonsave();
	OrginationInformation ooo=new OrginationInformation(driver);
	ooo.clickOndeleteButton();
	h1.signoutAction();
	
	
}
}
