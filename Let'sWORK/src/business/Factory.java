package business;

import persistence.*;

public interface Factory {
	
	// public User getUserWithUsername(String id);
	public User createUser();
	public PersonInfo createPerson();
	public Customer createCustomer();
	public Seller createSeller();
	public Category createCategory();
	public Goal createGoal();
	public Activity createActivity();
	public Diary createDiary();
	public Resource createRessource();
	public ProductOffer createProductOffer(double price, int amount);
	public ServiceOffer createServiceOffer(double price);
	public CategorySet createCategorySet();
}
