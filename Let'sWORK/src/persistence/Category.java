package persistence;

public class Category {

	private String name;
	private String description;
	
	/*public BasketLine(Offer bo, int qty) {
		this.basketOffer=bo;
		this.amount=qty;
	}*/
		
	public Category(String nom, String desc) {
		super();
		this.name = nom;
		this.description = desc;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String desc) {
		this.description=desc;
	}
}
