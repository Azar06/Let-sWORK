package business.utils;

public class CategoryReturnState {

	private String nameState = null;
	private String descriptionState = null;
	
	/**
	 * Function which display if it is good or not
	 * @return if the nameState and the descriptionState are not null
	 */
	public boolean isRight(){
		//No error message on name and description
		return (nameState == null && descriptionState == null);
	}

	/**
	 * Get the name state of a category and check all its rights
	 * @return the nameState of a category
	 */
	public String getNameState() {
		return nameState;
	}

	/**
	 * Change the name state of a category
	 * @param nameState : the new name state of a category
	 */
	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	/**
	 * Get the description state of a category and check all its rights
	 * @return the descriptionState of a category
	 */
	public String getDescriptionState() {
		return descriptionState;
	}

	/**
	 * Change the description state of a category
	 * @param descriptionState : the new description state of the category
	 */
	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}
	
	
}
