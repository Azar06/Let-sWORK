package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.facade.DiaryFacade;
import persistence.Activity;

import persistence.Diary;
import persistence.User;

import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DiaryView extends AbstractContentView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3621700323154728791L;
	
	private DiaryFacade facade;
	private Diary diary;
	private ActivityPanel selectedPanel = null;
	private JButton updateButton;
	private JButton deleteButton;

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
		btnNewActivity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getMainView().setContentView(new CreateActivityView(user, diary));
			}
		});
		buttonPanel.add(btnNewActivity);
		
		this.updateButton = new JButton("Update");
		buttonPanel.add(this.updateButton);
		
		this.deleteButton = new JButton("Delete");
		this.deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean custumerIsSure = (JOptionPane.showConfirmDialog(
						getMainView().getWindow(),
						"Are you sure about deleting \"" + selectedPanel.getActivity().getName() + "\" ?",
					    "Delete Activity",
					    JOptionPane.YES_NO_OPTION) == 0);
				if(custumerIsSure) {
					boolean deleteSucced = facade.deleteActivity(selectedPanel.getActivity());
					if(deleteSucced) {
						panel.remove(selectedPanel);
						panel.setVisible(false);
						panel.setVisible(true);
					}
				}
			}
		});
		buttonPanel.add(this.deleteButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setEnabledUpdateAndDelete(false);
	}
	
	public void setSelected(ActivityPanel activityPanel) {
		if(this.selectedPanel != null) {
			this.selectedPanel.setUnselected();
		}
		this.selectedPanel = activityPanel;
		if(this.selectedPanel == null){
			this.setEnabledUpdateAndDelete(false);
		}
		else {
			this.setEnabledUpdateAndDelete(true);
		}
	}
	
	public void setEnabledUpdateAndDelete(boolean bool) {
		this.updateButton.setEnabled(bool);
		this.deleteButton.setEnabled(bool);
	}
	
	@Override
	public String getTitle() {
		return "Diary : " + this.diary.getName();
	}
}
