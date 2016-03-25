package view;

import javax.swing.JPanel;

import persistence.User;

public abstract class MainViewComponent extends JPanel {
	private MainView mainView = null;

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	
	public User getUser() {
		User u = null;
		if(this.mainView != null) {
			u = this.mainView.getUser();
		}
		return u;
	}
	
	public void setUser(User user) {
		if(this.mainView != null) {
			this.mainView.setUser(user);
		}
	}
}
