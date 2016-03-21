package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Admin;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class AdminJDBC extends Admin {

	private long id = -1;

	@Override
	public void save() throws SaveException {
		// TODO Auto-generated method stub
	}

	@Override
	public void load(long id) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.admin WHERE id = ?;");
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
				throw new LoadException("Can't load Admin with the id : " + id);
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load Admin with the id : " + id);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
