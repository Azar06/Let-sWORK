package persistence;

public abstract class PersonInfo {
	private String lastName;
	private String fistName;
	private String street;
	private String postalCode;
	private String city;
	private String phone;
	private String email;
	
	public PersonInfo(String ln, String fn, String s, String pc, String c, String p, String e) {
		this.lastName=ln;
		this.fistName=fn;
		this.street=s;
		this.postalCode=pc;
		this.city=c;
		this.phone=p;
		this.email=e;
	}
	
	public PersonInfo(User owner) {
		this(null, null, null, null, null, null, null);
	}
	
	public PersonInfo() {
		this(null);
	}
	
	// ABSTACT METHODS
	public abstract void save() throws SaveException;
	public abstract void load(long id) throws LoadException;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
