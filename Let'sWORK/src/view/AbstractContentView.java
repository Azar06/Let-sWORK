package view;

import javax.swing.JPanel;

import persistence.Right;
import persistence.User;

public abstract class AbstractContentView extends MainViewComponent {
	public abstract String getTitle();
	
	public static AbstractContentView getMainContentView(Right right, User user) {
		AbstractContentView contentView = null;
		if(right == Right.ADMIN) {
			contentView = new CategoryView();
		}
		else if(right == Right.CUSTOMER) {
			contentView = new DiaryView(user);
		}
		else if(right == Right.SELLER) {
			contentView = new SellerView();
		}
		return contentView;
	}
}
