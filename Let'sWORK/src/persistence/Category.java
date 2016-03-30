package persistence;

import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public abstract class Category {

	private String name;
	private String description;

	public Category() {
		super();
		this.name = null;
		this.description = null;
	}
		
	public Category(String nom, String desc) {
		super();
		this.name = nom;
		this.description = desc;
	}
	
	/**
	 * Load an object category thanks to its name.
	 * Load the id, the name and the description of a category
	 * @param name : the name of the category we search
	 * @throws LoadException
	 */
	public abstract void loadWithName(String name) throws LoadException;
	
	/**
	 * Allow the user to create a new category
	 * @throws SaveException
	 */
	public abstract void save() throws SaveException;
	
	/**
	 * Delete the category selected
	 * @throws DeleteException
	 */
	public abstract void delete() throws DeleteException;
	
	/**
	 * Get the name of a category
	 * @return the name of the category
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Change the name of the category
	 * @param nom : the new name of the category
	 */
	public void setName(String nom) {
		this.name = nom;
	}
	
	/**
	 * Get the description of a category
	 * @return the description of the category
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Change the description of the category
	 * @param desc : the new description of the category
	 */
	public void setDescription(String desc) {
		this.description=desc;
	}
}
