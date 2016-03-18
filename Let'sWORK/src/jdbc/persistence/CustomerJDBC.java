package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Customer;
import persistence.PersonInfo;
import persistence.SaveException;
import persistence.UserRole;

public class CustomerJDBC extends Customer {

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
}
