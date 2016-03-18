package persistence;

import java.util.*;

public abstract class User implements Savable {

	private String username;
	private String password;
	private List<UserRole> roles;
	
	// Abstract
	public abstract void load(String username) throws LoadException;
	
	// Constructor
	public User(String username, String password, List<UserRole> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User(String username, String password) {
		this(username, password, new ArrayList<UserRole>());
	}
	
	public User() {
		this(null, null, null);
	}
	
	// GETTER / SETTER
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean hasRole(UserRole r) {
		return this.roles.contains(r);
	}
	
	public void addRole(UserRole r) {
		if (!(this.hasRole(r))) {
			this.roles.add(r);
			r.setUser(this);
		}
	}
	
	public void removeRole(UserRole r) {
		if (this.hasRole(r)) {
			this.roles.remove(r);
			if(r.getUser() == this){
				r.setUser(null);
			}
		}
	}
	
	public List<UserRole> getRoles() {
		return this.roles;
	}
}
