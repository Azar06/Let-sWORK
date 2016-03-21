package view;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class SignupView extends AbstractView {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public SignupView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 99, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
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
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 3, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName, -6, SpringLayout.WEST, textField);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		add(lblLastName);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 3, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 202, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblLastName);
		add(lblEmail);
		
		JLabel lblId = new JLabel("ID");
		add(lblId);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 3, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, lblId, -6, SpringLayout.WEST, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 0, SpringLayout.NORTH, lblId);
		add(lblPassword);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, textField_4);
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblId);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		springLayout.putConstraint(SpringLayout.NORTH, lblPhone, 3, SpringLayout.NORTH, textField);
		add(lblPhone);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_5);
		springLayout.putConstraint(SpringLayout.EAST, lblPhone, -6, SpringLayout.WEST, textField_5);
		springLayout.putConstraint(SpringLayout.EAST, textField_5, -37, SpringLayout.EAST, this);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 0, SpringLayout.NORTH, lblLastName);
		add(lblStreet);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblStreet, -6, SpringLayout.WEST, textField_6);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, -37, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_5, -6, SpringLayout.NORTH, textField_6);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 3, SpringLayout.NORTH, textField_2);
		add(lblCity);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblCity, -6, SpringLayout.WEST, textField_7);
		springLayout.putConstraint(SpringLayout.NORTH, textField_7, 230, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, -37, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_6, -6, SpringLayout.NORTH, textField_7);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPersonalInfos = new JLabel("Personal infos");
		springLayout.putConstraint(SpringLayout.WEST, lblPersonalInfos, 0, SpringLayout.WEST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPersonalInfos, -6, SpringLayout.NORTH, textField);
		lblPersonalInfos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPersonalInfos);
		
		JLabel lblSignInInfos = new JLabel("Sign in infos");
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignInInfos, -201, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, lblSignInInfos);
		springLayout.putConstraint(SpringLayout.WEST, lblSignInInfos, 0, SpringLayout.WEST, lblFirstName);
		lblSignInInfos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblSignInInfos);
		
		JButton btnSignIn = new JButton("Sign in");
		springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, 6, SpringLayout.SOUTH, textField_7);
		springLayout.putConstraint(SpringLayout.WEST, btnSignIn, 0, SpringLayout.WEST, textField_4);
		add(btnSignIn);
		
		JCheckBox chckbxCustomer = new JCheckBox("Customer");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCustomer, 6, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxCustomer, 0, SpringLayout.WEST, textField);
		add(chckbxCustomer);
		
		JCheckBox chckbxSeller = new JCheckBox("Seller");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxSeller, 6, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxSeller, 4, SpringLayout.EAST, chckbxCustomer);
		add(chckbxSeller);
	}
}
