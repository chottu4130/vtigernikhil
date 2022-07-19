package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllTheDataFromExcTest 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("./commondata/loginsheet xlsx.xlsx");
		Workbook book=WorkbookFactory.create(file);
		Sheet sh=book.getSheet("Sheet1");
		int temp=sh.getLastRowNum();
		for(int i=1;i<=temp;i++)
		{
			Row r=sh.getRow(i);
			String cell1= r.getCell(0).getStringCellValue();
			String cell2= r.getCell(1).getStringCellValue();
			String cell3= r.getCell(2).getStringCellValue();
			System.out.println(cell1 +" " +cell2 + " "+cell3);
		}

	}

}
