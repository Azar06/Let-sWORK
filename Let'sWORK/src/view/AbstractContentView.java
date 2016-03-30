package view;

import javax.swing.JPanel;

import persistence.Right;

public abstract class AbstractContentView extends MainViewComponent {
	public abstract String getTitle();
	
	public static AbstractContentView getMainContentView(Right right) {
		AbstractContentView contentView = null;
		if(right == Right.ADMIN) {
			contentView = new CategoryView();
		}
		else if(right == Right.CUSTOMER) {
			contentView = new CategoryView();
		}
		else if(right == Right.SELLER) {
			contentView = new CategoryView();
		}
		return contentView;
	}
}
