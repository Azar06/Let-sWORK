package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import persistence.Activity;

public class ActivityPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1154427238618216246L;
	
	private static Border basicBorder = BorderFactory.createLineBorder(new Color(100, 100, 100));
	private static Border fatBorder = BorderFactory.createLineBorder(new Color(100, 100, 100), 5);
	
	private DiaryView diaryView;
	private Activity activity;
	private boolean selected = false;
	
	public ActivityPanel(DiaryView diaryView, Activity activity) {
		
		this.diaryView = diaryView;
		
		this.activity = activity;
		this.addMouseListener(this);
		
		this.setUnselected();
		this.setBackground(SystemColor.menu);
		this.setLayout(new BorderLayout());
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		this.add(content, BorderLayout.CENTER);
		
		JLabel lblActivityname = new JLabel(this.activity.getName());
		lblActivityname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActivityname.setAlignmentX( Component.LEFT_ALIGNMENT );
		content.add(lblActivityname);
		
		JPanel datePanel = new JPanel();
		JLabel lblAchievementDate = new JLabel("Achievement date :");
		lblAchievementDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAchievementDate.setAlignmentX( Component.LEFT_ALIGNMENT );
		datePanel.add(lblAchievementDate);
		
		JLabel lblDate = new JLabel(this.activity.getDate().toString());
		lblDate.setForeground(Color.BLUE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setAlignmentX( Component.LEFT_ALIGNMENT );
		datePanel.add(lblDate);
		
		datePanel.setAlignmentX( Component.LEFT_ALIGNMENT );
		content.add(datePanel);
		
		// boolean to know if the activity is visible or hidden;
		String isVisibleText;
		Color isVisibleBckgdCol;
		Color isVisibleFrgdCol;
		if(this.activity.getIsPublic()) {
			isVisibleText = "Visible";
			isVisibleBckgdCol = new Color(0, 230, 0);
		} else {
			isVisibleText = "Hidden";
			isVisibleBckgdCol = new Color(250, 0, 0);
		}
		JButton btnVisible = new JButton(isVisibleText);
		btnVisible.setEnabled(false);
		btnVisible.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVisible.setBackground(isVisibleBckgdCol);
		btnVisible.addMouseListener(this);
		this.add(btnVisible, BorderLayout.EAST);
	}

	public void setSelected() {
		this.setBorder(fatBorder);
		this.selected = true;
	}
	
	public void setUnselected() {
		this.setBorder(basicBorder);
		this.selected = false;
	}
	
	// METHOD FROM MouseListener
	
    @Override public void mouseClicked(MouseEvent e){    }
    @Override public void mousePressed(MouseEvent e){    }
    @Override public void mouseEntered(MouseEvent e){    }
    @Override public void mouseExited(MouseEvent e){    }
    @Override 
    public void mouseReleased(MouseEvent e){
    	if(!this.selected){
    		this.setSelected();
        	this.diaryView.setSelected(this);
    	}
    	else {
    		this.setUnselected();
        	this.diaryView.setSelected(null);
    	}
    }
    
    // GETTER AND SETTER
    
    public Activity getActivity() {
    	return this.activity;
    }
}
