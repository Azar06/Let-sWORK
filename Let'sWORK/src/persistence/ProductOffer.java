package persistence;

public abstract class ProductOffer extends Offer {

    private int amount;

    public ProductOffer() {
    	super();
    	this.amount = 0;
    }
    
    public ProductOffer(double price, int initialAmount) {
        super(price);
        this.amount = initialAmount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void removeAmount(int amount) {
        this.amount -= amount;
    }

}
