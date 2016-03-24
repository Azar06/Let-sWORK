package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.DataBaseConnection;
import persistence.Ressource;
import persistence.exception.SaveException;

public class RessourceJDBC extends Ressource{

	private long id = -1;
	
	public RessourceJDBC(String name, String description) {
		super(name, description);
	}
	
	public RessourceJDBC() {
		super(null, null);
	}
	
	public void save() throws SaveException {
		/*this.getRessource().save();*/
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			if (id==-1) {
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.ressource (id, code, description) VALUES(DEFAULT, ?, ?) RETURNING id;");
				prepare.setString(1, this.getCode());
				prepare.setString(2, this.getDescription());
				// Execution of the query
				prepare.execute();
			} 
			/*
			else {
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.category SET name=?,  description=? WHERE id=?;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setString(2, this.getDescription());
				prepare.setLong(3, this.getId());
				
				// Execution of the query
				prepare.execute();
			}
			*/
			
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
