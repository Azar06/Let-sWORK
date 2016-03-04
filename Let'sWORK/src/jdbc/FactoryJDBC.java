package jdbc;

import business.Factory;
import jdbc.persistence.UserJDBC;
import persistence.LoadException;
import persistence.User;

public class FactoryJDBC extends Factory {

	@Override
	public User getUserWithUsername(String username) {
		User user = new UserJDBC();
		try {
			user.load(username);
		}
		catch (LoadException e) {
			user = null;
		}
		return user;
	}
}
