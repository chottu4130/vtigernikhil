package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;

public class FrameWorkExample1
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
		String campname=ex.getDataFromExcel("Sheet1", 0, 0)+ja.getRanDomNumber();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wb.waitForElementInDOM(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		wb.mouseOverOnElement(driver, more);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String s1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(s1.contains("Campaign Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		
		WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wb.mouseOverOnElement(driver,ta);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.close();
		
		
		
		
		

	}

}
