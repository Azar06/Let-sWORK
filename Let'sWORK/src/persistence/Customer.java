package persistence;

public class Customer extends Person{
	private Basket customerBasket;
	public Customer(String ln, String fn, String s, String pc, String c, String p, String e) {
		super(ln, fn, s, pc, c, p, e);
		this.customerBasket= new Basket();
		// TODO Auto-generated constructor stub
	}

}
