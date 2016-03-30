package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DataBaseConnection;
import persistence.Category;
import persistence.Resource;
import persistence.exception.SaveException;

public class ResourceJDBC extends Resource{

	private long id = -1;
	
	public ResourceJDBC(String name, String description, Category cat) {
		super(name, description, cat);
	}
	
	public ResourceJDBC() {
		super(null, null, null);
	}
	
	public void save() throws SaveException {
		/*this.getRessource().save();*/
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			if (id==-1) {
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.ressource (code, label, description) VALUES(DEFAULT, ?, ?) RETURNING id;");
				prepare.setString(1, this.getLabel());
				prepare.setString(2, this.getDescription());
				// Execution of the query
				ResultSet rs = prepare.executeQuery();
				
				this.setId(rs.getLong("id"));
				PreparedStatement prepareCatId = connection.prepareStatement("SELECT id FROM public.category WHERE name = ?");
				prepareCatId.setString(1, this.getCategory().getName());
				ResultSet rsCatId = prepareCatId.executeQuery();
				
				PreparedStatement prepare2 = connection.prepareStatement("INSERT INTO public.categoryRessource (categoryId, ressourceCode) VALUES(?,?) RETURNING categoryId;");
				prepare2.setString(1, rsCatId.getString("id"));
				prepare2.setLong(2, this.getId());
				prepare2.execute();
			} else {
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.ressource SET label=?,  description=? WHERE code=?;");
				prepare.setString(1, this.getLabel());
				prepare.setString(2, this.getDescription());
				prepare.setLong(3, this.getId());
				// Execution of the query
				prepare.execute();
				
				PreparedStatement prepareCatId = connection.prepareStatement("SELECT id FROM public.category WHERE name = ?");
				prepareCatId.setString(1, this.getCategory().getName());
				ResultSet rsCatId = prepareCatId.executeQuery();
				
				PreparedStatement prepare2 = connection.prepareStatement("UPDATE public.categoryRessource SET categoryId=? WHERE ressourceCode=?;");
				prepare.setString(1, rsCatId.getString("id"));
				prepare.setLong(2, this.getId());
				prepare2.execute();				
			}
			
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
