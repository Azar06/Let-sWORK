package persistence;

import java.util.*;

import persistence.exception.LoadException;

public abstract class User implements Savable {

	private String username;
	private String password;
	private List<UserRole> roles;
	private List<Goal> goals;
	
	// Abstract
	public abstract void load(String username) throws LoadException;
	public abstract void loadGoals() throws LoadException;
	
	// Constructor
	public User(String username, String password, List<UserRole> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.goals = null;
	}
	
	public User(String username, String password) {
		this(username, password, new ArrayList<UserRole>());
	}
	
	public User() {
		this(null, null);
	}
	
	// METHODS
	public UserRole getRole(Right right) {
		UserRole role = null;
		Iterator<UserRole> it = this.roles.iterator();
		while(it.hasNext() && role == null) {
			UserRole r = it.next();
			if(r.getRight() == right) {
				role = r;
			}
		}
		return role;
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
	
	public List<Goal> getGoals() {
		return this.goals;
	}
	
	public boolean hasRole(UserRole r) {
		return this.roles.contains(r);
	}
	
	public void addRole(UserRole r) {
		UserRole currentRole = this.getRole(r.getRight());
		if (currentRole != null) {
			this.roles.remove(currentRole);
		}
		this.roles.add(r);
		r.setUser(this);
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
	
	public void setGoals(List<Goal> goals) {
		this.goals = goals; 
	}
}
