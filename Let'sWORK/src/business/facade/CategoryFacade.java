package business.facade;

import business.manager.CategoryManager;


public class CategoryFacade {
	private CategoryManager manager;

	public CategoryFacade() {
		// UserManager creation
		this.manager = new CategoryManager();
	}

	public boolean create(String name, String description) {
		return this.manager.create(name, description);
		// In UserManager, if they are the same, it's OK
	}
}
