package persistence;

public abstract class Person extends UserRole{
	private String lastName;
	private String fistName;
	private String street;
	private String postalCode;
	private String city;
	private String phone;
	private String email;
	
	public Person(String ln, String fn, String s, String pc, String c, String p, String e) {
		this.lastName=ln;
		this.fistName=fn;
		this.street=s;
		this.postalCode=pc;
		this.city=c;
		this.phone=p;
		this.email=e;
	}
	
	public void setLastName(String ln) {
		this.lastName=ln;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setFirstName(String fn) {
		this.fistName=fn;
	}
	
	public String getFirstName() {
		return this.fistName;
	}
	
	public void setStreet(String s) {
		this.street=s;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setPostalCode(String pc) {
		this.postalCode=pc;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public void setCity(String c) {
		this.city=c;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setPhone(String p) {
		this.phone=p;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setEmail(String e) {
		this.email=e;
	}
	
	public String getEmail() {
		return this.email;
	}
}
