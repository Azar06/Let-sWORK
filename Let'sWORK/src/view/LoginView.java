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
		//Creation d'un UserFacade
		this.facade = new UserFacade();
		setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(281, 93, 238, 41);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.add(lblWelcome);

		JLabel lblLogin = new JLabel("Username");
		lblLogin.setBounds(324, 184, 152, 25);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(355, 279, 102, 25);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(296, 226, 207, 25);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(296, 321, 207, 25);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.add(passwordField);

		JButton btnEnter = new JButton("Login");
		btnEnter.setBounds(352, 387, 96, 31);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnter.addActionListener(this);
		btnEnter.setActionCommand("enter");
		this.add(btnEnter);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(368, 439, 63, 13);
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(lblOr);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(356, 458, 88, 21);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSignUp.addActionListener(this);
		btnSignUp.setActionCommand("signup");
		add(btnSignUp);
	}

	//Recupere le pseudo
	public String getLoginText()
	{
		return this.textField.getText(); 
	}

	//Recupere le mot de passe
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
			this.getWindow().setView(new MainView(new CustomerMenuView(), new CategoryView()));
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
