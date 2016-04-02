package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Category;
import persistence.Product;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ProductJDBC extends Product {
	private long id = -1;
	private ResourceJDBC resource;
	
	public ProductJDBC() {
		super();
	}
	
	public ProductJDBC(String brandName, String label, String description, Category category) {
		super(brandName, label, description, category);
	}
	
	@Override
	public void loadWithLabel(String label) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT code FROM public.ressource WHERE label = ?;");

			prepare.setString(1, label);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we use a while here bcs we know it is a list
			if (result.next()) {
				// We get the id, the name and the description
				this.setId(result.getLong("code"));

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
		try {
			if(this.id < 0) {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.ressource (code, label, description) VALUES(DEFAULT, ?, ?) RETURNING code;");
				prepare.setString(1, this.getLabel());
				prepare.setString(2, this.getDescription());
				// Execution of the query
				ResultSet result = prepare.executeQuery();
				// we don't use a while here bcs we know label is unique
				if (result.next()) {
					// We get the label and the description and the database
					this.setId(result.getLong("code"));
				} else {
					// If there is no result : Exception
					throw new SaveException("An error");
				}
	
				PreparedStatement prepare2 = connection.prepareStatement("INSERT INTO public.product (id, brandname) VALUES(?, ?);");
				prepare2.setLong(1, this.getId());
				prepare2.setString(2, this.getBrandName());
				// Execution of the query
				prepare2.execute();
				
				PreparedStatement prepare3 = connection.prepareStatement(
						"INSERT INTO public.categoryressource (categoryid, ressourcecode) VALUES(?, ?)");
				prepare3.setLong(1, ((CategoryJDBC)this.getCategory()).getId());
				prepare3.setLong(2, this.getId());
				prepare3.execute();
			}
			else {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.ressource SET label = ?, description = ? WHERE code = ?;");
				prepare.setString(1, this.getLabel());
				prepare.setString(2, this.getDescription());
				prepare.setLong(3, this.getId());
				prepare.execute();
				
				PreparedStatement prepare2 = connection.prepareStatement("UPDATE public.product SET brandname = ? WHERE id = ?;");
				prepare2.setString(1, this.getBrandName());
				prepare2.setLong(2, this.getId());
				
				// Execution of the query
				prepare2.execute();
				
				PreparedStatement prepare3 = connection.prepareStatement(
						"UPDATE public.categoryressource SET categoryid = ? WHERE ressourcecode = ?;");
				prepare3.setLong(1, ((CategoryJDBC)this.getCategory()).getId());
				prepare3.setLong(2, this.getId());
				prepare3.execute();
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void delete() throws DeleteException {
		if(this.id >= 0){
			try {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("DELETE FROM public.product WHERE id=?;");
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

	/**
	 * Get the id of the product
	 * @return the id of the product
	 */
	public long getId() {
		return id;
	}

	/**
	 * Change the id of the product
	 * @param id : the new id of the product
	 */
	public void setId(long id) {
		this.id = id;
//		this.resource.setId(id);
	}
}
