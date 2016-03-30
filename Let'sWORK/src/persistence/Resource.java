package persistence;

public abstract class Resource {

	private String label;
	private String description;
	
	public Resource () {
		super();
	}
	public Resource(String labelR, String desc) {
		super();
		this.label = labelR;
		this.description = desc;
	}

	// Accesseurs & Mutateurs : CODE
	public String getLabel() {
		return this.label;
	}
	
	public void setLabel(String labelR) {
		this.label = labelR;
	}
	
	// Accesseurs & Mutateurs : DESCRIPTION
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
}
