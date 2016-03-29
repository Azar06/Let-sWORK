package test;

import business.Factory;
import persistence.*;
import test.persistence.*;

public class TestFactory implements Factory {

	@Override
	public User createUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonInfo createPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller createSeller() {
		// TODO Auto-generated method stub
		return null;
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
	public Resource createRessource() {
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

}
