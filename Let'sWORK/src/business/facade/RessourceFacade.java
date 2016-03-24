package business.facade;

import business.manager.RessourceManager;
import business.utils.RessourceReturnState;

public class RessourceFacade {

	private RessourceManager manager;

	public RessourceFacade() {
		// RessourceManager creation
		this.manager = new RessourceManager();
	}

	//Return the state of the creation of a ressource
	public RessourceReturnState create(String code, String description) {
		return this.manager.create(code, description);
	}
	
}
