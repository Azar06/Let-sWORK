package business.facade;

import business.manager.CategoryManager;
import business.utils.CategoryReturnState;


public class CategoryFacade {
	private CategoryManager manager;

	public CategoryFacade() {
		// CategoryManager creation
		this.manager = new CategoryManager();
	}

	//Return the state of the creation of a category
	public CategoryReturnState create(String name, String description) {
		return this.manager.create(name, description);
	}
}
