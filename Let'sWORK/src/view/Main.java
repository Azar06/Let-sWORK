package view;

import controller.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi on Let'sWORK application !");
		DataBaseController db = DataBaseController.getConnection();
		// We can use the database here !!
		LoginView logV = new LoginView();
		db.close();
	}

}