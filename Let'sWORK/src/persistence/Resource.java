package persistence;

public abstract class Resource {

	private String code;
	private String description;
	
	public Resource(String codeR, String desc) {
		super();
		this.code = codeR;
		this.description = desc;
	}

	// Accesseurs & Mutateurs : CODE
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String codeR) {
		this.code = codeR;
	}
	
	// Accesseurs & Mutateurs : DESCRIPTION
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
}
