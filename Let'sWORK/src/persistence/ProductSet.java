package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistence.exception.LoadException;

public abstract class ProductSet {
private List<Product> products;
	
	public ProductSet() {
		this.products = new ArrayList<Product>();
	}
	
	// ABSTRACT METHODS
	
	/**
	 * Load a collection of products, all the products in the collection.
	 * @throws LoadException
	 */
	public abstract void loadAll() throws LoadException;

	// GETTER AND SETTER
	
	/**
	 * Get a list of products
	 * @return a list of products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Change the list of products in a collection of products
	 * @param products : the list of products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * Search a list of labels
	 * @return a list whiwh contains all the labels
	 */
	public List<String> getLabels() {
		List<String> labels = new ArrayList<String>();
		for(Product p : this.products) {
			labels.add(p.getLabel());
		}
		return labels;
	}
	
	/**
	 * Search a product in a list of products
	 * @param label : the label of the product we search
	 * @return the product as an object product
	 */
	public Product getProductWithLabel(String label) {
		Iterator<Product> it = this.getProducts().iterator();
		Product p = null;
		if(label != null){
			while(it.hasNext() && p == null) {
				Product prod = it.next();
				if(label.equals(prod.getLabel())) {
					p = prod;
				}
			}
		}
		return p;
	}
}
