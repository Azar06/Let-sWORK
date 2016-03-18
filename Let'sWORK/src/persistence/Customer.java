package persistence;

public abstract class Customer extends Person {
	
	private Basket customerBasket;
	
	public Customer(PersonInfo personInfo) {
		super(personInfo);
	}
}
