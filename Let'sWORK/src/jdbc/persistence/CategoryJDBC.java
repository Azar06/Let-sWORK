package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Category;
import persistence.LoadException;
import persistence.PersonInfo;
import persistence.SaveException;

public class CategoryJDBC extends Category {
	
	private long id = -1;
	
	public CategoryJDBC(String name, String description) {
		super(name, description);
	}
	
	public CategoryJDBC() {
		super(null, null);
	}
	
	
	public void save() throws SaveException {
		/*this.getCategory().save();*/
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			if (id==-1) {
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.category (id, name, description) VALUES(DEFAULT, ?, ?) RETURNING id;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setString(2, this.getDescription());
				// Execution of the query
				prepare.execute();
			} else {
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.category SET name=?,  description=? WHERE id=?;");
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}