package view;

import java.sql.Connection;
import java.sql.SQLException;

import business.*;
import jdbc.DataBaseConnection;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi on Let'sWORK application !");
		Connection connection = DataBaseConnection.getConnection();
		// We can use the database here !!
		LoginView logV = new LoginView();
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}