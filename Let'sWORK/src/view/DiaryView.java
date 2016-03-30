package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.facade.CategoryFacade;
import persistence.Category;
import persistence.CategorySet;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class DiaryView extends AbstractContentView implements ActionListener {

	//private ActivityFacade facade;
	//private ActivitySet activities;
	//private Activity selectedActivity;

	public DiaryView() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 23, 651, 447);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		//FROM HERE
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(100, 100, 100)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(12, 13, 605, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblActivityname = new JLabel("ActivityName");
		lblActivityname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActivityname.setBounds(12, 13, 514, 27);
		panel_1.add(lblActivityname);
		
		JLabel lblAchievementDate = new JLabel("Achievement date :");
		lblAchievementDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAchievementDate.setBounds(12, 46, 134, 16);
		panel_1.add(lblAchievementDate);
		
		JLabel lblDate = new JLabel("dd/mm/yyyy");
		lblDate.setForeground(Color.BLUE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(149, 47, 94, 16);
		panel_1.add(lblDate);
		
		//boolean to know if the activity is visible or hidden
		boolean isVisible = true;
		String isVisibleText;
		Color isVisibleBckgdCol;
		Color isVisibleFrgdCol;
		if(isVisible) {
			isVisibleText = "Visible";
			isVisibleBckgdCol = Color.GREEN;
			isVisibleFrgdCol = new Color(0, 128, 0);
		} else {
			isVisibleText = "Hidden";
			isVisibleBckgdCol = Color.RED;
			isVisibleFrgdCol = new Color(128, 0, 0);
		}
		JButton btnVisible = new JButton(isVisibleText);
		btnVisible.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVisible.setBackground(isVisibleBckgdCol);
		btnVisible.setForeground(isVisibleFrgdCol);
		btnVisible.setBounds(530, 13, 63, 25);
		panel_1.add(btnVisible);
		
		//TO HERE
		
		JButton btnNewActivity = new JButton("New activity");
		btnNewActivity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewActivity.setBounds(78, 495, 153, 60);
		add(btnNewActivity);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(468, 483, 97, 25);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(577, 483, 97, 25);
		add(btnDelete);
		//this.activities = this.facade.getActivitySet();
		//this.selectedActivity = null;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Diary";
	}
}
