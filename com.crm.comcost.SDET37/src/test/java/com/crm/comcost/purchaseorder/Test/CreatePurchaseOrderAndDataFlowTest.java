package com.crm.comcost.purchaseorder.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class CreatePurchaseOrderAndDataFlowTest
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
		FileInputStream file1=new FileInputStream("./commondata/purch.xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file1);
		Sheet sh=book.getSheet("Sheet1");
		String product=sh.getRow(1).getCell(0).getStringCellValue()+num1;
		String vender=sh.getRow(1).getCell(1).getStringCellValue()+num1;
		String subj=sh.getRow(1).getCell(2).getStringCellValue()+num1;
		String add=sh.getRow(1).getCell(3).getStringCellValue()+num1;
		//login
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		//product
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String t=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(t.contains("Product Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		//Thread.sleep(2000);
		
		//more
		Actions act=new Actions(driver);
		WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(wb).perform();
		//venders
		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vender);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String s1=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(s1.contains("Vendor Information"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		//Thread.sleep(2000);
		//more
		WebElement wb1=driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(wb1).perform();
		//purchase
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(subj);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		String par=driver.getWindowHandle();
		Set<String>chi=driver.getWindowHandles();
		Iterator<String> it=chi.iterator();
		while(it.hasNext())
		{
			String wid=it.next();
			driver.switchTo().window(wid);
			String text1=driver.findElement(By.className("moduleName")).getText();
			if(text1.contains("Vendors"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(vender);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(vender)).click();
		Set<String>chi1=driver.getWindowHandles();
		Iterator<String> it1=chi1.iterator();
		while(it1.hasNext())
		{
			String wid1=it1.next();
			driver.switchTo().window(wid1);
			String s3=driver.findElement(By.xpath("(//a[text()='Purchase Order'])[3]")).getText();
			if(s3.contains("Purchase Order"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(add);
		driver.findElement(By.name("ship_street")).sendKeys(add);
		driver.findElement(By.id("searchIcon1")).click();
		Set<String>chi2=driver.getWindowHandles();
		Iterator<String> it2=chi2.iterator();
		while(it2.hasNext())
		{
			String wid2=it2.next();
			driver.switchTo().window(wid2);
			String s2=driver.findElement(By.className("moduleName")).getText();
			if(s2.contains("Products"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(product);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(product)).click();
		Set<String>chi3=driver.getWindowHandles();
		Iterator<String> it3=chi3.iterator();
		while(it3.hasNext())
		{
			String wid3=it3.next();
			driver.switchTo().window(wid3);
			String s2=driver.findElement(By.xpath("(//a[text()='Purchase Order'])[3]")).getText();
			if(s2.contains("Purchase Order"))
			{
				break;
			}
		}
		    driver.findElement(By.id("qty1")).sendKeys("12");
		    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		    WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		    act.moveToElement(ta).perform();
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		    driver.close();
		
		
	}

}
