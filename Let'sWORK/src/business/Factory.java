package business;

import persistence.*;

public interface Factory {
	
	//public User getUserWithUsername(String id);
	
	/**
	 * Create a User
	 * @return a UserJDBC
	 */
	public User createUser();
	
	/**
	 * Create an admin
	 * @return an AdminJDBC
	 */
	public Admin createAdmin();
	
	/**
	 * Create a person
	 * @return a PersonJDBC
	 */
	public PersonInfo createPerson();
	
	/**
	 * Create a customer
	 * @return a CustomerJDBC
	 */
	public Customer createCustomer();
	
	/**
	 * Create a Seller
	 * @return a SellerJDBC
	 */
	public Seller createSeller();
	
	/**
	 * Create a category
	 * @return a CategoryJDBC
	 */
	public Category createCategory();
	
	/**
	 * Create a goal
	 * @return a GoalJDBC
	 */
	public Goal createGoal();
	
	/**
	 * Create an activity
	 * @return an ActivityJDBC
	 */
	public Activity createActivity();
	
	/**
	 * Create a diary
	 * @return a DiaryJDBC
	 */
	public Diary createDiary();
	
	/**
	 * Create a resource
	 * @return a ResourceJDBC
	 */
	public Resource createResource();
	
	/**
	 * Create a product offer
	 * @param price : the price of the product
	 * @param amount : the quantity of the product
	 * @return a ProductOfferJDBC
	 */
	public ProductOffer createProductOffer(double price, int amount);
	
	/**
	 * Create a service offer
	 * @param price : the price of the service
	 * @return a ServiceOfferJDBC
	*/
	public ServiceOffer createServiceOffer(double price);
	
	/**
	 * Create a collection of categories
	 * @return a CategorySetJDBC
	 */
	public CategorySet createCategorySet();
	
	/**
	 * Create a service
	 * @return a ServiceJDBC
	 */
	public Service createService();
	
	/**
	 * Create a collection of services
	 * @return a ServiceSetJDBC
	 */
	public ServiceSet createServiceSet();
	
	/**
	 * Create a product
	 * @return a ProductJDBC
	 */
	public Product createProduct();
	
	/**
	 * Create a collection of products
	 * @return a ProductSetJDBC
	 */
	public ProductSet createProductSet();
	
	/**
	 * Create a collection of activities
	 * @return a ActivitySetJDBC
	 */
	public ActivitySet createActivitySet();
	
	/**
	 * Create a collection of goals
	 * @return a GoalSetJDBC
	 */
	public GoalSet createGoalSet();
}
