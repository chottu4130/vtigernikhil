package com.cem.comcost.campaignTest;

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

public class CreateCampaignAndIntegrationFlowTest 
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
		FileInputStream file1=new FileInputStream("./commondata/product.xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file1);
		Sheet sh=book.getSheet("Sheet1");
		String lastnum=sh.getRow(1).getCell(0).getStringCellValue()+num1;
		int num2=r.nextInt(10000);
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
		Actions act=new Actions(driver);
		WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//		FileInputStream file2=new FileInputStream("./commondata/Contact.xlsx.xlsx");
//		Workbook book1=WorkbookFactory.create(file1);
//		Sheet sh1=book.getSheet("Sheet1");
//		String lastnum1=sh.getRow(1).getCell(0).getStringCellValue()+num2;
		
		driver.findElement(By.name("campaignname")).sendKeys(lastnum);
		String partitle=driver.getTitle();
		System.out.println(partitle);
        driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
        /*
          String par=driver.getWindowHandle();
	      Set<String> chi=driver.getWindowHandles();
		
		for(String i:chi) 
		{
		if(!par.equals(i))
		{
			driver.switchTo().window(i);
			driver.findElement(By.id("search_txt")).sendKeys(lastnum);
            driver.findElement(By.name("search"));
	        driver.findElement(By.xpath("//a[text()='nani1834']")).click();
	      s
			
		}
		}
		driver.switchTo().window(par);
		*/
		 String par=driver.getWindowHandle();
		 Set<String> chi=driver.getWindowHandles();
		
		Iterator<String> it=chi.iterator();
         while(it.hasNext())
        {
        String wid=it.next();
        driver.switchTo().window(wid);
        String t=driver.findElement(By.className("moduleName")).getText();
        if(t.contains("product"))
        {
        	break;
        }
        //String chititle=driver.getTitle();
        }
        driver.findElement(By.id("search_txt")).sendKeys(lastnum);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.id("1")).click();
        
        Set<String> chi1=driver.getWindowHandles();
        //System.out.println(driver.getTitle());
        Iterator<String> it1=chi1.iterator();
        
         while(it1.hasNext())
         {
        	String wid2= it1.next();
        	driver.switchTo().window(wid2);
        	String textt=driver.findElement(By.className("moduleName")).getText();
        	if(textt.contains("Campaigns"))
        	{
        		break;
        	}
         }
        
		//Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		String actu=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
		if(actu.contains(lastnum))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fell");
		}
		WebElement ta= driver.findElement(By.xpath("(//td[@class='small'])[2]"));
	    act.moveToElement(ta).perform();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.close();
		
        }
		
		

	}


