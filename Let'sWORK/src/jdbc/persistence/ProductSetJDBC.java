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
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.product;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				ProductJDBC prod = new ProductJDBC();

				prod.setId(result.getLong("id"));
				prod.setBrandName(result.getString("brandName"));
				// Preparation for the query
				PreparedStatement prepare2 = connection.prepareStatement("SELECT * FROM public.ressource WHERE code = ?;");
				prepare2.setLong(1, prod.getId());
				// Execution of the query
				ResultSet result2 = prepare2.executeQuery();

				if (result2.next()) {
					prod.setLabel(result2.getString("label"));
					prod.setDescription(result2.getString("description"));

					products.add(prod);
				}
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Products");
		}
		this.setProducts(products);
		
	}
}
