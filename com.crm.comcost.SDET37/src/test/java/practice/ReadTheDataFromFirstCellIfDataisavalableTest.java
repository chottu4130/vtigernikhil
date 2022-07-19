package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromFirstCellIfDataisavalableTest 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("./commondata/loginsheet xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file);
		Sheet sh=book.getSheet("Sheet1");
		int count=sh.getLastRowNum();
		String exp="rwo";
		for(int i=1;i<count;i++) 
		{
			Row r=sh.getRow(i);
			String s1=r.getCell(1).getStringCellValue();
			if(s1.equals(exp))
			{
				String s2=r.getCell(2).getStringCellValue();
				System.out.println(s2);
			}
		}

	}

}
