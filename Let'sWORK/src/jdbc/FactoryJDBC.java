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

	@Override
	public Goal createGoal() {
		return new GoalJDBC();
	}
	
	@Override
	public Activity createActivity(){
		return new ActivityJDBC();
	}
	
	@Override
	public Diary createDiary() {
		return new DiaryJDBC();
	}

	@Override
	public Ressource createRessource() {
		return new RessourceJDBC();
	}

	@Override
	public ProductOffer createProductOffer(double price, int initialAmount) {
		return new ProductOfferJDBC(price, initialAmount);
	}

	@Override
	public ServiceOffer createServiceOffer(double price) {
		return new ServiceOfferJDBC(price);
	}

}
