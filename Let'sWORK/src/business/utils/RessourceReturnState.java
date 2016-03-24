package business.utils;

public class RessourceReturnState {

	private String codeState = null;
	private String descriptionState = null;
	
	public boolean isRight(){
		//No error message on name and description
		return (codeState == null && descriptionState == null);
	}

	public String getCodeState() {
		return codeState;
	}

	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}

	public String getDescriptionState() {
		return descriptionState;
	}

	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}
}
