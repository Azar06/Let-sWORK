package persistence;

import persistence.exception.LoadException;

public abstract class UserRole implements Savable {
	
	private User user;

	public abstract void load(long id) throws LoadException;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
