package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SqlQuarywithoutSelectTest
{

	public static void main(String[] args) throws SQLException
	{
		Connection conn=null;
		int resultset=0;
		try 
		{
		
		Driver driver=new Driver();
		
		
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
		
		Statement state=conn.createStatement();
		String query="insert into students_info (regno, firstName, middleName, lastName) values('7', 'mam','linga', 'h')";
		resultset=state.executeUpdate(query);
		System.out.println("updated");
		
		}
		
		catch(Exception e)
		{
			 
		}
		finally 
		{
		conn.close();	

	

}
		}
	}

	
	