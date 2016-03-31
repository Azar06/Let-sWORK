package business.utils;

import java.sql.Date;

import persistence.Category;

public class ActivityReturnState {

	private String nameState = null;
	private String dateState = null;
	private String positionState = null;
	private String isPublicState = null;
	private String diaryIdState = null;
	private String categoryIdState = null;
	private String goalIdState = null;
	
	/**
	 * Function which display if it is good or not
	 * @return if the states are not null
	 */
	public boolean isRight(){
		//No error message on name and description
		return (nameState == null 
				&& dateState == null
				&& positionState == null
				&& isPublicState == null
				&& diaryIdState == null
				&& categoryIdState == null
				&& goalIdState == null);
	}

	// GET & SET : NAME
	/**
	 * Get the name state of an activity and check all its rights
	 * @return the nameState of an activity
	 */
	public String getNameState() {
		return nameState;
	}

	/**
	 * Change the name state of an activity
	 * @param nameState : the new name state of an activity
	 */
	public void setNameState(String nameState){
		this.nameState = nameState ;
	}
	
	// GET & SET : DATE
	/**
	 * Get the date state of an activity and check all its rights
	 * @return the dateState of an activity
	 */
	public String getDateState() {
		return dateState;
	}
	
	/**
	 * Change the date state of an activity
	 * @param dateState : the new date state of an activity
	 */
	public void setDateState(String dateState) {
		this.dateState = dateState;
	}

	// GET & SET : POSITION
	/**
	 * Get the position state of an activity and check all its rights
	 * @return the positionState of an activity
	 */
	public String getPositionState() {
		return positionState;
	}

	/**
	 * Change the position state of an activity
	 * @param positionState : the new position state of an activity
	 */
	public void setPositionState(String positionState) {
		this.positionState = positionState;
	}
	
	// GET & SET : ISPUBLIC
	/**
	 * Get the visibility state of an activity and check all its rights
	 * @return the visibilityState of an activity
	 */
	public String getIsPublicState() {
		return isPublicState;
	}

	/**
	 * Change the visibility state of an activity
	 * @param isPublicState : the new visibility state of an activity
	 */
	public void setIsPublicState(String isPublicState) {
		this.isPublicState = isPublicState;
	}
	
	// GET & SET : DIARYID
	/**
	 * Get the diary state of an activity and check all its rights
	 * @return the diaryState of an activity
	 */
	public String getDiaryState() {
		return diaryIdState;
	}

	/**
	 * Change the diary state of an activity
	 * @param diaryIdState : the new diary state of an activity
	 */
	public void setDiaryState(String diaryIdState) {
		this.diaryIdState = diaryIdState;
	}
	
	// GET & SET : CATEGORYID
	/**
	 * Get the category state of an activity and check all its rights
	 * @return the categoryState of an activity
	 * @return
	 */
	public String getCategoryState() {
		return categoryIdState;
	}

	/**
	 * Change the category state of an activity
	 * @param categoryIdState : the new category state of an activity
	 */
	public void setCategoryState(String categoryIdState) {
		this.categoryIdState = categoryIdState;
	}
	
	// GET & SET : GOALID
	/**
	 * Get the goal state of an activity and check all its rights
	 * @return the goalState of an activity
	 * @return
	 */
	public String getGoalState() {
		return goalIdState;
	}

	/**
	 * Change the goal state of an activity
	 * @param goalIdState : the new goal state of an activity
	 */
	public void setGoalState(String goalIdState) {
		this.goalIdState = goalIdState;
	}
}
