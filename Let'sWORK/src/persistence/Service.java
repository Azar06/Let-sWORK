package persistence;

import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public abstract class Service extends Resource {
	
	public Service() {
		super();
	}
	
	public Service(String label, String desc, Category category) {
		super(label,desc, category);
	}
	
	/**
	 * Load an object service thanks to its label.
	 * Load the id, the label and the description of a service.
	 * @param label : the label of the service we search
	 * @throws LoadException
	 */
	public abstract void loadWithLabel(String label) throws LoadException;
	
	/**
	 * Create a new service.
	 * @throws SaveException
	 */
	public abstract void save() throws SaveException;
	
	/**
	 * Delete the service selected
	 * @throws DeleteException
	 */
	public abstract void delete() throws DeleteException;
	
}
