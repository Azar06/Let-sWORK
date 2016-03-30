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
	
	public abstract void loadWithLabel(String label) throws LoadException;
	public abstract void save() throws SaveException;
	public abstract void delete() throws DeleteException;
	
}
