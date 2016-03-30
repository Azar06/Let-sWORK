package test;

import business.Factory;
import persistence.*;
import test.persistence.*;

public class TestFactory implements Factory {

	@Override
	public User createUser() {
		return new UserT();
	}

	@Override
	public PersonInfo createPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer() {
		return new CustomerT(null);
	}

	@Override
	public Seller createSeller() {
		return new SellerT(null, null, null);
	}

	@Override
	public Category createCategory() {
		// TODO Auto-generated method stub
		return new CategoryT();
	}

	@Override
	public Goal createGoal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity createActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary createDiary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource createResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductOffer createProductOffer(double price, int amount) {
		return new ProductOfferT(price, amount);
	}

	@Override
	public ServiceOffer createServiceOffer(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategorySet createCategorySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin createAdmin() {
		return new AdminT();
	}

	@Override
	public Service createService() {
		// TODO Auto-generated method stub
		return new ServiceT();
	}

	@Override
	public ServiceSet createServiceSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
