package persistence;

import persistence.exception.*;

public abstract class Diary {
	private String name;
	private Boolean isPublic;
	private Customer owner;
	
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
	public abstract void load(Customer owner) throws LoadException;
	public abstract void save() throws SaveException;
	public abstract void update() throws SaveException;
	
	// GETTER / SETTER

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
}
