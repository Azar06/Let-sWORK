package jdbc.persistence;

import java.sql.*;
import java.util.*;

import jdbc.DataBaseConnection;
import persistence.LoadException;
import persistence.User;
import persistence.UserRole;

public class UserJDBC extends User {

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
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.user WHERE username = ?;");
			prepare.setString(1, username);
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if(result.next()) {
				this.setUsername(result.getString("username"));
				this.setPassword(result.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoadException("Can't load User with the username : " + username);
		}
		
	}
	
}
