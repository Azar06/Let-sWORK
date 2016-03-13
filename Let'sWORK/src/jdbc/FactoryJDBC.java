package jdbc;

import business.Factory;
import jdbc.persistence.UserJDBC;
import persistence.LoadException;
import persistence.User;

public class FactoryJDBC implements Factory {

	@Override
	public User getUserWithUsername(String username) {
		//Création d'un UserJDBC
		User user = new UserJDBC();
		try {
			//get the username
			user.load(username);
		}
		catch (LoadException e) {
			user = null;
		}
		return user;
	}
}
