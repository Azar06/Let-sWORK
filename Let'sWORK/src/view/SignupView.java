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

import business.facade.UserFacade;
import business.utils.SignupReturnState;

public class SignupView extends AbstractView implements ActionListener {
	private UserFacade facade;
	
	private JTextField firstnameField;
	private JTextField lastnameField;
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
	private JCheckBox chckbxSeller;
	private JCheckBox chckbxCustomer;
	private JTextField postalField;
	
	public SignupView() {
		this.facade = new UserFacade();
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
		lblLastName.setBounds(79, 230, 85, 19);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLastName);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(180, 229, 167, 22);
		add(lastnameField);
		lastnameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(180, 264, 167, 22);
		add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(93, 265, 71, 19);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblEmail);
		
		JLabel lblId = new JLabel("Username");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(375, 197, 85, 16);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblId);
		
		idField = new JTextField();
		idField.setBounds(474, 194, 167, 22);
		add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(389, 241, 71, 16);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(93, 300, 71, 19);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setBounds(180, 299, 167, 22);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(93, 335, 71, 19);
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblStreet);
		
		streetField = new JTextField();
		streetField.setBounds(180, 334, 167, 22);
		add(streetField);
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(93, 370, 71, 19);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblCity);
		
		cityField = new JTextField();
		cityField.setBounds(180, 369, 167, 22);
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
		btnSignUp.addActionListener(this);
		btnSignUp.setActionCommand("signup");
		add(btnSignUp);
		
		chckbxCustomer = new JCheckBox("Customer");
		chckbxCustomer.setBounds(524, 277, 83, 25);
		add(chckbxCustomer);
		
		chckbxSeller = new JCheckBox("Seller");
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
		lblSiret.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUrl.setBounds(395, 374, 65, 16);
		lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrl.setEnabled(false);
		add(lblUrl);
		
		urlField = new JTextField();
		urlField.setBounds(474, 371, 167, 22);
		urlField.setEnabled(false);
		add(urlField);
		urlField.setColumns(10);
		
		postalField = new JTextField();
		postalField.setBounds(180, 404, 167, 22);
		add(postalField);
		postalField.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPostalCode.setBounds(79, 406, 85, 16);
		add(lblPostalCode);
			
	}
	
	//Recupere le prenom
	public String getFirstNameText()
	{
		return this.firstnameField.getText(); 
	}

	//Recupere le nom de famille
	public String getLastNameText()
	{
		return this.lastnameField.getText();
	}
	
	//Recupere l'email
	public String getEmailText()
	{
		return this.emailField.getText();
	}
	
	//Recupere le telephone
	public String getPhoneText()
	{
		return this.phoneField.getText();
	}
	
	//Recupere la rue
	public String getStreetText()
	{
		return this.streetField.getText();
	}
	
	//Recupere la ville
	public String getCityText()
	{
		return this.cityField.getText();
	}
	
	//Recupere le code postal
	public String getPostalCodeText()
	{
		return this.postalField.getText();
	}
	
	//Recupere l'identifiant
	public String getIdText()
	{
		return this.idField.getText();
	}
	
	//Recupere le mot de passe 
	public String getPassText()
	{
		return new String(this.passwordField.getPassword());
	}
	
	//Renvoie true si l'user est un seller
	public boolean isSeller()
	{
		return this.chckbxSeller.isSelected();
	}
	
	//Renvoie true si l'user est un customer
	public boolean isCustomer()
	{
		return this.chckbxCustomer.isSelected();
	}
	
	//Recupere le siret
	public String getSiretText()
	{
		return this.siretField.getText();
	}
	
	//Recupere l'url
	public String getUrlText()
	{
		return this.urlField.getText();
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
		if(cmd.equals("signup"))
		{
			String firstName = getFirstNameText();
			String lastName = getLastNameText();
			String street = getStreetText();
			String city = getCityText();
			String postalCode = getPostalCodeText();
			String phone = getPhoneText();
			String email = getEmailText();
			String username = getIdText();
			String password = getPassText();
			boolean isCustomer = isCustomer();
			boolean isSeller = isSeller();
			String siret = getSiretText();
			String url = getUrlText();
			
			//on verifie si les informations basiques sont bien renseignees
			if(firstName.equals("") || lastName.equals("") || street.equals("") || city.equals("") || postalCode.equals("") || phone.equals("") || email.equals("") || username.equals("") || password.equals(""))
			{
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(!isCustomer && !isSeller) { //on verifie si l'utilisateur a un role
					String message = "You must be customer and/or seller.";
					JOptionPane.showMessageDialog(null, message, "Missing role", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(isSeller && (siret.equals("") || url.equals(""))) { //si l'utilisateur est seller mais que le siret et/ou l'url ne sont pas renseignes
						String message = "All fields must be filled in.";
						JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
					}
					else {
						SignupReturnState returnState = this.facade.signup(firstName, lastName, street, city, postalCode, phone, email, username, password, isCustomer, isSeller, siret, url);
						if(returnState.isRight()) {
							String message = "Successfully signed up";
							JOptionPane.showMessageDialog(null, message, "Congrats, "+ username+". You have successfully registered into our application. You can now log in with the informations you filled.", JOptionPane.INFORMATION_MESSAGE);
							this.getWindow().setView(new LoginView());
						}
						else {
							String message = "Error at the creation of your account. Maybe an account with the same username is already existent.";
							JOptionPane.showMessageDialog(null, message, "Account creation failed", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
			
		}

	}
}
