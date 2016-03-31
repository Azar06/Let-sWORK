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
	
	public CustomerMenuView() {
		this.setLayout(new BoxLayout(this, 1));
		
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
	}
	
	public JButton getDiaryButton() {
		return this.diaryButton;
	}
}
