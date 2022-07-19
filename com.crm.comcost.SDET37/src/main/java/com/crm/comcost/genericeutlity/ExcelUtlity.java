package com.crm.comcost.genericeutlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POilibraries , which used to handle Microsoft Excel sheet
 * @author Nikhil Raj
 *
 */

public class ExcelUtlity 
    {
	    /**
		 *  its used read the data from excel base don below arguments 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throwsThrowable
		 */
		public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable 
		{
			FileInputStream fis  =new FileInputStream(IConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(celNum).getStringCellValue();
			wb.close();
			return data;
		}
		/**
		 * used to get the last used row number on specified Sheet
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable
		{
			FileInputStream fis  =new FileInputStream(IConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			wb.close();
			return sh.getLastRowNum();
		}
		/**
		 * 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @param data
		 * @throws Throwable
		 */
		
		public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable 
		{
			FileInputStream fis  =new FileInputStream(IConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(celNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IConstant.Excelpath);
			wb.write(fos);
			wb.close();
			
		}
		/**
		 * 
		 * @param sheetName
		 * @param rownum
		 * @param cellnum
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public String getDataFromExcelusingDataFormatter(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis  =new FileInputStream(IConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			DataFormatter format=new DataFormatter();
			return format.formatCellValue(sh.getRow(rownum).getCell(cellnum));	
			
			
		}
	
    }

