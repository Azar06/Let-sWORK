package business.manager;

import business.Factory;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;

public class CategoryManager {
	private Factory factorio;

	public CategoryManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}

	public boolean create(String name, String description) {
		return false;
	}

}
