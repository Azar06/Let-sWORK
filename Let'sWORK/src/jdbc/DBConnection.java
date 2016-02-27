package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Statement streamConnection;
	private ResultSet streamResponse;
	private String url = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2107850";
	private String user = "sql2107850";
	private String password = "jL5%lA8%";

	public boolean openConnection()
	{
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(this.url, this.user, this.password);
			this.streamConnection = con.createStatement();
			System.out.println("Connection established database at : " + this.url);
		}
		catch(Exception e) {
			System.out.println("Cannot access database at : " + this.url); 
			return false;  
		}

		return true;
	}

	public void close()
	{
		try
		{
			if(this.streamResponse != null)
			{
				this.streamResponse.close();
			}
			if(this.streamConnection != null)
			{
				this.streamConnection.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean executeRequest(String sqlRequest)
	{
		try {

			if (sqlRequest.contains("SELECT"))
			{
				this.streamResponse = this.streamConnection.executeQuery(sqlRequest);
			} 
			else
			{
				this.streamConnection.executeUpdate(sqlRequest);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();           
			return false;
		}
		return true;
	}

	public ResultSet fetchArray()
	{  
		try {
			if (this.streamResponse.next())
			{
				return this.streamResponse;              
			}
			else
			{
				return null;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int count()
	{
		ResultSet resultSet = this.streamResponse;
		int size = 0;
		try {
			resultSet.last();
			size = resultSet.getRow();        
		}
		catch (SQLException e) {
			return 0;
		}
		return size;
	}
}
