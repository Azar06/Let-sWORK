package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Category;
import persistence.exception.DeleteException;
import persistence.PersonInfo;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class CategoryJDBC extends Category {
	
	private long id = -1;
	
	public CategoryJDBC(String name, String description) {
		super(name, description);
	}
	
	public CategoryJDBC() {
		super(null, null);
	}
	
	@Override
	public void save() throws SaveException {
		/*this.getCategory().save();*/
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			if (id == -1) {
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.category (id, name, description) VALUES(DEFAULT, ?, ?) RETURNING id;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setString(2, this.getDescription());
				// Execution of the query
				prepare.execute();
			} else {
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.category SET name=?, description=? WHERE id=?;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setString(2, this.getDescription());
				prepare.setLong(3, this.getId());
				
				// Execution of the query
				prepare.execute();
			}
						
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void loadWithName(String name) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT id, name, description FROM public.category WHERE name=?;");
			prepare.setString(1, name);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we use a while here bcs we know it is a list
			if (result.next()) {
				// We get the id, the name and the description
				this.setId(result.getLong("id"));
				this.setName(result.getString("name"));
				this.setDescription(result.getString("description"));
			} else {
				throw new LoadException("Can't load the category");
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load the category");
		}
	}

	@Override
	public void delete() throws DeleteException {
		if(this.id >= 0){
			try {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("DELETE FROM public.category WHERE id=?;");
				prepare.setLong(1, this.getId());
				// Execution of the query
				prepare.execute();
				// we use a while here bcs we know it is a list
			}
			catch (SQLException ex){
				throw new DeleteException("Can't delete the category (SQL)");
			}
		}
		else {
			throw new DeleteException("Can't delete the category");
		}
	}
	
	
/*
	public void load() throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.category;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we use a while here bcs we know it is a list
			while (result.next()) {
				// We get the id, the name and the description
				this.setId(result.getLong("id"));
				this.setName(result.getString("name"));
				this.setDescription(result.getString("url"));
			} 
		}
		catch (SQLException ex){
			throw new LoadException("Can't load the categories");
		}
	}
	*/

	/**
	 * Get the id of the category
	 * @return the id of the category
	 */
	public long getId() {
		return id;
	}

	/**
	 * Change the id of the category
	 * @param id : the new id of the category
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
