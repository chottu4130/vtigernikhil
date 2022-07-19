package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatainExcTest
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("./commondata/loginsheet xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file);
		Sheet sh= book.getSheet("Sheet1");
		Row r=sh.getRow(1);
		Cell c= r.getCell(1);
		c.setCellValue("pass22");
		FileOutputStream file1=new FileOutputStream("./commondata/loginsheet xlsx.xlsx");
		book.write(file1);
		file1.flush();
		file1.close();
		

	}

	
}
