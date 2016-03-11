package persistence;

import java.util.*;

public abstract class Basket {
	private List<BasketLine> lines;
	
	public Basket() {
		this.lines=new ArrayList<BasketLine>();
	}
	
	public void addLine(BasketLine bl) {
		this.lines.add(bl);
	}
	
	public void delLine(BasketLine bl) {
		this.lines.remove(bl);
	}
	
	public List<BasketLine> getLine() {
		return this.lines;
	}
}
