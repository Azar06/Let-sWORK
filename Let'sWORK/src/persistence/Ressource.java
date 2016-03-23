package persistence;

public class Ressource {

	private String code;
	private String description;
	
	public Ressource(String codeR, String desc) {
		super();
		this.code = codeR;
		this.description = desc;
	}

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String codeR) {
		this.code = codeR;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
}
