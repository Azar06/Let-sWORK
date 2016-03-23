package business.manager;

import business.Factory;
import business.utils.RessourceReturnState;
import jdbc.FactoryJDBC;
import persistence.*;

public class RessourceManager {

	private Factory factorio;

	public RessourceManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public RessourceReturnState create(String code, String description) {
		RessourceReturnState state = new RessourceReturnState();
		if (code == null || code.length() == 0) {
			state.setCodeState("You need to fill this field.");
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Ressource ressource = this.factorio.createRessource();
			ressource.setCode(code);
			ressource.setDescription(description);
		}
		return state;
	}
}
