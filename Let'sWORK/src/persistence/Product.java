package persistence;

import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public abstract class Product extends Resource {
		private String brandName;

		public Product() {
			super();
			this.brandName = null;
		}
			
		public Product(String brandName) {
			super();
			this.brandName = brandName;
		}
		
		public Product(String brandName, String label, String description, Category category) {
			super(label, description, category);
			this.brandName = brandName;
		}
		
		/**
		 * Load an object product thanks to its label.
		 * Load the id, the label, the description and the brand name of a product.
		 * @param label :  the label of the product we search
		 * @throws LoadException
		 */
		public abstract void loadWithLabel(String label) throws LoadException;
		
		/**
		 * Allow the user to create a new product
		 * @throws SaveException
		 */
		public abstract void save() throws SaveException;
		
		/**
		 * Delete the product selected
		 * @throws DeleteException
		 */
		public abstract void delete() throws DeleteException;
		
		/**
		 * Get the brand name of a product
		 * @return the brand name of a product
		 */
		public String getBrandName() {
			return this.brandName;
		}
		
		/**
		 * Change the brand name of the product
		 * @param brandName : the new brand name of the product
		 */
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
	
}
