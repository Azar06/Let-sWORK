package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jdbc.DataBaseConnection;
import persistence.*;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class GoalJDBC extends Goal {
	
	private long id = -1;
	
	public static List<Goal> loadGoals(UserJDBC user) throws LoadException {
		List<Goal> goals = new ArrayList<Goal>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM public.goal WHERE customer.id = ?;");
			prepare.setLong(1, user.getId());
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				GoalJDBC goal = new GoalJDBC();

				goal.setId(result.getLong("id"));
				goal.setUser(user);
				goal.setName(result.getString("name"));
				goal.setDescription(result.getString("description"));
				goal.setDeadline(result.getDate("deadline"));
				
				goals.add(goal);
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Goals");
		}
		return goals;
	}
	
	@Override
	public void save() throws SaveException {
		try {
			if(this.getId() < 0) { // INSERT
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("INSERT INTO public.goal (id, name, description, deadline, customerId) VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id;");
				prepare.setLong(1, this.getId());
				// Execution of the query
				ResultSet result = prepare.executeQuery();
				
				if(result.next()) {
					this.setId(result.getLong("id"));
				}
			}
			else { // UPDATE
				
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
