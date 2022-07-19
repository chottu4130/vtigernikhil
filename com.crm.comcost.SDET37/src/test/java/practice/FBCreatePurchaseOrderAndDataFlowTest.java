package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;

public class FBCreatePurchaseOrderAndDataFlowTest
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
		String product=ex.getDataFromExcel("Sheet2", 0, 0)+ja.getRanDomNumber();
		String lastname=ex.getDataFromExcel("lastname", 0, 0)+ja.getRanDomNumber();
		String vender=ex.getDataFromExcel("vender", 0, 0)+ja.getRanDomNumber();
		String subj=ex.getDataFromExcel("subj", 0, 0)+ja.getRanDomNumber();
		String add=ex.getDataFromExcel("add", 0, 0)+ja.getRanDomNumber();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wb.waitForElementInDOM(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String text=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(text,"Product Information");
		/*
		if(text.contains("Product Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		*/
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String s1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		/*
		if(s1.contains("Contact Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		*/
		soft.assertEquals(s1,"Contact Information");
		WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		wb.mouseOverOnElement(driver, more);
		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vender);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String s2=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		/*
		if(s2.contains("Vendor Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		*/
		//soft.assertEquals(s2,"Vendor Information");
		Assert.assertTrue(s2.contains("Vendor Information"));
		WebElement more1=driver.findElement(By.xpath("//a[text()='More']"));
		wb.mouseOverOnElement(driver, more1);
		driver.findElement(By.xpath("(//a[text()='Purchase Order'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(subj);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		wb.swithToWindow(driver, "Vendors");
		driver.findElement(By.id("search_txt")).sendKeys(vender);
		driver.findElement(By.name("search")).click();
		wb.swithToWindow(driver,"Creating New Purchase Order");
		//driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
		//driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		wb.swithToWindow(driver, "Vendors");
		driver.findElement(By.id("search_txt")).sendKeys(vender);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(vender)).click();
	   // driver.findElement(By.xpath("//a[@id='1']")).click();
		//driver.findElement(By.id("1")).click();
	   
		wb.swithToWindow(driver, "Purchase Order");
		driver.findElement(By.xpath("//input[@name='contact_id']/../img")).click();
		wb.swithToWindow(driver, "Contacts");
		driver.findElement(By.name("search_text")).sendKeys(lastname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(lastname)).click();
		
		wb.swithToAlertWindowAndAccpect(driver, "Overwrite the existing address with this selected contact( ka8234) address details?");
		wb.swithToWindow(driver, "Purchase Order");
//		driver.findElement(By.name("bill_street")).sendKeys(add);
//		driver.findElement(By.name("ship_street")).sendKeys(add);
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(add);
		driver.findElement(By.name("ship_street")).sendKeys(add);
		
		
		
		driver.findElement(By.id("searchIcon1")).click();
		wb.swithToWindow(driver, "Products");
		driver.findElement(By.id("search_txt")).sendKeys(product);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(product)).click();
		wb.swithToWindow(driver, "Purchase Order");
		driver.findElement(By.id("qty1")).sendKeys("10");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		String s3=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		/*
		if(s3.contains("Purchase Order Information"))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fell");
		}
		*/
		soft.assertEquals(s3,"Purchase Order Information");
		WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wb.mouseOverOnElement(driver,ta);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.close();
		//soft.assertAll();
		

	}

}
