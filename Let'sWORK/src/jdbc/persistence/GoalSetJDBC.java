package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DataBaseConnection;
import persistence.Activity;
import persistence.Goal;
import persistence.GoalSet;
import persistence.User;
import persistence.exception.LoadException;

public class GoalSetJDBC extends GoalSet {

	public void loadWithUser(User user) throws LoadException {
		List<Goal> goals = new ArrayList<Goal>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT id, name, description, deadline FROM public.goal WHERE customer.id = ?;");
			prepare.setLong(1, ((UserJDBC)user).getId());
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
		this.setGoals(goals);
	}
}
