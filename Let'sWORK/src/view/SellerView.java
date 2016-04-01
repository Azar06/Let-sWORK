package view;

import javax.swing.JLabel;

public class SellerView extends AbstractContentView {

	public SellerView() {
		JLabel label = new JLabel("View in progress");
		this.add(label);
	}
	
	@Override
	public String getTitle() {
		return "SellerView";
	}

}
