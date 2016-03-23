package business.utils;

import java.sql.Date;

import persistence.Category;

public class ActivityReturnState {

	private String nameState = null;
	private Date dateState = null;
	private int positionState = 0;
	private boolean isPublicState = true;
	private int diaryIdState = 0;
	private Category categoryIdState = null;
	private int goalIdState = 0;
	
	// 
	public boolean isRight(){
		//No error message on name and description
		return (nameState == null);
	}

	// GET & SET : NAME
	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState){
		this.nameState = nameState ;
	}
	
	// GET & SET : DATE
	public Date getDateState() {
		return dateState;
	}
	public void setDateState(Date dateState) {
		this.dateState = dateState;
	}

	// GET & SET : POSITION
	public int getPositionState() {
		return positionState;
	}

	public void setPositionState(int positionState) {
		this.positionState = positionState;
	}
	
	// GET & SET : ISPUBLIC
	public boolean getIsPublicState() {
		return isPublicState;
	}

	public void setIsPublicState(boolean isPublicState) {
		this.isPublicState = isPublicState;
	}
	
	// GET & SET : DIARYID
	public int getDiaryIdState() {
		return diaryIdState;
	}

	public void setDiaryIdState(int diaryIdState) {
		this.diaryIdState = diaryIdState;
	}
	
	// GET & SET : CATEGORYID
	public Category getCategoryState() {
		return categoryIdState;
	}

	public void setCategoryState(Category categoryIdState) {
		this.categoryIdState = categoryIdState;
	}
	
	// GET & SET : GOALID
	public int getGoalIdState() {
		return goalIdState;
	}

	public void setGoalIdState(int goalIdState) {
		this.goalIdState = goalIdState;
	}
}
