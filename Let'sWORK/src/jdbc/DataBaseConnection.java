package jdbc;

import java.sql.*;

public class DataBaseConnection {
	
	public static Connection getConnection() {
		return DataBaseConnection.connection;
	}
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");
			String url = "jdbc:postgresql://localhost:5432/LetsWorkDB";
			String user = "LetsWorkAdmin";
			String passwd = "LetsWorkPassword";
			DataBaseConnection.connection = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
		} catch (Exception e) {
			DataBaseConnection.connection = null;
			System.out.println("Connexion failed !");
		}     
	}
}
