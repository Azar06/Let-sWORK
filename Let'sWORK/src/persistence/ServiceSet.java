package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistence.exception.LoadException;

public abstract class ServiceSet {
	
	private List<Service> services;
	
	public ServiceSet() {
		this.services = new ArrayList<Service>();
	}
	
	// ABSTRACT METHODS
	
	/**
	 * Load a collection of services, all the services in the collection.
	 * @throws LoadException
	 */
	public abstract void loadAll() throws LoadException;

	// GETTER AND SETTER
	
	/**
	 * Get a list of services
	 * @return a list of services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * Change the list of services in a collection of services
	 * @param services : the list of services
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	/**
	 * Search a list of services labels
	 * @return a list which contains all the services labels
	 */
	public List<String> getLabels() {
		List<String> labels = new ArrayList<String>();
		for(Service s : this.services) {
			labels.add(s.getLabel());
		}
		return labels;
	}
	
	/**
	 * Search a service in a list of services by its label
	 * @param label : the label of the service we search
	 * @return the service as an object service
	 */
	public Service getServiceWithLabel(String label) {
		Iterator<Service> it = this.getServices().iterator();
		Service s = null;
		if(label != null){
			while(it.hasNext() && s == null) {
				Service serv = it.next();
				if(label.equals(serv.getLabel())) {
					s = serv;
				}
			}
		}
		return s;
	}
}
