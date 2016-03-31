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
	
	// 
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
	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState){
		this.nameState = nameState ;
	}
	
	// GET & SET : DATE
	public String getDateState() {
		return dateState;
	}
	public void setDateState(String dateState) {
		this.dateState = dateState;
	}

	// GET & SET : POSITION
	public String getPositionState() {
		return positionState;
	}

	public void setPositionState(String positionState) {
		this.positionState = positionState;
	}
	
	// GET & SET : ISPUBLIC
	public String getIsPublicState() {
		return isPublicState;
	}

	public void setIsPublicState(String isPublicState) {
		this.isPublicState = isPublicState;
	}
	
	// GET & SET : DIARYID
	public String getDiaryState() {
		return diaryIdState;
	}

	public void setDiaryState(String diaryIdState) {
		this.diaryIdState = diaryIdState;
	}
	
	// GET & SET : CATEGORYID
	public String getCategoryState() {
		return categoryIdState;
	}

	public void setCategoryState(String categoryIdState) {
		this.categoryIdState = categoryIdState;
	}
	
	// GET & SET : GOALID
	public String getGoalState() {
		return goalIdState;
	}

	public void setGoalState(String goalIdState) {
		this.goalIdState = goalIdState;
	}
}
