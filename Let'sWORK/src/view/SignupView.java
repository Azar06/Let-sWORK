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
		setLayout(null);
		
		firstnameField = new JTextField();
		firstnameField.setBounds(180, 194, 167, 22);
		add(firstnameField);
		firstnameField.setColumns(10);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(280, 39, 240, 43);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(lblSignUp);
		
		JLabel lblToLetsWork = new JLabel("to Let's WORK!");
		lblToLetsWork.setBounds(273, 88, 254, 31);
		lblToLetsWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblToLetsWork.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblToLetsWork);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(79, 195, 85, 19);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(79, 239, 85, 19);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLastName);
		
		LastnameField = new JTextField();
		LastnameField.setBounds(180, 238, 167, 22);
		add(LastnameField);
		LastnameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(180, 282, 167, 22);
		add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(93, 283, 71, 19);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblEmail);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(395, 197, 65, 16);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblId);
		
		idField = new JTextField();
		idField.setBounds(474, 194, 167, 22);
		add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(389, 241, 71, 16);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(93, 327, 71, 19);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setBounds(180, 326, 167, 22);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(93, 372, 71, 19);
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblStreet);
		
		streetField = new JTextField();
		streetField.setBounds(180, 371, 167, 22);
		add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(93, 417, 71, 19);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblCity);
		
		cityField = new JTextField();
		cityField.setBounds(180, 416, 167, 22);
		add(cityField);
		cityField.setColumns(10);
		
		JLabel lblPersonalInfos = new JLabel("Personal informations");
		lblPersonalInfos.setBounds(79, 147, 193, 25);
		lblPersonalInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblPersonalInfos);
		
		JLabel lblSignInInfos = new JLabel("Sign in informations");
		lblSignInInfos.setBounds(395, 147, 177, 25);
		lblSignInInfos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSignInInfos);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(330, 455, 140, 32);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnSignUp);
		
		JCheckBox chckbxCustomer = new JCheckBox("Customer");
		chckbxCustomer.setBounds(524, 277, 83, 25);
		add(chckbxCustomer);
		
		JCheckBox chckbxSeller = new JCheckBox("Seller");
		chckbxSeller.setBounds(460, 277, 61, 25);
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
		add(chckbxSeller);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(474, 237, 167, 22);
		add(passwordField);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(364, 501, 71, 13);
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(lblOr);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(358, 520, 83, 21);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSignIn.addActionListener(this);
		btnSignIn.setActionCommand("signin");
		add(btnSignIn);
		
		lblSiret = new JLabel("SIRET");
		lblSiret.setBounds(395, 329, 65, 16);
		lblSiret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiret.setEnabled(false);
		add(lblSiret);
		
		siretField = new JTextField();
		siretField.setBounds(474, 326, 167, 22);
		siretField.setEnabled(false);
		add(siretField);
		siretField.setColumns(10);
		
		lblUrl = new JLabel("URL");
		lblUrl.setBounds(395, 374, 65, 16);
		lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrl.setEnabled(false);
		add(lblUrl);
		
		urlField = new JTextField();
		urlField.setBounds(474, 371, 167, 22);
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
