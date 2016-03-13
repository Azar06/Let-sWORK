package jdbc.persistence;

import java.sql.*;
import java.util.*;

import jdbc.DataBaseConnection;
import persistence.LoadException;
import persistence.User;
import persistence.UserRole;

public class UserJDBC extends User {

	//Constructeurs
	public UserJDBC(String username, String password, List<UserRole> roles) {
		super(username, password, roles);
	}
	
	public UserJDBC() {
		super();
	}

	@Override
	public void load(String username) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			//Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.user WHERE username = ?;");
			//Indication about the value of the username in the WHERE
			prepare.setString(1, username);
			//Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if(result.next()) {
				//We get the username and the password and the database
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
	
}
