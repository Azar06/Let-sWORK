package jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DataBaseConnection;
import persistence.Activity;
import persistence.ActivitySet;
import persistence.Diary;
import persistence.User;
import persistence.exception.LoadException;

public class ActivitySetJDBC extends ActivitySet {

	@Override
	public void loadWithDiary(Diary diary) throws LoadException {
		List<Activity> activities = new ArrayList<Activity>();
		try {
			Connection connection = DataBaseConnection.getConnection();
			// Preparation for the query
			PreparedStatement prepare = connection.prepareStatement("SELECT id, name, date, position, isPublic, diaryid, categoryid, goalid FROM public.activity WHERE diaryid = ?;");
			prepare.setLong(1, ((DiaryJDBC)diary).getId());
			// Execution of the query
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				ActivityJDBC activity = new ActivityJDBC();

				activity.setId(result.getLong("id"));
				activity.setName(result.getString("name"));
				activity.setDate(result.getDate("date"));
				activity.setPosition(result.getInt("position"));
				activity.setIsPublic(result.getBoolean("isPublic"));
				activity.setDiary(diary);
				// categoryId
				// goalId
					
				activities.add(activity);
			}
		} catch (SQLException e) {
			throw new LoadException("Can't load Goals");
		}
		this.setActivities(activities);
	}

}
