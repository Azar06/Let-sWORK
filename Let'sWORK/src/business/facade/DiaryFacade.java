package business.facade;

import java.util.Date;
import java.util.List;

import business.manager.DiaryManager;
import persistence.Goal;
import persistence.User;

public class DiaryFacade {

	private DiaryManager diaryManager;
	
	public DiaryFacade() {
		this.diaryManager = new DiaryManager();
	}
	
	public List<Goal> getGoals(User user) {
		return this.diaryManager.getGoals(user);
	}
	
	public void createGoal(User owner, String name, String description, Date deadline) {
		this.diaryManager.createGoal(owner, name, description, deadline);
	}
}