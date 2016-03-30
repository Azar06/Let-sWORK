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
	
	public abstract void loadAll() throws LoadException;

	// GETTER AND SETTER
	
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	public List<String> getLabels() {
		List<String> labels = new ArrayList<String>();
		for(Service s : this.services) {
			labels.add(s.getLabel());
		}
		return labels;
	}
	
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
