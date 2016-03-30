package business.utils;

public class ServiceReturnState {
	
	private String labelState = null;
	private String descriptionState = null;
	
	public boolean isRight(){
		//No error message on name and description
		return (labelState == null && descriptionState == null);
	}

	public String getLabelState() {
		return labelState;
	}

	public void setLabelState(String codeState) {
		this.labelState = codeState;
	}

	public String getDescriptionState() {
		return descriptionState;
	}

	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}
}
