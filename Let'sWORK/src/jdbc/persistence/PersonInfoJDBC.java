package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.*;

public class PersonInfoJDBC extends PersonInfo {

	private UserJDBC user;
	private boolean alreadySaved = false;

	public PersonInfoJDBC(UserJDBC user) {
		super();
		this.user = user;
	}

	public PersonInfoJDBC() {
		this(null);
	}

	public PersonInfoJDBC(String ln, String fn, String s, String pc, String c, String p, String e) {
		super(ln, fn, s, pc, c, p, e);
	}

	@Override
	public void save() throws SaveException {
		try {
			if (!this.alreadySaved) {
				// INSERT
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.person (id, firstName, lastName, street, postalCode, city, phone, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
				// Indication about the value of the username in the WHERE
				prepare.setLong(1, ((UserJDBC) this.getUser()).getId());
				prepare.setString(2, this.getFistName());
				prepare.setString(3, this.getLastName());
				prepare.setString(4, this.getStreet());
				prepare.setString(5, this.getPostalCode());
				prepare.setString(6, this.getCity());
				prepare.setString(7, this.getPhone());
				prepare.setString(8, this.getEmail());

				// Execution of the query
				prepare.execute();

				this.alreadySaved = true;
			} else {
				// UPDATE
				// TODO
			}
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void load(long id) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT firstName, lastName, street, postalCode, city, phone, email FROM public.person WHERE id = ?;");
			// Indication about the value of the username in the WHERE
			prepare.setLong(1, id);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if (result.next()) {
				// We get the username and the password and the database
				this.setFistName(result.getString("firstName"));
				this.setLastName(result.getString("lastName"));
				this.setStreet(result.getString("street"));
				this.setPostalCode(result.getString("postalCode"));
				this.setCity(result.getString("city"));
				this.setPhone(result.getString("phone"));
				this.setEmail(result.getString("email"));
			} else {
				// If there is no result : Exception
				throw new LoadException("Can't load Admin with the id : " + id);
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load Admin with the id : " + id);
		}
	}

	public UserJDBC getUser() {
		return user;
	}

	public void setUser(UserJDBC user) {
		this.user = user;
	}
	
	public long getId() {
		return this.getUser().getId();
	}
}
