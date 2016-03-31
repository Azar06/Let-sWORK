package persistence;

import persistence.exception.*;

public abstract class Diary {
	private String name;
	private Boolean isPublic;
	private Customer owner;
	private ActivitySet activitySet;
	
	public Diary(String name, Boolean isPublic, Customer owner) {
		super();
		this.name = name;
		this.isPublic = isPublic;
		this.owner = owner;
	}
	
	public Diary() {
		this(null, null, null);
	}
	
	// ABSTRACT METHODS
	/**
	 * Load an object diary thanks to its customer.
	 * Load the name, the visibility, the customer and the activity set of a diary
	 * @param owner
	 * @throws LoadException
	 */
	public abstract void load(Customer owner) throws LoadException;
	
	/**
	 * Create a new diary
	 * @throws SaveException
	 */
	public abstract void save() throws SaveException;
	
	/**
	 * Delete the diary selected
	 * @throws SaveException
	 */
	public abstract void update() throws SaveException;
	
	// GETTER / SETTER

	/**
	 * Get the name of a diary
	 * @return the name of the diary
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change the name of a diary
	 * @param name : the new name of the diary
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the visibility of the diary
	 * @return true if it is public, false otherwise
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * Change the visibility of a diary
	 * @param isPublic : the new visibility of the diary
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * Get the customer of a diary
	 * @return the customer of the diary
	 */
	public Customer getOwner() {
		return owner;
	}

	/**
	 * Change the owner of a diary
	 * @param owner : the new owner of the diary
	 */
	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	/**
	 * Get the colection of activities
	 * @return the colection of activities
	 */
	public ActivitySet getActivitySet() {
		return activitySet;
	}

	/**
	 * Change the collection of activities of a diary
	 * @param activitySet : the new collection of activities of the diary
	 */
	public void setActivitySet(ActivitySet activitySet) {
		this.activitySet = activitySet;
	}
}
