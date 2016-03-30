package business.manager;

import business.Factory;
import business.utils.ProductReturnState;
import jdbc.FactoryJDBC;
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
	 * @param label
	 * @param description
	 * @param brandName
	 * @return
	 */
	public ProductReturnState create(String label, String description, String brandName) {
		ProductReturnState state = new ProductReturnState();
		if (label == null || label.length() == 0) {
			state.setLabelState("You need to fill this field.");
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		if (brandName == null || brandName.length() == 0) {
			state.setBrandNameState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Product product = this.factorio.createProduct();
			product.setLabel(label);
			product.setDescription(description);
		}
		return state;
	}
	
	public ProductReturnState save(Product product) {
		ProductReturnState state = new ProductReturnState();
		if (product.getLabel() == null || product.getLabel().length() == 0) {
			state.setLabelState("You need to fill this field.");
		} else if (product.getDescription() == null || product.getDescription().length() == 0) {
			state.setLabelState("You need to fill this field.");
		} else {
			Product p = this.factorio.createProduct();
			try {
				p.loadWithLabel(product.getLabel());
				if(!p.equals(product)){
					state.setLabelState("The label is already used.");
				}
			}
			catch (LoadException ex){
			}
		}
		if (product.getDescription() == null || product.getDescription().length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				product.save();
			} catch (SaveException e) {
			}
		}
		return state;
	}
	
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
	
	public ProductSet getProductSet() {
		ProductSet pSet = factorio.createProductSet();
		try {
			pSet.loadAll();
		} catch (LoadException e) {
		}
		return pSet;
	}
}
