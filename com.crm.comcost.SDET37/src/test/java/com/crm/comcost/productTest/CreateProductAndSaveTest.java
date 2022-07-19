package com.crm.comcost.productTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductAndSaveTest
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
		FileInputStream file1=new FileInputStream("./commondata/product.xlsx.xlsx");
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
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(lastnum);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

	}

}
