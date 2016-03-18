package persistence;

public abstract class UserRole {
	
	private User user;
	
	// Abstract
	public abstract void save() throws SaveException;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
