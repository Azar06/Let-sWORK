package business.facade;

import business.manager.ActivityManager;
import business.manager.CategoryManager;
import business.utils.ActivityReturnState;
import business.utils.CategoryReturnState;

public class ActivityFacade {
	private ActivityManager manager;

	public ActivityFacade() {
		// ActivityManager creation
		this.manager = new ActivityManager();
	}

	//Return the state of the creation of an activity
	public ActivityReturnState create(String name, String date, String position, String isPublic, String diary, String category, String goal) {
		return this.manager.create(name, date, position, isPublic, diary, category, goal);
	}
}


