package view;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignupView extends AbstractView {
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
		springLayout.putConstraint(SpringLayout.WEST, firstnameField, 99, SpringLayout.WEST, this);
		add(firstnameField);
		firstnameField.setColumns(10);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		springLayout.putConstraint(SpringLayout.WEST, lblSignUp, 191, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignUp, -253, SpringLayout.SOUTH, this);
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSignUp);
		
		JLabel lblToLetsWork = new JLabel("to Let's WORK!");
		springLayout.putConstraint(SpringLayout.NORTH, lblToLetsWork, 4, SpringLayout.SOUTH, lblSignUp);
		springLayout.putConstraint(SpringLayout.WEST, lblToLetsWork, 173, SpringLayout.WEST, this);
		lblToLetsWork.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblToLetsWork);
		
		JLabel lblFirstName = new JLabel("First Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 3, SpringLayout.NORTH, firstnameField);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName, -6, SpringLayout.WEST, firstnameField);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		add(lblLastName);
		
		LastnameField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 3, SpringLayout.NORTH, LastnameField);
		springLayout.putConstraint(SpringLayout.NORTH, LastnameField, 202, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, firstnameField, -6, SpringLayout.NORTH, LastnameField);
		springLayout.putConstraint(SpringLayout.WEST, LastnameField, 0, SpringLayout.WEST, firstnameField);
		add(LastnameField);
		LastnameField.setColumns(10);
		
		emailField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, emailField, 6, SpringLayout.SOUTH, LastnameField);
		springLayout.putConstraint(SpringLayout.EAST, emailField, 0, SpringLayout.EAST, firstnameField);
		add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, emailField);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblLastName);
		add(lblEmail);
		
		JLabel lblId = new JLabel("ID");
		add(lblId);
		
		idField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 3, SpringLayout.NORTH, idField);
		springLayout.putConstraint(SpringLayout.EAST, lblId, -6, SpringLayout.WEST, idField);
		springLayout.putConstraint(SpringLayout.EAST, idField, 0, SpringLayout.EAST, firstnameField);
		add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, lblId);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -159, SpringLayout.EAST, this);
		add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		springLayout.putConstraint(SpringLayout.NORTH, lblPhone, 3, SpringLayout.NORTH, firstnameField);
		add(lblPhone);
		
		phoneField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblPhone, -6, SpringLayout.WEST, phoneField);
		springLayout.putConstraint(SpringLayout.EAST, phoneField, -37, SpringLayout.EAST, this);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 0, SpringLayout.NORTH, lblLastName);
		add(lblStreet);
		
		streetField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblStreet, -6, SpringLayout.WEST, streetField);
		springLayout.putConstraint(SpringLayout.EAST, streetField, -37, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, phoneField, -6, SpringLayout.NORTH, streetField);
		add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 3, SpringLayout.NORTH, emailField);
		add(lblCity);
		
		cityField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblCity, -6, SpringLayout.WEST, cityField);
		springLayout.putConstraint(SpringLayout.NORTH, cityField, 230, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, cityField, -37, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, streetField, -6, SpringLayout.NORTH, cityField);
		add(cityField);
		cityField.setColumns(10);
		
		JLabel lblPersonalInfos = new JLabel("Personal infos");
		springLayout.putConstraint(SpringLayout.WEST, lblPersonalInfos, 0, SpringLayout.WEST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPersonalInfos, -6, SpringLayout.NORTH, firstnameField);
		lblPersonalInfos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPersonalInfos);
		
		JLabel lblSignInInfos = new JLabel("Sign in infos");
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignInInfos, -201, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, idField, 6, SpringLayout.SOUTH, lblSignInInfos);
		springLayout.putConstraint(SpringLayout.WEST, lblSignInInfos, 0, SpringLayout.WEST, lblFirstName);
		lblSignInInfos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblSignInInfos);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 6, SpringLayout.SOUTH, cityField);
		add(btnSignUp);
		
		JCheckBox chckbxCustomer = new JCheckBox("Customer");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCustomer, 6, SpringLayout.SOUTH, emailField);
		springLayout.putConstraint(SpringLayout.WEST, chckbxCustomer, 0, SpringLayout.WEST, firstnameField);
		add(chckbxCustomer);
		
		JCheckBox chckbxSeller = new JCheckBox("Seller");
		springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 50, SpringLayout.EAST, chckbxSeller);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxSeller, 6, SpringLayout.SOUTH, emailField);
		springLayout.putConstraint(SpringLayout.WEST, chckbxSeller, 4, SpringLayout.EAST, chckbxCustomer);
		add(chckbxSeller);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblId);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 6, SpringLayout.EAST, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, phoneField);
		add(passwordField);
	}
}
