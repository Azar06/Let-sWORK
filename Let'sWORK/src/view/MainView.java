package view;

import java.awt.BorderLayout;

public class MainView extends AbstractView {
	private AbstractMenuView menuView;
	private AbstractContentView contentView;
	
	public MainView(AbstractMenuView menuView, AbstractContentView contentView) {
		this.menuView = menuView;
		this.contentView = contentView;
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.add(this.menuView, BorderLayout.WEST);
		this.add(this.contentView, BorderLayout.CENTER);
	}

	public AbstractMenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(AbstractMenuView menuView) {
		this.menuView = menuView;
		this.add(this.menuView, BorderLayout.WEST);
		this.setVisible(true);
		this.menuView.setMainView(this);
	}

	public AbstractContentView getContentView() {
		return contentView;
	}

	public void setContentView(AbstractContentView contentView) {
		this.contentView = contentView;
		this.add(this.contentView, BorderLayout.WEST);
		this.setVisible(true);
		this.contentView.setMainView(this);
	}
}
