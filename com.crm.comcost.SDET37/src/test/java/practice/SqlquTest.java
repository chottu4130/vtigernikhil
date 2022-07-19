package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
// to 
public class SqlquTest {

	public static void main(String[] args) throws SQLException
	{
		Connection conn=null;
		try 
		{
		
		Driver driver=new Driver();
		
		
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
		
		Statement state=conn.createStatement();
		String query="select*from students_info";
		
		ResultSet resultset=state.executeQuery(query);//By using Select class this will work
	
		while(resultset.next())
		{
			System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2));
		}
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

