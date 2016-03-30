package business.utils;

public class ProductReturnState {
	private String labelState = null;
	private String descriptionState = null;
	private String brandNameState = null;
	
	/**
	 * Function which display if it is good or not
	 * @return if the nameState, the descriptionState and the brandNameState are not null
	 */
	public boolean isRight(){
		//No error message on name and description
		return (labelState == null && descriptionState == null && brandNameState == null);
	}

	/**
	 * Get the label state of a product and check all its rights
	 * @return the label state of a product
	 */
	public String getLabelState() {
		return labelState;
	}

	/**
	 * Change the label state of a category
	 * @param codeState : the new label state of a category
	 */
	public void setLabelState(String codeState) {
		this.labelState = codeState;
	}

	/**
	 * Get the description state of a product and check all its rights
	 * @return the description state of a product
	 */
	public String getDescriptionState() {
		return descriptionState;
	}

	/**
	 * Change the description state of a category
	 * @param descriptionState : the new description state of a category
	 */
	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}
	
	/**
	 * Get the brand name state of a product and check all its rights
	 * @return the brand name state of a product
	 */
	public String getBrandNameState() {
		return brandNameState;
	}

	/**
	 * Change the brand name state of a category
	 * @param brandNameState : the new brand name state of a category
	 */
	public void setBrandNameState(String brandNameState) {
		this.brandNameState = brandNameState;
	}
}
