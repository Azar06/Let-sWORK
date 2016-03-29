package persistence;

import persistence.exception.LoadException;

public abstract class Category {

	private String name;
	private String description;

	public Category() {
		this.name = null;
		this.description = null;
	}
		
	public Category(String nom, String desc) {
		super();
		this.name = nom;
		this.description = desc;
	}
	
	public abstract void loadWithName(String name) throws LoadException;
	
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
