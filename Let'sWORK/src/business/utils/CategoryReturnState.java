package business.utils;

public class CategoryReturnState {

	private String nameState = null;
	private String descriptionState = null;
	
	public boolean isRight(){
		//No error message on name and description
		return (nameState == null && descriptionState == null);
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
	
	
}
