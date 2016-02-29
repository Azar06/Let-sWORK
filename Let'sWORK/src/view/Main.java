package view;

import business.*;
import jdbc.DataBaseConnection;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi on Let'sWORK application !");
		DataBaseConnection db = DataBaseConnection.getConnection();
		// We can use the database here !!
		LoginView logV = new LoginView();
		db.close();
	}

}