package business.utils;

public class GoalReturnState {
	private String nameState = null;
	private String descriptionState = null;
	private String deadlineState = null;
	
	public boolean isRight() {
		return this.nameState == null && this.descriptionState == null && this.deadlineState == null;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public String getDescriptionState() {
		return descriptionState;
	}

	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}

	public String getDeadlineState() {
		return deadlineState;
	}

	public void setDeadlineState(String deadlineState) {
		this.deadlineState = deadlineState;
	}
}
