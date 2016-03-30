package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persistence.Right;
import persistence.User;

public class SelectRoleView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5174934913657265380L;

	public SelectRoleView(User user) {
		
		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.add(panel, BorderLayout.CENTER);
		
		// Layout du Header
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		panel.setLayout(layout);
		
		if(user.getRole(Right.ADMIN) != null){
			JButton adminButton = new JButton("Admin");
			adminButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					getWindow().setView(new MainView(AbstractMenuView.getMenuView(Right.ADMIN), AbstractContentView.getMainContentView(Right.ADMIN), user));
				}
			});
			panel.add(adminButton);
		}
		if(user.getRole(Right.CUSTOMER) != null){
			JButton customerButton = new JButton("Customer");
			customerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					getWindow().setView(new MainView(AbstractMenuView.getMenuView(Right.CUSTOMER), AbstractContentView.getMainContentView(Right.CUSTOMER), user));
				}
			});
			panel.add(customerButton);
		}
		if(user.getRole(Right.SELLER) != null){
			JButton sellerButton = new JButton("Seller");
			sellerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					getWindow().setView(new MainView(AbstractMenuView.getMenuView(Right.SELLER), AbstractContentView.getMainContentView(Right.SELLER), user));
				}
			});
			panel.add(sellerButton);
		}
		JButton logoutButton = new JButton("LogOut");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().setView(new LoginView());
			}
		});
		panel.add(logoutButton);
	}
}
