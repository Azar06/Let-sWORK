package persistence;

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
	
	public abstract void loadWithName(String name) throws LoadException;
	public abstract void save() throws SaveException;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
}
