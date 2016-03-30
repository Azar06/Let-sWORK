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
	/**
	 * Get the user role of a user
	 * @param right : a collection of rights
	 * @return a role 
	 */
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
	/**
	 * Change the username of a user
	 * @param the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the username of a user
	 * @return the username of a user
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Change the password of a user
	 * @param pass : the new password
	 */
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	/**
	 * Get the password of a user
	 * @return the password of a user
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Get a collection of goals of a user
	 * @return a list of goals
	 */
	public List<Goal> getGoals() {
		return this.goals;
	}
	
	/**
	 * Check if the user as a certain role (write in parameter)
	 * @param r
	 * @return true if the user has the role, false otherwise
	 */
	public boolean hasRole(UserRole r) {
		return this.roles.contains(r);
	}
	
	/**
	 * Add a new role to a user
	 * @param r : a user role
	 */
	public void addRole(UserRole r) {
		UserRole currentRole = this.getRole(r.getRight());
		if (currentRole != null) {
			this.roles.remove(currentRole);
		}
		this.roles.add(r);
		r.setUser(this);
	}
	
	/**
	 * Remove the role of a user, to null
	 * @param r : a user role
	 */
	public void removeRole(UserRole r) {
		if (this.hasRole(r)) {
			this.roles.remove(r);
			if(r.getUser() == this){
				r.setUser(null);
			}
		}
	}
	
	/**
	 * Get a collection of roles of a user
	 * @return a list of roles
	 */
	public List<UserRole> getRoles() {
		return this.roles;
	}
	
	/**
	 * Change the collection of goals of a user
	 * @param goals : a collection of goals
	 */
	public void setGoals(List<Goal> goals) {
		this.goals = goals; 
	}
}
