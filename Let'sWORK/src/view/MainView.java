package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends AbstractView {
	private AbstractMenuView menuView;
	private AbstractContentView contentView;
	private JPanel header;
	private JLabel titleLabel;
	private String title;
	
	public MainView(AbstractMenuView menuView, AbstractContentView contentView) {
		this.menuView = menuView;
		this.contentView = contentView;
		this.header = new JPanel();
		this.titleLabel = new JLabel();
		this.titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.setTitle(this.contentView.getTitle());
		
		// Layout du Header
		BorderLayout layoutHeader = new BorderLayout();
		this.header.setLayout(layoutHeader);
		
		this.header.add(this.titleLabel,  BorderLayout.CENTER);
		JButton logoutButton = new JButton("Log out");
		this.header.add(logoutButton,  BorderLayout.EAST);
				
		// Layout de la vue enti�re
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.add(this.menuView, BorderLayout.WEST);
		this.add(this.contentView, BorderLayout.CENTER);
		this.add(this.header, BorderLayout.NORTH);
		
		
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
	
	public void setTitle(String title){
		this.title = title;
		this.titleLabel.setText(title);
	}
}
