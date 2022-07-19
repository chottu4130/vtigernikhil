package com.crm.comcost.genericeutlity;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author NIKHIL RAJ
 *
 */
    
public class DataBaseUtility 
{
	static Driver driver;
    static Connection connection;
     static ResultSet result;
 /**
  * this Method will perform the MYSQL database connection
  * @throws SQLException
  */
	public void connectionDB()throws SQLException
	{
		try 
		{
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students\", \"root\", \"root");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	/**
	 * this method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			
		}
	}
		/**This method will execute the querry
	     * @param query
		 * @return 
		 * @return 
	     * @return
	     * @throwsThrowable
	     *  
		 */
		
	  public ResultSet execyteQuery(String query) throws Throwable 
	  {	
		  result = connection.createStatement().executeQuery(query);
			return result;

	  }
	  /**
		 * This method will execute the querry
		 * @param query
		 * @return
		 * @throwsThrowable
		 */
		public int execyteUpdate(String query) throws Throwable
		{
			
				int result = connection.createStatement().executeUpdate(query);
		
			return result;

		}

		/**
		 * This method will execute querry based on querry and it will verify the data. 
		 * @paramquerry
		 * @paramcolumnName
		 * @paramexpectedData
		 * @return
		 * @throwsThrowable
		 */
		public boolean executeQuerryAndVerify(String querry,int columnName,String expectedData) throws Throwable
		{
			boolean flag=false;
			result=connection.createStatement().executeQuery(querry);
			while(result.next())
			{
				if(result.getString(columnName).equals(expectedData)) 
				{
					flag=true;
					break;
				}
			}
			if(flag) 
			{
				System.out.println(expectedData+"==>Data is verified in the data base table");
				return flag;
			}
			else
			{
				System.out.println(expectedData+"==>data is not verified in the database");
				return flag;
			}

		}
 


}
