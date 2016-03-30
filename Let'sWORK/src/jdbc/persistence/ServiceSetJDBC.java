package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.service;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				ServiceJDBC serv = new ServiceJDBC();

				serv.setId(result.getLong("id"));
				serv.setLabel(result.getString("label"));
				serv.setDescription(result.getString("description"));
				
				services.add(serv);
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Goals");
		}
		this.setServices(services);
		
	}

}
