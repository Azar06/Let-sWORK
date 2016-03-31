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

    /**
     * Get the amount of a product
     * @return the amount of a product
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Add a quantity of product
     * @param amount : the value to add
     */
    public void addAmount(int amount) {
        this.amount += amount;
    }

    /**
     * Delete a quantity of product
     * @param amount : the value to remove
     */
    public void removeAmount(int amount) {
        this.amount -= amount;
    }

}
