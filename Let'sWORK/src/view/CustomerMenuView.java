package view;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class CustomerMenuView extends AbstractMenuView {
	public CustomerMenuView() {
		
		this.setLayout(new BoxLayout(this, 1));
		
		JButton btnMenuProducts = new JButton("Products");
		btnMenuProducts.setBounds(72, 155, 101, 31);
		btnMenuProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuProducts);
		
		JButton btnMenuServices = new JButton("Services");
		btnMenuServices.setBounds(78, 194, 95, 31);
		btnMenuServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuServices);
		
		JButton btnMenuCategories = new JButton("Categories");
		btnMenuCategories.setBounds(58, 231, 115, 31);
		btnMenuCategories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMenuCategories.setEnabled(false);
		add(btnMenuCategories);
	}
}
