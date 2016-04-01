package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persistence.User;

public class MainView extends AbstractView {
	private AbstractMenuView menuView;
	private AbstractContentView contentView;
	private JPanel header;
	private JLabel titleLabel;
	private String title;
	
	public MainView(AbstractMenuView menuView, AbstractContentView contentView, User user) {
		this.header = new JPanel();
		this.titleLabel = new JLabel();
		this.titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.setMenuView(menuView);
		this.setContentView(contentView);
		
		// Layout du Header
		BorderLayout layoutHeader = new BorderLayout();
		this.header.setLayout(layoutHeader);
		
		this.header.add(this.titleLabel,  BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getWindow().setView(new LoginView());
				getWindow().setUser(null);
			}
		});
		buttonPanel.add(logoutButton);
		
		if(user.getRoles().size() > 1){
			JButton roleViewButton = new JButton("Roles");
			roleViewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					getWindow().setView(new SelectRoleView(user));
				}
			});
			buttonPanel.add(roleViewButton);
		}
		
		this.header.add(buttonPanel,  BorderLayout.EAST);
				
		// Layout de la vue entière
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
		this.setVisible(false);
		if(this.contentView != null){
			this.remove(this.contentView);
		}
		this.contentView = contentView;
		this.add(this.contentView, BorderLayout.CENTER);
		this.setTitle(this.contentView.getTitle());
		this.setVisible(true);
		this.contentView.setMainView(this);
	}
	
	public void setTitle(String title){
		this.title = title;
		this.titleLabel.setText(title);
	}
	
	public String getTitle() {
		return this.title;
	}
}
