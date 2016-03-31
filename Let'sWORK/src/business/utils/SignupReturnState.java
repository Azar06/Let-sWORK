package business.utils;

public class SignupReturnState {
	
	private String firstNameState = null;
	private String lastNameState = null;
	private String steetState = null;
	private String cityState = null;
	private String postalCode = null;
	private String phoneNumberState = null;
	private String emailState = null;
	private String usernameState = null;
	private String passwordState = null;
	private String rolesState = null;
	private String siretState = null;
	private String urlState = null;
	
	/**
	 * Function which display if it is good or not
	 * @return if all the states are not null
	 */
	public boolean isRight() {
		return firstNameState == null && lastNameState == null && steetState == null 
				&& cityState == null && phoneNumberState == null && emailState == null 
				&& usernameState == null && passwordState == null && rolesState == null
				&& siretState == null && urlState == null && postalCode == null;
	}
	
	// GETTER / SETTER
	/**
	 * Get the first name state of a user and check all its rights
	 * @return the first name State of a user
	 */
	public String getFirstNameState() {
		return firstNameState;
	}
	
	/**
	 * Change the first name state of a user
	 * @param firstNameState : the new first name state of a user
	 */
	public void setFirstNameState(String firstNameState) {
		this.firstNameState = firstNameState;
	}
	
	/**
	 * Get the last name state of a user and check all its rights
	 * @return the last name State of a user
	 */
	public String getLastNameState() {
		return lastNameState;
	}
	
	/**
	 * Change the last name state of a user
	 * @param lastNameState : the new last name state of a user
	 */
	public void setLastNameState(String lastNameState) {
		this.lastNameState = lastNameState;
	}
	
	/**
	 * Get the street state of a user and check all its rights
	 * @return the street State of a user
	 */
	public String getSteetState() {
		return steetState;
	}
	
	/**
	 * Change the street state of a user
	 * @param streetState : the new street state of a user
	 */
	public void setSteetState(String steetState) {
		this.steetState = steetState;
	}
	
	/**
	 * Get the city state of a user and check all its rights
	 * @return the city State of a user
	 */
	public String getCityState() {
		return cityState;
	}
	
	/**
	 * Change the city state of a user
	 * @param cityState : the new city state of a user
	 */
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	
	/**
	 * Get the postal code state of a user and check all its rights
	 * @return the postal code State of a user
	 */
	public String getPostalCodeState() {
		return postalCode;
	}
	
	/**
	 * Change the postal code state of a user
	 * @param postalCode : the new postal code state of a user
	 */
	public void setPostalCodeState(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * Get the phone number state of a user and check all its rights
	 * @return the phone number State of a user
	 */
	public String getPhoneNumberState() {
		return phoneNumberState;
	}
	
	/**
	 * Change the phone number state of a user
	 * @param phoneNumberState : the new phone number state of a user
	 */
	public void setPhoneNumberState(String phoneNumberState) {
		this.phoneNumberState = phoneNumberState;
	}
	
	/**
	 * Get the email state of a user and check all its rights
	 * @return the email State of a user
	 */
	public String getEmailState() {
		return emailState;
	}
	
	/**
	 * Change the email state of a user
	 * @param emailState : the new email state of a user
	 */
	public void setEmailState(String emailState) {
		this.emailState = emailState;
	}
	
	/**
	 * Get the username state of a user and check all its rights
	 * @return the username State of a user
	 */
	public String getUsernameState() {
		return usernameState;
	}
	
	/**
	 * Change the username state of a user
	 * @param usernameState : the new username state of a user
	 */
	public void setUsernameState(String usernameState) {
		this.usernameState = usernameState;
	}
	
	/**
	 * Get the password state of a user and check all its rights
	 * @return the password State of a user
	 */
	public String getPasswordState() {
		return passwordState;
	}
	
	/**
	 * Change the password state of a user
	 * @param passwordState : the new password state of a user
	 */
	public void setPasswordState(String passwordState) {
		this.passwordState = passwordState;
	}
	
	/**
	 * Get the roles state of a user and check all its rights
	 * @return the roles State of a user
	 */
	public String getRolesState() {
		return rolesState;
	}
	
	/**
	 * Change the roles state of a user
	 * @param rolesState : the new roles state of a user
	 */
	public void setRolesState(String rolesState) {
		this.rolesState = rolesState;
	}
	
	/**
	 * Get the siret state of a user and check all its rights
	 * @return the siret State of a user
	 */
	public String getSiretState() {
		return siretState;
	}
	
	/**
	 * Change the siret state of a user
	 * @param siretState : the new siret state of a user
	 */
	public void setSiretState(String siretState) {
		this.siretState = siretState;
	}
	
	/**
	 * Get the url state of a user and check all its rights
	 * @return the url State of a user
	 */
	public String getUrlState() {
		return urlState;
	}
	
	/**
	 * Change the url state of a user
	 * @param urlState : the new url state of a user
	 */
	public void setUrlState(String urlState) {
		this.urlState = urlState;
	}
}
