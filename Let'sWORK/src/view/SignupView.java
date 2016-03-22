package view;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class SignupView extends AbstractView implements ActionListener {
	private JTextField firstnameField;
	private JTextField LastnameField;
	private JTextField emailField;
	private JTextField idField;
	private JTextField phoneField;
	private JTextField streetField;
	private JTextField cityField;
	private JPasswordField passwordField;
	private JTextField siretField;
	private JTextField urlField;
	private JLabel lblSiret;
	private JLabel lblUrl;
	public SignupView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		firstnameField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, firstnameField, 180, SpringLayout.WEST, this);
		add(firstnameField);
		firstnameField.setColumns(10);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		springLayout.putConstraint(SpringLayout.NORTH, lblSignUp, 39, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSignUp, 280, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignUp, 82, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblSignUp, -280, SpringLayout.EAST, this);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(lblSignUp);
		
		JLabel lblToLetsWork = new JLabel("to Let's WORK!");
		springLayout.putConstraint(SpringLayout.NORTH, lblToLetsWork, 6, SpringLayout.SOUTH, lblSignUp);
		springLayout.putConstraint(SpringLayout.WEST, lblToLetsWork, 273, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblToLetsWork, -273, SpringLayout.EAST, this);
		lblToLetsWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblToLetsWork.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblToLetsWork);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName, -16, SpringLayout.WEST, firstnameField);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 25, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 0, SpringLayout.WEST, lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.EAST, lblLastName, 164, SpringLayout.WEST, this);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLastName);
		
		LastnameField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, LastnameField, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, LastnameField, 22, SpringLayout.SOUTH, firstnameField);
		springLayout.putConstraint(SpringLayout.SOUTH, LastnameField, 44, SpringLayout.SOUTH, firstnameField);
		add(LastnameField);
		LastnameField.setColumns(10);
		
		emailField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, emailField, 22, SpringLayout.SOUTH, LastnameField);
		springLayout.putConstraint(SpringLayout.SOUTH, emailField, 44, SpringLayout.SOUTH, LastnameField);
		springLayout.putConstraint(SpringLayout.EAST, emailField, -453, SpringLayout.EAST, this);
		add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.WEST, emailField, 16, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLastName, -25, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 283, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 164, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 93, SpringLayout.WEST, this);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblEmail);
		
		JLabel lblId = new JLabel("ID");
		springLayout.putConstraint(SpringLayout.EAST, firstnameField, -48, SpringLayout.WEST, lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 197, SpringLayout.NORTH, this);
		add(lblId);
		
		idField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, idField, 474, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, idField, -159, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblId, -14, SpringLayout.WEST, idField);
		add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.EAST, LastnameField, -42, SpringLayout.WEST, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 28, SpringLayout.SOUTH, lblId);
		add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, -25, SpringLayout.NORTH, lblPhone);
		springLayout.putConstraint(SpringLayout.NORTH, lblPhone, 327, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPhone, 93, SpringLayout.WEST, this);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhone);
		
		phoneField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblPhone, -16, SpringLayout.WEST, phoneField);
		springLayout.putConstraint(SpringLayout.WEST, phoneField, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, phoneField, 22, SpringLayout.SOUTH, emailField);
		springLayout.putConstraint(SpringLayout.SOUTH, phoneField, 44, SpringLayout.SOUTH, emailField);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		springLayout.putConstraint(SpringLayout.NORTH, lblStreet, 26, SpringLayout.SOUTH, lblPhone);
		springLayout.putConstraint(SpringLayout.WEST, lblStreet, 93, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblStreet, 45, SpringLayout.SOUTH, lblPhone);
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblStreet);
		
		streetField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblStreet, -16, SpringLayout.WEST, streetField);
		springLayout.putConstraint(SpringLayout.WEST, streetField, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, streetField, 23, SpringLayout.SOUTH, phoneField);
		springLayout.putConstraint(SpringLayout.SOUTH, streetField, 45, SpringLayout.SOUTH, phoneField);
		add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		springLayout.putConstraint(SpringLayout.WEST, lblCity, 93, SpringLayout.WEST, this);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblCity);
		
		cityField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblCity, -16, SpringLayout.WEST, cityField);
		springLayout.putConstraint(SpringLayout.NORTH, cityField, 23, SpringLayout.SOUTH, streetField);
		springLayout.putConstraint(SpringLayout.WEST, cityField, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cityField, -453, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 1, SpringLayout.NORTH, cityField);
		add(cityField);
		cityField.setColumns(10);
		
		JLabel lblPersonalInfos = new JLabel("Personal informations");
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 23, SpringLayout.SOUTH, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.NORTH, firstnameField, 22, SpringLayout.SOUTH, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.SOUTH, firstnameField, 44, SpringLayout.SOUTH, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.NORTH, lblPersonalInfos, 147, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPersonalInfos, 79, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPersonalInfos, 172, SpringLayout.NORTH, this);
		lblPersonalInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblPersonalInfos);
		
		JLabel lblSignInInfos = new JLabel("Sign in informations");
		springLayout.putConstraint(SpringLayout.NORTH, idField, 22, SpringLayout.SOUTH, lblSignInInfos);
		springLayout.putConstraint(SpringLayout.WEST, lblId, 0, SpringLayout.WEST, lblSignInInfos);
		springLayout.putConstraint(SpringLayout.NORTH, lblSignInInfos, 28, SpringLayout.SOUTH, lblToLetsWork);
		springLayout.putConstraint(SpringLayout.WEST, lblSignInInfos, 123, SpringLayout.EAST, lblPersonalInfos);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignInInfos, 53, SpringLayout.SOUTH, lblToLetsWork);
		lblSignInInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSignInInfos);
		
		JButton btnSignUp = new JButton("Sign up");
		springLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 17, SpringLayout.SOUTH, cityField);
		springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 330, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSignUp, 10, SpringLayout.EAST, lblId);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnSignUp);
		
		JCheckBox chckbxCustomer = new JCheckBox("Customer");
		springLayout.putConstraint(SpringLayout.WEST, chckbxCustomer, -276, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, chckbxCustomer, -193, SpringLayout.EAST, this);
		add(chckbxCustomer);
		
		JCheckBox chckbxSeller = new JCheckBox("Seller");
		chckbxSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxSeller.isSelected()) {
					siretField.setEnabled(true);
					lblSiret.setEnabled(true);
					urlField.setEnabled(true);
					lblUrl.setEnabled(true);
				}
				else {
					siretField.setEnabled(false);
					lblSiret.setEnabled(false);
					urlField.setEnabled(false);
					lblUrl.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, chckbxSeller, 113, SpringLayout.EAST, emailField);
		springLayout.putConstraint(SpringLayout.EAST, chckbxSeller, 174, SpringLayout.EAST, emailField);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxSeller, 277, SpringLayout.NORTH, this);
		add(chckbxSeller);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCustomer, 18, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, -85, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -14, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, idField, -21, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 237, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 474, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -159, SpringLayout.EAST, this);
		add(passwordField);
		
		JLabel lblOr = new JLabel("or");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, -14, SpringLayout.NORTH, lblOr);
		springLayout.putConstraint(SpringLayout.NORTH, lblOr, 501, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblOr, 364, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblOr, -365, SpringLayout.EAST, this);
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(lblOr);
		
		JButton btnSignIn = new JButton("Sign in");
		springLayout.putConstraint(SpringLayout.SOUTH, lblOr, -6, SpringLayout.NORTH, btnSignIn);
		springLayout.putConstraint(SpringLayout.NORTH, btnSignIn, 520, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSignIn, 358, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSignIn, -359, SpringLayout.EAST, this);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSignIn.addActionListener(this);
		btnSignIn.setActionCommand("signin");
		add(btnSignIn);
		
		lblSiret = new JLabel("SIRET");
		lblSiret.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.EAST, phoneField, -48, SpringLayout.WEST, lblSiret);
		springLayout.putConstraint(SpringLayout.NORTH, lblSiret, 72, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, lblSiret, 0, SpringLayout.WEST, lblId);
		lblSiret.setEnabled(false);
		add(lblSiret);
		
		siretField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, siretField, 24, SpringLayout.SOUTH, chckbxCustomer);
		springLayout.putConstraint(SpringLayout.WEST, siretField, 474, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, siretField, -159, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblSiret, -14, SpringLayout.WEST, siretField);
		siretField.setEnabled(false);
		add(siretField);
		siretField.setColumns(10);
		
		lblUrl = new JLabel("URL");
		springLayout.putConstraint(SpringLayout.EAST, streetField, -48, SpringLayout.WEST, lblUrl);
		springLayout.putConstraint(SpringLayout.WEST, lblUrl, 0, SpringLayout.WEST, lblId);
		lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.NORTH, lblUrl, 29, SpringLayout.SOUTH, lblSiret);
		lblUrl.setEnabled(false);
		add(lblUrl);
		
		urlField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, urlField, 23, SpringLayout.SOUTH, siretField);
		springLayout.putConstraint(SpringLayout.WEST, urlField, 474, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, urlField, -159, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblUrl, -14, SpringLayout.WEST, urlField);
		urlField.setEnabled(false);
		add(urlField);
		urlField.setColumns(10);
			
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
