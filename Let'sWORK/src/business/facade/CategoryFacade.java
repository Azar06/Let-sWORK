package business.facade;

import business.manager.CategoryManager;
import business.utils.CategoryReturnState;
import persistence.Category;
import persistence.CategorySet;


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
	
	public CategoryReturnState save(Category category, String name, String description) {
		return this.manager.save(category, name, description);
	}
	
	public boolean delete(Category category) {
		return this.manager.delete(category);
	}
	
	public CategorySet getCategorySet() {
		return this.manager.getCategorySet();
	}
}
