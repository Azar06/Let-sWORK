package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public UserJDBC getUser() {
		return user;
	}

	public void setUser(UserJDBC user) {
		this.user = user;
	}
}
