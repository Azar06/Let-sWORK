package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.PersonInfo;
import persistence.Seller;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class SellerJDBC extends Seller {

	private long id = -1;
	
	public SellerJDBC(PersonInfo person, String siret, String url) {
		super(person, siret, url);
	}
	
	public SellerJDBC() {
		super(null, null, null);
	}

	@Override
	public void save() throws SaveException {
		this.getPersonInfo().save();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement(
					"INSERT INTO public.seller (id, siret, url) VALUES(?, ?, ?);");
			// Indication about the value of the username in the WHERE
			prepare.setLong(1, ((UserJDBC)this.getUser()).getId());
			prepare.setString(2, this.getSiret());
			prepare.setString(3, this.getUrl());
			// Execution of the query
			prepare.execute();
			
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void load(long id) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.seller WHERE id = ?;");
			// Indication about the value of the username in the WHERE
			prepare.setLong(1, id);
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			// we don't use a while here bcs we know username is unique
			if (result.next()) {
				// We get the username and the password and the database
				this.setId(result.getLong("id"));
				this.setSiret(result.getString("siret"));
				this.setUrl(result.getString("url"));
			} else {
				// If there is no result : Exception
				throw new LoadException("Can't load Seller with the id : " + id);
			}
		}
		catch (SQLException ex){
			throw new LoadException("Can't load Seller with the id : " + id);
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
