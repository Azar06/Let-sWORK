package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.PersonInfo;
import persistence.SaveException;
import persistence.Seller;

public class SellerJDBC extends Seller {

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
}
