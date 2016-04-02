package business.facade;

import business.manager.ProductManager;
import business.utils.ProductReturnState;
import persistence.Category;
import persistence.Product;
import persistence.ProductSet;

public class ProductFacade {
	private ProductManager manager;

	public ProductFacade() {
		// CategoryManager creation
		this.manager = new ProductManager();
	}

	//Return the state of the creation of a category
	public ProductReturnState create(String label, String description, String brandName, Category cat) {
		return this.manager.create(label, description, brandName, cat);
	}
	
	public ProductReturnState save(Product product, String label, String description, String brandName, Category category) {
		return this.manager.save(product, label, description, brandName, category);
	}
	
	public boolean delete(Product product) {
		return this.manager.delete(product);
	}
	
	public ProductSet getProductSet() {
		return this.manager.getProductSet();
	}
}
