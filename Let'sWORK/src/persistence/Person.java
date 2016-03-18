package persistence;

public abstract class Person extends UserRole {

	private PersonInfo personInfo;
	
	public Person(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
