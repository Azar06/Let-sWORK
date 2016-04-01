package business.utils;

public class ServiceReturnState {
	
	private String labelState = null;
	private String descriptionState = null;
	private String categoryState = null;
	
	/**
	 * Function which display if it is good or not
	 * @return if the nameState and the descriptionState are not null
	 */
	public boolean isRight(){
		//No error message on name and description
		return (labelState == null && descriptionState == null && categoryState == null);
	}

	/**
	 * Get the label state of a service and check all its rights
	 * @return the label state of a service
	 */
	public String getLabelState() {
		return labelState;
	}

	/**
	 * Change the label state of a service
	 * @param codeState : the new label state of a service
	 */
	public void setLabelState(String codeState) {
		this.labelState = codeState;
	}

	/**
	 * Get the description state of a service and check all its rights
	 * @return the description state of a service
	 */
	public String getDescriptionState() {
		return descriptionState;
	}

	/**
	 * Change the description state of a service
	 * @param descriptionState : the new description state of a service
	 */
	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}

	public String getCategoryState() {
		return categoryState;
	}

	public void setCategoryState(String categoryState) {
		this.categoryState = categoryState;
	}
}
