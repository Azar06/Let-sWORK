package view;

import javax.swing.JPanel;

public abstract class MainViewComponent extends JPanel {
	private MainView mainView = null;

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
}
