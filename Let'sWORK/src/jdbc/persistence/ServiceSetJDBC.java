package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Factory;
import jdbc.DataBaseConnection;
import persistence.Service;
import persistence.ServiceSet;
import persistence.exception.LoadException;

public class ServiceSetJDBC extends ServiceSet {
	@Override
	public void loadAll() throws LoadException {
		List<Service> services = new ArrayList<Service>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT r.code, r.label, r.description, c.id, c.name, c.description AS catdescription FROM public.service s, public.ressource r, public.category c, public.categoryressource cr WHERE r.code = s.id AND r.code = cr.ressourcecode AND cr.categoryId = c.id;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
                ServiceJDBC serv = new ServiceJDBC();

                serv.setId(result.getLong("code"));
                serv.setLabel(result.getString("label"));
                serv.setDescription(result.getString("description"));

				CategoryJDBC category = new CategoryJDBC();
				category.setId(result.getLong("id"));
				category.setName(result.getString("name"));
				category.setDescription(result.getString("catdescription"));
				serv.setCategory(category);
				
                services.add(serv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoadException("Can't load Services");
		}
		this.setServices(services);
		
	}

}
