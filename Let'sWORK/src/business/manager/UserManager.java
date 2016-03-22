package business.manager;

import business.Factory;
import business.utils.SignupReturnState;
import jdbc.FactoryJDBC;
import persistence.*;
import persistence.exception.LoadException;

public class UserManager {
	private Factory factorio;

	public UserManager() {
		// FactoryJDBC creation
		this.factorio = new FactoryJDBC();
	}

	public boolean login(String username, String pass) {
		boolean result = false;

		User u = this.getUserWithUsername(username);

		if (u != null) {
			result = (u.getPassword().equals(pass));
		}
		// If the password write by the user is the same as the password in the
		// database
		return result;
	}
	
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
		}
		return signupReturnState;
	}
}
