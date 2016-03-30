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
		
		public Product(String brandName, String label, String description) {
			super(label, description);
			this.brandName = brandName;
		}
		
		public abstract void loadWithName(String name) throws LoadException;
		public abstract void save() throws SaveException;
		public abstract void delete() throws DeleteException;
		
		public String getBrandName() {
			return this.brandName;
		}
		
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
	
}
