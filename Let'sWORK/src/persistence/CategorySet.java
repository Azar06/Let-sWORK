package persistence;

import java.util.*;

import persistence.exception.LoadException;

public abstract class CategorySet {
	
	private List<Category> categories;
	
	public CategorySet() {
		this.categories = new ArrayList<Category>();
	}
	
	// ABSTRACT METHODS
	
	public abstract void loadAll() throws LoadException;

	// GETTER AND SETTER
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
