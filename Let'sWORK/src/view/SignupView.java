package view;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignupView extends AbstractView implements ActionListener {
	private JTextField firstnameField;
	private JTextField LastnameField;
	private JTextField emailField;
	private JTextField idField;
	private JTextField phoneField;
	private JTextField streetField;
	private JTextField cityField;
	private JPasswordField passwordField;
	public SignupView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		firstnameField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, firstnameField, 180, SpringLayout.WEST, this);
		add(firstnameField);
		firstnameField.setColumns(10);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		springLayout.putConstraint(SpringLayout.NORTH, lblSignUp, 39, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSignUp, 340, SpringLayout.WEST, this);
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(lblSignUp);
		
		JLabel lblToLetsWork = new JLabel("to Let's WORK!");
		springLayout.putConstraint(SpringLayout.NORTH, lblToLetsWork, 6, SpringLayout.SOUTH, lblSignUp);
		springLayout.putConstraint(SpringLayout.WEST, lblToLetsWork, 316, SpringLayout.WEST, this);
		lblToLetsWork.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblToLetsWork);
		
		JLabel lblFirstName = new JLabel("First Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 1, SpringLayout.NORTH, firstnameField);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 93, SpringLayout.WEST, this);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		springLayout.putConstraint(SpringLayout.EAST, lblLastName, 0, SpringLayout.EAST, lblFirstName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLastName);
		
		LastnameField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, LastnameField, 16, SpringLayout.EAST, lblLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 1, SpringLayout.NORTH, LastnameField);
		springLayout.putConstraint(SpringLayout.SOUTH, firstnameField, -22, SpringLayout.NORTH, LastnameField);
		add(LastnameField);
		LastnameField.setColumns(10);
		
		emailField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, LastnameField, -22, SpringLayout.NORTH, emailField);
		add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.WEST, emailField, 16, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 1, SpringLayout.NORTH, emailField);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblFirstName);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblEmail);
		
		JLabel lblId = new JLabel("ID");
		springLayout.putConstraint(SpringLayout.EAST, firstnameField, -101, SpringLayout.WEST, lblId);
		springLayout.putConstraint(SpringLayout.EAST, lblId, 0, SpringLayout.EAST, lblSignUp);
		add(lblId);
		
		idField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, idField, -3, SpringLayout.NORTH, lblId);
		springLayout.putConstraint(SpringLayout.WEST, idField, 14, SpringLayout.EAST, lblId);
		add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.EAST, LastnameField, -58, SpringLayout.WEST, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 2, SpringLayout.NORTH, lblLastName);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblSignUp);
		add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		springLayout.putConstraint(SpringLayout.EAST, lblPhone, 0, SpringLayout.EAST, lblFirstName);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhone);
		
		phoneField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblPhone, 1, SpringLayout.NORTH, phoneField);
		springLayout.putConstraint(SpringLayout.SOUTH, emailField, -22, SpringLayout.NORTH, phoneField);
		springLayout.putConstraint(SpringLayout.WEST, phoneField, 0, SpringLayout.WEST, firstnameField);
		springLayout.putConstraint(SpringLayout.EAST, phoneField, 0, SpringLayout.EAST, firstnameField);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		springLayout.putConstraint(SpringLayout.EAST, lblStreet, 0, SpringLayout.EAST, lblFirstName);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblStreet);
		
		streetField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 1, SpringLayout.NORTH, streetField);
		springLayout.putConstraint(SpringLayout.SOUTH, streetField, -207, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, phoneField, -23, SpringLayout.NORTH, streetField);
		springLayout.putConstraint(SpringLayout.WEST, streetField, 0, SpringLayout.WEST, firstnameField);
		springLayout.putConstraint(SpringLayout.EAST, streetField, 0, SpringLayout.EAST, firstnameField);
		add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		springLayout.putConstraint(SpringLayout.EAST, lblCity, 0, SpringLayout.EAST, lblFirstName);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblCity);
		
		cityField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 1, SpringLayout.NORTH, cityField);
		springLayout.putConstraint(SpringLayout.NORTH, cityField, 23, SpringLayout.SOUTH, streetField);
		springLayout.putConstraint(SpringLayout.WEST, cityField, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cityField, 0, SpringLayout.EAST, firstnameField);
		add(cityField);
		cityField.setColumns(10);
		
		JLabel lblPersonalInfos = new JLabel("Personal informations");
		springLayout.putConstraint(SpringLayout.WEST, lblPersonalInfos, 79, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPersonalInfos, -22, SpringLayout.NORTH, firstnameField);
		lblPersonalInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblPersonalInfos);
		
		JLabel lblSignInInfos = new JLabel("Sign in informations");
		springLayout.putConstraint(SpringLayout.WEST, lblSignInInfos, 123, SpringLayout.EAST, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 25, SpringLayout.SOUTH, lblSignInInfos);
		springLayout.putConstraint(SpringLayout.NORTH, lblSignInInfos, 0, SpringLayout.NORTH, lblPersonalInfos);
		lblSignInInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSignInInfos);
		
		JButton btnSignUp = new JButton("Sign up");
		springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 353, SpringLayout.WEST, this);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnSignUp);
		
		JCheckBox chckbxCustomer = new JCheckBox("Customer");
		add(chckbxCustomer);
		
		JCheckBox chckbxSeller = new JCheckBox("Seller");
		springLayout.putConstraint(SpringLayout.EAST, emailField, -113, SpringLayout.WEST, chckbxSeller);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxSeller, 277, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, chckbxSeller, -279, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCustomer, 0, SpringLayout.NORTH, chckbxSeller);
		springLayout.putConstraint(SpringLayout.WEST, chckbxCustomer, 3, SpringLayout.EAST, chckbxSeller);
		add(chckbxSeller);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 21, SpringLayout.SOUTH, idField);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 14, SpringLayout.EAST, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -159, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, idField, 0, SpringLayout.EAST, passwordField);
		add(passwordField);
		
		JLabel lblOr = new JLabel("or");
		springLayout.putConstraint(SpringLayout.SOUTH, lblOr, -79, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, -13, SpringLayout.NORTH, lblOr);
		springLayout.putConstraint(SpringLayout.WEST, lblOr, 395, SpringLayout.WEST, this);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblOr);
		
		JButton btnSignIn = new JButton("Sign in");
		springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, 6, SpringLayout.SOUTH, lblOr);
		springLayout.putConstraint(SpringLayout.WEST, btnSignIn, 368, SpringLayout.WEST, this);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSignIn.addActionListener(this);
		btnSignIn.setActionCommand("signin");
		add(btnSignIn);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String cmd = arg0.getActionCommand();
		if(cmd.equals("signin"))
		{
			LoginView lv = new LoginView();
			this.getWindow().setView(lv);
		}		
	}
}
