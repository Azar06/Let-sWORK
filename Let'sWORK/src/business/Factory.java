package business;

import persistence.*;

public interface Factory {
	
	public abstract User getUserWithUsername(String id);
}
