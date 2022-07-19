package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcost.genericeutlity.ExcelUtlity;
import com.crm.comcost.genericeutlity.FileUTility;
import com.crm.comcost.genericeutlity.JavaUtility;
import com.crm.comcost.genericeutlity.WebDriverUtility;

public class FramePopupTest 
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
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wb.waitForElementInDOM(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys(product);
		//wb.swithToFrame(driver,0);
		wb.swithToFrame(driver,0);
		
		//driver.findElement(By.xpath("(//span[text()='Strike Through']/../span)[1]")).click();
	//	wb.swithToFrame(driver, 0);
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("zxcvgfg");
		//driver.findElement(By.xpath("//iframe")).sendKeys("abcd");
		
	
		

	}

}
