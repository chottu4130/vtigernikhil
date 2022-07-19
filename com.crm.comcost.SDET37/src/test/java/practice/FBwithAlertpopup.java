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

public class FBwithAlertpopup
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
//		String lastname=ex.getDataFromExcel("lastname", 0, 0)+ja.getRanDomNumber();
//		String vender=ex.getDataFromExcel("vender", 0, 0)+ja.getRanDomNumber();
//		String subj=ex.getDataFromExcel("subj", 0, 0)+ja.getRanDomNumber();
//		String add=ex.getDataFromExcel("add", 0, 0)+ja.getRanDomNumber();
		
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
//		SoftAssert soft=new SoftAssert();
//		soft.assertEquals(text,"Product Information");
//		
		Assert.assertEquals(text,"Product Information");
				
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
		WebElement de=driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]"));
		de.click();
	    wb.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
	    WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wb.mouseOverOnElement(driver,ta);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.close();
	   // soft.assertAll();
		

	}

}
