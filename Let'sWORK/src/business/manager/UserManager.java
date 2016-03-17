package business.manager;

import business.Factory;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.User;

public class UserManager {
	private Factory factorio;
	
	public UserManager() {
		//FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}
	
	public boolean login(String username, String pass) {
		//We get the id of the user
		User u = this.factorio.getUserWithUsername(username);
		boolean result = false;
		if (u != null){
			result = (u.getPassword().equals(pass));
		}
		//If the password write by the user is the same as the password in the database
		return result;
	}
	
	public SignupReturnState signup(String firstName, String lastName, String steet, String city, String phoneNumber, String email, String username, String password, boolean isCustomer, boolean isSeller) {
		SignupReturnState signupReturnState = new SignupReturnState();
		// 
		if(firstName == null || firstName.length() == 0){
			signupReturnState.setFirstNameState("You need to fill this field.");
		}
		//
		if(lastName == null || lastName.length() == 0){
			signupReturnState.setLastNameState("You need to fill this field.");
		}
		//
		if(steet == null || steet.length() == 0){
			signupReturnState.setSteetState("You need to fill this field.");
		}
		//
		if(city == null || city.length() == 0){
			signupReturnState.setCityState("You need to fill this field.");
		}
		//
		if(phoneNumber == null || phoneNumber.length() == 0){
			signupReturnState.setPhoneNumberState("You need to fill this field.");
		}
		//
		if(email == null || email.length() == 0){
			signupReturnState.setEmailState("You need to fill this field.");
		}
		//
		if(username == null || username.length() == 0){
			signupReturnState.setUsernameState("You need to fill this field.");
		}
		else if(this.factorio.getUserWithUsername(username) != null){
			signupReturnState.setUsernameState("This username is already taken.");
		}
		//
		if(password == null || password.length() == 0){
			signupReturnState.setPasswordState("You need to fill this field.");
		}
		else if(password.length() < 6){
			signupReturnState.setPasswordState("Your password need more than 6 characters.");
		}
		//
		if(!isCustomer && !isSeller){
			signupReturnState.setRolesState("You need to choose one role or more.");
		}
		
		// If all is right :
		if(signupReturnState.isRight()){
			User user = this.factorio.createUser();
			// TODO
		}
		return signupReturnState;
	}
}
