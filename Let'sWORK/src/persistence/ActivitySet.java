package persistence;

import java.util.ArrayList;
import java.util.List;

import persistence.exception.LoadException;

public abstract class ActivitySet {
	
	private List<Activity> activities;
	
	public ActivitySet() {
		this.activities = new ArrayList<Activity>();
	}

	public abstract void loadWithDiary(Diary diary) throws LoadException;
	
	// GETTER AND SETTER
	
	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
}
