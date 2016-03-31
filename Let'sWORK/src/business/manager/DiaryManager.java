package business.manager;

import java.sql.Date;
import java.util.List;

import business.Factory;
import business.utils.ActivityReturnState;
import business.utils.GoalReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.*;

public class DiaryManager {
	private Factory factorio;

	public DiaryManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	/**
	 * Get a collection of goals
	 * @param user 
	 * @return a list of goals of a user
	 */
	public GoalSet getGoalSet(User user) {
		GoalSet goalSet = factorio.createGoalSet();
		try {
			goalSet.loadWithUser(user);
		}
		catch (LoadException e) {
			e.printStackTrace();
			goalSet = null;
		}
		return goalSet;
	}
	
	/**
	 * Get a collection of activities of a diary
	 * @param diary
	 * @return a list of activities in the diary
	 */
	public ActivitySet getActivitySet(Diary diary) {
		ActivitySet activitySet = factorio.createActivitySet();
		try {
			activitySet.loadWithDiary(diary);
		}
		catch (LoadException e) {
			e.printStackTrace();
			activitySet = null;
		}
		return activitySet;
	}
	
	/**
	 * Insert a new activity in the diary in the database 
	 * if all the fields have been filled in and if it does not already exist in the database
	 * @param diary
	 * @param name
	 * @param date
	 * @param position
	 * @param isPublic
	 * @param category
	 * @param goal
	 * @return state : true if the insertion has been done, false otherwise
	 */
	public ActivityReturnState createActivity(Diary diary, String name, Date date, TimePosition position, boolean isPublic, Category category, Goal goal) {
		ActivityReturnState state = new ActivityReturnState();
		if (name == null || name.length() == 0) {
			state.setNameState("You need to fill this field.");
		}
		if (date == null) {
			state.setDateState("You need to fill this field.");
		}
		if (position == null) {
			state.setPositionState("You need to fill this field.");
		}
		if (category == null) {
			state.setCategoryState("You need to fill this field.");
		}
		//If all is right
		if (state.isRight()) {
			Activity activity = this.factorio.createActivity();
			activity.setDiary(diary);
			activity.setName(name);
			activity.setDate(date);
			activity.setPosition(position);
			activity.setIsPublic(isPublic);
			activity.setCategory(category);
			activity.setGoal(goal);
			try {
				activity.save();
			} catch (SaveException e) {
				e.printStackTrace();
			}
		}
		return state;
	}
	
	/**
	 * Get a diary with the list of activities
	 * @param user
	 * @return the diary which contain the activities
	 */
	public Diary getDiaryWithActivySet(User user) {
		Diary diary = this.getDiary(user);
		if(diary != null) {
			diary.setActivitySet(this.getActivitySet(diary));
		}
		return diary;
	}
	
	/**
	 * Get the diary for a user
	 * @param user
	 * @return the object diary for a user
	 */
	public Diary getDiary(User user) {
		Diary diary = null;
		Customer customer = (Customer)user.getRole(Right.CUSTOMER);
		if(customer != null){
			try {
				diary = this.factorio.createDiary();
				diary.load(customer);
			}
			catch (LoadException e) {
				e.printStackTrace();
				diary = null;
			}
		}
		return diary;
	}
	
	/**
	 * Delete an activity
	 * @param activity
	 * @return state : true if the suppression has been done, false otherwise
	 */
	public boolean deleteActivity(Activity activity) {
		boolean returnState = false;
		try {
			activity.delete();
			returnState = true;
		} catch (DeleteException e) {
			returnState = false;
		}
		return returnState;
	}
	
	/**
	 * Create a new goal if all the fields have been filled in
	 * @param owner
	 * @param name
	 * @param description
	 * @param deadline
	 * @return state : true if the creation has been done, false otherwise
	 */
	public GoalReturnState createGoal(User owner, String name, String description, Date deadline) {
		GoalReturnState goalReturnState = new GoalReturnState();
		//
		if (name == null || name.length() == 0) {
			goalReturnState.setNameState("You need to fill this field.");
		}
		//
		if (description == null || description.length() == 0) {
			goalReturnState.setDescriptionState("You need to fill this field.");
		}
		// 
		if (deadline == null || deadline.after(new Date((new java.util.Date().getTime())))) {
			goalReturnState.setDeadlineState("You need to fill this field.");
		}

		// If all is right :
		if (goalReturnState.isRight()) {
			Goal goal = this.factorio.createGoal();
			goal.setUser(owner);
			goal.setName(name);
			goal.setDescription(description);
			goal.setDeadline(deadline);
			try {
				goal.save();
			} catch (SaveException e) {
				e.printStackTrace();
			}
		}
		return goalReturnState;
	}
}
