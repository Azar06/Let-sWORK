package persistence;

public abstract class Resource {

	private String label;
	private String description;
	private Category category;
	
	public Resource () {
		super();
	}
	public Resource(String labelR, String desc, Category cat) {
		super();
		this.label = labelR;
		this.description = desc;
		this.category = cat;
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
	
	//Accesseurs & Mutateurs : CATEGORY
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category cat) {
		this.category = cat;
	}
}
