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
	private DiaryFacade diaryFacade;
	
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField(createFormatter("##/##/####"));
		formattedTextField.setBounds(65, 172, 437, 25);
		this.add(formattedTextField);
		
		JLabel lblTimeslot = new JLabel("Timeslot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimeslot.setBounds(55, 238, 92, 16);
		add(lblTimeslot);
		
		JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setValue(1);
		slider.setBounds(81, 267, 421, 26);
		add(slider);
		
		JLabel lblMorning = new JLabel("Morning");
		lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorning.setBounds(55, 293, 56, 16);
		add(lblMorning);
		
		JLabel lblNoon = new JLabel("Noon");
		lblNoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoon.setBounds(162, 293, 56, 16);
		add(lblNoon);
		
		JLabel lblAternoon = new JLabel("Aternoon");
		lblAternoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAternoon.setBounds(264, 293, 56, 16);
		add(lblAternoon);
		
		JLabel lblEvening = new JLabel("Evening");
		lblEvening.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvening.setBounds(366, 293, 56, 16);
		add(lblEvening);
		
		JLabel lblNight = new JLabel("Night");
		lblNight.setHorizontalAlignment(SwingConstants.CENTER);
		lblNight.setBounds(469, 293, 56, 16);
		add(lblNight);
		
		// VISIBILITY :
		
		JRadioButton visibleButton = new JRadioButton("Visible");
		visibleButton.setActionCommand("visible");
		visibleButton.setSelected(true);
		visibleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		visibleButton.setBounds(55, 345, 84, 25);
		this.add(visibleButton);

	    JRadioButton hiddenButton = new JRadioButton("Hidden");
	    hiddenButton.setActionCommand("hidden");
	    hiddenButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    hiddenButton.setBounds(143, 345, 98, 25);
		this.add(hiddenButton);

	    //Group the radio buttons.
	    ButtonGroup visibilityGroup = new ButtonGroup();
	    visibilityGroup.add(visibleButton);
	    visibilityGroup.add(hiddenButton);

		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(293, 542, 113, 33);
		add(btnCreate);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategory.setBounds(55, 391, 92, 25);
		add(lblCategory);
		
		this.categorySet = (new CategoryFacade()).getCategorySet();
		JSpinner categorySpinner = new JSpinner();
		categorySpinner.setBounds(65, 426, 437, 22);
		List<String> catList = new ArrayList<String>();
		catList.add("");
		catList.addAll(this.categorySet.getNames());
		categorySpinner.setModel(new SpinnerListModel(catList));
		this.add(categorySpinner);

		
		JLabel lblObjective = new JLabel("Goal");
		lblObjective.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblObjective.setBounds(56, 469, 103, 25);
		add(lblObjective);
		
		JSpinner goalSpinner = new JSpinner();
		goalSpinner.setBounds(65, 500, 437, 22);
		GoalSet goalSet = this.diaryFacade.getGoalSet(user);
		List<String> goalNameList = new ArrayList<String>();
		goalNameList.add("");
		goalNameList.addAll(goalSet.getNames());
		goalSpinner.setModel(new SpinnerListModel(goalNameList));
		this.add(goalSpinner);
	}

	private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "New activity";
	}
}
