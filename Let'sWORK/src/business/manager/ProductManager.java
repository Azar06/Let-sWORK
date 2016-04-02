package business.manager;

import business.Factory;
import business.utils.ProductReturnState;
import jdbc.FactoryJDBC;
import persistence.Category;
import persistence.Product;
import persistence.ProductSet;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ProductManager {
	private Factory factorio;

	public ProductManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	/**
	 * Insert a new product in the database 
	 * if all the fields have been filled in and if it does not already exist in the database
	 * @param label : the label of the product we want to create
	 * @param description : the description of the product we want to create
	 * @param brandName : the brand name of the product we want to create
	 * @param cat : the category associate to the product
	 * @return state : true if the insertion has been done, false otherwise
	 */
	public ProductReturnState create(String label, String description, String brandName, Category cat) {
		ProductReturnState state = new ProductReturnState();
		if (label == null || label.length() == 0) {
			state.setLabelState("You need to fill this field.");
		} else {
			Product p = this.factorio.createProduct();
			try {
				p.loadWithLabel(label);
				System.out.println("COUCOU");
				state.setLabelState("The label is already used.");
			}
			catch (LoadException ex){
			}
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		if (brandName == null || brandName.length() == 0) {
			state.setBrandNameState("You need to fill this field.");
		}
		if (cat == null) {
			state.setBrandNameState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				Product product = this.factorio.createProduct();
				product.setLabel(label);
				product.setDescription(description);
				product.setBrandName(brandName);
				product.setCategory(cat);
				product.save();
			}
			catch (SaveException e) {
				state.setLabelState("SQL error");
			}
		}
		return state;
	}
	
	/**
	 * Update a product in the database 
	 * if all the fields have been filled in and if it already exists in the database
	 * @param product : an object product
	 * @return state : true if the modification has been done, false otherwise
	 */
	public ProductReturnState save(Product product, String label, String description, String brandName, Category category) {
		ProductReturnState state = new ProductReturnState();
		if (label == null || label.length() == 0) {
			state.setLabelState("You need to fill this field.");
		}
		else if(!label.equals(product.getLabel())) {
			Product p = this.factorio.createProduct();
			try {
				p.loadWithLabel(label);
				state.setLabelState("The label is already used.");
			}
			catch (LoadException ex){
			}
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		} 
		if (brandName == null || brandName.length() == 0){
			state.setBrandNameState("You need to fill this fiels.");
		}
		if (category == null) {
			state.setBrandNameState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				product.setLabel(label);
				product.setDescription(description);
				product.setBrandName(brandName);
				product.setCategory(category);
				product.save();
			} catch (SaveException e) {
				state.setLabelState("SQL error");
			}
		}
		return state;
	}
	
	/**
	 * Delete a product if it is present in the database
	 * @param product : an object product
	 * @return boolean : this boolean return true if the product has been deleted, and false otherwise
	 */
	public boolean delete(Product product) {
		boolean resultState = false;
		try {
			product.delete();
			resultState = true;
		}
		catch (DeleteException ex){
			ex.printStackTrace();
		}
		return resultState;
	}
	
	/**
	 * Get a collection of products
	 * @return the collection of products
	 */
	public ProductSet getProductSet() {
		ProductSet pSet = factorio.createProductSet();
		try {
			pSet.loadAll();
		} catch (LoadException e) {
			e.printStackTrace();
		}
		return pSet;
	}
}
