package business.manager;

import business.Factory;
import business.utils.ResourceReturnState;
import jdbc.FactoryJDBC;
import persistence.*;

public class ResourceManager {

	private Factory factorio;

	public ResourceManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public ResourceReturnState create(String code, String description) {
		ResourceReturnState state = new ResourceReturnState();
		if (code == null || code.length() == 0) {
			state.setCodeState("You need to fill this field.");
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Resource resource = this.factorio.createResource();
			resource.setLabel(code);
			resource.setDescription(description);
		}
		return state;
	}
}
