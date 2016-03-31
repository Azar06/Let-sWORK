package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CreateActivityView extends AbstractContentView implements ActionListener {
	private JTextField textField;
	public CreateActivityView() {
		setLayout(null);
		
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(65, 172, 437, 25);
		add(formattedTextField);
		
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
		
		JCheckBox chckbxVisible = new JCheckBox("Visible");
		chckbxVisible.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxVisible.setBounds(55, 345, 113, 25);
		add(chckbxVisible);
		
		JCheckBox chckbxHidden = new JCheckBox("Hidden");
		chckbxHidden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxHidden.setBounds(55, 379, 113, 25);
		add(chckbxHidden);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(293, 489, 113, 33);
		add(btnCreate);
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
