package business.facade;

import business.manager.ServiceManager;
import business.utils.ServiceReturnState;
import persistence.Category;
import persistence.Service;
import persistence.ServiceSet;

public class ServiceFacade {
	private ServiceManager manager;

	public ServiceFacade() {
		// CategoryManager creation
		this.manager = new ServiceManager();
	}

	//Return the state of the creation of a category
	public ServiceReturnState create(String label, String description, Category cat) {
		return this.manager.create(label, description, cat);
	}
	
	public ServiceReturnState save(Service service, String label, String description, Category category) {
		return this.manager.save(service, label, description, category);
	}
	
	public boolean delete(Service service) {
		return this.manager.delete(service);
	}
	
	public ServiceSet getServiceSet() {
		return this.manager.getServiceSet();
	}
}
