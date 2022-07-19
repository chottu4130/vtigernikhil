package com.crm.comcost.contact.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAndDeleteContectTest 

{

	public static void main(String[] args) throws IOException
	{
		FileInputStream file=new FileInputStream("./commondata/commondata.properties");
		Properties poy=new Properties();
		poy.load(file);
		String url=poy.getProperty("url");
		String un=poy.getProperty("username");
		String pw=poy.getProperty("password");
		Random r=new Random();
		int num1=r.nextInt(10000);
		FileInputStream file1=new FileInputStream("./commondata/Contact.xlsx.xlsx");
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
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastnum);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
	    Alert alt=driver.switchTo().alert();
	    alt.accept();
	    driver.findElement(By.name("search_text")).sendKeys(lastnum);
	    WebElement wb=driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
	    wb.click();
	    Select s=new Select(wb);
	    s.selectByVisibleText("Last Name");  
	    driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
	   String text=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
	   
	   if(text.contains(lastnum))
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
