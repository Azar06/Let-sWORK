package jdbc;

import business.Factory;
import jdbc.persistence.*;
import persistence.LoadException;
import persistence.*;

public class FactoryJDBC implements Factory {

	@Override
	public User getUserWithUsername(String username) {
		//Creation d'un UserJDBC
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
	
	@Override
	public User createUser() {
		return new UserJDBC();
	}
	
	@Override
	public PersonInfo createPerson() {
		return new PersonInfoJDBC();
	}
	
	@Override
	public Customer createCustomer() {
		return new CustomerJDBC();
	}
	
	@Override
	public Seller createSeller() {
		return new SellerJDBC();
	}
}
