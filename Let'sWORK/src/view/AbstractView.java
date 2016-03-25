package view;

import javax.swing.JPanel;

import persistence.User;

public abstract class AbstractView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LetsWorkWindow window = null;
	
	public LetsWorkWindow getWindow() {
		return this.window;
	}
	
	public void setWindow(LetsWorkWindow window) {
		this.window = window;
	}
	
	public User getUser() {
		User u = null;
		if(this.window != null) {
			u = this.window.getUser();
		}
		return u;
	}
	
	public void setUser(User user) {
		if(this.window != null) {
			this.window.setUser(user);
		}
	}
}
