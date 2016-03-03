package business.facade;

import business.manager.UserManager;

public class UserFacade {
	private UserManager manager;
	
	public UserFacade() {
		this.manager = new UserManager();
	}
	
	public boolean login(String id, String password) {
		return manager.login(id,password);
	}
}
