package business.manager;

import business.Factory;
import business.utils.ServiceReturnState;
import jdbc.FactoryJDBC;
import persistence.Category;
import persistence.Service;
import persistence.ServiceSet;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ServiceManager {
	private Factory factorio;

	public ServiceManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	/**
	 * Insert a new service in the database 
	 * if all the fields have been filled in and if it does not already exist in the database
	 * @param label : the label of the service we want to create
	 * @param description : the description of the service we want to create
	 * @param cat : the category associate to the service
	 * @return state : true if the insertion has been done, false otherwise
	 */
	public ServiceReturnState create(String label, String description, Category cat) {
		ServiceReturnState state = new ServiceReturnState();
		if (label == null || label.length() == 0) {
			state.setLabelState("You need to fill this field.");
		}
		if (description == null || description.length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		if (cat == null) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				Service service = this.factorio.createService();
				service.setLabel(label);
				service.setDescription(description);
				service.setCategory(cat);
				service.save();
			}
			catch (SaveException e) {
				System.out.println("ServiceManager a fait la merde");
			}
		}
		return state;
	}
	
	/**
	 * Update a service in the database 
	 * if all the fields have been filled in and if it already exists in the database
	 * @param service : an object service
	 * @return state : true if the modification has been done, false otherwise
	 */
	public ServiceReturnState save(Service service) {
		ServiceReturnState state = new ServiceReturnState();
		if (service.getLabel() == null || service.getLabel().length() == 0) {
			state.setLabelState("You need to fill this field.");
		} else if (service.getDescription() == null || service.getDescription().length() == 0) {
			state.setLabelState("You need to fill this field.");
		} else {
			Service s = this.factorio.createService();
			try {
				s.loadWithLabel(service.getLabel());
				if(!s.equals(service)){
					state.setLabelState("The label is already used.");
				}
			}
			catch (LoadException ex){
			}
		}
		if (service.getDescription() == null || service.getDescription().length() == 0) {
			state.setDescriptionState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			try {
				service.save();
			} catch (SaveException e) {
			}
		}
		return state;
	}
	
	/**
	 * Delete a service if it is present in the database
	 * @param service : an object service
	 * @return boolean : this boolean return true if the service has been deleted, and false otherwise
	 */
	public boolean delete(Service service) {
		boolean resultState = false;
		try {
			service.delete();
			resultState = true;
		}
		catch (DeleteException ex){
			ex.printStackTrace();
		}
		return resultState;
	}
	
	/**
	 * Get a collection of services
	 * @return the collection of services
	 */
	public ServiceSet getServiceSet() {
		ServiceSet sSet = factorio.createServiceSet();
		try {
			sSet.loadAll();
		} catch (LoadException e) {
		}
		return sSet;
	}
	
}
