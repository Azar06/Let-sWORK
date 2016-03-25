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
import persistence.User;
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
			//TODO INSERT
		}
		else {
			this.update();
		}
	}
	
	public void update() throws SaveException {
		try {
			if(this.getId() >= 0) {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("UPDATE public.goal SET name = ?, isPublic = ?, customerId = ?) WHERE id = ?;");
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