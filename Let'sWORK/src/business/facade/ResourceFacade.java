package business.facade;

import business.manager.ResourceManager;
import business.utils.ResourceReturnState;

public class ResourceFacade {

	private ResourceManager manager;

	public ResourceFacade() {
		// RessourceManager creation
		this.manager = new ResourceManager();
	}

	//Return the state of the creation of a resource
	public ResourceReturnState create(String code, String description) {
		return this.manager.create(code, description);
	}
	
}
