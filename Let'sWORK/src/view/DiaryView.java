package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.facade.ActivityFacade;
import business.facade.CategoryFacade;
import business.facade.DiaryFacade;
import persistence.Activity;
import persistence.ActivitySet;
import persistence.Category;
import persistence.CategorySet;
import persistence.Diary;
import persistence.User;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class DiaryView extends AbstractContentView implements ActionListener {

	private DiaryFacade facade;
	private Diary diary;
	private ActivityPanel selectedPanel = null;

	public DiaryView(User user) {
		
		this.facade = new DiaryFacade();
		this.diary = this.facade.getDiaryWithActivySet(user);
		
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		for(Activity activity : this.diary.getActivitySet().getActivities()) {
			panel.add(new ActivityPanel(this, activity));
		}
		
		JScrollPane scrollPane = new JScrollPane(panel);
		this.add(scrollPane, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		
		JButton btnNewActivity = new JButton("New activity");
		btnNewActivity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(btnNewActivity);
		
		JButton btnUpdate = new JButton("Update");
		buttonPanel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		buttonPanel.add(btnDelete);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		//this.activities = this.facade.getActivitySet();
		//this.selectedActivity = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		return "Diary : " + this.diary.getName();
	}
}
