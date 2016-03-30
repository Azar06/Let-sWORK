package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class AdminMenuView  extends AbstractMenuView implements ActionListener {
	
	JButton btnMenuProducts;
	JButton btnMenuServices;
	JButton btnMenuCategories;
	
	public AdminMenuView() {
		this.setLayout(new BoxLayout(this, 1));
		
		this.btnMenuProducts = new JButton("Products");
		this.btnMenuProducts.setBounds(72, 155, 101, 31);
		this.btnMenuProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnMenuProducts.addActionListener(this);
		this.btnMenuProducts.setActionCommand("product");
		add(this.btnMenuProducts);
		
		this.btnMenuServices = new JButton("Services");
		this.btnMenuServices.setBounds(78, 194, 95, 31);
		this.btnMenuServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnMenuServices.addActionListener(this);
		this.btnMenuServices.setActionCommand("service");
		add(this.btnMenuServices);
		
		this.btnMenuCategories = new JButton("Categories");
		this.btnMenuCategories.setBounds(58, 231, 115, 31);
		this.btnMenuCategories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnMenuCategories.setEnabled(false);
		this.btnMenuCategories.addActionListener(this);
		this.btnMenuCategories.setActionCommand("category");
		add(this.btnMenuCategories);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if(cmd.equals("product"))
		{
			btnMenuProducts.setEnabled(false);
			btnMenuServices.setEnabled(true);
			btnMenuCategories.setEnabled(true);
			this.getMainView().setContentView(new ProductView());
			
		}
		else if(cmd.equals("service")) {
			btnMenuProducts.setEnabled(true);
			btnMenuServices.setEnabled(false);
			btnMenuCategories.setEnabled(true);
			this.getMainView().setContentView(new ServiceView());
		}
		else if(cmd.equals("category")) {
			btnMenuProducts.setEnabled(true);
			btnMenuServices.setEnabled(true);
			btnMenuCategories.setEnabled(false);
			this.getMainView().setContentView(new CategoryView());
		}
	}
}
