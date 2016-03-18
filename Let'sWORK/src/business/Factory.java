package business;

import persistence.*;

public interface Factory {
	
	public abstract User getUserWithUsername(String id);
	public abstract User createUser();
	public PersonInfo createPerson();
	public Customer createCustomer();
	public Seller createSeller();
}
