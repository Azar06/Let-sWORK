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
	
	public boolean isRight() {
		return firstNameState == null && lastNameState == null && steetState == null 
				&& cityState == null && phoneNumberState == null && emailState == null 
				&& usernameState == null && passwordState == null && rolesState == null
				&& siretState == null && urlState == null && postalCode == null;
	}
	
	// GETTER / SETTER
	public String getFirstNameState() {
		return firstNameState;
	}
	public void setFirstNameState(String firstNameState) {
		this.firstNameState = firstNameState;
	}
	public String getLastNameState() {
		return lastNameState;
	}
	public void setLastNameState(String lastNameState) {
		this.lastNameState = lastNameState;
	}
	public String getSteetState() {
		return steetState;
	}
	public void setSteetState(String steetState) {
		this.steetState = steetState;
	}
	public String getCityState() {
		return cityState;
	}
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	public String getPostalCodeState() {
		return postalCode;
	}
	public void setPostalCodeState(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getPhoneNumberState() {
		return phoneNumberState;
	}
	public void setPhoneNumberState(String phoneNumberState) {
		this.phoneNumberState = phoneNumberState;
	}
	public String getEmailState() {
		return emailState;
	}
	public void setEmailState(String emailState) {
		this.emailState = emailState;
	}
	public String getUsernameState() {
		return usernameState;
	}
	public void setUsernameState(String usernameState) {
		this.usernameState = usernameState;
	}
	public String getPasswordState() {
		return passwordState;
	}
	public void setPasswordState(String passwordState) {
		this.passwordState = passwordState;
	}
	public String getRolesState() {
		return rolesState;
	}
	public void setRolesState(String rolesState) {
		this.rolesState = rolesState;
	}
	public String getSiretState() {
		return siretState;
	}
	public void setSiretState(String siretState) {
		this.siretState = siretState;
	}
	public String getUrlState() {
		return urlState;
	}
	public void setUrlState(String urlState) {
		this.urlState = urlState;
	}
}