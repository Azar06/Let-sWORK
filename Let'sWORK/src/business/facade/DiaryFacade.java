package business.facade;

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
	
	public void createGoal() {
		
	}
	
	public void updateGoal() {
		
	}
}
