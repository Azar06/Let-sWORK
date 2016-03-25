package persistence;

abstract class Offer {

    private float price;

    public Offer(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
