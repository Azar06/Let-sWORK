package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DataBaseConnection;
import persistence.Product;
import persistence.ProductSet;
import persistence.exception.LoadException;

public class ProductSetJDBC extends ProductSet {
	@Override
	public void loadAll() throws LoadException {
		List<Product> products = new ArrayList<Product>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT r.code, r.label, r.description, p.brandName, c.id, c.name, c.description AS catdescription FROM public.product p, public.ressource r, public.category c, public.categoryressource cr WHERE r.code = p.id AND r.code = cr.ressourcecode AND cr.categoryId = c.id;");

			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				ProductJDBC prod = new ProductJDBC();

				prod.setId(result.getLong("code"));
				prod.setBrandName(result.getString("brandName"));
				prod.setLabel(result.getString("label"));
				prod.setDescription(result.getString("description"));
				
				CategoryJDBC category = new CategoryJDBC();
				category.setId(result.getLong("id"));
				category.setName(result.getString("name"));
				category.setDescription(result.getString("catdescription"));
				prod.setCategory(category);

				products.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoadException("Can't load Products");
		}
		this.setProducts(products);
	}
}
