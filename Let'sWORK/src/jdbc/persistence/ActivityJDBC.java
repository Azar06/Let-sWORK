package jdbc.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DataBaseConnection;
import persistence.Activity;
import persistence.Category;
import persistence.Diary;
import persistence.Goal;
import persistence.TimePosition;
import persistence.exception.DeleteException;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class ActivityJDBC extends Activity {

	private long id = -1;
	
	public ActivityJDBC(String name, Date date, TimePosition position, boolean isPublic, Diary diary, Category category, Goal goal) {
		super(name, date, position, isPublic, diary, category, goal);
	}
	
	public ActivityJDBC() {
		super();
	}

	@Override
	public void save() throws SaveException {
		/*this.getCategory().save();*/
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			if (id == -1) {
				PreparedStatement prepare = connection.prepareStatement(
						"INSERT INTO public.activity (id, name, date, position, isPublic, diaryId, categoryId, goalId) VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?) RETURNING id;");
				prepare.setString(1, this.getName());
				prepare.setDate(2, this.getDate());
				prepare.setInt(3, this.getPosition().getValue());
				prepare.setBoolean(4, this.getIsPublic());
				prepare.setLong(5, ((DiaryJDBC)getDiary()).getId());
				prepare.setLong(6, ((CategoryJDBC)getCategory()).getId());
				prepare.setLong(7, ((GoalJDBC)getGoal()).getId());
				// Execution of the query
				ResultSet res = prepare.executeQuery();
				
				if(res.next()){
					this.id = res.getLong("id");
				}
				else {
					throw new SaveException("Can't know the id !");
				}
			} 
			/*
			else {
				PreparedStatement prepare = connection.prepareStatement(
						"UPDATE public.category SET name=?,  description=? WHERE id=?;");
				// Indication about the value of the username in the WHERE
				prepare.setString(1, this.getName());
				prepare.setString(2, this.getDescription());
				prepare.setLong(3, this.getId());
				
				// Execution of the query
				prepare.execute();
			}
			*/
			
		} catch (SQLException e) {
			throw new SaveException("An error");
		}
	}
	
	@Override
	public void delete() throws DeleteException {
		if(this.getId() >= 0){
			try {
				Connection connection = DataBaseConnection.getConnection();
				// Preparation for the query
				PreparedStatement prepare = connection.prepareStatement("DELETE FROM public.activity WHERE id = ?;");
				prepare.setLong(1, this.getId());
				// Execution of the query
				prepare.execute();
				
				this.setId(-1);
			}
			catch (SQLException ex){
				throw new DeleteException("Can't delete the activity (SQL)");
			}
		}
		else {
			throw new DeleteException("Can't delete the activity");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
