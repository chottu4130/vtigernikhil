package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataFlowBtContactToOrgintionTest 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{

		FileInputStream file=new FileInputStream("./commondata/commondata.properties");
		Properties poy=new Properties();
		poy.load(file);
		String url=poy.getProperty("url");
		String un=poy.getProperty("username");
		String pw=poy.getProperty("password");
		Random r=new Random();
		int num1=r.nextInt(10000);
		FileInputStream file1=new FileInputStream("./commondata/orgination.xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file1);
		Sheet sh=book.getSheet("Sheet1");
		String lastnum=sh.getRow(1).getCell(0).getStringCellValue()+num1;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(lastnum);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastnum);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		String par=driver.getWindowHandle();
		Set<String>chi=driver.getWindowHandles();
		Iterator<String> it=chi.iterator();
		while(it.hasNext())
		{
			String wid=it.next();
			driver.switchTo().window(wid);
//			String s2=driver.findElement(By.xpath("//td[text()='Organizations']")).getText();
//			if(s2.contains("Organizations"))
//			{
//				break;
//			}
		}
		driver.findElement(By.name("search_text")).sendKeys(lastnum);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		Set<String>chi1=driver.getWindowHandles();
		Iterator<String> it1=chi1.iterator();
		while(it1.hasNext())
		{
			String wid1=it1.next();
			driver.switchTo().window(wid1);
			String s=driver.findElement(By.xpath("(//a[text()='Contacts'])[2]")).getText();
			if(s.contains("Contacts"))
			{
			break;	
			}
		}
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String text=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains("Contact Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		Actions act=new Actions(driver);
	    WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
	    act.moveToElement(ta).perform();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.close();

	}

}
