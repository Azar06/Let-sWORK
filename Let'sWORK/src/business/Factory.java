package business;

import persistence.*;

public abstract class Factory {
	
	public abstract User getUserWithUsername(String id);
}
