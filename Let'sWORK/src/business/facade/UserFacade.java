package business.facade;

import business.manager.UserManager;
import business.utils.SignupReturnState;

public class UserFacade {
	private UserManager manager;

	public UserFacade() {
		// UserManager creation
		this.manager = new UserManager();
	}

	public boolean login(String id, String password) {
		return this.manager.login(id, password);
		// In UserManager, if they are the same, it's OK
	}

	public SignupReturnState signup(String firstName, String lastName, String steet, String city, String phoneNumber, String email, String username, String password, boolean isCustomer, boolean isSeller, String siret, String url) {
		return this.manager.signup(firstName, lastName, steet, city, phoneNumber, email, username, password, isCustomer, isSeller, siret, url);
	}
}
