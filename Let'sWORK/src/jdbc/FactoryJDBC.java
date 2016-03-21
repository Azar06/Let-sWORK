package jdbc;

import business.Factory;
import jdbc.persistence.*;
import persistence.*;
import persistence.exception.LoadException;

public class FactoryJDBC implements Factory {
	
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
	
	@Override
	public Category createCategory() {
		return new CategoryJDBC();
	}
}
