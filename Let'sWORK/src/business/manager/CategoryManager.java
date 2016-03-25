package business.manager;

import java.sql.PreparedStatement;

import business.Factory;
import business.utils.CategoryReturnState;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.LoadException;

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
		}
		return state;
	}
}
