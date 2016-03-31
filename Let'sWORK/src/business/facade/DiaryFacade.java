package business.facade;

import java.sql.Date;
import java.util.List;

import business.manager.DiaryManager;
import business.utils.ActivityReturnState;
import persistence.Activity;
import persistence.Category;
import persistence.Diary;
import persistence.Goal;
import persistence.GoalSet;
import persistence.TimePosition;
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
	
	public ActivityReturnState createActivity(Diary diary, String name, Date date, TimePosition position, boolean isPublic, Category category, Goal goal) {
		return this.diaryManager.createActivity(diary, name, date, position, isPublic, category, goal);
	}
	
	public Diary getDiaryWithActivySet(User user) {
		return this.diaryManager.getDiaryWithActivySet(user);
	}
	
	public boolean deleteActivity(Activity activity) {
		return this.diaryManager.deleteActivity(activity);
	}
}
