package business.manager;

import business.Factory;
import jdbc.FactoryJDBC;
import persistence.User;

public class UserManager {
	private Factory factorio;
	
	public UserManager() {
		//FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public boolean login(String id, String pass) {
		//We get the id of the user
		User u = this.factorio.getUserWithUsername(id);
		boolean result = false;
		if (u != null){
			result = (u.getPassword().equals(pass));
		}
		//If the password write by the user is the same as the password in the database
		return result;
	}
}
