package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import persistence.Activity;

public class ActivityPanel extends JPanel {
	
	private Activity activity;
	
	public ActivityPanel() {
		this.setBorder(new LineBorder(new Color(100, 100, 100)));
		this.setBackground(SystemColor.menu);
		this.setLayout(new BorderLayout());
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		this.add(content, BorderLayout.CENTER);
		
		JLabel lblActivityname = new JLabel("ActivityName");
		lblActivityname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActivityname.setAlignmentX( Component.LEFT_ALIGNMENT );
		content.add(lblActivityname);
		
		JPanel datePanel = new JPanel();
		JLabel lblAchievementDate = new JLabel("Achievement date :");
		lblAchievementDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAchievementDate.setAlignmentX( Component.LEFT_ALIGNMENT );
		datePanel.add(lblAchievementDate);
		
		JLabel lblDate = new JLabel("dd/mm/yyyy");
		lblDate.setForeground(Color.BLUE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setAlignmentX( Component.LEFT_ALIGNMENT );
		datePanel.add(lblDate);
		
		datePanel.setAlignmentX( Component.LEFT_ALIGNMENT );
		content.add(datePanel);
		
		// boolean to know if the activity is visible or hidden
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
		this.add(btnVisible, BorderLayout.EAST);
	}
}
