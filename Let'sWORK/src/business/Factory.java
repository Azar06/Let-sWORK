package business;

import persistence.*;

public interface Factory {
	
	// public User getUserWithUsername(String id);
	public User createUser();
	public Admin createAdmin();
	public PersonInfo createPerson();
	public Customer createCustomer();
	public Seller createSeller();
	public Category createCategory();
	public Goal createGoal();
	public Activity createActivity();
	public Diary createDiary();
	public Resource createResource();
	public ProductOffer createProductOffer(double price, int amount);
	public ServiceOffer createServiceOffer(double price);
	public CategorySet createCategorySet();
	public Service createService();
	public ServiceSet createServiceSet();
	public Product createProduct();
	public ProductSet createProductSet();
	public ActivitySet createActivitySet();
}
