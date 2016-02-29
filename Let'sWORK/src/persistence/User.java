package persistence;

import java.util.*;

public class User {

	private String id;
	private String password;
	private List<UserRole> roles;
	
	public User(String id, String password) {
		this.id=id;
		this.password=password;
		this.roles= new ArrayList<UserRole>();
	}
	
	public User(String id, String password, List<UserRole> rList) {
		this.id=id;
		this.password=password;
		this.roles=rList;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setPassword(String pass) {
		this.password=pass;
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
		}
	}
	
	public void delRole(UserRole r) {
		if (this.hasRole(r)) {
			this.roles.remove(r);
		}
	}
	
	public List<UserRole> getRoles() {
		return this.roles;
	}
}
