package controller;

import java.sql.*;

public class DataBaseController {
	
	private Connection conn;
	
	public DataBaseController() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");
			String url = "jdbc:postgresql://localhost:5432/LetsWorkDB";
			String user = "LetsWorkAdmin";
			String passwd = "LetsWorkPassword";
			this.conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");
		} catch (Exception e) {
			this.conn = null;
		}     
	}
	
	public void close() {
		try {
			if(this.conn != null && !this.conn.isClosed()) {
				this.conn.close();
			}
		} catch (SQLException e) {
		}
	}
}
