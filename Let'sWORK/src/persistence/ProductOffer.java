package persistence;

public class ProductOffer extends Offer{

    private int amount;

    public ProductOffer(float price, int amount) {
        super(price);
        this.amount= amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
