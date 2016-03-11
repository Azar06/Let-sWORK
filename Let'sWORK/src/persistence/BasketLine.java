package persistence;

public abstract class BasketLine {
	private int amount;
	private Offer basketOffer;
	
	public BasketLine(Offer bo, int qty) {
		this.basketOffer=bo;
		this.amount=qty;
	}
	
	public void setAmount(int qty) {
		this.amount=qty;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setOffer(Offer bo) {
		this.basketOffer=bo;
	}
	
	public Offer getOffer() {
		return this.basketOffer;
	}
	
}
