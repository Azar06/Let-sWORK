package view;

import javax.swing.JPanel;

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
}
