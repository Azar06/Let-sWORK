package view;

import javax.swing.JPanel;

import persistence.Right;

public abstract class AbstractMenuView extends MainViewComponent {
	
	public static AbstractMenuView getMenuView(Right right) {
		AbstractMenuView menuView = null;
		if(right == Right.ADMIN) {
			menuView = new AdminMenuView();
		}
		else if(right == Right.CUSTOMER) {
			menuView = new CustomerMenuView();
		}
		else if(right == Right.SELLER) {
			menuView = new SellerMenuView();
		}
		return menuView;
	}
}
