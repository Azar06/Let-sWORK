package business.manager;

import business.Factory;
import business.utils.CategoryReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CategoryManager {
	private Factory factorio;

	public CategoryManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}

	/**
	 * Insert a new category in the database 
	 * if all the fields have been filled in and if it does not already exist in the database
	 * @param name : the name of the category we want to create
	 * @param description : the description of the category we want to create
	 * @return state : true if the insertion has been done, false otherwise
	 */
	public CategoryReturnState create(String name, String description) {
		CategoryReturnState state = new CategoryReturnState();
		if (name == null || name.length() == 0) {
			state.setNameState("You need to fill this field.");
		} else {
			Category cat = this.factorio.createCategory();
			try {
				cat.loadWithName(name);
				state.setNameState("The name is already used.");
			}
			catch (LoadException ex){
			}
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Category category = this.factorio.createCategory();
			category.setName(name);
			category.setDescription(description);
			try {
				category.save();
			} catch (SaveException e) {
			}
		}
		return state;
	}
	
	/**
	 * Update a new category in the database 
	 * if all the fields have been filled in and if it already exists in the database
	 * @param category : an object category
	 * @return state : true if the modification has been done, false otherwise
	 */
	public CategoryReturnState save(Category category, String name, String description) {
		CategoryReturnState state = new CategoryReturnState();
		
		if (name == null || name.length() == 0) {
			state.setNameState("You need to fill this field.");
		} else if(!category.getName().equals(name)){
			Category cat = this.factorio.createCategory();
			try {
				cat.loadWithName(name);
				if(!cat.equals(category)){
					state.setNameState("The name is already used.");
				}
			}
			catch (LoadException ex){
			}
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				category.setName(name);
				category.setDescription(description);
				category.save();
			} catch (SaveException e) {
			}
		}
		return state;
	}
	
	/**
	 * Delete a category if it is present in the database
	 * @param category : an object category
	 * @return boolean : this boolean return true if the category has been deleted, and false otherwise
	 */
	public boolean delete(Category category) {
		boolean resultState = false;
		try {
			category.delete();
			resultState = true;
		}
		catch (DeleteException ex){
			ex.printStackTrace();
		}
		return resultState;
	}
	
	/**
	 * Get a collection of category
	 * @return the collection of category
	 */
	public CategorySet getCategorySet() {
		CategorySet catSet = factorio.createCategorySet();
		try {
			catSet.loadAll();
		} catch (LoadException e) {
		}
		return catSet;
	}
}
