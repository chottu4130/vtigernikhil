package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcTest
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("./commondata/loginsheet xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file);
	    String url=book.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
	    String un=book.getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
	    String pw=book.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();

		
		
	}

}
