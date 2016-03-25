package persistence;

abstract class Offer {

    private double price;

    public Offer(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
