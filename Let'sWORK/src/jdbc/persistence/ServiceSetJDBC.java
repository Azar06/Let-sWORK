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
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.service;");
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
                ServiceJDBC serv = new ServiceJDBC();

                serv.setId(result.getLong("id"));
                // Preparation for the query
                PreparedStatement prepare2 = connection.prepareStatement("SELECT * FROM public.ressource WHERE code = ?;");
                prepare2.setLong(1, serv.getId());
                // Execution of the query
                ResultSet result2 = prepare2.executeQuery();

                if (result2.next()) {
                    serv.setLabel(result2.getString("label"));
                    serv.setDescription(result2.getString("description"));

                    services.add(serv);
                }
			}
		} catch (SQLException e) {
//            System.out.println("-> " + e.toString());
			throw new LoadException("Can't load Services");
		}
		this.setServices(services);
		
	}

}
