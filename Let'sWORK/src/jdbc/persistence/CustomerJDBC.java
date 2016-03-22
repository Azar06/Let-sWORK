package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Customer;
import persistence.PersonInfo;
import persistence.UserRole;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CustomerJDBC extends Customer {

	private long id = -1;
	
	public CustomerJDBC(PersonInfo personInfo) {
		super(personInfo);
	}
	
	public CustomerJDBC() {
		super(null);
	}

	@Override
	public void save() throws SaveException {
		this.getPersonInfo().save();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement(
					"INSERT INTO public.customer (id) VALUES(?);");
			// Indication about the value of the username in the WHERE
			prepare.setLong(1, ((UserJDBC)this.getUser()).getId());
			// Execution of the query
			prepare.execute();
			
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void load(long id) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.customer WHERE id = ?;");
			// Indication about the value of the username in the WHERE
			prepare.setLong(1, id);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if (result.next()) {
				// We get the username and the password and the database
				this.setId(result.getLong("id"));
			} else {
				// If there is no result : Exception
				throw new LoadException("Can't load Customer with the id : " + id);
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load Customer with the id : " + id);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
