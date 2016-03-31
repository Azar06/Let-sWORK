package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;

import business.facade.CategoryFacade;
import business.facade.DiaryFacade;
import persistence.CategorySet;
import persistence.GoalSet;
import persistence.User;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class CreateActivityView extends AbstractContentView implements ActionListener {
	
	private JTextField textField;
	private CategorySet categorySet;
	private GoalSet goalSet;
	private DiaryFacade diaryFacade;
	
	private JFormattedTextField dateTextField;
	private JSlider positionSlider;
	private JRadioButton visibleButton;
	private JSpinner categorySpinner;
	private JSpinner goalSpinner;
	
	public CreateActivityView(User user) {
		
		this.diaryFacade = new DiaryFacade();
		
		this.setLayout(null);
		
		JLabel lblActivityName = new JLabel("Activity name ");
		lblActivityName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblActivityName.setBounds(55, 53, 185, 25);
		add(lblActivityName);
		
		textField = new JTextField();
		textField.setBounds(65, 86, 437, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(55, 143, 56, 16);
		add(lblDate);
		
		this.dateTextField = new JFormattedTextField(createFormatter("##/##/####"));
		this.dateTextField.setBounds(125, 138, 200, 25);
		this.add(this.dateTextField);
		
		JLabel lblTimeslot = new JLabel("Timeslot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimeslot.setBounds(55, 238-50, 92, 16);
		add(lblTimeslot);
		
		this.positionSlider = new JSlider();
		this.positionSlider.setMinimum(0);
		this.positionSlider.setMaximum(4);
		this.positionSlider.setValue(0);
		this.positionSlider.setBounds(81, 267-50, 421, 26);
		add(this.positionSlider);
		
		JLabel lblMorning = new JLabel("Morning");
		lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorning.setBounds(55, 293-50, 56, 16);
		add(lblMorning);
		
		JLabel lblNoon = new JLabel("Noon");
		lblNoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoon.setBounds(162, 293-50, 56, 16);
		add(lblNoon);
		
		JLabel lblAternoon = new JLabel("Aternoon");
		lblAternoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAternoon.setBounds(264, 293-50, 56, 16);
		add(lblAternoon);
		
		JLabel lblEvening = new JLabel("Evening");
		lblEvening.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvening.setBounds(366, 293-50, 56, 16);
		add(lblEvening);
		
		JLabel lblNight = new JLabel("Night");
		lblNight.setHorizontalAlignment(SwingConstants.CENTER);
		lblNight.setBounds(469, 293-50, 56, 16);
		add(lblNight);
		
		// VISIBILITY :
		
		this.visibleButton = new JRadioButton("Visible");
		this.visibleButton.setActionCommand("visible");
		this.visibleButton.setSelected(true);
		this.visibleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.visibleButton.setBounds(55, 345-50, 84, 25);
		this.add(this.visibleButton);

	    JRadioButton hiddenButton = new JRadioButton("Hidden");
	    hiddenButton.setActionCommand("hidden");
	    hiddenButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    hiddenButton.setBounds(143, 345-50, 98, 25);
		this.add(hiddenButton);

	    //Group the radio buttons.
	    ButtonGroup visibilityGroup = new ButtonGroup();
	    visibilityGroup.add(visibleButton);
	    visibilityGroup.add(hiddenButton);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory.setBounds(55, 391-50, 92, 25);
		add(lblCategory);
		
		this.categorySet = (new CategoryFacade()).getCategorySet();
		this.categorySpinner = new JSpinner();
		this.categorySpinner.setBounds(65, 426-50, 437, 22);
		List<String> catList = new ArrayList<String>();
		catList.add("");
		catList.addAll(this.categorySet.getNames());
		this.categorySpinner.setModel(new SpinnerListModel(catList));
		this.add(this.categorySpinner);

		
		JLabel lblObjective = new JLabel("Goal");
		lblObjective.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblObjective.setBounds(56, 469-50, 103, 25);
		add(lblObjective);
		
		this.goalSpinner = new JSpinner();
		this.goalSpinner.setBounds(65, 500-50, 437, 22);
		this.goalSet = this.diaryFacade.getGoalSet(user);
		List<String> goalNameList = new ArrayList<String>();
		goalNameList.add("");
		goalNameList.addAll(this.goalSet.getNames());
		this.goalSpinner.setModel(new SpinnerListModel(goalNameList));
		this.add(this.goalSpinner);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(293, 542-50, 113, 33);
		btnCreate.addActionListener(this);
		add(btnCreate);
	}

	private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.diaryFacade.
	}

	@Override
	public String getTitle() {
		return "New activity";
	}
}
