package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import business.utils.CategoryReturnState;

public class CustomerMenuView extends AbstractMenuView implements ActionListener {
	
	JButton btnMenuDiary;
	
	public CustomerMenuView() {
		this.setLayout(new BoxLayout(this, 1));
		
		this.btnMenuDiary = new JButton("Diary");
		this.btnMenuDiary.setBounds(72, 155, 101, 31);
		this.btnMenuDiary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnMenuDiary.addActionListener(this);
		this.btnMenuDiary.setEnabled(false);
		this.btnMenuDiary.setActionCommand("diary");
		add(this.btnMenuDiary);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
	}
}
