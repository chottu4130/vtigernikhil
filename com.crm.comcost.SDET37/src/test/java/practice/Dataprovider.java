package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcost.genericeutlity.ExcelUtlity;

public class Dataprovider 
{
	
	@Test(dataProvider = "dataprovider_bookticketTest")
	public void bookticket(String src,String des)
	{
		System.out.println("bookticket from"+src+"to"+des);
	}
	@DataProvider
	public Object[][] dataprovider_bookticketTest() throws Throwable
			
			{
		
		        Object[][] objarr=new Object[3][2];
		        ExcelUtlity ex=new ExcelUtlity();
		        String add=ex.getDataFromExcel("add", 0, 0);
		        String vender=ex.getDataFromExcel("vender", 0, 0);	
		        objarr[0][0]=add;
		        objarr[0][1]="bihar";
		        
		        objarr[1][0]=vender;
		        objarr[1][1]="goa";
		        
		        objarr[2][0]="bangloure";
		        objarr[2][1]=add;
		        
		        
				return objarr;
		
			}
}
