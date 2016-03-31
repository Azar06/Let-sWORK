package business.facade;

import java.sql.Date;
import java.util.List;

import business.manager.DiaryManager;
import persistence.Activity;
import persistence.Diary;
import persistence.Goal;
import persistence.GoalSet;
import persistence.User;

public class DiaryFacade {

	private DiaryManager diaryManager;
	
	public DiaryFacade() {
		this.diaryManager = new DiaryManager();
	}
	
	public GoalSet getGoalSet(User user) {
		return this.diaryManager.getGoalSet(user);
	}
	
	public void createGoal(User owner, String name, String description, Date deadline) {
		this.diaryManager.createGoal(owner, name, description, deadline);
	}
	
	public Diary getDiaryWithActivySet(User user) {
		return this.diaryManager.getDiaryWithActivySet(user);
	}
	
	public boolean deleteActivity(Activity activity) {
		return this.diaryManager.deleteActivity(activity);
	}
}
