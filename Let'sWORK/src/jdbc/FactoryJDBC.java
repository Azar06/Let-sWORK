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
	public Resource createResource() {
		return new ResourceJDBC();
	}

	@Override
	public ProductOffer createProductOffer(double price, int initialAmount) {
		return new ProductOfferJDBC(price, initialAmount);
	}

	@Override
	public ServiceOffer createServiceOffer(double price) {
		return new ServiceOfferJDBC(price);
	}

	@Override
	public CategorySet createCategorySet() {
		return new CategorySetJDBC();
	}

	@Override
	public Admin createAdmin() {
		return new AdminJDBC();
	}

	@Override
	public Service createService() {
		return new ServiceJDBC();
	}

	@Override
	public ServiceSet createServiceSet() {
		return new ServiceSetJDBC();
	}
	
	@Override
	public Product createProduct() {
		return new ProductJDBC();
	}

	@Override
	public ProductSet createProductSet() {
		return new ProductSetJDBC();
	}

	@Override
	public ActivitySet createActivitySet() {
		return new ActivitySetJDBC();
	}
}
