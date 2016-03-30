package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Service;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ServiceJDBC extends Service {
	private long id = -1;
	private ResourceJDBC resource;
	
	public ServiceJDBC() {
		super();
	}
	
	public ServiceJDBC(String label, String description) {
		super(label, description);
	}

	@Override
	public void loadWithLabel(String label) throws LoadException {
		// TODO Auto-generated method stub
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT id, label, description FROM public.service WHERE label=?;");
			prepare.setString(1, label);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we use a while here bcs we know it is a list
			if (result.next()) {
				// We get the id, the name and the description
				this.setId(result.getLong("id"));
				this.setLabel(result.getString("label"));
				this.setDescription(result.getString("description"));
			} else {
				throw new LoadException("Can't load the service");
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load the service");
		}
	}

	@Override
	public void save() throws SaveException {
		// TODO Auto-generated method stub
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement(
					"INSERT INTO public.service (id, label, description) VALUES(DEFAULT, ?, ?) RETURNING id;");
			prepare.setString(1, this.getLabel());
			prepare.setString(2, this.getDescription());
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know label is unique
			if (result.next()) {
				// We get the label and the description and the database
				this.setId(result.getLong("id"));
			} else {
				// If there is no result : Exception
				throw new SaveException("An error");
			}
			this.resource.save();
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}

	@Override
	public void delete() throws DeleteException {
		// TODO Auto-generated method stub
		if(this.id >= 0){
			try {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("DELETE FROM public.service WHERE id=?;");
				prepare.setLong(1, this.getId());
				// Execution of the query
				prepare.execute();
				// we use a while here bcs we know it is a list
			}
			catch (SQLException ex){
				throw new DeleteException("Can't delete the service (SQL)");
			}
		}
		else {
			throw new DeleteException("Can't delete the service");
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		this.resource.setId(id);
	}
	
}