package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DataBaseConnection;
import persistence.Category;
import persistence.CategorySet;
import persistence.exception.LoadException;

public class CategorySetJDBC extends CategorySet {

	@Override
	public void loadAll() throws LoadException {
		List<Category> categories = new ArrayList<Category>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.category;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				CategoryJDBC cat = new CategoryJDBC();

				cat.setId(result.getLong("id"));
				cat.setName(result.getString("name"));
				cat.setDescription(result.getString("description"));
				
				categories.add(cat);
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Goals");
		}
		this.setCategories(categories);
	}

}
