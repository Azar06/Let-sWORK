package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DataBaseConnection;
import persistence.Customer;
import persistence.Diary;
import persistence.Goal;
import persistence.Right;
import persistence.User;
import persistence.UserRole;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class DiaryJDBC extends Diary {

	private long id = -1;
	
	public DiaryJDBC(String name, Boolean isPublic, Customer owner) {
		super(name, isPublic, owner);
	}
	
	public DiaryJDBC() {
		super();
	}
	
	@Override
	public void load(Customer owner) throws LoadException {
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT id, name, isPublic, customerId FROM public.diary WHERE customerId = ?;");
			prepare.setLong(1, ((UserJDBC)owner.getUser()).getId());
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			if (result.next()) {
				this.setId(result.getLong("id"));
				this.setName(result.getString("name"));
				this.setPublic(result.getBoolean("isPublic"));
				this.setOwner(owner);
			}
			else {
				throw new LoadException("Can't load Diary (not found)");
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Diary (SQL issue)");
		}
	}
	
	public void save() throws SaveException {
		if(id == -1) {
			try {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.diary (id, name, isPublic, customerId) VALUES(DEFAULT, ?, ?, ?) RETURNING id;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setBoolean(2, this.isPublic());
				prepare.setLong(3, ((UserJDBC)this.getOwner().getUser()).getId());
				// Execution of the query
				ResultSet result = prepare.executeQuery();
				// we don't use a while here bcs we know username is unique
				if (result.next()) {
					// We get the username and the password and the database
					this.setId(result.getLong("id"));
				} else {
					// If there is no result : Exception
					throw new SaveException("An error");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new SaveException("An error");
			}
		}
		else {
			//this.update();
		}
	}
	
	public void update() throws SaveException {
		try {
			if(this.getId() >= 0) {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("UPDATE public.diary SET name = ?, isPublic = ?, customerId = ?) WHERE id = ?;");
				prepare.setString(1, this.getName());
				prepare.setBoolean(2, this.isPublic());
				prepare.setLong(3, ((CustomerJDBC)this.getOwner()).getId());
				prepare.setLong(4, this.getId());
				// Execution of the query
				ResultSet result = prepare.executeQuery();
				
				if(result.next()) {
					this.setId(result.getLong("id"));
				}
			}
		} catch (SQLException e) {
			throw new SaveException("Can't save this Goal");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
