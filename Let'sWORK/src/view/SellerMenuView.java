package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SellerMenuView  extends AbstractMenuView implements ActionListener {
	
	JButton btnMenuStock;
	
	public SellerMenuView() {
		this.setLayout(new BoxLayout(this, 1));
		
		this.btnMenuStock = new JButton("Products");
		this.btnMenuStock.setBounds(72, 155, 101, 31);
		this.btnMenuStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnMenuStock.addActionListener(this);
		this.btnMenuStock.setActionCommand("product");
		this.btnMenuStock.setEnabled(false);
		add(this.btnMenuStock);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
	}
}
