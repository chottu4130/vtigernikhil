package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class Excel 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream("./commondata/commondata.properties");
		Properties poy=new Properties();
		poy.load(file);
		FileInputStream file1=new FileInputStream("./commondata/framework.xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file1);
		Sheet sh=book.getSheet("ex");
		String lastnum=sh.getRow(0).getCell(0).getStringCellValue();
		String url=poy.getProperty("flip");
       	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys(lastnum);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		String text=driver.findElement(By.xpath("//div[text()='APPLE iPhone X (Silver, 64 GB)']/../../../div[2]/div[2]/div/div/div")).getText();
		System.out.println(text);
		sh.getRow(0).createCell(5).setCellValue(text);
		FileOutputStream file2=new FileOutputStream("./commondata/framework.xlsx.xlsx");
		book.write(file2);
		driver.close();
		
	}
	

}
