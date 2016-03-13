package business.facade;

import business.manager.UserManager;

public class UserFacade {
	private UserManager manager;
	
	public UserFacade() {
		//UserManager creation
		this.manager = new UserManager();
	}
	
	public boolean login(String id, String password) {
		return manager.login(id,password);
		//In UserManager, if they are the same, it's OK
	}
}
