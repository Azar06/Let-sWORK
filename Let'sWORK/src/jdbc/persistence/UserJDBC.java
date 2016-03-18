package jdbc.persistence;

import java.sql.*;
import java.util.*;

import jdbc.DataBaseConnection;
import persistence.LoadException;
import persistence.SaveException;
import persistence.User;
import persistence.UserRole;

public class UserJDBC extends User {

	private long id;

	// Constructeurs
	public UserJDBC(String username, String password, List<UserRole> roles) {
		super(username, password, roles);
		this.id = -1;
	}

	public UserJDBC() {
		super();
		this.id = -1;
	}

	@Override
	public void load(String username) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.user WHERE username = ?;");
			// Indication about the value of the username in the WHERE
			prepare.setString(1, username);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if (result.next()) {
				// We get the username and the password and the database
				this.setId(result.getLong("id"));
				this.setUsername(result.getString("username"));
				this.setPassword(result.getString("password"));
			} else {
				// If there is no result : Exception
				throw new LoadException("Can't load User with the username : " + username);
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load User with the username : " + username);
		}
	}

	@Override
	public void save() throws SaveException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement(
					"INSERT INTO public.user (id, username, password) VALUES(DEFAULT, ?, ?) RETURNING id;");
			// Indication about the value of the username in the WHERE
			prepare.setString(1, this.getUsername());
			prepare.setString(2, this.getPassword());
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if (result.next()) {
				// We get the username and the password and the database
				this.setId(result.getLong("id"));
			} else {
				// If there is no result : Exception
				throw new SaveException("An error");
			}
			
			for(UserRole role : this.getRoles()) {
				try {
					role.save();
				} catch (SaveException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof UserJDBC && this.id >= 0){
			return this.id == ((UserJDBC)o).id;
		}
		else {
			return false;
		}
	}

	protected long getId() {
		return this.id;
	}

	protected void setId(long id) {
		this.id = id;
	}
}
