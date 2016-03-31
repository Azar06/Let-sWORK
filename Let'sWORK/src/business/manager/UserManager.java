package business.manager;

import business.Factory;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.LoadException;
import persistence.exception.SaveException;

public class UserManager {
	private Factory factorio;

	public UserManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}

	/**
	 * Get a user 
	 * if the username exist in the database and if the password corresponding is the same
	 * @param username : a string corresponding to the pseudo of the user
	 * @param pass : a string corresponding to the password of the user (associate to the username)
	 * @return a user if the informations in parameters are exacts.
	 */
	public User login(String username, String pass) {
		User result = null;

		User u = this.getUserWithUsername(username);

		if (u != null) {
			if(u.getPassword().equals(pass)) {
				result = u;
			}
		}
		// If the password write by the user is the same as the password in the
		// database
		return result;
	}
	
	/**
	 * Get a user with the username if this username exists in the database
	 * @param username : a string corresponding to the pseudo of the user
	 * @return a user which can be null
	 */
	private User getUserWithUsername(String username) {
		// We get the id of the user
		User u = this.factorio.createUser();
		try {
			// get the username
			u.load(username);
		} catch (LoadException e) {
			u = null;
		}
		return u;
	}

	/**
	 * Insert a new user in the database 
	 * if all the fields have been filled in and if it does not already exist in the database
	 * @param firstName : the firstname of the user
	 * @param lastName : the lastname of the user
	 * @param street : the street of the user
	 * @param city : the city of the user
	 * @param postalCode : the postal code of the user
	 * @param phone : the phone number of the user
	 * @param email : the email address of the user
	 * @param username : the username of the user
	 * @param password : the password of the user
	 * @param isCustomer : a boolean to know if he is customer
	 * @param isSeller : a boolean to know if he is seller
	 * @param siret : the siret of the user
	 * @param url : the url of the user
	 * @return state : true if the create has been done, false otherwise
	 */
	public SignupReturnState signup(String firstName, String lastName, String street, String city, String postalCode, String phone,
			String email, String username, String password, boolean isCustomer, boolean isSeller, String siret,
			String url) {
		SignupReturnState signupReturnState = new SignupReturnState();
		//
		if (firstName == null || firstName.length() == 0) {
			signupReturnState.setFirstNameState("You need to fill this field.");
		}
		//
		if (lastName == null || lastName.length() == 0) {
			signupReturnState.setLastNameState("You need to fill this field.");
		}
		//
		if (street == null || street.length() == 0) {
			signupReturnState.setSteetState("You need to fill this field.");
		}
		//
		if (city == null || city.length() == 0) {
			signupReturnState.setCityState("You need to fill this field.");
		}
		//
		if (postalCode == null || postalCode.length() == 0) {
			signupReturnState.setPostalCodeState("You need to fill this field.");
		}
		//
		if (phone == null || phone.length() == 0) {
			signupReturnState.setPhoneNumberState("You need to fill this field.");
		}
		//
		if (email == null || email.length() == 0) {
			signupReturnState.setEmailState("You need to fill this field.");
		}
		//
		if (username == null || username.length() == 0) {
			signupReturnState.setUsernameState("You need to fill this field.");
		} else if (this.getUserWithUsername(username) != null) {
			signupReturnState.setUsernameState("This username is already taken.");
		}
		//
		if (password == null || password.length() == 0) {
			signupReturnState.setPasswordState("You need to fill this field.");
		} else if (password.length() < 6) {
			signupReturnState.setPasswordState("Your password need more than 6 characters.");
		}
		//
		if (!isCustomer && !isSeller) {
			signupReturnState.setRolesState("You need to choose one role or more.");
		}
		//
		if (isSeller && (siret == null || siret.length() == 0)) {
			signupReturnState.setSiretState("You need to fill this field.");
		}
		//
		if (isSeller && (url == null || url.length() == 0)) {
			signupReturnState.setUrlState("You need to fill this field.");
		}

		// If all is right :
		if (signupReturnState.isRight()) {
			User user = this.factorio.createUser();
			user.setUsername(username);
			user.setPassword(password);
			PersonInfo person = this.factorio.createPerson();
			person.setUser(user);
			person.setFistName(firstName);
			person.setLastName(lastName);
			person.setEmail(email);
			person.setPhone(phone);
			person.setCity(city);
			person.setPostalCode(postalCode);
			person.setStreet(street);

			if (isCustomer) {
				Customer c = this.factorio.createCustomer();
				c.setPersonInfo(person);
				user.addRole(c);
			}
			if (isSeller) {
				Seller s = this.factorio.createSeller();
				s.setUrl(url);
				s.setSiret(siret);
				s.setPersonInfo(person);
				user.addRole(s);
			}
			
			try {
				user.save();
			} catch (SaveException e) {
				e.printStackTrace();
			}
		}
		return signupReturnState;
	}
}
