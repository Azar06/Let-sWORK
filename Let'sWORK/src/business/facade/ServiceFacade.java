package business.facade;

import business.manager.ServiceManager;
import business.utils.ServiceReturnState;
import persistence.Service;
import persistence.ServiceSet;

public class ServiceFacade {
	private ServiceManager manager;

	public ServiceFacade() {
		// CategoryManager creation
		this.manager = new ServiceManager();
	}

	//Return the state of the creation of a category
	public ServiceReturnState create(String label, String description) {
		return this.manager.create(label, description);
	}
	
	public ServiceReturnState save(Service service) {
		return this.manager.save(service);
	}
	
	public boolean delete(Service service) {
		return this.manager.delete(service);
	}
	
	public ServiceSet getServiceSet() {
		return this.manager.getServiceSet();
	}
}
