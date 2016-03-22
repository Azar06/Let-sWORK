package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import business.facade.UserFacade;

public class LoginView extends AbstractView implements ActionListener {
	
	private JTextField textField;
	private JPasswordField passwordField;
	private UserFacade facade;

	public LoginView(){
		//Création d'un UserFacade
		this.facade = new UserFacade();
		
		SpringLayout sl_container = new SpringLayout();
		this.setLayout(sl_container);

		JLabel lblWelcome = new JLabel("Welcome!");
		sl_container.putConstraint(SpringLayout.NORTH, lblWelcome, 93, SpringLayout.NORTH, this);
		sl_container.putConstraint(SpringLayout.WEST, lblWelcome, 281, SpringLayout.WEST, this);
		sl_container.putConstraint(SpringLayout.EAST, lblWelcome, -281, SpringLayout.EAST, this);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.add(lblWelcome);

		JLabel lblLogin = new JLabel("Username");
		sl_container.putConstraint(SpringLayout.WEST, lblLogin, 324, SpringLayout.WEST, this);
		sl_container.putConstraint(SpringLayout.EAST, lblLogin, -324, SpringLayout.EAST, this);
		sl_container.putConstraint(SpringLayout.SOUTH, lblWelcome, -50, SpringLayout.NORTH, lblLogin);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		sl_container.putConstraint(SpringLayout.WEST, lblPassword, 355, SpringLayout.WEST, this);
		sl_container.putConstraint(SpringLayout.EAST, lblPassword, -343, SpringLayout.EAST, this);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblPassword);

		textField = new JTextField();
		sl_container.putConstraint(SpringLayout.NORTH, textField, 226, SpringLayout.NORTH, this);
		sl_container.putConstraint(SpringLayout.SOUTH, lblLogin, -17, SpringLayout.NORTH, textField);
		sl_container.putConstraint(SpringLayout.WEST, textField, 296, SpringLayout.WEST, this);
		sl_container.putConstraint(SpringLayout.EAST, textField, -297, SpringLayout.EAST, this);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		sl_container.putConstraint(SpringLayout.SOUTH, lblPassword, -17, SpringLayout.NORTH, passwordField);
		sl_container.putConstraint(SpringLayout.NORTH, passwordField, 321, SpringLayout.NORTH, this);
		sl_container.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		sl_container.putConstraint(SpringLayout.EAST, passwordField, -297, SpringLayout.EAST, this);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(passwordField);

		JButton btnEnter = new JButton("Login");
		sl_container.putConstraint(SpringLayout.WEST, btnEnter, 352, SpringLayout.WEST, this);
		sl_container.putConstraint(SpringLayout.EAST, btnEnter, -352, SpringLayout.EAST, this);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnter.addActionListener(this);
		btnEnter.setActionCommand("enter");
		this.add(btnEnter);
		
		JLabel lblOr = new JLabel("or");
		sl_container.putConstraint(SpringLayout.SOUTH, lblOr, -118, SpringLayout.SOUTH, this);
		sl_container.putConstraint(SpringLayout.SOUTH, btnEnter, -18, SpringLayout.NORTH, lblOr);
		sl_container.putConstraint(SpringLayout.WEST, lblOr, 395, SpringLayout.WEST, this);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblOr);
		
		JButton btnSignUp = new JButton("Sign up");
		sl_container.putConstraint(SpringLayout.NORTH, btnSignUp, 6, SpringLayout.SOUTH, lblOr);
		sl_container.putConstraint(SpringLayout.WEST, btnSignUp, 366, SpringLayout.WEST, this);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSignUp.addActionListener(this);
		btnSignUp.setActionCommand("signup");
		add(btnSignUp);
	}

	//Récupère le pseudo
	public String getLoginText()
	{
		return this.textField.getText(); 
	}

	//Récupère le mot de passe
	public String getPasswdText()
	{
		return new String( this.passwordField.getPassword() );
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String cmd = arg0.getActionCommand();
		if(cmd.equals("enter"))
		{
			String id = getLoginText();
			String pass = getPasswdText();
			if((!id.equals("")) && (!pass.equals("")))
			{
				if (login(id,pass)) {
					String message = "Welcome "+ id+".";
					JOptionPane.showMessageDialog(null, message, "Connection established", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String message = "Invalid user name password combination.";
					JOptionPane.showMessageDialog(null, message, "Invalid combination", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(cmd.equals("signup"))
		{
			SignupView suv = new SignupView();
			this.getWindow().setView(suv);
		}
	}
	
	public boolean login(String id, String pass) {
		return this.facade.login(id,pass);
	}
}
