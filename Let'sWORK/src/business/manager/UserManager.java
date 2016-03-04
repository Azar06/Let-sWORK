package business.manager;

import business.Factory;
import jdbc.FactoryJDBC;
import persistence.User;

public class UserManager {
	private Factory factorio;
	
	public UserManager() {
		this.factorio = new FactoryJDBC();
	}
	
	public boolean login(String id, String pass) {
		User u = this.factorio.getUserWithUsername(id);
		boolean result = false;
		if (u != null){
			result = (u.getPassword().equals(pass));
		}
		return result;
	}
}
