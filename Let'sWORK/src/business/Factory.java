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
	public Ressource createRessource()
}
