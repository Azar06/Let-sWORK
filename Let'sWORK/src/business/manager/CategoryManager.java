package business.manager;

import java.sql.PreparedStatement;
import java.util.List;

import business.Factory;
import business.utils.CategoryReturnState;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CategoryManager {
	private Factory factorio;

	public CategoryManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}

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
	
	public CategoryReturnState save(Category category) {
		CategoryReturnState state = new CategoryReturnState();
		if (category.getName() == null || category.getName().length() == 0) {
			state.setNameState("You need to fill this field.");
		} else {
			Category cat = this.factorio.createCategory();
			try {
				cat.loadWithName(category.getName());
				if(!cat.equals(category)){
					state.setNameState("The name is already used.");
				}
			}
			catch (LoadException ex){
			}
		}
		if (category.getDescription() == null || category.getDescription().length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				category.save();
			} catch (SaveException e) {
			}
		}
		return state;
	}
	
	public CategorySet getCategorySet() {
		CategorySet catSet = factorio.createCategorySet();
		try {
			catSet.loadAll();
		} catch (LoadException e) {
		}
		return catSet;
	}
}
