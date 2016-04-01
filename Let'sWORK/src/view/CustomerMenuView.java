package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import business.utils.CategoryReturnState;

public class CustomerMenuView extends AbstractMenuView {
	
	private JButton diaryButton;
	private JButton goalButton;
	private JButton friendsButton;
	private JButton accountButton;
	
	public CustomerMenuView() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.diaryButton = new JButton("Diary");
		this.diaryButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.diaryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getMainView().setContentView(new DiaryView(getMainView().getUser()));
				diaryButton.setEnabled(false);
			}
		});
		this.diaryButton.setEnabled(false);
		this.diaryButton.setActionCommand("diary");
		this.add(this.diaryButton);
		
		this.goalButton = new JButton("Goals");
		this.goalButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(this.goalButton);
		
		this.friendsButton = new JButton("Friends");
		this.friendsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(this.friendsButton);
		
		this.accountButton = new JButton("Account");
		this.accountButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(this.accountButton);
	}
	
	public JButton getDiaryButton() {
		return this.diaryButton;
	}
}
